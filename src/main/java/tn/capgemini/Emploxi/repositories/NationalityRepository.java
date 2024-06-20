package tn.capgemini.Emploxi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.capgemini.Emploxi.entities.Nationality;

public interface NationalityRepository extends JpaRepository<Nationality, Long> {
    Nationality findByName(String country);
}