package com.abdul.eth.domain.ethereum.validators;

import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.EthGetCode;

@Component
@RequiredArgsConstructor
public class SmartContractValidator {

    private final Web3j web3j;

    public boolean contractExists(String contractAddress) throws IOException {
        EthGetCode ethGetCode =
                web3j.ethGetCode(contractAddress, org.web3j.protocol.core.DefaultBlockParameterName.LATEST).send();
        String code = ethGetCode.getCode();
        return code != null && !code.equals("0x");
    }
}
