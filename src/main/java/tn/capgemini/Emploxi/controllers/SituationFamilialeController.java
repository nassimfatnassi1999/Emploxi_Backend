package tn.capgemini.Emploxi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.capgemini.Emploxi.entities.Classement;
import tn.capgemini.Emploxi.entities.SituationFamiliale;
import tn.capgemini.Emploxi.services.SituationFamilialeService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/situationfamiliales")
public class SituationFamilialeController {

    @Autowired
    private SituationFamilialeService situationFamilialeService;

    @GetMapping
    public ResponseEntity<List<SituationFamiliale>> getAllSituationsFamiliale() {
        List<SituationFamiliale> situationFamiliales = situationFamilialeService.getAllSituationsFamiliale();
        return new ResponseEntity<>(situationFamiliales, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SituationFamiliale> getSituationFamilialeById(@PathVariable Long id) {
        Optional<SituationFamiliale> situationFamiliale = situationFamilialeService.getSituationFamilialeById(id);
        return situationFamiliale.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<SituationFamiliale> createSituationFamiliale(@RequestBody SituationFamiliale situationFamiliale) {
        SituationFamiliale newSituationFamiliale = situationFamilialeService.saveSituationFamiliale(situationFamiliale);
        return new ResponseEntity<>(newSituationFamiliale, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSituationFamiliale(@PathVariable Long id) {
        Optional<SituationFamiliale> situationFamiliale = situationFamilialeService.getSituationFamilialeById(id);
        if (situationFamiliale.isPresent()) {
            situationFamilialeService.deleteSituationFamiliale(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<SituationFamiliale> update(@PathVariable Long id, @RequestBody SituationFamiliale updated) {
        Optional<SituationFamiliale> existing = situationFamilialeService.getSituationFamilialeById(id);
        if (existing.isPresent()) {
            updated.setId(id); // Ensure ID consistency
            SituationFamiliale saved = situationFamilialeService.saveSituationFamiliale(updated);
            return new ResponseEntity<>(saved, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
