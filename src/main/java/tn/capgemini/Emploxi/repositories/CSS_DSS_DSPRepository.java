package tn.capgemini.Emploxi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.capgemini.Emploxi.entities.CSS_DSS_DSP;

public interface CSS_DSS_DSPRepository extends JpaRepository<CSS_DSS_DSP, Long> {
    CSS_DSS_DSP findByName(String name);
}