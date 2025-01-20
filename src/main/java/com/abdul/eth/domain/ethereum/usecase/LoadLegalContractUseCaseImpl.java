package com.abdul.eth.domain.ethereum.usecase;

import com.abdul.eth.domain.ethereum.model.LoadLegalContractInfo;
import com.abdul.eth.domain.ethereum.port.in.LoadLegalContractUseCase;
import com.abdul.eth.domain.ethereum.validators.SmartContractValidator;
import com.abdul.eth.wrappers.contracts.LegalContract;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.tx.gas.ContractGasProvider;

@Service
@RequiredArgsConstructor
public class LoadLegalContractUseCaseImpl implements LoadLegalContractUseCase {

    private final Web3j web3j;
    private final ContractGasProvider contractGasProvider;
    private final SmartContractValidator smartContractValidator;

    @Value("${ethereum.wallet.private-key-hex}")
    private String privateKeyHex;

    public LegalContract execute(LoadLegalContractInfo loadLegalContractInfo) throws IOException {
        if (!smartContractValidator.contractExists(loadLegalContractInfo.getContractAddress())) {
            return null;
        }
        return LegalContract.load(loadLegalContractInfo.getContractAddress(), web3j,
                Credentials.create(privateKeyHex), contractGasProvider);
    }

}
