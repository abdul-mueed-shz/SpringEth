package com.abdul.eth.domain.ethereum.usecase;

import com.abdul.eth.domain.ethereum.port.in.DeployContractUseCase;
import com.abdul.eth.wrappers.contracts.LegalContract;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.tx.gas.ContractGasProvider;

@Service
@RequiredArgsConstructor
public class DeployContractUseCaseImpl implements DeployContractUseCase {

    @Value("${ethereum.wallet.private-key-hex}")
    private String privateKeyHex;

    private final ContractGasProvider contractGasProvider;
    private final Web3j web3j;

    public String execute(List<String> contractParticipants) throws Exception {
        LegalContract legalContract =
                LegalContract.deploy(
                        web3j,
                        Credentials.create(privateKeyHex),
                        contractGasProvider,
                        contractParticipants).send();
        return legalContract.getContractAddress();
    }
}
