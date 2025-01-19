package com.abdul.eth.domain.ethereum.port.in;

import com.abdul.eth.domain.ethereum.model.BlockInfo;
import java.io.IOException;

public interface GetBlockNumberUseCase {

    BlockInfo get() throws IOException;
}
