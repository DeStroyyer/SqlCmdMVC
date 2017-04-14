package org.base.dao;

import org.base.model.Role;

public interface RoleDao {
    public void addRole(Role role);
    public Role getRole(int id);
}

