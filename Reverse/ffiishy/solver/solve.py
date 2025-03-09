"""
Short writeup:
  - Decompile apk along with the dex file and see that MainActivity have so
    many calcN (calc0 ... calc299) functions

  - We can also see that there is one native calc function there and that its
    called when a button is clicked

  - We can also see data from the EditText is passed into the calc function

  - Analyze the binary (statically) in libs dir (choose any arch) then see the
    exposed calc function (since this is a shared lib) and im already generous
    enough to rewrite the code purely in C to make it easier lol

  - We can see that calc native function actually call one of the calcN functions
    where N will be randomized between 0-299, and then all these calcN functions
    will do some operations on the input, and then call the calc native function
    back again (recursion...)

  - By reading more on the decompiled code of the libfishy.so, we would know that
    there exist a base case that will happen if calc native function is trying to
    call one of non-existing calcN function (e.g. calc300) in which case it will

    1. check if input argument == "133713371337", return "wrong" if incorrect
       otherwise continue
    2. grab a resource string named "flag" which is
       "you_really_think_this_is_the_flag_huh_????"
    3. then xor it with the value we supply in the EditText
    4. return the xor result (which is the actual flag)

  - It means that our main target now is to find out what value we have to supply
    to the EditText in such a way that the input will become "133713371337"

  - But before that, one thing we have to know is how do we reach the base case?
    and the answer is we need to find one of calc native function call where pos
    argument is given non-existing N (which is 300 or more in this case)

  - Then we know there are only two function that will reach this, so same question
    arise, how to reach any of these two functions? yep, we have to backtrack these
    two functions to get to the root fn (which should be the first fn call)

  - But we can also see that the pos argument in the calc native function call inside
    the button onClick is actually randomized, yeah this is another hassle where the
    hacker have to be able to change this such that they could pass in any value to
    the pos argument (there are sooo many ways to do this, so i'll leave this as an
    excercise)

  - Once we know which function to call first, we will understand that all these calcN
    functions are just doing arithmetic operations on the input value we supply in the
    EditText and so we can get the actual input we have to pass in by putting all these
    equations to an SMT Solver (z3, cvc5, etc) or not if you watch carefully (SMT Solver
    is not required at all to solve this challenge)

  - Pass in the correct input, and the correct pos argument, then win!

  NOTE: Most of the solution code here is written by chatgpt so if chatgpt can solve it,
        then you can too :wink:
"""


def split_arguments(arg_str):
    """
    Splits a string by commas that are not inside nested parentheses.
    """
    args = []
    current = ""
    nesting = 0
    for char in arg_str:
        if char == "," and nesting == 0:
            args.append(current.strip())
            current = ""
        else:
            if char == "(":
                nesting += 1
            elif char == ")":
                nesting -= 1
            current += char
    if current:
        args.append(current.strip())
    return args


def extract_calc_call_arguments(body):
    """
    Finds the "return calc(" call in the given function body,
    extracts the full argument string (handling nested parentheses),
    and returns the list of arguments.
    """
    marker = "return calc("
    start_index = body.find(marker)
    if start_index == -1:
        return []
    # start right after "return calc("
    i = start_index + len(marker)
    nesting = 1  # the initial '(' has been seen
    arg_chars = []
    while i < len(body) and nesting > 0:
        char = body[i]
        if char == "(":
            nesting += 1
        elif char == ")":
            nesting -= 1
            if nesting == 0:
                break  # reached the closing parenthesis of calc(...)
        arg_chars.append(char)
        i += 1
    arg_str = "".join(arg_chars).strip()
    return split_arguments(arg_str)


def parse_function_block(func_block):
    """
    Given a block of code for a function (starting with e.g. "0(String input..."),
    extract:
      - N (the digit right after "calc")
      - operation (the method called on "val", e.g. subtract, xor, multiply, etc.)
      - value (the numeric literal inside new BigInteger)
      - second_argument (the second argument to calc; may include "pos +" if present)
    """
    # Get N: assume the block begins with something like "0(String input, int pos)"
    header = func_block.split("(", 1)[0].strip()
    N = header  # e.g. "0" or "1", etc.

    # Find the operation on val.
    op_marker = "val."
    op_index = func_block.find(op_marker)
    if op_index == -1:
        operation = None
    else:
        # The operation name is after "val." until the next "("
        op_start = op_index + len(op_marker)
        op_end = func_block.find("(", op_start)
        operation = func_block[op_start:op_end].strip()

    # Extract the number inside new BigInteger for the operation.
    bigint_marker = "new BigInteger("
    bigint_index = func_block.find(bigint_marker, op_index)
    if bigint_index == -1:
        value = None
    else:
        # Find the first quoted string after the marker.
        quote_start = func_block.find('"', bigint_index)
        quote_end = func_block.find('"', quote_start + 1)
        value = func_block[quote_start + 1 : quote_end]

    # Extract second argument from the calc() call.
    args = extract_calc_call_arguments(func_block)
    second_argument = args[1] if len(args) >= 2 else None

    return {
        "N": N,
        "operation": operation,
        "value": value,
        "second_argument": second_argument,
    }


def effective_second_argument(obj):
    """Compute the effective second_argument:
    - If it starts with 'pos +', then effective value = int(N) + (number after 'pos +')
    - Otherwise, just convert the second_argument to an integer.
    """
    sec_arg = obj["second_argument"]
    if sec_arg.startswith("pos +"):
        return int(obj["N"]) + int(sec_arg.split("+")[1].strip())
    else:
        return int(sec_arg)

    from z3 import BitVec, BitVecVal, simplify


def simplify_chain(chain):
    """
    Remove cancelling operations from the chain.
    For now we implement cancellation for:
      - XOR: two consecutive XOR operations with the same value cancel each other.
      - Add/Subtract: an add immediately following a subtract with the same value cancels (and vice versa).
    (More complex cancellation could be implemented if needed.)
    """
    simplified = []
    for op in chain:
        # If there is a previous op, check if it cancels with the current one.
        if simplified:
            prev = simplified[-1]
            # XOR cancellation: a ^ a cancels.
            if op["operation"] == "xor" and prev["operation"] == "xor":
                if int(op["value"]) == int(prev["value"]):
                    simplified.pop()
                    continue
            # Add/Subtract cancellation:
            if (prev["operation"] == "subtract" and op["operation"] == "add") or (
                prev["operation"] == "add" and op["operation"] == "subtract"
            ):
                if int(prev["value"]) == int(op["value"]):
                    simplified.pop()
                    continue
        simplified.append(op)
    return simplified


def simplify_chain_mul_add_div(chain):
    """
    Look for a pattern in the chain where three consecutive operations occur:
      1. A "multiply" with value X.
      2. An "add" with value V.
      3. A "divide" with value X.

    Provided that V is divisible by X, this pattern is equivalent to just an "add" of (V//X).
    The resulting operation uses the "N" and "second_argument" of the add operation.
    """
    simplified = []
    i = 0
    while i < len(chain):
        # Check if there are at least three operations left.
        if i + 2 < len(chain):
            op1 = chain[i]
            op2 = chain[i + 1]
            op3 = chain[i + 2]
            # Check for the pattern: multiply, then add, then divide.
            if (
                op1["operation"] == "multiply"
                and op2["operation"] == "add"
                and op3["operation"] == "divide"
            ):
                # Convert the multiplier from the multiply and divide operations.
                X = int(op1["value"])
                if int(op3["value"]) == X:
                    V = int(op2["value"])
                    if V % X == 0:
                        # Create a simplified add operation.
                        new_op = {
                            "N": op2["N"],  # take N from the add op
                            "operation": "add",
                            "second_argument": op2[
                                "second_argument"
                            ],  # preserve second_argument
                            "value": str(V // X),  # new value is V divided by X
                        }
                        simplified.append(new_op)
                        i += 3  # Skip the next two operations as they are merged.
                        continue
        # If the pattern isn't found, keep the current operation.
        simplified.append(chain[i])
        i += 1
    return simplified


def neutralize_chain(chain):
    """
    Process each operation in the chain:
      - If the operation is "add" and its value is negative,
        change it to "subtract" and set the value to its absolute value.
      - If the operation is "subtract" and its value is negative,
        change it to "add" and set the value to its absolute value.
    Returns a new chain with these modifications.
    """
    new_chain = []
    for op in chain:
        new_op = op.copy()
        if new_op["operation"] == "add":
            v = int(new_op["value"])
            if v < 0:
                new_op["operation"] = "subtract"
                new_op["value"] = str(-v)
        elif new_op["operation"] == "subtract":
            v = int(new_op["value"])
            if v < 0:
                new_op["operation"] = "add"
                new_op["value"] = str(-v)
        new_chain.append(new_op)
    return new_chain


def merge_repeating_operations(chain):
    """
    Merge consecutive operations in the chain that have the same "operation" field.

    For operations:
      - "add" or "subtract": merge by summing the integer values.
      - "multiply": merge by taking the product.
      - "divide": merge by taking the product of the denominators.
      - "xor": merge by performing bitwise XOR on the integer values.

    When merging, the new operation's "N" is taken from the first element in the group,
    and the "second_argument" is taken from the last element.
    """
    merged = []
    i = 0
    while i < len(chain):
        current_op = chain[i]["operation"]
        # Group consecutive operations with the same type.
        group = [chain[i]]
        i += 1
        while i < len(chain) and chain[i]["operation"] == current_op:
            group.append(chain[i])
            i += 1

        if len(group) == 1:
            merged.append(group[0])
        else:
            if current_op in ("add", "subtract"):
                total = sum(int(op["value"]) for op in group)
                new_op = {
                    "N": group[0]["N"],
                    "operation": current_op,
                    "value": str(total),
                    "second_argument": group[-1]["second_argument"],
                }
            elif current_op == "multiply":
                prod = 1
                for op in group:
                    prod *= int(op["value"])
                new_op = {
                    "N": group[0]["N"],
                    "operation": current_op,
                    "value": str(prod),
                    "second_argument": group[-1]["second_argument"],
                }
            elif current_op == "divide":
                # Consecutive divisions: x / a / b / c = x / (a*b*c)
                prod = 1
                for op in group:
                    prod *= int(op["value"])
                new_op = {
                    "N": group[0]["N"],
                    "operation": current_op,
                    "value": str(prod),
                    "second_argument": group[-1]["second_argument"],
                }
            elif current_op == "xor":
                result = 0
                for op in group:
                    result ^= int(op["value"])
                new_op = {
                    "N": group[0]["N"],
                    "operation": current_op,
                    "value": str(result),
                    "second_argument": group[-1]["second_argument"],
                }
            else:
                # If an unknown operation is encountered, just keep the first one.
                new_op = group[0]
            merged.append(new_op)
    return merged


# Split the java_code by function definitions.
# We split on "private String calc" so that each block (except possibly the first) is one function.
blocks = open("eqs.java", "r").read().split("private String calc")
results = []

for block in blocks:
    block = block.strip()
    if not block:
        continue
    # Parse the block; the first token up to "(" is our N.
    parsed = parse_function_block(block)
    results.append(parsed)


# Step 1: Find an object whose effective second_argument equals 300.
target_objects = [obj for obj in results if effective_second_argument(obj) == 300]

# Remember that there will be 2 of these where the first one is
# actually the incorrect path, so we need to take second one here
current_obj = target_objects[1]
chain = [current_obj]

# Step 2: Backtrack – look for an object whose effective second_argument equals the current object's N.
# We assume that "pointing to" means:
#   effective_second_argument(other_obj) == int(current_obj['N'])
while True:
    current_N = int(current_obj["N"])
    # Look for an object that points to the current one.
    prev_obj = next(
        (obj for obj in results if effective_second_argument(obj) == current_N),
        None,
    )
    if prev_obj is None:
        break
    chain.append(prev_obj)
    current_obj = prev_obj

# Step 3: Reverse the chain (so that it goes from the earliest pointing object to the target)
chain.reverse()

# Simplify the chain by removing cancelling operations.
simplified_chain = simplify_chain(chain)
simplified_chain = simplify_chain_mul_add_div(simplified_chain)
neutralized_chain = neutralize_chain(simplified_chain)
merged_chain = merge_repeating_operations(neutralized_chain)

target = 133713371337

# Extract the operation and constant value.
op = merged_chain[0]
op_type = op["operation"]
const_val = int(op["value"])

# Solve for x based on the operation.
if op_type == "subtract":
    # Equation: x - const_val = target  =>  x = target + const_val
    x = target + const_val
elif op_type == "add":
    # Equation: x + const_val = target  =>  x = target - const_val
    x = target - const_val
elif op_type == "mul":
    # Equation: x * const_val = target  =>  x = target / const_val (must be integer)
    if target % const_val != 0:
        raise ValueError(
            "No integer solution: target is not divisible by the multiplier"
        )
    x = target // const_val
elif op_type == "div":
    # Equation: x / const_val = target  =>  x = target * const_val
    x = target * const_val
else:
    raise ValueError("Unsupported operation: " + op_type)

assert (
    x
    == 6036484293797524118214696477123119962732168204788163459286669969312814709765272252904636681889927242
)

from Crypto.Util.number import long_to_bytes

x_bytes = long_to_bytes(x)

# The key to XOR with.
key = "you_really_think_this_is_the_flag_huh_????"
key_bytes = key.encode("ascii")

# XOR each byte of x_bytes with the corresponding byte of the key (cycling the key).
result_bytes = bytes(b ^ key_bytes[i % len(key_bytes)] for i, b in enumerate(x_bytes))

flag = result_bytes.decode("ascii")
print("Flag: ", flag)

assert flag == "recursion_through_ffi_calls_to_confuse_you"
