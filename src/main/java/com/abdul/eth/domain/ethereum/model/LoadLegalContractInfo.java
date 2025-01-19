package com.abdul.eth.domain.ethereum.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class LoadLegalContractInfo {

    private String contractAddress;
}
