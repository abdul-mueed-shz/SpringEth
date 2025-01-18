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

    Participant[] public participants;

    // Constructor to initialize participants
    constructor(string[] memory _participants) {
        for (uint256 i = 0; i < _participants.length; i++) {
            participants.push(Participant({name: _participants[i]}));
        }
    }

    // Function to add a participant
    function addParticipant(string memory _participant) public onlyOwner {
        // emit Modified(greet, _greet, greet, _greet);
        participants.push(Participant({name: _participant}));
    }

    // Function to get a participant by index
    function getParticipant(uint256 index) public view returns (string memory) {
        require(index < participants.length, "Index out of bounds");
        return participants[index].name;
    }

    // Function to get the total number of participants
    function getParticipantCount() public view returns (uint256) {
        return participants.length;
    }

    // NOTE: The following is not handled correctly in web3j wrapper classes yet.
    // event Modified(
    //     string indexed oldGreetingIdx,
    //     string indexed newGreetingIdx,
    //     string oldGreeting,
    //     string newGreeting
    // );
}