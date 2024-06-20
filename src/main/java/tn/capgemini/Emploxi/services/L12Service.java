package tn.capgemini.Emploxi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.capgemini.Emploxi.entities.L12;
import tn.capgemini.Emploxi.repositories.L12Repository;

import java.util.List;
import java.util.Optional;

@Service
public class L12Service {

    @Autowired
    private L12Repository l12Repository;

    public List<L12> getAllL12s() {
        return l12Repository.findAll();
    }

    public Optional<L12> getL12ById(Long id) {
        return l12Repository.findById(id);
    }

    public L12 saveL12(L12 l12) {
        return l12Repository.save(l12);
    }

    public void deleteL12(Long id) {
        l12Repository.deleteById(id);
    }
}
