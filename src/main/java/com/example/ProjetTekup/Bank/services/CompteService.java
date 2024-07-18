package com.example.ProjetTekup.Bank.services;

import java.util.List;

import com.example.ProjetTekup.Bank.models.Compte;

public interface CompteService {
    
    public List<Compte> getAllComptes();
    
    public Compte getCompteById(Long id);
    
    public Compte addCompte(Compte c);
    
    public Compte updateCompte(Compte c);
       
    public void deleteCompteById(Long id);
}
