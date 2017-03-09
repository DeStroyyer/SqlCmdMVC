package utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Rostyslav on 2/3/2017.
 */
public class ConnectProperty {
    private Properties properties;

    public ConnectProperty(String propertyFileName){
        properties=getList(propertyFileName);
    }

    public ConnectProperty() {
    }

    public Properties getList(String propertyFileName) {

        Properties property = new Properties();
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propertyFileName)) {
            if (inputStream != null) {
                property.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propertyFileName + "' not found in the classpath");
            }
        } catch (IOException e) {
            System.err.println("Property file doesn`t exists!");
        }
    return property;
    }
    public String  getProperty(String key) {
       return properties.getProperty(key);

    }

}
