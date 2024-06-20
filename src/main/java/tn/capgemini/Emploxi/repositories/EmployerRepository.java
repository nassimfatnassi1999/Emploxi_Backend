package tn.capgemini.Emploxi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.capgemini.Emploxi.entities.Employer;

public interface EmployerRepository extends JpaRepository<Employer, Long> {
}