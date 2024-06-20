package tn.capgemini.Emploxi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.capgemini.Emploxi.entities.Classement;
import tn.capgemini.Emploxi.entities.Grade;
import tn.capgemini.Emploxi.services.GradeService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

@RequestMapping("/api/grades")
public class GradeController {

    @Autowired
    private GradeService gradeService;

    @GetMapping
    public ResponseEntity<List<Grade>> getAllGrades() {
        List<Grade> grades = gradeService.getAllGrades();
        return new ResponseEntity<>(grades, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Grade> getGradeById(@PathVariable Long id) {
        Optional<Grade> grade = gradeService.getGradeById(id);
        return grade.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Grade> createGrade(@RequestBody Grade grade) {
        Grade newGrade = gradeService.saveGrade(grade);
        return new ResponseEntity<>(newGrade, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGrade(@PathVariable Long id) {
        Optional<Grade> grade = gradeService.getGradeById(id);
        if (grade.isPresent()) {
            gradeService.deleteGrade(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Grade> update(@PathVariable Long id, @RequestBody Grade updated) {
        Optional<Grade> existing = gradeService.getGradeById(id);
        if (existing.isPresent()) {
            updated.setId(id); // Ensure ID consistency
            Grade saved = gradeService.saveGrade(updated);
            return new ResponseEntity<>(saved, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
