package tn.capgemini.Emploxi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.capgemini.Emploxi.entities.Activity;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
    Activity findByName(String nomActivity);
}