package org.base.service.ServiceImplementation;

import org.base.dao.Dao;
import org.base.model.User;
import org.base.service.Service;

import java.sql.SQLException;

public class ManagerService implements Service {


    private Dao dao;

    public void setDao(Dao dao) {
        this.dao = dao;
    }


    public ManagerService() {
    }

    @Override
    public String createTable(String tableName) throws SQLException {
        return !dao.createTable(tableName).equals("Table " + tableName + " don`t created") ? "Table " + tableName + " created successful." : "Something wrong, try again.";
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
    public String inputUser(String tableName, String... params) throws SQLException {
        return dao.insertUser(tableName, params).equals("Data inserted in table: " + tableName + " successful.") ? "Data inserted into" + tableName + " successful" : "Something wrong, try again.";

    }

    @Override
    public String clear(String tableName) throws SQLException {

        return dao.deleteTable(tableName).equals("All Rows In The Table" + tableName + " Successfully deleted") ? "Table cleared successful." : "Someting wrong try again.";
    }

    @Override
    public String drop(String tableName) throws SQLException {
        return !dao.dropTable(tableName).equals("Table " + tableName + " wasn`t droped.") ? "Operation done successful." : "Something wrong, try again.";
    }

    @Override
    public String showUser(String tableName, String name) throws SQLException {
        String userInfo = "";
       User user= dao.showUser(tableName,name);
            userInfo += user.toString() + "\n";

        return (!userInfo.equals("") & userInfo != null) ? userInfo : "Table is empty.";
    }

    @Override
    public String help() {
        return "=======================================================================\n" +
                "Existed commands:\n" +
                "connect-connect to db, example: connect.showUser.password\n" +
                "clear-deleteTable all data from table, example: clear.tablename\n" +
                "dropTable-remove table from db, example: dropTable.tablename\n" +
                "createTable-createTable table with specific name, example: createTable.tablename\n" +
                "find-show content from table, example: find.tablename\n" +
                "inputUser-enter data about showUser, example: inputUser.id.username.email.password\n" +
                "========================================================================";
    }


}
