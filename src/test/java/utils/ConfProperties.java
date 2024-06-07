package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfProperties {
    private static final Properties commonProperties;

    static {
        commonProperties = loadProperties("src/test/resources/conf.properties");

    }

    public static String getCommonProperty(String key) {
        return commonProperties.getProperty(key);
    }

    public static boolean getCommonBoolProperty(String key) {
        return Boolean.parseBoolean(commonProperties.getProperty(key));
    }

    private static Properties loadProperties(String filePath) {
        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
            Properties properties = new Properties();
            properties.load(fileInputStream);
            return properties;
        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties from file: " + filePath, e);
        }
    }
}