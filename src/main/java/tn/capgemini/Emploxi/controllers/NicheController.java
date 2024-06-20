package tn.capgemini.Emploxi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.capgemini.Emploxi.entities.Classement;
import tn.capgemini.Emploxi.entities.Niche;
import tn.capgemini.Emploxi.services.NicheService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/niche")
public class NicheController {

    @Autowired
    private NicheService nicheService;

    @GetMapping
    public ResponseEntity<List<Niche>> getAllNiches() {
        List<Niche> niches = nicheService.getAllNiches();
        return new ResponseEntity<>(niches, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Niche> getNicheById(@PathVariable Long id) {
        Optional<Niche> niche = nicheService.getNicheById(id);
        return niche.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Niche> createNiche(@RequestBody Niche niche) {
        Niche newNiche = nicheService.saveNiche(niche);
        return new ResponseEntity<>(newNiche, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNiche(@PathVariable Long id) {
        Optional<Niche> niche = nicheService.getNicheById(id);
        if (niche.isPresent()) {
            nicheService.deleteNiche(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Niche> update(@PathVariable Long id, @RequestBody Niche updated) {
        Optional<Niche> existing = nicheService.getNicheById(id);
        if (existing.isPresent()) {
            updated.setId(id); // Ensure ID consistency
            Niche saved = nicheService.saveNiche(updated);
            return new ResponseEntity<>(saved, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
