package com.panda.utils;

import java.io.IOException;
import java.util.Locale;

import com.panda.constant.OS;

public class OSInformation {

    private static OS os = OS.OTHER;

    public static OS getOs() {
        return os;
    }

    public static void setOs(OS os) {
        OSInformation.os = os;
    }

    static {
        try {
            String osName = System.getProperty("os.name");
            if (osName == null) {
                throw new IOException("os.name not found");
            }
            osName = osName.toLowerCase(Locale.ENGLISH);
            if (osName.contains("windows")) {
                os = OS.WINDOWS;
            } else if (osName.contains("linux")) {
                os = OS.LINUX;
            } else if (osName.contains("mpe/ix")
                    || osName.contains("freebsd")
                    || osName.contains("irix")
                    || osName.contains("digital unix")
                    || osName.contains("unix")) {
                os = OS.UNIX;
            } else if (osName.contains("mac os")) {
                os = OS.MAC;
            } else if (osName.contains("sun os")
                    || osName.contains("sunos")
                    || osName.contains("solaris")) {
                os = OS.POSIX_UNIX;
            } else if (osName.contains("hp-ux")
                    || osName.contains("aix")) {
                os = OS.POSIX_UNIX;
            } else {
                os = OS.OTHER;
            }
        } catch (Exception ex) {
            os = OS.OTHER;
        } finally {
            // os.setVersion(System.getProperty("os.version"));
        }
    }

    public static void main(String[] args) {
        System.out.println("OS::" + System.getProperty("os.name"));
        System.out.println("OS::" + System.getProperties().getProperty("os.arch"));

    }
}
