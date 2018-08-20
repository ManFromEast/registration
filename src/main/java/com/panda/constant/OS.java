package com.panda.constant;

public enum OS {

    MAC("mac"),
    UNIX("unix"),
    LINUX("linux"),
    WINDOWS("windows"),
    POSIX_UNIX("posix_unix"),
    OTHER("other");

    private String osName;

    OS(String osName) {
        this.osName = osName;
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

}
