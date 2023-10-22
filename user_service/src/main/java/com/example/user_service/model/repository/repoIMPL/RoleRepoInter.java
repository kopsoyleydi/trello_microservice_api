package com.example.user_service.model.repository.repoIMPL;


import com.example.user_service.model.Role;

import java.util.List;

public interface RoleRepoInter {

    List<Role> getAllRoles();

    Role getRoleById(Long id);
    Role addRole(Role role);

    Role changeRoleById(Role role);
}
