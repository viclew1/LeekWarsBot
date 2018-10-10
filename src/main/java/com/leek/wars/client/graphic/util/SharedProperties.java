package com.leek.wars.client.graphic.util;

import java.util.Properties;

public class SharedProperties extends Properties {

	public static final SharedProperties INSTANCE = new SharedProperties();
	
	private static final long serialVersionUID = 7843358817743641241L;

	private SharedProperties() {}
	
}
