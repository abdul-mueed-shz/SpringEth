package com.abdul.eth.wrappers.contracts;

import io.reactivex.Flowable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.DynamicStruct;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple4;
import org.web3j.tuples.generated.Tuple5;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/hyperledger-web3j/web3j/tree/main/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.12.3.
 */
@SuppressWarnings("rawtypes")
public class LegalContract extends Contract {
    public static final String BINARY = "60806040525f600155348015610013575f80fd5b50604051611b9c380380611b9c8339810160408190526100329161041e565b5f80546001600160a01b0319163317905561004f84848484610058565b505050506107eb565b5f546001600160a01b031633146100c05760405162461bcd60e51b815260206004820152602260248201527f4f6e6c79206f776e65722063616e2063616c6c20746869732066756e6374696f604482015261371760f11b606482015260840160405180910390fd5b6001545f818152600260205260409020908155600481016100e18382610616565b50600381016100f08482610616565b508463ffffffff166002811115610109576101096106d3565b60018083018054909160ff199091169083600281111561012b5761012b6106d3565b02179055505f5b84518110156101895781600201858281518110610151576101516106e7565b60209081029190910181015182546001810184555f938452919092208251910190819061017e9082610616565b505050600101610132565b50600180545f908152600260208190526040909120835481558284015481840180548695939460ff90931693919260ff19909116919084908111156101d0576101d06106d3565b0217905550600282810180546101e99284019190610285565b506003818101906101fc908401826106fb565b5060048181019061020f908401826106fb565b50506001546040519081527fac210b01e42cafdce02d0cd5dc41f3fe6a7245262f52a1cdf2a2eea60dada940915060200160405180910390a1600180546003905f90838261025c836107c7565b90915550815260208101919091526040015f20805460ff19169115159190911790555050505050565b828054828255905f5260205f209081019282156102cd575f5260205f209182015b828111156102cd578282806102bb83826106fb565b505050916001019190600101906102a6565b506102d99291506102dd565b5090565b808211156102d9575f6102f082826102f9565b506001016102dd565b50805461030590610592565b5f825580601f10610314575050565b601f0160209004905f5260205f20908101906103309190610333565b50565b5b808211156102d9575f8155600101610334565b634e487b7160e01b5f52604160045260245ffd5b604051602081016001600160401b038111828210171561037d5761037d610347565b60405290565b604051601f8201601f191681016001600160401b03811182821017156103ab576103ab610347565b604052919050565b5f82601f8301126103c2575f80fd5b81516001600160401b038111156103db576103db610347565b6103ee601f8201601f1916602001610383565b818152846020838601011115610402575f80fd5b8160208501602083015e5f918101602001919091529392505050565b5f805f8060808587031215610431575f80fd5b845163ffffffff81168114610444575f80fd5b60208601519094506001600160401b0381111561045f575f80fd5b8501601f8101871361046f575f80fd5b80516001600160401b0381111561048857610488610347565b8060051b61049860208201610383565b9182526020818401810192908101908a8411156104b3575f80fd5b6020850192505b838310156105305782516001600160401b038111156104d7575f80fd5b85016020818d03601f190112156104ec575f80fd5b6104f461035b565b60208201516001600160401b0381111561050c575f80fd5b61051b8e6020838601016103b3565b825250835250602092830192909101906104ba565b60408a0151909750935050506001600160401b038211159050610551575f80fd5b61055d878288016103b3565b606087015190935090506001600160401b0381111561057a575f80fd5b610586878288016103b3565b91505092959194509250565b600181811c908216806105a657607f821691505b6020821081036105c457634e487b7160e01b5f52602260045260245ffd5b50919050565b601f82111561061157805f5260205f20601f840160051c810160208510156105ef5750805b601f840160051c820191505b8181101561060e575f81556001016105fb565b50505b505050565b81516001600160401b0381111561062f5761062f610347565b6106438161063d8454610592565b846105ca565b6020601f821160018114610678575f831561065e5750848201515b600184901b5f19600386901b1c198216175b85555061060e565b5f84815260208120601f198516915b828110156106a75787850151825560209485019460019092019101610687565b50848210156106c457868401515f19600387901b60f8161c191681555b50505050600190811b01905550565b634e487b7160e01b5f52602160045260245ffd5b634e487b7160e01b5f52603260045260245ffd5b818103610706575050565b6107108254610592565b6001600160401b0381111561072757610727610347565b6107358161063d8454610592565b5f601f821160018114610764575f831561065e575081850154600184901b5f19600386901b1c19821617610670565b5f8581526020808220868352908220601f198616925b8381101561079a578286015482556001958601959091019060200161077a565b50858310156107b757818501545f19600388901b60f8161c191681555b5050505050600190811b01905550565b5f600182016107e457634e487b7160e01b5f52601160045260245ffd5b5060010190565b6113a4806107f85f395ff3fe608060405260043610610087575f3560e01c80636ebc8c86116100575780636ebc8c861461011e5780638da5cb5b1461014e5780639399869d14610184578063a70fd7fa14610198578063d4650e2b146101b7575f80fd5b8063079f524a146100925780633a4490b0146100ba5780633ccfd60b146100db578063474da79a146100ef575f80fd5b3661008e57005b5f80fd5b34801561009d575f80fd5b506100a760015481565b6040519081526020015b60405180910390f35b3480156100c5575f80fd5b506100d96100d4366004610d6d565b6101f5565b005b3480156100e6575f80fd5b506100d96103ec565b3480156100fa575f80fd5b5061010e610109366004610e09565b61044f565b6040516100b19493929190610e82565b348015610129575f80fd5b5061013d610138366004610e09565b610587565b6040516100b1959493929190610ec4565b348015610159575f80fd5b505f5461016c906001600160a01b031681565b6040516001600160a01b0390911681526020016100b1565b34801561018f575f80fd5b506001546100a7565b3480156101a3575f80fd5b506100d96101b2366004610f6e565b6108a5565b3480156101c2575f80fd5b506101e56101d1366004610e09565b60036020525f908152604090205460ff1681565b60405190151581526020016100b1565b5f546001600160a01b031633146102275760405162461bcd60e51b815260040161021e90611013565b60405180910390fd5b6001545f8181526002602052604090209081556004810161024883826110d9565b506003810161025784826110d9565b508463ffffffff16600281111561027057610270610e20565b60018083018054909160ff199091169083600281111561029257610292610e20565b02179055505f5b84518110156102f057816002018582815181106102b8576102b8611196565b60209081029190910181015182546001810184555f93845291909220825191019081906102e590826110d9565b505050600101610299565b50600180545f908152600260208190526040909120835481558284015481840180548695939460ff90931693919260ff199091169190849081111561033757610337610e20565b0217905550600282810180546103509284019190610aea565b50600381810190610363908401826111aa565b50600481810190610376908401826111aa565b50506001546040519081527fac210b01e42cafdce02d0cd5dc41f3fe6a7245262f52a1cdf2a2eea60dada940915060200160405180910390a1600180546003905f9083826103c383611276565b90915550815260208101919091526040015f20805460ff19169115159190911790555050505050565b5f546001600160a01b031633146104155760405162461bcd60e51b815260040161021e90611013565b5f80546040516001600160a01b03909116914780156108fc02929091818181858888f1935050505015801561044c573d5f803e3d5ffd5b50565b60026020525f9081526040902080546001820154600383018054929360ff9092169261047a90611055565b80601f01602080910402602001604051908101604052809291908181526020018280546104a690611055565b80156104f15780601f106104c8576101008083540402835291602001916104f1565b820191905f5260205f20905b8154815290600101906020018083116104d457829003601f168201915b50505050509080600401805461050690611055565b80601f016020809104026020016040519081016040528092919081815260200182805461053290611055565b801561057d5780601f106105545761010080835404028352916020019161057d565b820191905f5260205f20905b81548152906001019060200180831161056057829003601f168201915b5050505050905084565b5f8060608060608560015481106105d65760405162461bcd60e51b8152602060048201526013602482015272496e646578206f7574206f6620626f756e647360681b604482015260640161021e565b5f87815260036020526040902054879060ff166106055760405162461bcd60e51b815260040161021e9061129a565b5f8881526002602081905260408220908101549091906001600160401b0381111561063257610632610bbc565b60405190808252806020026020018201604052801561067257816020015b6040805160208101909152606081528152602001906001900390816106505790505b5090505f5b600283015481101561075f5782600201818154811061069857610698611196565b905f5260205f20016040518060200160405290815f820180546106ba90611055565b80601f01602080910402602001604051908101604052809291908181526020018280546106e690611055565b80156107315780601f1061070857610100808354040283529160200191610731565b820191905f5260205f20905b81548152906001019060200180831161071457829003601f168201915b50505050508152505082828151811061074c5761074c611196565b6020908102919091010152600101610677565b508154600183015460038401805460ff909216918491906004870190829061078690611055565b80601f01602080910402602001604051908101604052809291908181526020018280546107b290611055565b80156107fd5780601f106107d4576101008083540402835291602001916107fd565b820191905f5260205f20905b8154815290600101906020018083116107e057829003601f168201915b5050505050915080805461081090611055565b80601f016020809104026020016040519081016040528092919081815260200182805461083c90611055565b80156108875780601f1061085e57610100808354040283529160200191610887565b820191905f5260205f20905b81548152906001019060200180831161086a57829003601f168201915b50505050509050985098509850985098505050505091939590929450565b5f546001600160a01b031633146108ce5760405162461bcd60e51b815260040161021e90611013565b8460015481106109165760405162461bcd60e51b8152602060048201526013602482015272496e646578206f7574206f6620626f756e647360681b604482015260640161021e565b5f86815260036020526040902054869060ff166109455760405162461bcd60e51b815260040161021e9061129a565b5f8781526002602052604090206004810161096085826110d9565b506003810161096f86826110d9565b508663ffffffff16600281111561098857610988610e20565b60018083018054909160ff19909116908360028111156109aa576109aa610e20565b02179055505f5b8651811015610a34576109e08782815181106109cf576109cf611196565b60200260200101515f01518a610a3f565b15610a2c57816002018782815181106109fb576109fb611196565b60209081029190910181015182546001810184555f9384529190922082519101908190610a2890826110d9565b5050505b6001016109b1565b505050505050505050565b5f818152600260205260408120815b6002820154811015610ade5784604051602001610a6b91906112e7565b60405160208183030381529060405280519060200120826002018281548110610a9657610a96611196565b905f5260205f20015f01604051602001610ab091906112fd565b6040516020818303038152906040528051906020012003610ad657600192505050610ae4565b600101610a4e565b505f9150505b92915050565b828054828255905f5260205f20908101928215610b32575f5260205f209182015b82811115610b3257828280610b2083826111aa565b50505091600101919060010190610b0b565b50610b3e929150610b42565b5090565b80821115610b3e575f610b558282610b5e565b50600101610b42565b508054610b6a90611055565b5f825580601f10610b79575050565b601f0160209004905f5260205f209081019061044c91905b80821115610b3e575f8155600101610b91565b803563ffffffff81168114610bb7575f80fd5b919050565b634e487b7160e01b5f52604160045260245ffd5b604051602081016001600160401b0381118282101715610bf257610bf2610bbc565b60405290565b604051601f8201601f191681016001600160401b0381118282101715610c2057610c20610bbc565b604052919050565b5f82601f830112610c37575f80fd5b81356001600160401b03811115610c5057610c50610bbc565b610c63601f8201601f1916602001610bf8565b818152846020838601011115610c77575f80fd5b816020850160208301375f918101602001919091529392505050565b5f82601f830112610ca2575f80fd5b81356001600160401b03811115610cbb57610cbb610bbc565b8060051b610ccb60208201610bf8565b91825260208185018101929081019086841115610ce6575f80fd5b6020860192505b83831015610d635782356001600160401b03811115610d0a575f80fd5b86016020818903601f19011215610d1f575f80fd5b610d27610bd0565b60208201356001600160401b03811115610d3f575f80fd5b610d4e8a602083860101610c28565b82525083525060209283019290910190610ced565b9695505050505050565b5f805f8060808587031215610d80575f80fd5b610d8985610ba4565b935060208501356001600160401b03811115610da3575f80fd5b610daf87828801610c93565b93505060408501356001600160401b03811115610dca575f80fd5b610dd687828801610c28565b92505060608501356001600160401b03811115610df1575f80fd5b610dfd87828801610c28565b91505092959194509250565b5f60208284031215610e19575f80fd5b5035919050565b634e487b7160e01b5f52602160045260245ffd5b60038110610e5057634e487b7160e01b5f52602160045260245ffd5b9052565b5f81518084528060208401602086015e5f602082860101526020601f19601f83011685010191505092915050565b848152610e926020820185610e34565b608060408201525f610ea76080830185610e54565b8281036060840152610eb98185610e54565b979650505050505050565b5f60a08201878352610ed96020840188610e34565b60a0604084015280865180835260c08501915060c08160051b8601019250602088015f5b82811015610f385760bf1987860301845281515160208652610f226020870182610e54565b9550506020938401939190910190600101610efd565b505050508281036060840152610f4e8186610e54565b90508281036080840152610f628185610e54565b98975050505050505050565b5f805f805f60a08688031215610f82575f80fd5b85359450610f9260208701610ba4565b935060408601356001600160401b03811115610fac575f80fd5b610fb888828901610c93565b93505060608601356001600160401b03811115610fd3575f80fd5b610fdf88828901610c28565b92505060808601356001600160401b03811115610ffa575f80fd5b61100688828901610c28565b9150509295509295909350565b60208082526022908201527f4f6e6c79206f776e65722063616e2063616c6c20746869732066756e6374696f604082015261371760f11b606082015260800190565b600181811c9082168061106957607f821691505b60208210810361108757634e487b7160e01b5f52602260045260245ffd5b50919050565b601f8211156110d457805f5260205f20601f840160051c810160208510156110b25750805b601f840160051c820191505b818110156110d1575f81556001016110be565b50505b505050565b81516001600160401b038111156110f2576110f2610bbc565b611106816111008454611055565b8461108d565b6020601f82116001811461113b575f83156111215750848201515b600184901b5f19600386901b1c198216175b8555506110d1565b5f84815260208120601f198516915b8281101561116a578785015182556020948501946001909201910161114a565b508482101561118757868401515f19600387901b60f8161c191681555b50505050600190811b01905550565b634e487b7160e01b5f52603260045260245ffd5b8181036111b5575050565b6111bf8254611055565b6001600160401b038111156111d6576111d6610bbc565b6111e4816111008454611055565b5f601f821160018114611213575f8315611121575081850154600184901b5f19600386901b1c19821617611133565b5f8581526020808220868352908220601f198616925b838110156112495782860154825560019586019590910190602001611229565b508583101561126657818501545f19600388901b60f8161c191681555b5050505050600190811b01905550565b5f6001820161129357634e487b7160e01b5f52601160045260245ffd5b5060010190565b6020808252602d908201527f436f6e747261637420776974682074686520737065636966696564206964206460408201526c1bd95cc81b9bdd08195e1a5cdd609a1b606082015260800190565b5f82518060208501845e5f920191825250919050565b5f80835461130a81611055565b600182168015611321576001811461133657611363565b60ff1983168652811515820286019350611363565b865f5260205f205f5b8381101561135b5781548882015260019091019060200161133f565b505081860193505b50919594505050505056fea264697066735822122099793e551b3e1d555c1b6344538d6f7dfc107a17404a650cc52a396ce5d0707564736f6c634300081a0033";

    private static String librariesLinkedBinary;

    public static final String FUNC_ADDCONTRACT = "addContract";

    public static final String FUNC_CONTRACTEXISTS = "contractExists";

    public static final String FUNC_CONTRACTIDCOUNTER = "contractIdCounter";

    public static final String FUNC_CONTRACTS = "contracts";

    public static final String FUNC_GETCONTRACT = "getContract";

    public static final String FUNC_GETCONTRACTCOUNT = "getContractCount";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_UPDATECONTRACT = "updateContract";

    public static final String FUNC_WITHDRAW = "withdraw";

    public static final Event CONTRACTADDED_EVENT = new Event("ContractAdded", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
    ;

    @Deprecated
    protected LegalContract(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected LegalContract(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected LegalContract(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected LegalContract(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static List<ContractAddedEventResponse> getContractAddedEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(CONTRACTADDED_EVENT, transactionReceipt);
        ArrayList<ContractAddedEventResponse> responses = new ArrayList<ContractAddedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ContractAddedEventResponse typedResponse = new ContractAddedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.contractId = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static ContractAddedEventResponse getContractAddedEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(CONTRACTADDED_EVENT, log);
        ContractAddedEventResponse typedResponse = new ContractAddedEventResponse();
        typedResponse.log = log;
        typedResponse.contractId = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
        return typedResponse;
    }

    public Flowable<ContractAddedEventResponse> contractAddedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getContractAddedEventFromLog(log));
    }

    public Flowable<ContractAddedEventResponse> contractAddedEventFlowable(
            DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(CONTRACTADDED_EVENT));
        return contractAddedEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> addContract(BigInteger _contractType,
            List<Participant> _participants, String _terms, String _desc) {
        final Function function = new Function(
                FUNC_ADDCONTRACT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint32(_contractType), 
                new org.web3j.abi.datatypes.DynamicArray<Participant>(Participant.class, _participants), 
                new org.web3j.abi.datatypes.Utf8String(_terms), 
                new org.web3j.abi.datatypes.Utf8String(_desc)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Boolean> contractExists(BigInteger param0) {
        final Function function = new Function(FUNC_CONTRACTEXISTS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<BigInteger> contractIdCounter() {
        final Function function = new Function(FUNC_CONTRACTIDCOUNTER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<Tuple4<BigInteger, BigInteger, String, String>> contracts(
            BigInteger param0) {
        final Function function = new Function(FUNC_CONTRACTS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint8>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
        return new RemoteFunctionCall<Tuple4<BigInteger, BigInteger, String, String>>(function,
                new Callable<Tuple4<BigInteger, BigInteger, String, String>>() {
                    @Override
                    public Tuple4<BigInteger, BigInteger, String, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple4<BigInteger, BigInteger, String, String>(
                                (BigInteger) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (String) results.get(3).getValue());
                    }
                });
    }

    public RemoteFunctionCall<Tuple5<BigInteger, BigInteger, List<Participant>, String, String>> getContract(
            BigInteger contractId) {
        final Function function = new Function(FUNC_GETCONTRACT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(contractId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint8>() {}, new TypeReference<DynamicArray<Participant>>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
        return new RemoteFunctionCall<Tuple5<BigInteger, BigInteger, List<Participant>, String, String>>(function,
                new Callable<Tuple5<BigInteger, BigInteger, List<Participant>, String, String>>() {
                    @Override
                    public Tuple5<BigInteger, BigInteger, List<Participant>, String, String> call()
                            throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple5<BigInteger, BigInteger, List<Participant>, String, String>(
                                (BigInteger) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                convertToNative((List<Participant>) results.get(2).getValue()), 
                                (String) results.get(3).getValue(), 
                                (String) results.get(4).getValue());
                    }
                });
    }

    public RemoteFunctionCall<BigInteger> getContractCount() {
        final Function function = new Function(FUNC_GETCONTRACTCOUNT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> owner() {
        final Function function = new Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> updateContract(BigInteger contractId,
            BigInteger _contractType, List<Participant> _participants, String _terms,
            String _desc) {
        final Function function = new Function(
                FUNC_UPDATECONTRACT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(contractId), 
                new org.web3j.abi.datatypes.generated.Uint32(_contractType), 
                new org.web3j.abi.datatypes.DynamicArray<Participant>(Participant.class, _participants), 
                new org.web3j.abi.datatypes.Utf8String(_terms), 
                new org.web3j.abi.datatypes.Utf8String(_desc)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> withdraw() {
        final Function function = new Function(
                FUNC_WITHDRAW, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static LegalContract load(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        return new LegalContract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static LegalContract load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new LegalContract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static LegalContract load(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        return new LegalContract(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static LegalContract load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new LegalContract(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<LegalContract> deploy(Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider, BigInteger _contractType,
            List<Participant> _participants, String _terms, String _desc) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint32(_contractType), 
                new org.web3j.abi.datatypes.DynamicArray<Participant>(Participant.class, _participants), 
                new org.web3j.abi.datatypes.Utf8String(_terms), 
                new org.web3j.abi.datatypes.Utf8String(_desc)));
        return deployRemoteCall(LegalContract.class, web3j, credentials, contractGasProvider, getDeploymentBinary(), encodedConstructor);
    }

    public static RemoteCall<LegalContract> deploy(Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider,
            BigInteger _contractType, List<Participant> _participants, String _terms,
            String _desc) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint32(_contractType), 
                new org.web3j.abi.datatypes.DynamicArray<Participant>(Participant.class, _participants), 
                new org.web3j.abi.datatypes.Utf8String(_terms), 
                new org.web3j.abi.datatypes.Utf8String(_desc)));
        return deployRemoteCall(LegalContract.class, web3j, transactionManager, contractGasProvider, getDeploymentBinary(), encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<LegalContract> deploy(Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit, BigInteger _contractType,
            List<Participant> _participants, String _terms, String _desc) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint32(_contractType), 
                new org.web3j.abi.datatypes.DynamicArray<Participant>(Participant.class, _participants), 
                new org.web3j.abi.datatypes.Utf8String(_terms), 
                new org.web3j.abi.datatypes.Utf8String(_desc)));
        return deployRemoteCall(LegalContract.class, web3j, credentials, gasPrice, gasLimit, getDeploymentBinary(), encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<LegalContract> deploy(Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit,
            BigInteger _contractType, List<Participant> _participants, String _terms,
            String _desc) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint32(_contractType), 
                new org.web3j.abi.datatypes.DynamicArray<Participant>(Participant.class, _participants), 
                new org.web3j.abi.datatypes.Utf8String(_terms), 
                new org.web3j.abi.datatypes.Utf8String(_desc)));
        return deployRemoteCall(LegalContract.class, web3j, transactionManager, gasPrice, gasLimit, getDeploymentBinary(), encodedConstructor);
    }

    public static void linkLibraries(List<Contract.LinkReference> references) {
        librariesLinkedBinary = linkBinaryWithReferences(BINARY, references);
    }

    private static String getDeploymentBinary() {
        if (librariesLinkedBinary != null) {
            return librariesLinkedBinary;
        } else {
            return BINARY;
        }
    }

    public static class Participant extends DynamicStruct {
        public String name;

        public Participant(String name) {
            super(new org.web3j.abi.datatypes.Utf8String(name));
            this.name = name;
        }

        public Participant(Utf8String name) {
            super(name);
            this.name = name.getValue();
        }
    }

    public static class ContractAddedEventResponse extends BaseEventResponse {
        public BigInteger contractId;
    }
}
