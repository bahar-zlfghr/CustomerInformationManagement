package com.dotin.service.component;

import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * @author : Bahar Zolfaghari
 **/
@Component
public class PropertyReaderComponent {
    private static final Properties properties = new Properties();

    static {
        try {
            FileReader fileReader = new FileReader("src/main/resources/app-properties.properties");
            properties.load(fileReader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
