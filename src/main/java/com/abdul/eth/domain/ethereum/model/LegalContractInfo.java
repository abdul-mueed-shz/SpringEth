package com.abdul.eth.domain.ethereum.model;

import com.abdul.eth.domain.ethereum.enums.ContractType;
import java.math.BigInteger;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LegalContractInfo {

    private BigInteger id;
    private List<String> contractParticipants;
    private String terms;
    private String description;
    private ContractType contractType;
}
