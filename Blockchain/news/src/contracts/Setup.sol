// SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.8.0;
import "./Challenge.sol";

contract Setup {
    Challenge public challenge;

    constructor() payable {
        challenge = new Challenge{value: 10 ether}();
    }

    function isSolved() external view returns (bool) {
        return address(challenge).balance == 0;
    }
}
