package com.leek.wars.client.util.jackson;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Helper using Jackson mappers. Used to manipulate Json, to parse objects and to convert them into other objects.
 */
public enum JacksonHelper {

	INSTANCE;

	private ObjectMapper mapper;

	private JacksonHelper() {
		mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	/**
	 * Generates a Json from an Object
	 * @param o The object that will be printed to Json 
	 * @return the Json in String format 
	 * @throws JsonProcessingException 
	 */
	public String objectToJson(Object o) throws JsonProcessingException {
		return mapper.writeValueAsString(o);
	}

	/**
	 * Parses a Json to generate an Object of the passed class based on it
	 * @param clazz The class of the generated Object
	 * @param json The Json in byte[] format
	 * @return The generated Object
	 * @throws IOException
	 */
	public <T> T jsonToObject(Class<T> clazz, byte[] json) throws IOException {
		return mapper.readerFor(clazz).readValue(json);
	}

	/**
	 * Parses a Json to generate an Object of the passed class based on it
	 * @param clazz The class of the generated Object
	 * @param json The Json in String format
	 * @return The generated Object
	 * @throws IOException
	 */
	public <T> T jsonToObject(Class<T> clazz, String json) throws IOException {
		return jsonToObject(clazz, json.getBytes());
	}

	/**
	 * Generates an object of the passed class based on the passed map
	 * @param fieldsValues Map with field names as keys, and field values as values
	 * @param clazz Class of the generated Object
	 * @return The generated Object
	 */
	public <T> T mapToObject(Map<String, String> fieldsValues, Class<T> clazz) {
		return mapper.convertValue(fieldsValues, clazz);
	}

	/**
	 * Converts a passed object to an instance of the passed class
	 * @param clazz The destination class
	 * @param o the object to convert
	 * @return The converted object
	 */
	public <T> T convertObject(Class<T> clazz, Object o) {
		return mapper.convertValue(o, clazz);
	}

	/**
	 * Reads the json from the file specified by the passed filePath and converts it to the passed class
	 * @param clazz The destination class
	 * @param filePath The path defining the file to read
	 * @return
	 * @throws IOException
	 */
	public <T> T fileToJson(Class<T> clazz, String filePath) throws IOException {
		return fileToJson(clazz, new File(filePath));
	}

	/**
	 * Reads the json from the passed File and converts it to the passed class
	 * @param clazz The destination class
	 * @param file The File to read
	 * @return
	 * @throws IOException
	 */
	public <T> T fileToJson(Class<T> clazz, File file) throws IOException {
		try (FileInputStream fis = new FileInputStream(file)) {
			byte[] content = new byte[(int) file.length()];
			fis.read(content);
			return jsonToObject(clazz, content);
		}
	}


}
