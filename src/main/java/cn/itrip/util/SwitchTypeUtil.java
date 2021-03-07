package cn.itrip.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: javaType 和 jdbcType 的互转
 * @author: 浮~沉
 * @create: 2020-07-15 15:21
 */
public class SwitchTypeUtil {

    private static final Map<String, String> JDBC_TYPE_CONVERT_TO_JAVA_TYPE_MAP = new HashMap<String, String>(){{
        put("BIGINT", "Long");
        put("INT", "Integer");
        put("INT UNSIGNED", "Integer");
        put("TINYINT", "Integer");
        put("VARCHAR", "String");
        put("TEXT", "String");
        put("LONGTEXT", "Integer");
//        put("DATETIME", "Date"); 升级到mysql8推荐的日期
        put("DATETIME", "LocalDateTime");
        put("DECIMAL", "Double");
    }};


    public static String getJavaType(String jdbcType) {
        String javaType = JDBC_TYPE_CONVERT_TO_JAVA_TYPE_MAP.get(jdbcType);
        return  javaType == null ? "Object" : javaType;
    }
}
