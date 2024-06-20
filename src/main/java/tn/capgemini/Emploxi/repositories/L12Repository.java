package tn.capgemini.Emploxi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.capgemini.Emploxi.entities.L12;

public interface L12Repository extends JpaRepository<L12, Long> {
    L12 findByName(String name);
}