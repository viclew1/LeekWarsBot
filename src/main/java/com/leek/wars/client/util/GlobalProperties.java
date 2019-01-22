package com.leek.wars.client.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public enum GlobalProperties {

	INSTANCE;
	
	private String url;
	private String proxyUrl;
	private String proxyPort;

	private GlobalProperties() {}

	public void init(String propsPath) throws IOException {
		Properties props = new Properties();
		props.load(new FileInputStream(new File(propsPath)));
		url      	= props.getProperty("url");
		proxyUrl 	= props.getProperty("proxy_url");
		proxyPort	= props.getProperty("proxy_port");
	}


	public String getUrl() {
		return url;
	}

	public String getProxyUrl() {
		return proxyUrl;
	}

	public String getProxyPort() {
		return proxyPort;
	}

}
