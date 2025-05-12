package cl.conversor;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
    private static final String CONFIG_FILE = "src/config.properties";
    private Properties properties;

    public Config(){
        properties = new Properties();
        try (FileInputStream fis = new FileInputStream(CONFIG_FILE)) {
            properties.load(fis);
        }catch (IOException e){
            System.out.println("Error cargando configuración: " + e.getMessage());
        }
    }
    public String get(String key) {
        return properties.getProperty(key);
    }
}
