package tn.capgemini.Emploxi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.capgemini.Emploxi.entities.RoleFamily;
import tn.capgemini.Emploxi.entities.RoleName;

public interface RoleNameRepository extends JpaRepository<RoleName, Long> {
    RoleName findByName(String name);
}