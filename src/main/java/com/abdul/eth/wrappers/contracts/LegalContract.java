package com.abdul.eth.wrappers.contracts;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.11.0.
 */
@SuppressWarnings("rawtypes")
public class LegalContract extends Contract {
    public static final String BINARY = "608060405234801561000f575f80fd5b50604051610acc380380610acc83398101604081905261002e916100ed565b5f80546001600160a01b031916331781555b81518110156100a2576002604051806020016040528084848151811061006857610068610211565b60209081029190910181015190915282546001810184555f9384529220815191920190819061009790826102a9565b505050600101610040565b5050610363565b634e487b7160e01b5f52604160045260245ffd5b604051601f8201601f191681016001600160401b03811182821017156100e5576100e56100a9565b604052919050565b5f602082840312156100fd575f80fd5b81516001600160401b03811115610112575f80fd5b8201601f81018413610122575f80fd5b80516001600160401b0381111561013b5761013b6100a9565b8060051b61014b602082016100bd565b91825260208184018101929081019087841115610166575f80fd5b6020850192505b838310156102065782516001600160401b0381111561018a575f80fd5b8501603f8101891361019a575f80fd5b60208101516001600160401b038111156101b6576101b66100a9565b6101c9601f8201601f19166020016100bd565b8181526040838301018b10156101dd575f80fd5b8160408401602083015e5f6020838301015280855250505060208201915060208301925061016d565b979650505050505050565b634e487b7160e01b5f52603260045260245ffd5b600181811c9082168061023957607f821691505b60208210810361025757634e487b7160e01b5f52602260045260245ffd5b50919050565b601f8211156102a457805f5260205f20601f840160051c810160208510156102825750805b601f840160051c820191505b818110156102a1575f815560010161028e565b50505b505050565b81516001600160401b038111156102c2576102c26100a9565b6102d6816102d08454610225565b8461025d565b6020601f821160018114610308575f83156102f15750848201515b5f19600385901b1c1916600184901b1784556102a1565b5f84815260208120601f198516915b828110156103375787850151825560209485019460019092019101610317565b508482101561035457868401515f19600387901b60f8161c191681555b50505050600190811b01905550565b61075c806103705f395ff3fe608060405260043610610071575f3560e01c80633ccfd60b1161004c5780633ccfd60b146100f15780638da5cb5b14610105578063ad6057291461013b578063cfae321714610158575f80fd5b80631b9db2ef1461007c57806335c1d349146100b1578063364de8b6146100d0575f80fd5b3661007857005b5f80fd5b348015610087575f80fd5b5061009b61009636600461047e565b61016c565b6040516100a89190610495565b60405180910390f35b3480156100bc575f80fd5b5061009b6100cb36600461047e565b610266565b3480156100db575f80fd5b506100ef6100ea3660046104de565b610310565b005b3480156100fc575f80fd5b506100ef61038f565b348015610110575f80fd5b505f54610123906001600160a01b031681565b6040516001600160a01b0390911681526020016100a8565b348015610146575f80fd5b506002546040519081526020016100a8565b348015610163575f80fd5b5061009b6103f2565b60025460609082106101bb5760405162461bcd60e51b8152602060048201526013602482015272496e646578206f7574206f6620626f756e647360681b60448201526064015b60405180910390fd5b600282815481106101ce576101ce610591565b905f5260205f20015f0180546101e3906105a5565b80601f016020809104026020016040519081016040528092919081815260200182805461020f906105a5565b801561025a5780601f106102315761010080835404028352916020019161025a565b820191905f5260205f20905b81548152906001019060200180831161023d57829003601f168201915b50505050509050919050565b60028181548110610275575f80fd5b5f9182526020909120018054909150819061028f906105a5565b80601f01602080910402602001604051908101604052809291908181526020018280546102bb906105a5565b80156103065780601f106102dd57610100808354040283529160200191610306565b820191905f5260205f20905b8154815290600101906020018083116102e957829003601f168201915b5050505050905081565b5f546001600160a01b031633146103395760405162461bcd60e51b81526004016101b2906105dd565b6040805160208101909152818152600280546001810182555f9190915281517f405787fa12a823e0f2b7631cc41b3ba8828b3321ca811111fa75cd3aa3bb5ace909101908190610389908261066b565b50505050565b5f546001600160a01b031633146103b85760405162461bcd60e51b81526004016101b2906105dd565b5f80546040516001600160a01b03909116914780156108fc02929091818181858888f193505050501580156103ef573d5f803e3d5ffd5b50565b600180546103ff906105a5565b80601f016020809104026020016040519081016040528092919081815260200182805461042b906105a5565b80156104765780601f1061044d57610100808354040283529160200191610476565b820191905f5260205f20905b81548152906001019060200180831161045957829003601f168201915b505050505081565b5f6020828403121561048e575f80fd5b5035919050565b602081525f82518060208401528060208501604085015e5f604082850101526040601f19601f83011684010191505092915050565b634e487b7160e01b5f52604160045260245ffd5b5f602082840312156104ee575f80fd5b813567ffffffffffffffff811115610504575f80fd5b8201601f81018413610514575f80fd5b803567ffffffffffffffff81111561052e5761052e6104ca565b604051601f8201601f19908116603f0116810167ffffffffffffffff8111828210171561055d5761055d6104ca565b604052818152828201602001861015610574575f80fd5b816020840160208301375f91810160200191909152949350505050565b634e487b7160e01b5f52603260045260245ffd5b600181811c908216806105b957607f821691505b6020821081036105d757634e487b7160e01b5f52602260045260245ffd5b50919050565b60208082526022908201527f4f6e6c79206f776e65722063616e2063616c6c20746869732066756e6374696f604082015261371760f11b606082015260800190565b601f82111561066657805f5260205f20601f840160051c810160208510156106445750805b601f840160051c820191505b81811015610663575f8155600101610650565b50505b505050565b815167ffffffffffffffff811115610685576106856104ca565b6106998161069384546105a5565b8461061f565b6020601f8211600181146106cb575f83156106b45750848201515b5f19600385901b1c1916600184901b178455610663565b5f84815260208120601f198516915b828110156106fa57878501518255602094850194600190920191016106da565b508482101561071757868401515f19600387901b60f8161c191681555b50505050600190811b0190555056fea26469706673582212204ddf2540ccf651b78f3c0deb79b28a85d3838a051cd0cffe71b0d67b29de010e64736f6c634300081a0033";

    public static final String FUNC_ADDPARTICIPANT = "addParticipant";

    public static final String FUNC_GETPARTICIPANT = "getParticipant";

    public static final String FUNC_GETPARTICIPANTCOUNT = "getParticipantCount";

    public static final String FUNC_GREET = "greet";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_PARTICIPANTS = "participants";

    public static final String FUNC_WITHDRAW = "withdraw";

    @Deprecated
    protected LegalContract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected LegalContract(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected LegalContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected LegalContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> addParticipant(String _participant) {
        final Function function = new Function(
                FUNC_ADDPARTICIPANT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_participant)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> getParticipant(BigInteger index) {
        final Function function = new Function(FUNC_GETPARTICIPANT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(index)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> getParticipantCount() {
        final Function function = new Function(FUNC_GETPARTICIPANTCOUNT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> greet() {
        final Function function = new Function(FUNC_GREET, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> owner() {
        final Function function = new Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> participants(BigInteger param0) {
        final Function function = new Function(FUNC_PARTICIPANTS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> withdraw() {
        final Function function = new Function(
                FUNC_WITHDRAW, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static LegalContract load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new LegalContract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static LegalContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new LegalContract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static LegalContract load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new LegalContract(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static LegalContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new LegalContract(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<LegalContract> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, List<String> _participants) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Utf8String>(
                        org.web3j.abi.datatypes.Utf8String.class,
                        org.web3j.abi.Utils.typeMap(_participants, org.web3j.abi.datatypes.Utf8String.class))));
        return deployRemoteCall(LegalContract.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<LegalContract> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, List<String> _participants) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Utf8String>(
                        org.web3j.abi.datatypes.Utf8String.class,
                        org.web3j.abi.Utils.typeMap(_participants, org.web3j.abi.datatypes.Utf8String.class))));
        return deployRemoteCall(LegalContract.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<LegalContract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, List<String> _participants) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Utf8String>(
                        org.web3j.abi.datatypes.Utf8String.class,
                        org.web3j.abi.Utils.typeMap(_participants, org.web3j.abi.datatypes.Utf8String.class))));
        return deployRemoteCall(LegalContract.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<LegalContract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, List<String> _participants) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Utf8String>(
                        org.web3j.abi.datatypes.Utf8String.class,
                        org.web3j.abi.Utils.typeMap(_participants, org.web3j.abi.datatypes.Utf8String.class))));
        return deployRemoteCall(LegalContract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }
}
