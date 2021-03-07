package cn.itrip.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author lkg
 */
public class PropertiesUtil {
	private static final Properties PROPERTIES = new Properties();
	
	static {
		InputStream inputStream = null;
			try {
			inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream("db.properties");
			PROPERTIES.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("db.properties不存在");
		}finally {
			if(inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}	
		}
	}
	
	public static String getValue(String key) {
		return PROPERTIES.getProperty(key) == null ? "" : PROPERTIES.getProperty(key);
	}

	public static void main(String[] args) {
		System.out.println(PropertiesUtil.getValue("password"));
	}
}
