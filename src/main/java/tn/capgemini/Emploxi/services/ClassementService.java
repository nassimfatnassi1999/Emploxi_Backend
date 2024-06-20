package tn.capgemini.Emploxi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.capgemini.Emploxi.entities.Classement;
import tn.capgemini.Emploxi.repositories.ClassementRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClassementService {

    @Autowired
    private ClassementRepository classementRepository;

    public List<Classement> getAllClassements() {
        return classementRepository.findAll();
    }

    public Optional<Classement> getClassementById(Long id) {
        return classementRepository.findById(id);
    }

    public Classement saveClassement(Classement classement) {
        return classementRepository.save(classement);
    }

    public void deleteClassement(Long id) {
        classementRepository.deleteById(id);
    }
}
