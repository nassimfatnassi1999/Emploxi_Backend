package tn.capgemini.Emploxi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.capgemini.Emploxi.entities.Classement;
import tn.capgemini.Emploxi.entities.RoleName;
import tn.capgemini.Emploxi.services.RoleNameService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/rolenames")
public class RoleNameController {

    @Autowired
    private RoleNameService roleNameService;

    @GetMapping
    public ResponseEntity<List<RoleName>> getAllRoleNames() {
        List<RoleName> roleNames = roleNameService.getAllRoleNames();
        return new ResponseEntity<>(roleNames, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleName> getRoleNameById(@PathVariable Long id) {
        Optional<RoleName> roleName = roleNameService.getRoleNameById(id);
        return roleName.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<RoleName> createRoleName(@RequestBody RoleName roleName) {
        RoleName newRoleName = roleNameService.saveRoleName(roleName);
        return new ResponseEntity<>(newRoleName, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoleName(@PathVariable Long id) {
        Optional<RoleName> roleName = roleNameService.getRoleNameById(id);
        if (roleName.isPresent()) {
            roleNameService.deleteRoleName(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<RoleName> update(@PathVariable Long id, @RequestBody RoleName updated) {
        Optional<RoleName> existing = roleNameService.getRoleNameById(id);
        if (existing.isPresent()) {
            updated.setId(id); // Ensure ID consistency
            RoleName saved = roleNameService.saveRoleName(updated);
            return new ResponseEntity<>(saved, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
