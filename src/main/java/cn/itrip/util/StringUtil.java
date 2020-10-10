package cn.itrip.util;

/**
 * @description:
 * @author: 浮~沉
 * @create: 2020-07-15 14:30
 */
public class StringUtil {


    /**
     * 某位置指定大写
     * @param str
     * @param index 从1开始
     * @return
     */
    public static String toUpperWithIndex(String str, int index) {
        if (index <= 0 ) return str;
        //首字母大小写
        if (index == 1) return str.substring(0, index).toUpperCase() + str.substring(index);
        return str.substring(0, index) +
                    str.substring(index, index + 1).toUpperCase() +
                        str.substring(index + 1);
    }



    public static String toLowerFirstWord(String str) {
        return str.substring(0, 1).toLowerCase() + str.substring(1);
    }


    /**
     * 去除数据表的下划线
     * @param tableName
     * @return
     */
    public static String removeUnderLine(String tableName) {
        if(tableName == null) return null;
        StringBuffer fieldNameBuffer = new StringBuffer();
        String temp[] = tableName.split("_");
        for (int i = 0; i < temp.length; i++) {
            fieldNameBuffer.append(toUpperWithIndex(temp[i], 1));
        }
        return fieldNameBuffer.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeUnderLine("web_admin_add"));
    }
}
