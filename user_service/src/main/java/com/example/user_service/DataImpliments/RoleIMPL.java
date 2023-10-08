package com.example.user_service.DataImpliments;

import com.example.user_service.model.Role;
import com.example.user_service.repoIMPL.RoleRepoInter;
import com.example.user_service.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoleIMPL implements RoleRepoInter {

    private final RoleRepository roleRepository;
    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role getRoleById(Long id) {
        return roleRepository.getRoleById(id);
    }


    @Override
    public Role addRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role changeRoleById(Role role) {
        return roleRepository.save(role);
    }
}
