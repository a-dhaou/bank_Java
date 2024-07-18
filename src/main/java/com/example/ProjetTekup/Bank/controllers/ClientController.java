package com.example.ProjetTekup.Bank.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.ProjetTekup.Bank.models.Client;
import com.example.ProjetTekup.Bank.models.Transaction;
import com.example.ProjetTekup.Bank.services.ClientService;

@RequestMapping("clients")
@CrossOrigin("*")
@RestController
public class ClientController {
    @Autowired
    public ClientService clientService;

    @GetMapping
    public List<Client> getAll() {
        return clientService.getAllClients();
    }

    @GetMapping("/{id}")
    public Client getById(@PathVariable Long id) {
        return clientService.getClientById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        clientService.deleteClientById(id);
    }

    @PostMapping
    public Client addClient(@RequestBody Client client) {
        return clientService.addClient(client);
    }

    @PutMapping
    public Client editMatch(@RequestBody Client c) {
        return clientService.updateClient(c);
    }

    @GetMapping("/{clientId}/transactions")
    public List<Transaction> getTransactionHistory(@PathVariable Long clientId) {
        return clientService.getTransactionHistory(clientId);
    }
}
