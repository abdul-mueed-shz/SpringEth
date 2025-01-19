package com.abdul.eth.domain.ethereum.port.in;

import com.abdul.eth.domain.ethereum.model.LoadLegalContractInfo;
import com.abdul.eth.wrappers.contracts.LegalContract;
import java.io.IOException;

public interface LoadLegalContractUseCase {

    LegalContract execute(LoadLegalContractInfo loadLegalContractInfo) throws IOException;
}
