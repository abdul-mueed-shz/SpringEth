package com.abdul.eth.domain.ethereum.port.in;

import java.io.IOException;
import org.web3j.crypto.exception.CipherException;

public interface CreateWalletUseCase {

    void execute(String walletName, String password, String privateKeyHex) throws IOException, CipherException;
}
