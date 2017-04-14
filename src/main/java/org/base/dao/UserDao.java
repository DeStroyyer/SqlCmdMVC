package org.base.dao;

import org.base.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    public void addUser(User user) throws SQLException;
    public void  deleteUser(User user) throws SQLException;
    public User getUser(int id) throws SQLException;
    public List<User>getUsers()throws SQLException;

}
