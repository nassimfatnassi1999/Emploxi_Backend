package tn.capgemini.Emploxi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.capgemini.Emploxi.entities.Classement;
import tn.capgemini.Emploxi.entities.TypeContrat;
import tn.capgemini.Emploxi.services.TypeContratService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/typecontrats")
public class TypeContratController {

    @Autowired
    private TypeContratService typeContratService;

    @GetMapping
    public ResponseEntity<List<TypeContrat>> getAllTypeContrats() {
        List<TypeContrat> typeContrats = typeContratService.getAllTypeContrats();
        return new ResponseEntity<>(typeContrats, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeContrat> getTypeContratById(@PathVariable Long id) {
        Optional<TypeContrat> typeContrat = typeContratService.getTypeContratById(id);
        return typeContrat.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<TypeContrat> createTypeContrat(@RequestBody TypeContrat typeContrat) {
        TypeContrat newTypeContrat = typeContratService.saveTypeContrat(typeContrat);
        return new ResponseEntity<>(newTypeContrat, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTypeContrat(@PathVariable Long id) {
        Optional<TypeContrat> typeContrat = typeContratService.getTypeContratById(id);
        if (typeContrat.isPresent()) {
            typeContratService.deleteTypeContrat(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<TypeContrat> update(@PathVariable Long id, @RequestBody TypeContrat updated) {
        Optional<TypeContrat> existing = typeContratService.getTypeContratById(id);
        if (existing.isPresent()) {
            updated.setId(id); // Ensure ID consistency
            TypeContrat saved = typeContratService.saveTypeContrat(updated);
            return new ResponseEntity<>(saved, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
