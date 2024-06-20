package tn.capgemini.Emploxi.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.capgemini.Emploxi.entities.Employer;
import tn.capgemini.Emploxi.services.ExcelImportService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/importExport")
@AllArgsConstructor
public class ImportExportController {

    private final ExcelImportService excelImportService;
    @PostMapping("/import-employers")
    public ResponseEntity<List<Employer>> importEmployees(@RequestParam("file") MultipartFile file) {
        List<Employer> employees = excelImportService.importExcelFile(file);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
}
