package org.base.service.ServiceImplementation;

import org.base.dao.Dao;
import org.base.dao.DaoFactory;
import org.base.model.User;
import org.base.service.Service;

import javax.annotation.PostConstruct;
import java.sql.Connection;
import java.sql.SQLException;

public class ManagerService implements Service {
    private DaoFactory factory;
    private Dao dao;

    public ManagerService() {
    }

    public void setFactory(DaoFactory factory) {
        this.factory = factory;
        dao = factory.getManagerDao();
    }

    public void createtabel() throws SQLException {
        String[] params = {"user", "user@gmail.com", "pass"};
        create("user");
        input("user", params);
    }

    @Override
    public String connect(String driver, String url, String userName, String password) {
        factory.initDaoFactory();

        String res = null;
        try {
            Connection connection = factory.getConnection();
            res = connection != null ? "Connection done" : "Someting wrong, try again";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
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

    @Override
    public User readByName(String name) throws SQLException {

        String table = "user";
        return dao.readByName(table, name);
    }

    @Override
    public String help() {
        return "=======================================================================\n" +
                "Existed commands:\n" +
                "connect-connect to db, example: connect.user.password\n" +
                "clear-delete all data from table, example: clear.tablename\n" +
                "drop-remove table from db, example: drop.tablename\n" +
                "create-create table with specific name, example: create.tablename\n" +
                "find-show content from table, example: find.tablename\n" +
                "input-enter data about user, example: input.id.username.email.password\n" +
                "========================================================================";
    }


}
