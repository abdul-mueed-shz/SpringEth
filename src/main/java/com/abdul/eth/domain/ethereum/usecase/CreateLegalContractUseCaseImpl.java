package com.abdul.eth.domain.ethereum.usecase;

import com.abdul.eth.domain.ethereum.model.LegalContractInfo;
import com.abdul.eth.domain.ethereum.model.LoadLegalContractInfo;
import com.abdul.eth.domain.ethereum.port.in.CreateLegalContractUseCase;
import com.abdul.eth.domain.ethereum.port.in.DeployLegalContractUseCase;
import com.abdul.eth.domain.ethereum.port.in.LoadLegalContractUseCase;
import com.abdul.eth.wrappers.contracts.LegalContract;
import com.abdul.eth.wrappers.contracts.LegalContract.Participant;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

@Service
@RequiredArgsConstructor
public class CreateLegalContractUseCaseImpl implements CreateLegalContractUseCase {

    private final LoadLegalContractUseCase loadLegalContractUseCase;
    private final DeployLegalContractUseCase deployLegalContractUseCase;

    public LegalContractInfo execute(LegalContractInfo legalContractInfo) throws Exception {
        // TODO:
        //  Check database or whatever storage location you have for addresses to get the address and load the contract.
        String contractAddress = "0x5fbdb2315678afecb367f032d93f642f64180aa3";
        LegalContract legalContract = loadLegalContractUseCase
                .execute(LoadLegalContractInfo.builder().contractAddress(contractAddress).build());

        if (Objects.nonNull(legalContract)) {
            List<Participant> participantList = new ArrayList<>();
            for (String participant : legalContractInfo.getContractParticipants()) {
                participantList.add(new LegalContract.Participant(participant));
            }
            TransactionReceipt transactionReceipt = legalContract.addContract(
                    legalContractInfo.getContractType().getValue(),
                    participantList,
                    legalContractInfo.getTerms(),
                    legalContractInfo.getDescription()
            ).send();
            BigInteger contractId = getContractIdFromContractAddedEvent(transactionReceipt);
            legalContractInfo.setId(contractId);
            return legalContractInfo;
        }
        legalContract = deployLegalContractUseCase.execute(legalContractInfo);
        TransactionReceipt transactionReceipt = legalContract.getTransactionReceipt().orElseThrow(() ->
                new RuntimeException("Transaction receipt not available")
        );
        BigInteger contractId = getContractIdFromContractAddedEvent(transactionReceipt);
        legalContractInfo.setId(contractId);
        return legalContractInfo;
    }

    private BigInteger getContractIdFromContractAddedEvent(
            TransactionReceipt transactionReceipt) {
        List<LegalContract.ContractAddedEventResponse> events =
                LegalContract.getContractAddedEvents(transactionReceipt);
        if (events.isEmpty()) {
            return null;
        }
        return events.get(0).contractId; // Extract the emitted contractId
    }
}
