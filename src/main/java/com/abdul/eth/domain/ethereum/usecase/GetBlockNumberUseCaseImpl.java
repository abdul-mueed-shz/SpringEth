package com.abdul.eth.domain.ethereum.usecase;

import com.abdul.eth.domain.ethereum.port.in.GetBlockNumberUseCase;
import java.io.IOException;
import java.math.BigInteger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.web3j.protocol.Web3j;

@Service
@RequiredArgsConstructor
public class GetBlockNumberUseCaseImpl implements GetBlockNumberUseCase {

    private final Web3j web3j;

    public BigInteger get() throws IOException {
        return web3j.ethBlockNumber().send().getBlockNumber();
    }
}
