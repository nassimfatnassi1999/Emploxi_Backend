package tn.capgemini.Emploxi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.capgemini.Emploxi.entities.SituationFamiliale;
import tn.capgemini.Emploxi.repositories.SituationFamilialeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SituationFamilialeService {

    @Autowired
    private SituationFamilialeRepository situationFamilialeRepository;

    public List<SituationFamiliale> getAllSituationsFamiliale() {
        return situationFamilialeRepository.findAll();
    }

    public Optional<SituationFamiliale> getSituationFamilialeById(Long id) {
        return situationFamilialeRepository.findById(id);
    }

    public SituationFamiliale saveSituationFamiliale(SituationFamiliale situationFamiliale) {
        return situationFamilialeRepository.save(situationFamiliale);
    }

    public void deleteSituationFamiliale(Long id) {
        situationFamilialeRepository.deleteById(id);
    }
}
