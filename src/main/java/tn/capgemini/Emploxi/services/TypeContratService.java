package tn.capgemini.Emploxi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.capgemini.Emploxi.entities.TypeContrat;
import tn.capgemini.Emploxi.repositories.TypeContratRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TypeContratService {

    @Autowired
    private TypeContratRepository typeContratRepository;

    public List<TypeContrat> getAllTypeContrats() {
        return typeContratRepository.findAll();
    }

    public Optional<TypeContrat> getTypeContratById(Long id) {
        return typeContratRepository.findById(id);
    }

    public TypeContrat saveTypeContrat(TypeContrat typeContrat) {
        return typeContratRepository.save(typeContrat);
    }

    public void deleteTypeContrat(Long id) {
        typeContratRepository.deleteById(id);
    }
}
