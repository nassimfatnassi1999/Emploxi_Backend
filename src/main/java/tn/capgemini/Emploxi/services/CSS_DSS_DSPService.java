package tn.capgemini.Emploxi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.capgemini.Emploxi.entities.CSS_DSS_DSP;
import tn.capgemini.Emploxi.repositories.CSS_DSS_DSPRepository;

import java.util.List;

@Service
public class CSS_DSS_DSPService {
    @Autowired
    private CSS_DSS_DSPRepository cssDssDspRepository;




    public List<CSS_DSS_DSP> getAllCSSDssDsp() {
        return cssDssDspRepository.findAll();
    }

    public CSS_DSS_DSP getCSSDssDspById(Long id) {
        return cssDssDspRepository.findById(id).orElse(null);
    }

    public CSS_DSS_DSP saveOrUpdateCSSDssDsp(CSS_DSS_DSP cssDssDsp) {
        return cssDssDspRepository.save(cssDssDsp);
    }

    public void deleteCSSDssDsp(Long id) {
        cssDssDspRepository.deleteById(id);
    }
}
