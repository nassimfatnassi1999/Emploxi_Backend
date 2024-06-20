package tn.capgemini.Emploxi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.capgemini.Emploxi.entities.Profil;
import tn.capgemini.Emploxi.repositories.ProfilRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProfilService {

    @Autowired
    private ProfilRepository profilRepository;

    public List<Profil> getAllProfils() {
        return profilRepository.findAll();
    }

    public Optional<Profil> getProfilById(Long id) {
        return profilRepository.findById(id);
    }

    public Profil saveProfil(Profil profil) {
        return profilRepository.save(profil);
    }

    public void deleteProfil(Long id) {
        profilRepository.deleteById(id);
    }
}
