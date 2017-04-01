package org.base.dao.daoImplementation;

import org.base.dao.Dao;
import org.base.dao.DaoFactory;
import org.base.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ManagerDao implements Dao {

    private DaoFactory factory;

    public void setFactory(DaoFactory factory) {
        this.factory = factory;
    }

    public ManagerDao() {
    }


    @Override
    public List<String> tablesList() throws SQLException {
        String sql="SELECT table_name FROM information_schema.tables WHERE table_schema='public' AND table_type='BASE TABLE'";
        List<String> tables = new ArrayList<String>();
        try (Connection connection = factory.getConnection();
             PreparedStatement statement= connection.prepareStatement(sql);
             ResultSet resultSet =statement.executeQuery() ){
            while(resultSet.next()){
                    tables.add(resultSet.getString("table_name"));
                }
            }

        return tables;
    }

    @Override
    public String deleteTable(String tableName) throws SQLException {
        String query = "DELETE FROM " + tableName;
        try (Connection connection = factory.getConnection();
             Statement statement = connection.createStatement()) {
            int deletedRows = statement.executeUpdate(query);
            if (deletedRows > 0) {
                return "All Rows In The Table " + tableName + " Successfully deleted";
            } else {
                return "Table" + tableName + " already empty.";
            }
        }
    }

    @Override
    public String dropTable(String tableName) throws SQLException {
        String sql = "DROP TABLE " + tableName;
        try (Connection connection = factory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            if (statement.executeUpdate() >= 0) {
                return "Table " + tableName + " was droped.";
            } else {
                return "Table " + tableName + " wasn`t droped.";
            }
        }
    }

    @Override
    public String insertUser(String tableName, String... params) throws SQLException {
        String sql = "INSERT INTO " + tableName + "(id, name, email, password) values(?,?,?,?)";
        if (params.length == 4) {
            try (Connection connection = factory.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, Integer.parseInt(params[0]));
                preparedStatement.setString(2, params[1]);
                preparedStatement.setString(3, params[2]);
                preparedStatement.setString(4, params[3]);

                if (preparedStatement.executeUpdate() >= 0) {
                    return "Data inserted in table: " + tableName + " successful.";
                } else {
                    return "Data didn`t insertUser in table: " + tableName;
                }
            }
        } else {
            return "Amount of parameters not correct.";
        }
    }

    @Override
    public String createTable(String tableName) throws SQLException {
        String sql = "CREATE TABLE " + tableName + "(id INTEGER , name VARCHAR(255), email VARCHAR(255), password VARCHAR(255),PRIMARY KEY (id))";
        try (Connection connection = factory.getConnection();
             Statement statement = connection.createStatement()) {
            if (0 >= statement.executeUpdate(sql)) {
                return "Table " + tableName + " created successful.";
            } else {
                return "Table " + tableName + " don`t created";

            }
        }
    }

    @Override
    public List<User> showUsers(String tableName) throws SQLException {
        List<User> users = new ArrayList<>();

        String sql = "SELECT id, name, email, password FROM " + tableName;
        try (Connection connection = factory.getConnection();
             PreparedStatement statment = connection.prepareStatement(sql)) {
            try (
                    ResultSet resultSet = statment.executeQuery()) {
                while (resultSet.next()) {
                    User user = new User();
                    user.setId(resultSet.getInt("id"));
                    user.setName(resultSet.getString("name"));
                    user.setEmail(resultSet.getString("email"));
                    user.setPassword(resultSet.getString("password"));
                    users.add(user);

                }
            }
        }
        return users;
    }


    @Override
    public User showUser(String tableName, String name) throws SQLException {
        User user = new User();
        String sql = "SELECT * FROM " + tableName + " WHERE name =?";
        try (Connection connection = factory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, name);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    user.setId(resultSet.getInt("id"));
                    user.setName(resultSet.getString("name"));
                    user.setEmail(resultSet.getString("email"));
                    user.setPassword(resultSet.getString("password"));
                }
            }
        }
        return user;
    }
}

