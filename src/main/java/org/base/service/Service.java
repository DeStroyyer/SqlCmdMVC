package org.base.service;

import org.base.model.User;

import java.sql.SQLException;
import java.util.List;

public interface Service {

    String tables() throws SQLException;

    String clear(String tableName) throws SQLException;

    String drop(String tableName) throws SQLException;

    String createTable(String tableName) throws SQLException;

    String insertUser(String tableName, String... params) throws SQLException;

    String showUser(String name) throws SQLException;

    User getUser(String name) throws SQLException;

    List showUsers(String tableName) throws SQLException;

    String editUser(String... params) throws SQLException;

    boolean isLogined();

    void setLogined(boolean logined);

    String help();
}
