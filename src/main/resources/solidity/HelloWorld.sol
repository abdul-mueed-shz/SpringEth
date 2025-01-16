// SPDX-License-Identifier: Apache-2.0
pragma solidity ^0.8.0;

contract BaseContract {
    address public owner;

    constructor() {
        owner = msg.sender;
    }

    modifier onlyOwner() {
        require(msg.sender == owner, "Only owner can call this function.");
        _;
    }

    /* Function to withdraw funds */
    function withdraw() public onlyOwner {
        payable(owner).transfer(address(this).balance);
    }

    /* Function to receive Ether */
    receive() external payable {}
}

contract LegalContract is BaseContract {

    string public greet;

    struct Participant {
        string name;
    }

    uint256[] participants;

    constructor(string memory _greet) {
        greet = _greet;
    }

    function newGreeting(string memory _greet) public onlyOwner {
        emit Modified(greet, _greet, greet, _greet);
        greet = _greet;
    }

    function greeting() public view returns (string memory) {
        return greet;
    }

    event Modified(
        string indexed oldGreetingIdx,
        string indexed newGreetingIdx,
        string oldGreeting,
        string newGreeting
    );
}
