package com.example.ProjetTekup.Bank.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProjetTekup.Bank.models.Compte;
import com.example.ProjetTekup.Bank.repositories.CompteRepository;
import com.example.ProjetTekup.Bank.services.CompteService;

@Service
public class CompteServiceImpl implements CompteService {

    @Autowired
    public CompteRepository compteRepository;
     

    @Override
    public List<Compte> getAllComptes() {
        return compteRepository.findAll();
    }

    @Override
    public Compte getCompteById(Long id) {
        Optional<Compte> c = compteRepository.findById(id);
        return c.isPresent() ? c.get() : null;
    }

    @Override
    public Compte addCompte(Compte c) {
        return compteRepository.save(c);
    }

    @Override
    public Compte updateCompte(Compte c) {
        return compteRepository.save(c);
    }

    @Override
    public void deleteCompteById(Long id) {
        compteRepository.deleteById(id);
    }
  
}
