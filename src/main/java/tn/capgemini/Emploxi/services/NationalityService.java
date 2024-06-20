package tn.capgemini.Emploxi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.capgemini.Emploxi.entities.Nationality;
import tn.capgemini.Emploxi.repositories.NationalityRepository;

import java.util.List;
import java.util.Optional;

@Service
public class NationalityService {

    @Autowired
    private NationalityRepository nationalityRepository;

    public List<Nationality> getAllNationalities() {
        return nationalityRepository.findAll();
    }

    public Optional<Nationality> getNationalityById(Long id) {
        return nationalityRepository.findById(id);
    }

    public Nationality saveNationality(Nationality nationality) {
        return nationalityRepository.save(nationality);
    }

    public void deleteNationality(Long id) {
        nationalityRepository.deleteById(id);
    }
}
