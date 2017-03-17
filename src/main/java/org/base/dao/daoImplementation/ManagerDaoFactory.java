package org.base.dao.daoImplementation;

import org.base.dao.Dao;
import org.base.dao.DaoFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ManagerDaoFactory implements DaoFactory {
    private String url;
    private String user;
    private String password;

    public ManagerDaoFactory() {
    }

    public void createManagerDaoFactory(String driver, String url, String user, String password) {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        this.url = url;
        this.user = user;
        this.password = password;

    }

    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);

    }

    @Override
    public Dao getManagerDao() {
        return new ManagerDao(this);
    }
}
