package com.example.ProjetTekup.Bank.services;

import java.util.List;
import com.example.ProjetTekup.Bank.models.Client;
import com.example.ProjetTekup.Bank.models.Transaction;

public interface ClientService {
    public List<Client> getAllClients();
    public Client getClientById(Long id);
    public Client addClient(Client c);
    public Client updateClient(Client c);
    public void deleteClientById(Long id);

    // New method to get transaction history
    public List<Transaction> getTransactionHistory(Long clientId);
}
