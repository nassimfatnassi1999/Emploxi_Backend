package tn.capgemini.Emploxi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.capgemini.Emploxi.entities.Activity;
import tn.capgemini.Emploxi.entities.Classement;
import tn.capgemini.Emploxi.services.ClassementService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

@RequestMapping("/api/classements")
public class ClassementController {

    @Autowired
    private ClassementService classementService;

    @GetMapping
    public ResponseEntity<List<Classement>> getAllClassements() {
        List<Classement> classements = classementService.getAllClassements();
        return new ResponseEntity<>(classements, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Classement> getClassementById(@PathVariable Long id) {
        Optional<Classement> classement = classementService.getClassementById(id);
        return classement.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Classement> createClassement(@RequestBody Classement classement) {
        Classement newClassement = classementService.saveClassement(classement);
        return new ResponseEntity<>(newClassement, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClassement(@PathVariable Long id) {
        Optional<Classement> classement = classementService.getClassementById(id);
        if (classement.isPresent()) {
            classementService.deleteClassement(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Classement> update(@PathVariable Long id, @RequestBody Classement updated) {
        Optional<Classement> existing = classementService.getClassementById(id);
        if (existing.isPresent()) {
            updated.setId(id); // Ensure ID consistency
            Classement saved = classementService.saveClassement(updated);
            return new ResponseEntity<>(saved, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
