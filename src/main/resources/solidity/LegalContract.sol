// SPDX-License-Identifier: Apache-2.0
pragma solidity ^0.8.12;

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

    enum Type {
        RENTAL,   // 0
        LEGAL,   // 1
        NDA     // 2
    }

    struct CContract {
        uint256 id;
        Type contractType;
        Participant[] participants;
        string terms;
        string description;
    }

    struct Participant {
        string name;
    }

    uint256 public contractIdCounter = 0;
    mapping(uint256 => CContract) public contracts;
    mapping(uint256 => bool) public contractExists; // Tracker for existence

    // Constructor to initialize participants
    constructor(
        uint32 _contractType,
        Participant[] memory _participants,
        string memory _terms,
        string memory _desc) {
        addContract(
            _contractType,
            _participants,
            _terms,
            _desc
        );
    }

    // Function to add a participant
    function addContract(
        uint32 _contractType,
        Participant[] memory _participants,
        string memory _terms,
        string memory _desc
    ) public onlyOwner {
        CContract storage cContract = contracts[contractIdCounter];
        cContract.id = contractIdCounter;
        cContract.description = _desc;
        cContract.terms = _terms;
        cContract.contractType = Type(_contractType);
        // Copy each participant from memory to storage
        for (uint256 i = 0; i < _participants.length; i++) {
            cContract.participants.push(_participants[i]);
        }
        contracts[contractIdCounter] = cContract;
        emit ContractAdded(contractIdCounter);
        contractExists[contractIdCounter++] = true;
    }

    // Function to add a participant
    function updateContract(
        uint256 contractId,
        uint32 _contractType,
        Participant[] memory _participants,
        string memory _terms,
        string memory _desc
    ) public onlyOwner checkContractIndexBound(contractId) checkContractExists(contractId) {
        CContract storage cContract = contracts[contractId];
        cContract.description = _desc;
        cContract.terms = _terms;
        cContract.contractType = Type(_contractType);
        for (uint256 i = 0; i < _participants.length; i++) {
            if (participantExists(_participants[i].name, contractId)) {
                cContract.participants.push(_participants[i]);
            }
        }
    }

    function participantExists(string memory participantName, uint256 contractId) private returns (bool) {
        CContract storage cContract = contracts[contractId];
        for (uint256 j = 0; j < cContract.participants.length; j++) {
            if (
                keccak256(abi.encodePacked(cContract.participants[j].name)) ==
                keccak256(abi.encodePacked(participantName))) {
                return true;
            }
        }
        return false;
    }

    // Get a contract by index (auto-generated getter alternative)
    function getContract(uint256 contractId)
    public checkContractIndexBound(contractId) checkContractExists(contractId) view
    returns (
        uint256 id,
        Type contractType,
        Participant[] memory participants,
        string memory terms,
        string memory description
    )
    {
        CContract storage cContract = contracts[contractId];
        // Initialize a memory array with the same length as the storage array
        Participant[] memory participantsMemory = new Participant[](cContract.participants.length);
        // Copy each participant from storage to memory
        for (uint256 i = 0; i < cContract.participants.length; i++) {
            participantsMemory[i] = cContract.participants[i];
        }

        // Return the contract details
        return (
            cContract.id,
            cContract.contractType,
            participantsMemory,
            cContract.terms,
            cContract.description
        );
    }

    // Function to get the total number of participants
    function getContractCount() public view returns (uint256) {
        return contractIdCounter;
    }

    event ContractAdded(uint256 contractId);

    modifier checkContractIndexBound(uint256 contractId) {
        require(contractId < contractIdCounter, "Index out of bounds");
        _;
    }

    modifier checkContractExists(uint256 contractId) {
        require(contractExists[contractId], "Contract with the specified id does not exist");
        _;
    }

    // NOTE: The following is not handled correctly in web3j wrapper classes yet.
    // event Modified(
    //     string indexed oldGreetingIdx,
    //     string indexed newGreetingIdx,
    //     string oldGreeting,
    //     string newGreeting
    // );
}