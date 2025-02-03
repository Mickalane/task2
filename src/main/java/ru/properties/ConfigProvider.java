package ru.properties;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

public class ConfigProvider {

    private static ConfigReader config;

    static {
        loadConfig();
    }

    private static void loadConfig() {
        ObjectMapper objectMapper = new ObjectMapper();
        try (InputStream inputStream = ConfigProvider.class.getClassLoader().getResourceAsStream("testData.json")) {
            if (inputStream == null) {
                throw new RuntimeException("testData.json не найден в resources");
            }
            config = objectMapper.readValue(inputStream, ConfigReader.class);
        } catch (IOException e) {
            throw new RuntimeException("Ошибка загрузки конфигурации", e);
        }
    }

    public static String getOS() {
        return config.getCheckboxOS();
    }
    public static String getLAN(){
        return config.getCheckboxLAN();
    }
    public static String getAction(){
        return config.getCheckboxACTION();
    }
}
