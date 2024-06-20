package tn.capgemini.Emploxi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.capgemini.Emploxi.entities.RoleFamily;
import tn.capgemini.Emploxi.repositories.RoleFamilyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RoleFamilyService {

    @Autowired
    private RoleFamilyRepository roleFamilyRepository;

    public List<RoleFamily> getAllRoleFamilies() {
        return roleFamilyRepository.findAll();
    }

    public Optional<RoleFamily> getRoleFamilyById(Long id) {
        return roleFamilyRepository.findById(id);
    }

    public RoleFamily saveRoleFamily(RoleFamily roleFamily) {
        return roleFamilyRepository.save(roleFamily);
    }

    public void deleteRoleFamily(Long id) {
        roleFamilyRepository.deleteById(id);
    }
}
