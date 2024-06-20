package tn.capgemini.Emploxi.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.capgemini.Emploxi.entities.*;
import tn.capgemini.Emploxi.services.EmployerService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/employers")
public class EmployerController {

    @Autowired
    private EmployerService employerService;
@GetMapping
public  ResponseEntity<List<Employer>>getEmployers(){
    List<Employer> employers = employerService.getAllEmployers();
    return new ResponseEntity<>(employers, HttpStatus.OK);
}

    @GetMapping("/special")
    public ResponseEntity<List<EmployerDTO>> getAllEmployers() {
        List<Employer> employers = employerService.getAllEmployers();
        List<EmployerDTO> employerDTOs = employers.stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ResponseEntity<>(employerDTOs, HttpStatus.OK);
    }

    private EmployerDTO convertToDTO(Employer employer) {
        EmployerDTO employerDTO = new EmployerDTO();
        employerDTO.setId(employer.getId());
        employerDTO.setLocal_id(employer.getLocal_id());
        employerDTO.setPrener_id(employer.getPrener_id());
        employerDTO.setCg_id(employer.getCg_id());
        employerDTO.setNom(Optional.ofNullable(employer.getNom()).orElse(""));
        employerDTO.setPrenom(Optional.ofNullable(employer.getPrenom()).orElse(""));
        employerDTO.setR_hierarchique(Optional.ofNullable(employer.getR_hierarchique()).orElse(""));
        employerDTO.setStartDate(employer.getStartDate());
        employerDTO.setDate_atc(employer.getDate_atc());
        employerDTO.setSalaireNet_entree(employer.getSalaireNet_entree());
        employerDTO.setSlaireBrute(employer.getSlaireBrute());
        employerDTO.setExp_ANT(Optional.ofNullable(employer.getExp_ANT()).orElse(""));
        employerDTO.setAnncientite_ATC(Optional.ofNullable(employer.getAnncientite_ATC()).orElse(""));
        employerDTO.setExp_total_as_is(Optional.ofNullable(employer.getExp_total_as_is()).orElse(""));
        employerDTO.setCin(employer.getCin());
        employerDTO.setDate_naissance(employer.getDate_naissance());
        employerDTO.setAge(employer.getAge());
        employerDTO.setNbr_enfant(employer.getNbr_enfant());
        employerDTO.setDiplome(Optional.ofNullable(employer.getDiplome()).orElse(""));
        employerDTO.setPromotion(Optional.ofNullable(employer.getPromotion()).orElse(""));
        employerDTO.setEcole(Optional.ofNullable(employer.getEcole()).orElse(""));
        employerDTO.setMail_personnel(Optional.ofNullable(employer.getMail_personnel()).orElse(""));
        employerDTO.setTitre_admin(Optional.ofNullable(employer.getTitre_admin()).orElse(""));
        employerDTO.setMail_capgemini(Optional.ofNullable(employer.getMail_capgemini()).orElse(""));
        employerDTO.setDateSortie(employer.getDateSortie());
        employerDTO.setTelephone(employer.getTelephone());
        employerDTO.setCnss(Optional.ofNullable(employer.getCnss()).orElse(""));
        employerDTO.setAdresse_cnss(Optional.ofNullable(employer.getAdresse_cnss()).orElse(""));
        employerDTO.setRib(Optional.ofNullable(employer.getRib()).orElse(""));
        employerDTO.setDesignation(Optional.ofNullable(employer.getDesignation()).orElse(""));
        employerDTO.setProfessional_community(Optional.ofNullable(employer.getProfessional_community()).orElse(""));
        employerDTO.setGenre(Optional.ofNullable(employer.getGenre()).map(Enum::name).orElse(""));
        employerDTO.setNationality(Optional.ofNullable(employer.getNationality()).map(Nationality::getName).orElse("")); // Assuming getName() returns the name of the nationality
        employerDTO.setTypeContrat(Optional.ofNullable(employer.getTypeContrat()).map(TypeContrat::getName).orElse("")); // Assuming getName() returns the name of the contract type
        employerDTO.setActivity(Optional.ofNullable(employer.getActivity()).map(Activity::getName).orElse("")); // Assuming getName() returns the name of the activity
        employerDTO.setClassement(Optional.ofNullable(employer.getClassement()).map(Classement::getName).orElse("")); // Assuming getName() returns the name of the ranking
        employerDTO.setGrade(Optional.ofNullable(employer.getGrade()).map(Grade::getName).orElse("")); // Assuming getName() returns the name of the grade
        employerDTO.setJobNameCGcg(Optional.ofNullable(employer.getJobNameCGcg()).map(JobNameCG::getName).orElse("")); // Assuming getName() returns the name of the job name
        employerDTO.setL12(Optional.ofNullable(employer.getL12()).map(L12::getName).orElse("")); // Assuming getName() returns the name of the L12
        employerDTO.setNiche(Optional.ofNullable(employer.getNiche()).map(Niche::getName).orElse("")); // Assuming getName() returns the name of the niche
        employerDTO.setProfil(Optional.ofNullable(employer.getProfil()).map(Profil::getName).orElse("")); // Assuming getName() returns the name of the profile
        employerDTO.setRoleFamily(Optional.ofNullable(employer.getRoleFamily()).map(RoleFamily::getName).orElse("")); // Assuming getName() returns the name of the role family
        employerDTO.setRoleName(Optional.ofNullable(employer.getRoleName()).map(RoleName::getName).orElse("")); // Assuming getName() returns the name of the role name
        employerDTO.setSituationFamiliale(Optional.ofNullable(employer.getSituationFamiliale()).map(SituationFamiliale::getName).orElse("")); // Assuming getName() returns the name of the family situation
        employerDTO.setCssDssDsp(Optional.ofNullable(employer.getCssDssDsp()).map(CSS_DSS_DSP::getName).orElse("")); // Assuming getName() returns the name of the CSS_DSS_DSP

        return employerDTO;
    }


    @GetMapping("/headers")
    public Headers[] getStatuses() {
        return Headers.values();
    }
    @GetMapping("/drops")
    public Drops[] getDrops() {
        return Drops.values();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Employer> getEmployerById(@PathVariable Long id) {
        Optional<Employer> employer = employerService.getEmployerById(id);
        return employer.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Employer> createEmployer(@RequestBody Employer employer) {
        Employer newEmployer = employerService.saveEmployer(employer);
        return new ResponseEntity<>(newEmployer, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employer> updateEmployer(@PathVariable Long id , @RequestBody Employer employerDetails) {
        Optional<Employer> employer = employerService.getEmployerById(id);
        if (employer.isPresent()) {
            Employer existingEmployer = employer.get();
            // Update fields here
            existingEmployer.setNom(employerDetails.getNom());
            existingEmployer.setPrenom(employerDetails.getPrenom());
            // Add more fields to update as necessary
            Employer updatedEmployer = employerService.saveEmployer(existingEmployer);
            return new ResponseEntity<>(updatedEmployer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployer(@PathVariable Long id) {
        Optional<Employer> employer = employerService.getEmployerById(id);
        if (employer.isPresent()) {
            employerService.deleteEmployer(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
