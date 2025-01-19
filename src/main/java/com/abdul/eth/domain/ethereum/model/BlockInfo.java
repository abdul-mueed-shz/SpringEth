package com.abdul.eth.domain.ethereum.model;

import java.math.BigInteger;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BlockInfo {

    private BigInteger blockNumber;
}
