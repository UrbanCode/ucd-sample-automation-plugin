package com.ibm.ucd.sample.automation.plugin;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Util {

    public static Properties readProperties(String propertiesFilePath)
    throws IOException
    {
        Properties properties = new Properties();
        try (FileInputStream inputStream = new FileInputStream(propertiesFilePath)) {
            properties.load(inputStream);
        }
        return properties;
    }

}
