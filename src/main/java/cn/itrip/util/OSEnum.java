package cn.itrip.util;

/**
 * @Description： 操作系统枚举
 * @Author： lkg
 * @Date： 2021/3/9 1:10 下午
 **/

public enum OSEnum {
    /**
     * linux
     */
    Linux("Linux"),
    /**
     * mac
     */
    Mac_OS("Mac OS"),
    /**
     * mac
     */
    Mac_OS_X("Mac OS X"),
    /**
     * windows
     */
    Windows("Windows");
//    OS2("OS/2"),
//    Solaris("Solaris"),
//    SunOS("SunOS"),
//    MPEiX("MPE/iX"),
//    HP_UX("HP-UX"),
//    AIX("AIX"),
//    OS390("OS/390"),
//    FreeBSD("FreeBSD"),
//    Irix("Irix"),
//    Digital_Unix("Digital Unix"),
//    NetWare_411("NetWare"),
//    OSF1("OSF1"),
//    OpenVMS("OpenVMS"),
//    Others("Others");

    private String desc;

    OSEnum(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "OSEnum{" +
                "desc='" + desc + '\'' +
                '}';
    }
}
