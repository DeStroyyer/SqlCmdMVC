package controller;

import service.Service;
import view.View;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
        }
    }

    private List parseInput(String inputCommand) {
        List<String> result = new ArrayList<>();
        for (String cut : inputCommand.split(".")) {
            result.add(cut);
        }
        return result;
    }

    private void connect(List<String> parsed) {
        String driver = (parsed.get(1).equals("H2")) ? "org.h2.Driver" : "org.postgresql.Driver";
        String url = parsed.get(2);
        String userName = parsed.get(3);
        String password = parsed.get(4);
        try {
            service.connect(driver, url, userName, password);
        } catch (SQLException e) {
            view.write("Some problem with params");
        }
    }

    private void clear(List<String> parsed) throws SQLException {
        String tableName = parsed.get(1);
        service.clear(tableName);
    }

    private void drop(List<String> parsed) throws SQLException {
        String tableName = parsed.get(1);
        service.clear(tableName);
    }

    private void create(List<String> parsed) throws SQLException {
        String tableName = parsed.get(1);
        service.create(tableName);
    }

    private void find(List<String> parsed) throws SQLException {
        String tableName = parsed.get(1);
        service.find(tableName);
    }

    private void input(List<String> parsed) throws SQLException {
        String tableName = parsed.get(1);
        String[] params = {parsed.get(2), parsed.get(3), parsed.get(4), parsed.get(5)};
        service.input(tableName, params);
    }

}
