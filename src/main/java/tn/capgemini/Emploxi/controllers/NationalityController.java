package tn.capgemini.Emploxi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.capgemini.Emploxi.entities.Nationality;
import tn.capgemini.Emploxi.services.NationalityService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/nationalities")
public class NationalityController {

    @Autowired
    private NationalityService nationalityService;

    @GetMapping
    public ResponseEntity<List<Nationality>> getAllNationalities() {
        List<Nationality> nationalities = nationalityService.getAllNationalities();
        return new ResponseEntity<>(nationalities, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Nationality> getNationalityById(@PathVariable Long id) {
        Optional<Nationality> nationality = nationalityService.getNationalityById(id);
        return nationality.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Nationality> createNationality(@RequestBody Nationality nationality) {
        Nationality newNationality = nationalityService.saveNationality(nationality);
        return new ResponseEntity<>(newNationality, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNationality(@PathVariable Long id) {
        Optional<Nationality> nationality = nationalityService.getNationalityById(id);
        if (nationality.isPresent()) {
            nationalityService.deleteNationality(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Nationality> updateNationality(@PathVariable Long id, @RequestBody Nationality updatedNationality) {
        Optional<Nationality> existingNationality = nationalityService.getNationalityById(id);
        if (existingNationality.isPresent()) {
            updatedNationality.setId(id); // Ensure ID consistency
            Nationality savedNationality = nationalityService.saveNationality(updatedNationality);
            return new ResponseEntity<>(savedNationality, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
