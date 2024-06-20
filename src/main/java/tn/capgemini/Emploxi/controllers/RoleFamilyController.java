package tn.capgemini.Emploxi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.capgemini.Emploxi.entities.Classement;
import tn.capgemini.Emploxi.entities.RoleFamily;
import tn.capgemini.Emploxi.services.RoleFamilyService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/rolefamilies")
public class RoleFamilyController {

    @Autowired
    private RoleFamilyService roleFamilyService;

    @GetMapping
    public ResponseEntity<List<RoleFamily>> getAllRoleFamilies() {
        List<RoleFamily> roleFamilies = roleFamilyService.getAllRoleFamilies();
        return new ResponseEntity<>(roleFamilies, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleFamily> getRoleFamilyById(@PathVariable Long id) {
        Optional<RoleFamily> roleFamily = roleFamilyService.getRoleFamilyById(id);
        return roleFamily.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<RoleFamily> createRoleFamily(@RequestBody RoleFamily roleFamily) {
        RoleFamily newRoleFamily = roleFamilyService.saveRoleFamily(roleFamily);
        return new ResponseEntity<>(newRoleFamily, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoleFamily(@PathVariable Long id) {
        Optional<RoleFamily> roleFamily = roleFamilyService.getRoleFamilyById(id);
        if (roleFamily.isPresent()) {
            roleFamilyService.deleteRoleFamily(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<RoleFamily> update(@PathVariable Long id, @RequestBody RoleFamily updated) {
        Optional<RoleFamily> existing = roleFamilyService.getRoleFamilyById(id);
        if (existing.isPresent()) {
            updated.setId(id); // Ensure ID consistency
            RoleFamily saved = roleFamilyService.saveRoleFamily(updated);
            return new ResponseEntity<>(saved, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
