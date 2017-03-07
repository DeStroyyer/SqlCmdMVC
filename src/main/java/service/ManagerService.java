package service;

import dao.daoImplementation.ManagerDaoFactory;
import dao.daoInterface.Dao;
import dao.daoInterface.DaoFactory;
import model.User;
import utils.GetProperties;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ManagerService implements Service {
    private DaoFactory factory;
    private Dao dao = factory.getManagerDao();
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
    public String tables() throws SQLException {
        return (dao.tablesList().toString() != null | !dao.tablesList().toString().equals("")) ? dao.tablesList().toString() : "Data Base is empty.";
    }

    @Override
    public String clear(String tableName) throws SQLException {
        dao.delete(tableName);
        return dao.read(tableName) == null ? "Table cleared successful." : "Someting wrong try again.";
    }

    @Override
    public String drop(String tableName) throws SQLException {
        return !dao.drop(tableName).equals("Table " + tableName + " wasn`t droped.") ? "Operation done successful" : "Something wrong, try again";
    }

    @Override
    public String create(String tableName) throws SQLException {
        return !dao.create(tableName).equals("Table " + tableName + " don`t created") ? "Table " + tableName + " created successful" : "Something wrong, try again";
    }

    @Override
    public String find(String tableName) throws SQLException {
        String tableInfo = null;
        for (User row : dao.read(tableName)) {
            tableInfo += row.toString() + "\n";
        }
        return (!tableInfo.equals("") | tableInfo != null) ? tableInfo : "Table is empty.";
    }
}
