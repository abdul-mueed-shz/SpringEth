package com.abdul.eth.domain.ethereum.enums;

import java.math.BigInteger;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ContractType {
    RENTAL(BigInteger.valueOf(0), "Rental"),
    LEGAL(BigInteger.valueOf(1), "Legal"),
    NDA(BigInteger.valueOf(2), "NDA");

    private final BigInteger value;
    private final String name;

    public static ContractType fromValue(BigInteger value) {
        for (ContractType type : ContractType.values()) {
            if (type.value == value) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid ContractType value: " + value);
    }
}
