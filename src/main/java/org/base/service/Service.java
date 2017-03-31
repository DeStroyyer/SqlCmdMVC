package org.base.service;

import org.base.model.User;

import java.sql.SQLException;

public interface Service {

    String tables() throws SQLException;

    String clear(String tableName) throws SQLException;

    String drop(String tableName) throws SQLException;

    String createTable(String tableName) throws SQLException;

    String inputUser(String tableName, String...params) throws SQLException;

   String showUser(String name) throws SQLException;

    User getUser(String name) throws SQLException;

    String help();
}
