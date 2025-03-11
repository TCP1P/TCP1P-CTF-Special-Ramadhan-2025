// SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.8.0;

import "./CodelessContract.sol";

contract Setup {
    CodelessContract public challenge;
    
    constructor() payable {
        challenge = new CodelessContract();
    }
    
    function isSolved() external view returns (bool) {
        return challenge.isSolved();
    }
}
