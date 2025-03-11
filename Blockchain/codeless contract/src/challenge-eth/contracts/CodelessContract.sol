//SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract CodelessContract {
    
    bool public isSolved;

    function hack(address _contract) external {
        
        uint codeLen;
        assembly {
            codeLen := extcodesize(_contract)
        }
        require(codeLen == 0, "Code is not empty");

        
        (bool success, bytes memory result) = _contract.call(abi.encodePacked(unicode"昔者莊周夢為胡蝶，栩栩然胡蝶也，自喻適志與。不知周也。俄然覺，則蘧蘧然周也。不知周之夢為胡蝶與，胡蝶之夢為周與。周與胡蝶，則必有分矣。此之謂物化。"));
        
        uint256 number = abi.decode(result, (uint256));
        
        require(number < 2**224, "lol");
        require(success, "Call failed");
        isSolved = true;
    }

    
}