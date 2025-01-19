package com.abdul.eth.domain.ethereum.usecase;

import com.abdul.eth.domain.ethereum.port.in.CreateWalletUseCase;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.web3j.crypto.Wallet;
import org.web3j.crypto.WalletFile;
import org.web3j.crypto.exception.CipherException;

@Service
@RequiredArgsConstructor
public class CreateWalletUseCaseImpl implements CreateWalletUseCase {

    @Value("${ethereum.wallet.directory-path}")
    private String walletDirectoryPath;

    private final ObjectMapper objectMapper;

    public void execute(String walletName, String password, String privateKeyHex)
            throws IOException, CipherException {

        BigInteger privateKey = new BigInteger(privateKeyHex, 16);
        WalletFile walletFile =
                Wallet.create(password, org.web3j.crypto.ECKeyPair.create(privateKey), 1024, 1);
        File walletDirectory = getWalletDirectory(walletDirectoryPath);
        File walletFilePath = new File(walletDirectory, walletName + ".json");
        objectMapper.writeValue(walletFilePath, walletFile);
    }

    private static File getWalletDirectory(String path) {
        File walletDirectory = new File(path);

        if (walletDirectory.exists()) {
            return walletDirectory;
        }
        if (walletDirectory.mkdirs()) {
            return walletDirectory;
        }
        return null;
    }
}
