package tn.capgemini.Emploxi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.capgemini.Emploxi.entities.Niche;
import tn.capgemini.Emploxi.entities.SituationFamiliale;

public interface SituationFamilialeRepository extends JpaRepository<SituationFamiliale, Long> {
    SituationFamiliale findByName(String name);
}