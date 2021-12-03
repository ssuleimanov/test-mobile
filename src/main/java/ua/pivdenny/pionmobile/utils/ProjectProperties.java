package ua.pivdenny.pionmobile.utils;

import java.util.Properties;

public class ProjectProperties {

    private final static Properties properties = ProjectPropertiesLoader.load();


    public static String getApkFile() {
        String value = properties.getProperty("apkFile");
        if (value != null) return value;
        else throw new RuntimeException("apkFile is absent in properties file");
    }

    public static String getProperty(String propertyName) {
        String value = properties.getProperty(propertyName);
        if (value != null) return value;
        else throw new RuntimeException("Property is absent in properties file");
    }
}