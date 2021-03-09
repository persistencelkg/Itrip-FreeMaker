package cn.itrip.util;

import java.io.File;

/**
 *  模版所生成的文件路径参数
 *  需要自定义修改
 */
public class PathConstant {



    /**
     * 三层的通用包名 自定义
     */
    public static String PACKAGE  = "cn.itrip";


    /**
     * 三层生成的文件保存路径
     */
    public static String SERVICE_SAVE_PATH = "D:\\test\\";
    public static String SERVICE_IMPL_SAVE_PATH = "D:\\test\\";
    public static String MAPPER_SAVE_PATH = "D:\\test\\";
    public static String MODEL_SAVE_PATH = "D:\\test\\";

    public static String returnPathWithSystem() {
        String osName = System.getProperty("os.name").toLowerCase();
        System.out.println("current os: " + osName);
        if (OsDistinguishUtil.isWindows(osName)) {
            return "D:\\test\\";
        } else {
            return "/usr/test" + File.separator;
        }


    }
}
