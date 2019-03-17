package com.leek.wars.client.util.files;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum FileHelper {

	INSTANCE;

	private static final Logger logger = LoggerFactory.getLogger(FileHelper.class);

	private FileHelper() {}


	public void delete(String path) {
		delete(new File(path));
	}

	public void delete(File f) {
		if (f.isDirectory()) {
			deleteDir(f);
		} else {
			deleteFile(f);
		}
	}

	private void deleteDir(File f) {
		for (File subF : f.listFiles()) {
			delete(subF);
		}
		f.delete();
	}

	private void deleteFile(File f) {
		f.delete();
	}

	public File createDir(String path) {
		File f = new File(path);
		f.mkdir();
		return f;
	}

	public File createFile(String path, String content) {
		File f = new File(path);
		try (FileWriter fw = new FileWriter(f, false)) {
			if (content != null) {
				fw.write(content);
			}
			fw.flush();
		} catch (IOException e) {
			logger.error("Can't write file", e);
		}
		return f;
	}

}
