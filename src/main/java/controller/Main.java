package controller;

import service.ManagerService;
import service.Service;
import view.Console;
import view.View;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Service service=new ManagerService();
        View view=new Console();
        Controller controller=new ManagerController(view,service);
        controller.watch();
    }
}
