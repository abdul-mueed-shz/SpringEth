package com.abdul.eth.domain.ethereum.port.in;

import com.abdul.eth.domain.ethereum.model.LegalContractInfo;

public interface CreateLegalContractUseCase {

    LegalContractInfo execute(LegalContractInfo legalContractInfo) throws Exception;
}
