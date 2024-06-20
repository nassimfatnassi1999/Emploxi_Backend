package tn.capgemini.Emploxi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.capgemini.Emploxi.entities.Classement;
import tn.capgemini.Emploxi.entities.L12;
import tn.capgemini.Emploxi.services.L12Service;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/l12s")
public class L12Controller {

    @Autowired
    private L12Service l12Service;

    @GetMapping
    public ResponseEntity<List<L12>> getAllL12s() {
        List<L12> l12s = l12Service.getAllL12s();
        return new ResponseEntity<>(l12s, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<L12> getL12ById(@PathVariable Long id) {
        Optional<L12> l12 = l12Service.getL12ById(id);
        return l12.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<L12> createL12(@RequestBody L12 l12) {
        L12 newL12 = l12Service.saveL12(l12);
        return new ResponseEntity<>(newL12, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteL12(@PathVariable Long id) {
        Optional<L12> l12 = l12Service.getL12ById(id);
        if (l12.isPresent()) {
            l12Service.deleteL12(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<L12> update(@PathVariable Long id, @RequestBody L12 updated) {
        Optional<L12> existing = l12Service.getL12ById(id);
        if (existing.isPresent()) {
            updated.setId(id); // Ensure ID consistency
            L12 saved = l12Service.saveL12(updated);
            return new ResponseEntity<>(saved, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
