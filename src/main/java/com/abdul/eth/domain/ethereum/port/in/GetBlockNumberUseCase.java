package com.abdul.eth.domain.ethereum.port.in;

import java.io.IOException;
import java.math.BigInteger;

public interface GetBlockNumberUseCase {

    BigInteger get() throws IOException;
}
