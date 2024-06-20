package tn.capgemini.Emploxi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.capgemini.Emploxi.entities.Grade;

public interface GradeRepository extends JpaRepository<Grade, Long> {
    Grade findByName(String name);
}