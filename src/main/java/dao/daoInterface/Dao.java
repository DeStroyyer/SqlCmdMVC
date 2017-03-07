package dao.daoInterface;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface Dao {
    List tablesList() throws SQLException;

    String create(String tableName) throws SQLException;

    List<User> read(String tableName) throws SQLException;

    String delete(String tableName) throws SQLException;

    String drop(String tableName) throws SQLException;

    String insert(String tableName,String... params) throws SQLException;
}