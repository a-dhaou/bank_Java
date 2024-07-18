package com.example.ProjetTekup.Bank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ProjetTekup.Bank.models.Client;

@Repository
public interface ClientRepositories extends JpaRepository<Client, Long> {
    Client findByEmail(String email);
}
