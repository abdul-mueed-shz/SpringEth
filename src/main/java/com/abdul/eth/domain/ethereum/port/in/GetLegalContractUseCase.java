package com.abdul.eth.domain.ethereum.port.in;

import com.abdul.eth.domain.ethereum.model.LegalContractInfo;
import java.math.BigInteger;

public interface GetLegalContractUseCase {

    LegalContractInfo get(BigInteger legalContractId) throws Exception;
}
