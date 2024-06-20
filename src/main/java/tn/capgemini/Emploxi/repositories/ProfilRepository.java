package tn.capgemini.Emploxi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.capgemini.Emploxi.entities.Activity;
import tn.capgemini.Emploxi.entities.Profil;

public interface ProfilRepository extends JpaRepository<Profil, Long> {
    Profil findByName(String nomProfil);
}