package com.abdul.eth.domain.ethereum.usecase;

import com.abdul.eth.domain.ethereum.model.LegalContractInfo;
import com.abdul.eth.domain.ethereum.port.in.DeployLegalContractUseCase;
import com.abdul.eth.wrappers.contracts.LegalContract;
import com.abdul.eth.wrappers.contracts.LegalContract.Participant;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.tx.gas.ContractGasProvider;

@Service
@RequiredArgsConstructor
public class DeployLegalContractUseCaseImpl implements DeployLegalContractUseCase {

    @Value("${ethereum.wallet.private-key-hex}")
    private String privateKeyHex;

    private final ContractGasProvider contractGasProvider;
    private final Web3j web3j;

    public LegalContract execute(LegalContractInfo legalContractInfo) throws Exception {
        List<Participant> participantList = new ArrayList<>();
        for (String participant : legalContractInfo.getContractParticipants()) {
            participantList.add(new LegalContract.Participant(participant));
        }
        return LegalContract.deploy(
                web3j,
                Credentials.create(privateKeyHex),
                contractGasProvider,
                legalContractInfo.getContractType().getValue(),
                participantList,
                legalContractInfo.getTerms(),
                legalContractInfo.getDescription()
        ).send();
    }
}
