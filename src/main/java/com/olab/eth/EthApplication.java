package com.olab.eth;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Wallet;
import org.web3j.crypto.WalletFile;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

@SpringBootApplication
public class EthApplication {

	private static void createWalletFromPK() throws IOException, CipherException {
		// Replace with your existing private key (in hexadecimal format)
		// 0xac0974bec39a17e36ba4a6b4d238ff944bacb478cbed5efcae784d7bf4f2ff80
		String privateKeyHex = "ac0974bec39a17e36ba4a6b4d238ff944bacb478cbed5efcae784d7bf4f2ff80";

		// Password to encrypt the wallet
		String password = "abc12345";

		// Convert the private key from hex string to BigInteger
		BigInteger privateKey = new BigInteger(privateKeyHex, 16);

		// Generate the wallet file using the private key
		WalletFile walletFile = Wallet.create(password, org.web3j.crypto.ECKeyPair.create(privateKey), 1024, 1);

		// Directory to store the wallet file
		File walletDirectory = new File("./wallets");
		if (!walletDirectory.exists()) {
			walletDirectory.mkdirs();
		}

		// Save the wallet file to the specified directory
		File walletFilePath = new File(walletDirectory, "myExistingAccountWallet.json");

		// Use Jackson to write the WalletFile object as JSON
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.writeValue(walletFilePath, walletFile);

		System.out.println("Wallet file created: " + walletFilePath.getAbsolutePath());
	}

	private void checkBlockNumber() {
		Web3j web3 = Web3j.build(new HttpService("http://127.0.0.1:8545"));

		try {
			BigInteger blockNumber = web3.ethBlockNumber().send().getBlockNumber();
			System.out.println("Latest Ethereum block number: " + blockNumber);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws CipherException, IOException {
		SpringApplication.run(EthApplication.class, args);
	}

}
