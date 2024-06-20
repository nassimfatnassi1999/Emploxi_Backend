package tn.capgemini.Emploxi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.capgemini.Emploxi.entities.CSS_DSS_DSP;
import tn.capgemini.Emploxi.entities.Classement;

public interface ClassementRepository extends JpaRepository<Classement, Long> {
    Classement findByName(String name);
}