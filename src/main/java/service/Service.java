package service;

import java.sql.SQLException;
import java.util.List;

public interface Service {
    String connect(String dbName, String userName, String password) throws SQLException;

    String tables() throws SQLException;

    String clear(String tableName) throws SQLException;

    String drop(String tableName) throws SQLException;

    String create(String tableName) throws SQLException;

    String find(String tableName) throws SQLException;
}
