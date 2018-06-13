package com.panda.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class EnvUtil {
	
	private static String env;
	
	static {   
        Properties prop = new Properties();   
        InputStream in = Object.class.getResourceAsStream("/application.properties");   
        try {   
            prop.load(in);   
            env = prop.getProperty("spring.profiles.active").trim();   
        } catch (IOException e) {   
            e.printStackTrace();   
        }   
    }   
	
	public static String getEnv() {
		return env;
	}

	public static void setEnv(String env) {
		EnvUtil.env = env;
	}

	 public static void main(String args[]){   
	        System.out.println(getEnv());   
	    }  
	
	
}
