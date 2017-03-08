package controller;

import service.Service;
import utils.ConnectProperty;
import view.View;

import java.sql.SQLException;


public class ManagerController implements Controller {
    private String inputCommand;
    private View view;
    private Service service;

    public ManagerController(View view, Service service) {
        this.view = view;
        this.service = service;
    }

    @Override
    public void watch() throws SQLException {
        while (true) {
            view.write("Insert command:");
            inputCommand = view.read();
            check(inputCommand);
        }
    }

    private void check(String input) throws SQLException {
        if (input.startsWith("connect")) {
            connect(parseInput(input));
        } else if (input.startsWith("tables")) {
            service.tables();
        } else if (input.startsWith("clear")) {
            clear(parseInput(input));
        } else if (input.startsWith("drop")) {
            drop(parseInput(input));
        } else if (input.startsWith("create")) {
            create(parseInput(input));
        } else if (input.startsWith("find")) {
            find(parseInput(input));
        } else if (input.startsWith("input")) {
            input(parseInput(input));
        } else if (input.equals("help")) {
            help();
        } else {
            view.write("Input exist command, or help to see command list");
        }
    }

    private String[] parseInput(String inputCommand) {
        String[] result = inputCommand.split("[.]");
        return result;
    }

    private void connect(String[] parsed) {
        ConnectProperty properties = new ConnectProperty();
        if (parsed.length == 3) {

            String driver = properties.getDriver();
            String url = properties.getUrl();
            String userName = parsed[1];
            String password = parsed[2];
            try {
                view.write(service.connect(driver, url, userName, password));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            view.write("Not enough parameters.");
        }
    }

    private void clear(String[] parsed) throws SQLException {
        if (parsed.length == 2) {
            try {
                String tableName = parsed[1];
                service.clear(tableName);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            view.write("Amount of parameters not correct.");
        }
    }

    private void drop(String[] parsed) {
        if (parsed.length == 2) {
            try {
                String tableName = parsed[1];
                service.clear(tableName);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            view.write("Amount of parameters not correct.");
        }
    }

    private void create(String[] parsed) {
        if (parsed.length == 2) {
            try {
                String tableName = parsed[1];
                view.write(service.create(tableName));
            } catch (SQLException e) {

            }
        } else {
            view.write("Amount of parameters not correct.");
        }
    }

    private void find(String[] parsed) {
        if (parsed.length == 2) {
            try {
                String tableName = parsed[1];
                service.find(tableName);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            view.write("Amount of parameters not correct.");
        }
    }

    private void input(String[] parsed) {
        if (parsed.length == 6) {
            try {
                String tableName = parsed[1];
                String[] params = {parsed[2], parsed[3], parsed[4], parsed[5]};
                service.input(tableName, params);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            view.write("Amount of parameters not correct.");
        }
    }

    private void help() {

        view.write("Existed commands:" +
                "connect-connect to db, example: connect.user.password\n" +
                "clear-delete all data from table, example: clear.tablename\n" +
                "drop-remove table from db, example: drop.tablename\n" +
                "create-create table with specific name, example: create.tablename\n" +
                "find-show content from table, example: find.tablename\n" +
                "input-enter data about user, example: input.id.username.email.password\n");
    }

}
