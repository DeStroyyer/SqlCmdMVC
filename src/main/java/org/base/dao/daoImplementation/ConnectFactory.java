package org.base.dao.daoImplementation;

import org.base.dao.DaoFactory;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectFactory implements DaoFactory {

    private String driver;
    private String url;
    private String user;
    private String password;

    public ConnectFactory(String driver, String url, String user, String password) {
        this.driver = driver;
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public ConnectFactory() {

    }

    public void init() {
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

