package com.panda.constant;

import java.util.Arrays;
import java.util.List;

public enum SystemArchitecture {

    ARCHITECTURE_64_BIT("64bit"), ARCHITECTURE_32_BIT("32bit");

    private final String systemArchitectureName;
    private static final SystemArchitecture defaultSystemArchitecture = ARCHITECTURE_32_BIT;
    private static List<String> architecture64bitNames = Arrays.asList("amd64", "x86_64");

    SystemArchitecture(String systemArchitectureName) {
        this.systemArchitectureName = systemArchitectureName;
    }

    public String getSystemArchitectureName() {
        return systemArchitectureName;
    }

    public static SystemArchitecture getSystemArchitecture(String currentArchitecture) {
        SystemArchitecture result = defaultSystemArchitecture;
        if (architecture64bitNames.contains(currentArchitecture)) {
            result = ARCHITECTURE_64_BIT;
        }
        return result;
    }

    public static SystemArchitecture getCurrentSystemArchitecture() {
        final String currentArchitecture = System.getProperties().getProperty("os.arch");
        return getSystemArchitecture(currentArchitecture);
    }
}
