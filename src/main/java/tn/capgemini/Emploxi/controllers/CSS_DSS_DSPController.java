package tn.capgemini.Emploxi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.capgemini.Emploxi.entities.CSS_DSS_DSP;
import tn.capgemini.Emploxi.entities.Classement;
import tn.capgemini.Emploxi.services.CSS_DSS_DSPService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/cssdssdsp")
public class CSS_DSS_DSPController {
    @Autowired
    private CSS_DSS_DSPService cssDssDspService;




    @GetMapping
    public ResponseEntity<List<CSS_DSS_DSP>> getAllCSSDssDsp() {
        List<CSS_DSS_DSP> cssDssDspList = cssDssDspService.getAllCSSDssDsp();
        return new ResponseEntity<>(cssDssDspList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CSS_DSS_DSP> getCSSDssDspById(@PathVariable Long id) {
        CSS_DSS_DSP cssDssDsp = cssDssDspService.getCSSDssDspById(id);
        if (cssDssDsp != null) {
            return new ResponseEntity<>(cssDssDsp, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<CSS_DSS_DSP> createCSSDssDsp(@RequestBody CSS_DSS_DSP cssDssDsp) {
        CSS_DSS_DSP savedCSSDssDsp = cssDssDspService.saveOrUpdateCSSDssDsp(cssDssDsp);
        return new ResponseEntity<>(savedCSSDssDsp, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CSS_DSS_DSP> updateCSSDssDsp(@PathVariable Long id, @RequestBody CSS_DSS_DSP cssDssDsp) {
        CSS_DSS_DSP existingCSSDssDsp = cssDssDspService.getCSSDssDspById(id);
        if (existingCSSDssDsp != null) {
            cssDssDsp.setId(id);
            CSS_DSS_DSP updatedCSSDssDsp = cssDssDspService.saveOrUpdateCSSDssDsp(cssDssDsp);
            return new ResponseEntity<>(updatedCSSDssDsp, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCSSDssDsp(@PathVariable Long id) {
        CSS_DSS_DSP existingCSSDssDsp = cssDssDspService.getCSSDssDspById(id);
        if (existingCSSDssDsp != null) {
            cssDssDspService.deleteCSSDssDsp(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
