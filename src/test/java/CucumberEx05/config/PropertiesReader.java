package CucumberEx05.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader implements ConfReader {
    private final Properties properties = new Properties();

    public PropertiesReader() {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        try (InputStream config = contextClassLoader.getResourceAsStream("config/config.properties")) {
            properties.load(config);
        } catch (IOException e) {
            throw new IllegalStateException();
        }
    }

    @Override
    public String getValue(String key) {
        return properties.getProperty(key);
    }

    @Override
    public boolean getBooleanValue(String booleanValue) {
        if (properties.getProperty(booleanValue).equals(false)){
            return false;
        }
        return true;
    }
}
