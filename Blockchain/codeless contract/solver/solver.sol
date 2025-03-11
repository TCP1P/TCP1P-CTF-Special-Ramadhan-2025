
// SPDX-License-Identifier: MIT
pragma solidity ^0.8.13;

import {Script, console} from "forge-std/Script.sol";

contract CodelessContract {
    
    bool public isSolved;

    function hack(address _contract) external {
        
        uint codeLen;
        assembly {
            codeLen := extcodesize(_contract)
        }
        require(codeLen == 0, "Code is not empty");

        
        (bool success, bytes memory result) = _contract.call(abi.encodePacked(blockhash(block.number)));
        
        uint256 number = abi.decode(result, (uint256));
        
        require(number < 2**224, "lol");
        require(success, "Call failed");
        isSolved = true;
    }
}

interface Setup{
    function challenge() external returns (CodelessContract);
}


contract SolveScript is Script {
    function setUp() public {}

    function run() public {
        // Get environment variables
        string memory rpcUrl = vm.envString("RPC_URL");
        uint256 privkey = vm.envUint("PRIVKEY");
        address setupAddress = vm.envAddress("SETUP_CONTRACT_ADDR");
        // Set RPC URL
        vm.createSelectFork(rpcUrl);
        
        // Start broadcast with the private key
        vm.startBroadcast(privkey);

        // Interact with the contracts
        Setup setup = Setup(setupAddress);
        CodelessContract temp = setup.challenge();
        temp.hack(address(3));
        require(temp.isSolved());

        vm.stopBroadcast();
    }
}

/* env file example
RPC_URL="http://localhost:48334/abdd7b67-1a88-4b8b-a5a1-4a3c37c51608"
PRIVKEY="0x34ab96218189060f60764d85825bb6a2c38baa8d2ebf9e8e3335e25c16591213"
SETUP_CONTRACT_ADDR="0xe6171E7b01D794b5d6e69B7d2791Ca0D75DFaC7B"
WALLET_ADDR="0xb71F48C5E0c861A276fFEc281921139012b1648d"
*/

// run with `forge script solver.sol:SolveScript --broadcast` don't forget to source env