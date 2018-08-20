package com.panda.constant;

import java.util.HashSet;
import java.util.Set;

public enum OperatingSystem {

    WINDOWS("windows", "windows", ".exe"), LINUX("linux", "linux", ""), MAC("mac", "mac", "");

    private final String osName;
    private final String osDirectory;
    private final String osFileSuffix;

    OperatingSystem(String osName, String osDirectory, String osFileSuffix) {
        this.osName = osName;
        this.osDirectory = osDirectory;
        this.osFileSuffix = osFileSuffix;
    }

    public static OperatingSystem getOperatingSystem(String osName) {
        for (final OperatingSystem operatingSystemName : values()) {
            if (osName.toLowerCase().contains(operatingSystemName.getOsName())) {
                return operatingSystemName;
            }
        }
        throw new IllegalArgumentException("Unrecognised operating system name '" + osName + "'");
    }

    public static Set<OperatingSystem> getCurrentOS() {
        final String currentOSName = System.getProperties().getProperty("os.name");

        final Set<OperatingSystem> operatingSystems = new HashSet<>();
        operatingSystems.add(getOperatingSystem(currentOSName));

        return operatingSystems;
    }

    public static OperatingSystem getCurrentOperatingSystem() {
        final String currentOSName = System.getProperties().getProperty("os.name");
        return getOperatingSystem(currentOSName);
    }

    public String getOsName() {
        return osName;
    }

    public String getOsDirectory() {
        return osDirectory;
    }

    public String getOsFileSuffix() {
        return osFileSuffix;
    }

}
