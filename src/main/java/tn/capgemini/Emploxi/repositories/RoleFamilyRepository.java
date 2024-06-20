package tn.capgemini.Emploxi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.capgemini.Emploxi.entities.Classement;
import tn.capgemini.Emploxi.entities.RoleFamily;

public interface RoleFamilyRepository extends JpaRepository<RoleFamily, Long> {
    RoleFamily findByName(String name);
}