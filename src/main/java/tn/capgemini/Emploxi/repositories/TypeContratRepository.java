package tn.capgemini.Emploxi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.capgemini.Emploxi.entities.Activity;
import tn.capgemini.Emploxi.entities.TypeContrat;

public interface TypeContratRepository extends JpaRepository<TypeContrat, Long> {
    TypeContrat findByName(String nomTypeContrat);
}