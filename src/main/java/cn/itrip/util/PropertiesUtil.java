package cn.itrip.util;
/**
 * 获取数据库的工具类
 * @description:
 * @author: 浮~沉
 * @version: 1.0
 * @data 2019年12月27日 上午11:35:28
 * @CopyRight lkg.nb.com
 */

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
	private static Properties properties=new Properties();
	
	static {
		InputStream inputStream=null;
			try {
			inputStream= PropertiesUtil.class.getClassLoader().getResourceAsStream("db.properties");
			properties.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("db.properties不存在");
		}finally {
			if(inputStream!=null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}	
		}
	}
	
	public static String getValue(String key) {
		return properties.getProperty(key) == null ? "" : properties.getProperty(key);
	}

	public static void main(String[] args) {
		System.out.println(PropertiesUtil.getValue("password"));
	}
}
