package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Rostyslav on 2/3/2017.
 */
public class GetProperties {
    public GetProperties() {
        this.getProperty();
    }

    private String driver;
    private String url;
    private String user;
    private String password;

    public String getDriver() {
        return driver;
    }

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public void getProperty() {


        try {
            Properties property = new Properties();
            String propFileName = "connect.properties";

            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                property.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }


            driver = property.getProperty("driver");
            url = property.getProperty("url");
            user = property.getProperty("user");
            password = property.getProperty("password");

        } catch (IOException e) {
            System.err.println("Property file doesn`t exists!");
        }
    }
}
