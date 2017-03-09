package service.ServiceImplementation;

import dao.Dao;
import dao.DaoFactory;
import model.User;
import service.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ManagerService implements Service {
    private DaoFactory factory;
    private Dao dao;

    public ManagerService(DaoFactory factory) {
        this.factory = factory;
    }

    @Override
    public String connect(String driver, String url, String userName, String password) throws SQLException {
        factory.createManagerDaoFactory(driver, url, userName, password);
        dao = factory.getManagerDao();
        Connection connection = factory.getConnection();
        return connection != null ? "Connection done" : "Someting wrong, try again";
    }

    @Override
    public String tables() throws SQLException {
        String result = "";
        for (Object s : dao.tablesList()) {
            result += (String) s;
        }
        return (dao.tablesList().toString() != null || dao.tablesList().toString().equals("")) ? result : "Data Base is empty.";
    }

    @Override
    public String clear(String tableName) throws SQLException {

        return dao.delete(tableName).equals("All Rows In The Table" + tableName + " Successfully deleted") ? "Table cleared successful." : "Someting wrong try again.";
    }

    @Override
    public String drop(String tableName) throws SQLException {
        return !dao.drop(tableName).equals("Table " + tableName + " wasn`t droped.") ? "Operation done successful." : "Something wrong, try again.";
    }

    @Override
    public String create(String tableName) throws SQLException {
        return !dao.create(tableName).equals("Table " + tableName + " don`t created") ? "Table " + tableName + " created successful." : "Something wrong, try again.";
    }

    @Override
    public String find(String tableName) throws SQLException {
        String tableInfo = "";
        for (User user : dao.read(tableName)) {
            tableInfo += user.toString() + "\n";
        }
        return (!tableInfo.equals("") & tableInfo != null) ? tableInfo : "Table is empty.";
    }

    @Override
    public String input(String tableName, String... params) throws SQLException {
        return dao.insert(tableName, params).equals("Data inserted in table: " + tableName + " successful.") ? "Data inserted into" + tableName + " successful" : "Something wrong, try again.";

    }

    private boolean compare() {
        for (Object existTable : tables) {
            if (existTable.equals(tableName)) {
                result = "Table " + tableName + " already exist.";
            } else {
            }
        }
