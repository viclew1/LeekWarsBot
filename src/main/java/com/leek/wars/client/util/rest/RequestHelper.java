package com.leek.wars.client.util.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;
import com.leek.wars.client.util.GlobalProperties;
import com.leek.wars.client.util.exceptions.ServerException;
import com.leek.wars.client.util.jackson.JacksonHelper;

enum RequestHelper implements AutoCloseable {

	INSTANCE;

	private static final Logger logger = LoggerFactory.getLogger(RequestHelper.class);

	private DefaultHttpClient client;

	private RequestHelper() {
		client = new DefaultHttpClient();
		if (GlobalProperties.INSTANCE.getProxyUrl() != null) {
			String proxyUrl = GlobalProperties.INSTANCE.getProxyUrl();
			int proxyPort = Integer.parseInt(GlobalProperties.INSTANCE.getProxyPort());
			HttpHost proxy = new HttpHost(proxyUrl, proxyPort);
			client.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY,proxy);
		}
	}

	private String readOutput(HttpResponse response) throws ServerException, IOException {
		return readInputStream(response.getEntity().getContent());
	}

	private String readInputStream(InputStream is) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String completeData = "";
		String data;
		while ((data = br.readLine()) != null) {
			completeData += data;
		}
		return completeData;
	}

	private String processRequest(HttpUriRequest request) throws IOException, ServerException {

		logger.debug("Request  : " + request.getURI().toString());
		HttpResponse response = client.execute(request);

		int code = response.getStatusLine().getStatusCode();

		String msg = readOutput(response);
		logger.debug("Response : " + msg);
		
		if (code < HttpURLConnection.HTTP_BAD_REQUEST) {
			return msg;
		} else {
			String url = request.getURI().toString();
			JsonNode errorMsgNode = JacksonHelper.INSTANCE.jsonToObject(JsonNode.class, msg).get("message");
			String errorMsgText = errorMsgNode == null ? "" : errorMsgNode.asText();
			throw new ServerException(url, code, errorMsgText);
		}
	}



	public String processPostRequest(String url, String input) throws IOException, ServerException {
		HttpPost postRequest = new HttpPost(url);
		if (input != null && !"".equals(input)) {
			StringEntity entity = new StringEntity(input);
			entity.setContentType("application/json");
			postRequest.setEntity(entity);
		}
		return processRequest(postRequest);
	}

	public String processGetRequest(String url) throws IOException, ServerException {
		HttpGet getRequest = new HttpGet(url);
		return processRequest(getRequest);
	}

	public String processPutRequest(String url, String input) throws IOException, ServerException {
		HttpPut putRequest = new HttpPut(url);
		if (input != null && !"".equals(input)) {
			StringEntity entity = new StringEntity(input);
			entity.setContentType("application/json");
			putRequest.setEntity(entity);
		}
		return processRequest(putRequest);
	}

	public String processDeleteRequest(String url) throws IOException, ServerException {
		HttpDelete deleteRequest = new HttpDelete(url);
		return processRequest(deleteRequest);
	}

	@Override
	public void close() throws Exception {
		client.getConnectionManager().shutdown();
	}

}
