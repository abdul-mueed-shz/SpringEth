package com.abdul.eth.domain.ethereum.usecase;

import com.abdul.eth.domain.ethereum.enums.ContractType;
import com.abdul.eth.domain.ethereum.model.LegalContractInfo;
import com.abdul.eth.domain.ethereum.model.LoadLegalContractInfo;
import com.abdul.eth.domain.ethereum.port.in.GetLegalContractUseCase;
import com.abdul.eth.domain.ethereum.port.in.LoadLegalContractUseCase;
import com.abdul.eth.wrappers.contracts.LegalContract;
import com.abdul.eth.wrappers.contracts.LegalContract.Participant;
import java.math.BigInteger;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.web3j.tuples.generated.Tuple5;

@Service
@RequiredArgsConstructor
public class GetLegalContractUseCaseImpl implements GetLegalContractUseCase {

    private final LoadLegalContractUseCase loadLegalContractUseCase;

    public LegalContractInfo get(BigInteger legalContractId) throws Exception {
        // TODO: Validate if a contract is deployed or not on the chain from your off-chain data
        // Don't use this hardcoded address. Validate if contract exists from the above step
        // and then load it from the address retrieved.
        String contractAddress = "0x5fbdb2315678afecb367f032d93f642f64180aa3";
        LegalContract legalContract = loadLegalContractUseCase
                .execute(LoadLegalContractInfo.builder().contractAddress(contractAddress).build());

        // Handle contract does not exist use case.
        Tuple5<BigInteger, BigInteger, List<Participant>, String, String> contractDetails =
                legalContract.getContract(legalContractId).send();

        List<String> participants = contractDetails.component3().stream().map(
                participant -> participant.name
        ).toList();
        return LegalContractInfo.builder()
                .id(contractDetails.component1())
                .contractParticipants(participants)
                .contractType(ContractType.fromValue(contractDetails.component2()))
                .terms(contractDetails.component4())
                .description(contractDetails.component5())
                .build();
    }
}
