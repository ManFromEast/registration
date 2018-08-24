package com.panda.constant;

public enum Browser {

    CHROME("chrome"), FIREFOX("firefox");

    private String browser;

    Browser(String browser) {
        this.browser = browser;
    }

    public String getBrowser() {
        return browser;
    }

}
