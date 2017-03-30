package org.base.dao.daoImplementation;

import org.base.dao.Dao;
import org.base.dao.DaoFactory;
import org.base.utils.ConnectProperty;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ManagerDaoFactory implements DaoFactory {
    private String driver;
    private String url;
    private String user;
    private String password;

    public void setConnectProperty(ConnectProperty connectProperty) {
        this.connectProperty = connectProperty;
    }

    private ConnectProperty connectProperty;


    public ManagerDaoFactory() {

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

    @Override
    public Dao getManagerDao() {
        return new ManagerDao();
    }
}
