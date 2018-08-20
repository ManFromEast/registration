package com.panda.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

public class BrowserInformation {

    public Map<String, String> getUserAgent(HttpServletRequest request) {
        Map<String, String> userAgents = new HashMap<String, String>();
        String userAgent = request.getHeader("User-Agent").toLowerCase();
        String version;
        String iePattern = "msie ([\\d.]+)";
        String firefoxPattern = "firefox\\/([\\d.]+)";
        String chromePattern = "chrome\\/([\\d.]+)";
        String operaPattern = "opera.([\\d.]+)/)";
        String safariPattern = "version\\/([\\d.]+).*safari";

        Pattern pattern = Pattern.compile(iePattern);
        Matcher matcher = pattern.matcher(userAgent);
        if (matcher.find()) {
            version = matcher.group();
            userAgents.put("type", "ie");
            userAgents.put("version", version.split(" ")[1]);
            return userAgents;
        }
        pattern = Pattern.compile(firefoxPattern);
        matcher = pattern.matcher(userAgent);
        if (matcher.find()) {
            version = matcher.group();
            userAgents.put("type", "firefox");
            userAgents.put("version", version.split("/")[1]);
            return userAgents;
        }
        pattern = Pattern.compile(chromePattern);
        matcher = pattern.matcher(userAgent);
        if (matcher.find()) {
            version = matcher.group();
            userAgents.put("type", "chrome");
            userAgents.put("version", version.split("/")[1]);
            return userAgents;
        }
        pattern = Pattern.compile(operaPattern);
        matcher = pattern.matcher(userAgent);
        if (matcher.find()) {
            version = matcher.group();
            userAgents.put("type", "opera");
            userAgents.put("version", version.split("\\.")[1]);
            return userAgents;
        }
        pattern = Pattern.compile(safariPattern);
        matcher = pattern.matcher(userAgent);
        if (matcher.find()) {
            version = matcher.group();
            userAgents.put("type", "safari");
            userAgents.put("version", version.split("/")[1].split(".")[0]);
            return userAgents;
        }
        return userAgents;
    }
}
