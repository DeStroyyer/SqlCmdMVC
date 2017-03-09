package dao.daoImplementation;

import dao.Dao;
import dao.DaoFactory;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ManagerDao implements Dao {
    private DaoFactory factory;

    public ManagerDao(DaoFactory factory) {
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
             Statement statement = connection.createStatement()) {
            if (statement.executeUpdate(sql) >= 0) {
                return "Table " + tableName + " was droped.";
            } else {
                return "Table " + tableName + " wasn`t droped.";
            }
        }
    }

    @Override
    public String insert(String tableName, String... params) throws SQLException {
        String sql = "INSERT INTO " + tableName + "(id, username, email, password) values(?,?,?,?)";
        if(params.length==4){
        try (Connection connection = factory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, params[0]);
            preparedStatement.setString(2, params[1]);
            preparedStatement.setString(3, params[2]);
            preparedStatement.setString(4, params[3]);
            if (3 == preparedStatement.executeUpdate()) {
                return "Data inserted in table: " + tableName + " successful.";
            } else {
                return "Data didn`t insert in table: " + tableName;
            }
        }}else{
            return "Amount of parameters not correct.";
        }
    }

    @Override
    public String create(String tableName) throws SQLException {
        String sql = "CREATE TABLE " + tableName + "(id INTEGER not NULL, username VARCHAR(255), email VARCHAR(255),password VARCHAR(255), PRIMARY KEY ( id ))";
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
        User user = new User();
        String sql = "SELECT id, username, email, password FROM " + tableName;
        try (Connection connnection = factory.getConnection();
             Statement statment = connnection.createStatement();
             ResultSet resultSet = statment.executeQuery(sql)) {
            while (resultSet.next()) {
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("username"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                users.add(user);
            }
        }
        return users;
    }
}

