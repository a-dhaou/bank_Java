package com.example.ProjetTekup.Bank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ProjetTekup.Bank.models.Compte;

@Repository
public interface CompteRepository extends JpaRepository<Compte, Long> {
        
}
