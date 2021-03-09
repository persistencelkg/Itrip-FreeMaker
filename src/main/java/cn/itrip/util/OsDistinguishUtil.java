package cn.itrip.util;

/**
 * @Description： 操作系统识别工具类
 * @Author： lkg
 * @Date： 2021/3/9 9:58 下午
 **/
public class OsDistinguishUtil {

    public static boolean isMac(String osName) {
        return OSEnum.Mac_OS.toString().indexOf(osName) >= 0 ||
                OSEnum.Mac_OS_X.toString().indexOf(osName) >= 0;
    }

    public static boolean isLinux(String osName) {
        return OSEnum.Linux.toString().indexOf(osName) >= 0;
    }

    public static boolean isWindows(String osName) {
        return OSEnum.Windows.toString().indexOf(osName) >= 0;
    }


}
