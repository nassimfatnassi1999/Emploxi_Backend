package tn.capgemini.Emploxi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.capgemini.Emploxi.entities.Niche;
import tn.capgemini.Emploxi.repositories.NicheRepository;

import java.util.List;
import java.util.Optional;

@Service
public class NicheService {

    @Autowired
    private NicheRepository nicheRepository;

    public List<Niche> getAllNiches() {
        return nicheRepository.findAll();
    }

    public Optional<Niche> getNicheById(Long id) {
        return nicheRepository.findById(id);
    }

    public Niche saveNiche(Niche niche) {
        return nicheRepository.save(niche);
    }

    public void deleteNiche(Long id) {
        nicheRepository.deleteById(id);
    }
}
