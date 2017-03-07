package service;

import dao.daoImplementation.ManagerDaoFactory;
import dao.daoInterface.DaoFactory;
import utils.GetProperties;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ManagerService implements Service {
    private DaoFactory factory;
    private GetProperties properties;

    public ManagerService() {

    }

    @Override
    public String connect(String dbName, String userName, String password) throws SQLException {
        properties = new GetProperties();
        factory = new ManagerDaoFactory(properties.getDriver(), dbName, userName, password);
        Connection connection = factory.getConnection();

        return connection != null ? "Connection done" : "Someting wrong, try again";
    }

    @Override
    public String tables() {
        return null;
    }

    @Override
    public String clear(String tableName) {
        return null;
    }

    @Override
    public String drop(String tableName) {
        return null;
    }

    @Override
    public String create(String tableName, String... columns) {
        return null;
    }

    @Override
    public List<List<String>> find(String tableName) {
        return null;
    }
}
