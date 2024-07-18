package com.example.ProjetTekup.Bank.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ProjetTekup.Bank.models.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByCompteSource_ClientIdOrCompteDest_ClientId(Long clientIdSource, Long clientIdDest);

}