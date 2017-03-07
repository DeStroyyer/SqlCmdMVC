package service;

import java.sql.SQLException;
import java.util.List;

public interface Service {
    String connect(String dbName, String userName, String password) throws SQLException;

    String tables();

    String clear(String tableName);

    String drop(String tableName);

    String create(String tableName, String... columns);

    List<List<String>> find(String tableName);
}
