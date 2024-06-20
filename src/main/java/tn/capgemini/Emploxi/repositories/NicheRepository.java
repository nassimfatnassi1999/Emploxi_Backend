package tn.capgemini.Emploxi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.capgemini.Emploxi.entities.Niche;

public interface NicheRepository extends JpaRepository<Niche, Long> {
    Niche findByName(String name);
}