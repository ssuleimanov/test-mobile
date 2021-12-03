package ua.pivdenny.pionmobile.utils;


import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Slf4j
public class ProjectPropertiesLoader {

    public static Properties load() {

        Properties properties = new Properties();

        try (FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/project.properties")) {

            properties.load(fis);
            log.info("Project properties has been loaded");
        } catch (IOException e) {
            e.printStackTrace();
            log.info("Failed to load properties file");

        }

        return properties;
    }
}
