package cn.itrip.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: javaType 和 jdbcType 的互转
 * @author: 浮~沉
 * @create: 2020-07-15 15:21
 */
public class SwitchTypeUtil {

    private static final Map<String, String> jdbcTypeConvertToJavaTypeMap = new HashMap<String, String>(){{
        put("BIGINT", "Long");
        put("INT", "Integer");
        put("TINYINT", "Integer");
        put("VARCHAR", "String");
        put("TEXT", "String");
        put("DATETIME", "Date");
        put("DECIMAL", "Double");
    }};


    public static String getJavaType(String jdbcType) {
        String javaType = jdbcTypeConvertToJavaTypeMap.get(jdbcType);
        return  javaType == null ? "Object" : javaType;
    }
}
