package org.base.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface DaoFactory {
    Connection getConnection() throws SQLException;

    Dao getManagerDao();

    void createManagerDaoFactory(String driver, String url, String user, String password);
}
