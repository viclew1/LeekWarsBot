package com.leek.wars.client.util.accounts;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.leek.wars.client.util.jackson.JacksonHelper;

public enum AccountHelper {

	INSTANCE;
	
	private static final Logger logger = LoggerFactory.getLogger(AccountHelper.class);
	
	private File accountsFile;
	private AccountsLib accounts;

	private AccountHelper() {}

	public void init(String dataDirPath) throws IOException {
		String accountsFilePath = dataDirPath + "/Accounts";
		accountsFile = new File(accountsFilePath);
		if (accountsFile.exists()) {
			byte[] jsonAccountsByteArray = Files.readAllBytes(Paths.get(accountsFilePath));
			accounts = JacksonHelper.INSTANCE.jsonToObject(AccountsLib.class, new String(jsonAccountsByteArray));
		} else {
			accounts = new AccountsLib();
		}
	}
	
	public Set<String> getUsers() {
		return accounts.keySet();
	}

	public void addAccount(String user, String password) {
		accounts.put(user, password);
		saveState();
	}

	public void deleteAccount(String user) {
		accounts.remove(user);
		saveState();
	}
	
	public void clearAccounts() {
		accounts.clear();
		saveState();
	}

	public String getPassword(String user) {
		return accounts.get(user);
	}

	public void saveState() {
		try (FileWriter accountsFileWriter = new FileWriter(accountsFile, false)) {
			accountsFileWriter.write(JacksonHelper.INSTANCE.objectToJson(accounts));
			accountsFileWriter.flush();
		} catch (IOException e) {
			logger.error("Can't save accounts", e);
		}
	}
}
