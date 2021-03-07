package cn.itrip.util;

import java.util.Objects;

/**
 * @description:
 * @author: 浮~沉
 * @create: 2020-07-15 14:30
 */
public class StringUtil {


    /**
     * 根据传入和字符串和下标 将对应下标位置大写
     * @param str 字符串
     * @param index 从1开始
     * @return 返回处理结果
     */
    public static String toUpperWithIndex(String str, int index) {
        if (index < 0) {
            return null;
        }
        if (Objects.isNull(str)) {
            return null;
        }
        //首字母大小写
        switch (index) {
            case 0:
                 return str;
            case 1:
                return str.substring(0, index).toUpperCase() + str.substring(index);
            default:
                return str.substring(0, index) +
                        str.substring(index, index + 1).toUpperCase() +
                        str.substring(index + 1);
        }

    }


    /**
     * 首字母小写
     * @param str 字符串
     * @return 返回处理结果
     */
    public static String toLowerFirstWord(String str) {
        if (Objects.isNull(str)) {
            return null;
        }
        return str.substring(0, 1).toLowerCase() + str.substring(1);
    }


    /**
     * 将数据库的格式映射为java格式
     * <p>
     *     默认是根据下划线进行区分，age： "web_admin_add" will be return WebAdminAdd
     * </p>
     * @param tableName 表名
     * @return 返回首字母大写的java格式
     */
    public static String removeUnderLine(String tableName) {
        if (tableName == null) {
            return null;
        }
        StringBuilder fieldNameBuffer = new StringBuilder();
        String[] temp = tableName.split("_");
        for (String s : temp) {
            fieldNameBuffer.append(toUpperWithIndex(s, 1));
        }
        return fieldNameBuffer.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeUnderLine("web_admin_add"));
    }
}
