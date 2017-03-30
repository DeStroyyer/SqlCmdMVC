package org.base.dao.daoImplementation;

import org.base.dao.Dao;
import org.base.dao.DaoFactory;
import org.base.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ManagerDao implements Dao {

    private DaoFactory factory;

    public void setDaoFactory(DaoFactory factory) {
        this.factory = factory;
    }

    public ManagerDao() {
    }


    @Override
    public List<String> tablesList() throws SQLException {
        List<String> tables = new ArrayList<String>();
        try (Connection connection = factory.getConnection()) {
            DatabaseMetaData metaData = connection.getMetaData();
            try (ResultSet rs = metaData.getTables(null, "PUBLIC", null, null)) {
                while (rs.next()) {
                    tables.add(rs.getString(3));
                }
            }
        }
        return tables;
    }

    @Override
    public String delete(String tableName) throws SQLException {
        String query = "DELETE FROM " + tableName;
        try (Connection connection = factory.getConnection();
             Statement statement = connection.createStatement()) {
            int deletedRows = statement.executeUpdate(query);
            if (deletedRows > 0) {
                return "All Rows In The Table" + tableName + " Successfully deleted";
            } else {
                return "Table" + tableName + " already empty.";
            }
        }
    }

    @Override
    public String drop(String tableName) throws SQLException {
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
    public String insert(String tableName, String... params) throws SQLException {
        String sql = "INSERT INTO " + tableName + "(username, email, password) values(?,?,?)";
        if (params.length == 3) {
            try (Connection connection = factory.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, params[0]);
                preparedStatement.setString(2, params[1]);
                preparedStatement.setString(3, params[2]);

                if (preparedStatement.executeUpdate() >= 0) {
                    return "Data inserted in table: " + tableName + " successful.";
                } else {
                    return "Data didn`t insert in table: " + tableName;
                }
            }
        } else {
            return "Amount of parameters not correct.";
        }
    }

    @Override
    public String create(String tableName) throws SQLException {
        String sql = "CREATE TABLE " + tableName + "(id int IDENTITY PRIMARY KEY,username VARCHAR(255), email VARCHAR(255), password VARCHAR(255))";
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
    public List<User> read(String tableName) throws SQLException {
        List<User> users = new ArrayList<>();

        String sql = "SELECT id, username, email, password FROM " + tableName;
        try (Connection connnection = factory.getConnection();
             PreparedStatement statment = connnection.prepareStatement(sql)) {
            try (
                    ResultSet resultSet = statment.executeQuery()) {
                while (resultSet.next()) {
                    User user = new User();
                    user.setId(resultSet.getInt("id"));
                    user.setName(resultSet.getString("username"));
                    user.setEmail(resultSet.getString("email"));
                    user.setPassword(resultSet.getString("password"));
                    users.add(user);

                }
            }
        }
        return users;
    }


    @Override
    public User readByName(String tableName, String name) throws SQLException {
        User user = new User();
        String sql = "SELECT * FROM " + tableName + " WHERE username =?";
        try (Connection connnection = factory.getConnection();
             PreparedStatement statment = connnection.prepareStatement(sql)) {
            statment.setString(1, name);
            try (ResultSet resultSet = statment.executeQuery()) {
                while (resultSet.next()) {
                    user.setId(resultSet.getInt("id"));
                    user.setName(resultSet.getString("username"));
                    user.setEmail(resultSet.getString("email"));
                    user.setPassword(resultSet.getString("password"));
                }
            }
        }
        return user;
    }
}

