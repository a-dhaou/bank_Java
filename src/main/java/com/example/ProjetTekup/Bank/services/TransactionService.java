package com.example.ProjetTekup.Bank.services;

import java.util.List;

import com.example.ProjetTekup.Bank.models.Transaction;

public interface TransactionService {
    public List<Transaction> getAllTransactions();

    public Transaction effectuerDepot(Transaction t);
    public Transaction effectuerRetrait(Transaction t);
    public Transaction effectuerVirement(Transaction t);

    
}
