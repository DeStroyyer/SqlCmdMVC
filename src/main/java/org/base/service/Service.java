package org.base.service;

import java.sql.SQLException;

public interface Service {
    String connect(String driver, String dbName, String userName, String password) throws SQLException;

    String tables() throws SQLException;

    String clear(String tableName) throws SQLException;

    String drop(String tableName) throws SQLException;

    String create(String tableName) throws SQLException;

    String find(String tableName) throws SQLException;

    String input(String tableName,String...params) throws SQLException;

    String help();
}
