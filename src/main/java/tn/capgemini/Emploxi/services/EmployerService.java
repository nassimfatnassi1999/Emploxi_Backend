package tn.capgemini.Emploxi.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.capgemini.Emploxi.entities.Employer;
import tn.capgemini.Emploxi.entities.Nationality;
import tn.capgemini.Emploxi.repositories.EmployerRepository;
import tn.capgemini.Emploxi.repositories.NationalityRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployerService {

    @Autowired
    private EmployerRepository employerRepository;
    @Autowired
    private NationalityRepository nationalityRepository;


    public List<Employer> getAllEmployers() {
        return employerRepository.findAll();
    }

    public Optional<Employer> getEmployerById(Long id) {
        return employerRepository.findById(id);
    }

    public Employer saveEmployer(Employer employer) {

        return employerRepository.save(employer);
    }

    public void deleteEmployer(Long id) {
        employerRepository.deleteById(id);
    }
}
