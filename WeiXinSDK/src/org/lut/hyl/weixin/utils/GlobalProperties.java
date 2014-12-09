package org.lut.hyl.weixin.utils;

import java.io.IOException;
import java.util.Properties;

public class GlobalProperties {
	public static String CHARACTER_ENCODING = "UTF-8";
	public static String TULIN_API_KEY = "http://www.tuling123.com/openapi/api?key=5b0a070cead4b60d1cfa71c8d42b71db";
	public static String TOKEN = "token_key";
	static {
		try {
			Properties properties = new Properties();
			properties.load(GlobalProperties.class.getClassLoader()
					.getResourceAsStream("weixin.properties"));
			CHARACTER_ENCODING = properties.getProperty("charset", "UTF-8");
			TOKEN = properties.getProperty("token", "token_key");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
