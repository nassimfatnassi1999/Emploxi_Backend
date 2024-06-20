package tn.capgemini.Emploxi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.capgemini.Emploxi.entities.RoleName;
import tn.capgemini.Emploxi.repositories.RoleNameRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RoleNameService {

    @Autowired
    private RoleNameRepository roleNameRepository;

    public List<RoleName> getAllRoleNames() {
        return roleNameRepository.findAll();
    }

    public Optional<RoleName> getRoleNameById(Long id) {
        return roleNameRepository.findById(id);
    }

    public RoleName saveRoleName(RoleName roleName) {
        return roleNameRepository.save(roleName);
    }

    public void deleteRoleName(Long id) {
        roleNameRepository.deleteById(id);
    }
}
