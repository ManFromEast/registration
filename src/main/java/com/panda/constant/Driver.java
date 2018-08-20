package com.panda.constant;

public enum Driver {

    IE("webdriver.ie.driver"),
    CHROME("webdriver.chrome.driver"),
    FIREFOX("webdriver.gecko.driver"),
    PHANTOMJS("phantomjs.binary.path");

    public String driverName;

    Driver(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverName() {
        return driverName;
    }

}
