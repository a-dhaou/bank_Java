package com.example.ProjetTekup.Bank.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ProjetTekup.Bank.models.Transaction;
import com.example.ProjetTekup.Bank.services.TransactionService;
@RequestMapping("transactions") 
@CrossOrigin("*")
@RestController

public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping
    public List<Transaction> getAll() {
        return transactionService.getAllTransactions();
    }

    @PostMapping("/depot")
    public Transaction ajouterDepot(@RequestBody Transaction t) {
        return transactionService.effectuerDepot(t);
    }

    @PostMapping("/retrait")
    public Transaction effectuerRetrait(@RequestBody Transaction t) {
        return transactionService.effectuerRetrait(t);
    }
    @PostMapping("/virement")
    public Transaction effectuerVirement(@RequestBody Transaction t) {
        return transactionService.effectuerVirement(t);
    }
}

    

