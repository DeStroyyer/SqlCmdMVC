package service;

import dao.daoImplementation.ManagerDaoFactory;
import dao.daoInterface.DaoFactory;
import utils.GetProperties;

import java.util.List;

public class ManagerService implements Service{


    public ManagerService(){

    }
    @Override
    public String connect(String dbName, String userName, String password) {

        return null;
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
