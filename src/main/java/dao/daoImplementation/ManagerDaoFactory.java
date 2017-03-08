package dao.daoImplementation;

import dao.Dao;
import dao.DaoFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ManagerDaoFactory implements DaoFactory {
    private String url;
    private String user;
    private String password;


    public ManagerDaoFactory(String driver, String url, String user, String password) {
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
