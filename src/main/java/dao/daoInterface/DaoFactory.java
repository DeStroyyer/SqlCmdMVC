package dao.daoInterface;

import jdk.nashorn.internal.runtime.regexp.JoniRegExp;

import java.sql.Connection;
import java.sql.SQLException;

public interface DaoFactory {
    Connection getConnection() throws SQLException;

    Dao getManagerDao();
}
