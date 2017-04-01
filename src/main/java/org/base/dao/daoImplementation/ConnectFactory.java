package org.base.dao.daoImplementation;

import org.base.dao.Dao;
import org.base.dao.DaoFactory;
import org.base.utils.ConnectProperty;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectFactory implements DaoFactory {
    private String driver;
    private String url;
    private String user;
    private String password;

    private ConnectProperty connectProperty;

    public void setConnectProperty(ConnectProperty connectProperty) {
        this.connectProperty = connectProperty;
    }

    public ConnectFactory() {

    }

    public void initDaoFactory() {
        this.driver = connectProperty.getProperty("driver");
        this.url = connectProperty.getProperty("url");
        this.user = connectProperty.getProperty("user");
        this.password = connectProperty.getProperty("password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);

    }

}

