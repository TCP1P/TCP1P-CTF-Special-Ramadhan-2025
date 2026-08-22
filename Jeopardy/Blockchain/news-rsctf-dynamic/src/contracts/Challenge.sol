// SPDX-License-Identifier: MIT
// Author: Hanz
pragma solidity ^0.8.0;

contract Challenge {
	bool done;

	error OnlyHuman();
	error InvalidDeposit();

	modifier onlyHuman() {
		require(msg.sender == tx.origin, OnlyHuman());
		_;
	}

	constructor() payable {
		require(msg.value == 10 ether, InvalidDeposit());
	}

	function golf() onlyHuman payable external {
		assembly {
			if eq(sload(0), 0) {
				if eq(shr(caller(), 144), 0) {
					if not(iszero(call(gas(), caller(), 0, 0, 32, 0, 32))) {
						if eq(iszero(mload(0)), 0) {
							pop(call(gas(), origin(), exp(10,18), 0, 32, 0, 0))
						}
					}
				}
			}
			sstore(0, 1)
		}
	}
}