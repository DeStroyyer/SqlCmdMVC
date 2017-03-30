package org.base.dao;

import org.base.model.User;

import java.sql.SQLException;
import java.util.List;

public interface Dao {
    List tablesList() throws SQLException;

    String createTable(String tableName) throws SQLException;

    String insertUser(String tableName, String... params) throws SQLException;

    String deleteTable(String tableName) throws SQLException;

    String dropTable(String tableName) throws SQLException;

    List<User> showUsers(String tableName) throws SQLException;

    User showUser(String tableName, String name) throws SQLException;
}
