package tn.capgemini.Emploxi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.capgemini.Emploxi.entities.Classement;
import tn.capgemini.Emploxi.entities.Profil;
import tn.capgemini.Emploxi.services.ProfilService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/profils")
public class ProfilController {

    @Autowired
    private ProfilService profilService;

    @GetMapping
    public ResponseEntity<List<Profil>> getAllProfils() {
        List<Profil> profils = profilService.getAllProfils();
        return new ResponseEntity<>(profils, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profil> getProfilById(@PathVariable Long id) {
        Optional<Profil> profil = profilService.getProfilById(id);
        return profil.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Profil> createProfil(@RequestBody Profil profil) {
        Profil newProfil = profilService.saveProfil(profil);
        return new ResponseEntity<>(newProfil, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfil(@PathVariable Long id) {
        Optional<Profil> profil = profilService.getProfilById(id);
        if (profil.isPresent()) {
            profilService.deleteProfil(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Profil> update(@PathVariable Long id, @RequestBody Profil updated) {
        Optional<Profil> existing = profilService.getProfilById(id);
        if (existing.isPresent()) {
            updated.setId(id); // Ensure ID consistency
            Profil saved = profilService.saveProfil(updated);
            return new ResponseEntity<>(saved, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
