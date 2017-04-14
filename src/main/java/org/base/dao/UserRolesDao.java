package org.base.dao;

import org.base.model.UserRoles;

import java.util.List;

public interface UserRolesDao {
    public void addUserRole(UserRoles userRoles);

    public List<UserRoles> getUserRoles();


}
