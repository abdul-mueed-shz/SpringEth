package com.abdul.eth.domain.ethereum.port.in;

import com.abdul.eth.domain.ethereum.model.LegalContractInfo;
import com.abdul.eth.wrappers.contracts.LegalContract;

public interface DeployLegalContractUseCase {

    LegalContract execute(LegalContractInfo deployContractRequestInfo) throws Exception;
}
