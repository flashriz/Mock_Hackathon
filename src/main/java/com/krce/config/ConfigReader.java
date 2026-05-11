package com.krce.config;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    Properties prop=new Properties();
    public ConfigReader(){

    try {

        FileInputStream file =
                new FileInputStream("src/main/resources/config.properties");

        prop.load(file);

    } catch (Exception e) {

        System.out.println("File not found");
    }
}

    public String getURL(){
        return prop.getProperty("baseUrl");
    }
    public String timeout(){
        return prop.getProperty("timeout");
    }
}
