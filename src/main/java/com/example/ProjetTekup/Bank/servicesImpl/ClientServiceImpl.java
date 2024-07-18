package com.example.ProjetTekup.Bank.servicesImpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ProjetTekup.Bank.models.Client;
import com.example.ProjetTekup.Bank.models.Transaction;
import com.example.ProjetTekup.Bank.repositories.ClientRepositories;
import com.example.ProjetTekup.Bank.repositories.TransactionRepository;
import com.example.ProjetTekup.Bank.services.ClientService;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    public ClientRepositories clientrepo;

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public List<Client> getAllClients() {
        return clientrepo.findAll();
    }

    @Override
    public Client getClientById(Long id) {
        Optional<Client> c = clientrepo.findById(id);
        return c.isPresent() ? c.get() : null;
    }

    @Override
    public Client addClient(Client c) {
        return clientrepo.save(c);
    }

    @Override
    public Client updateClient(Client c) {
        return clientrepo.save(c);
    }

    @Override
    public void deleteClientById(Long id) {
        clientrepo.deleteById(id);
    }

    @Override
    public List<Transaction> getTransactionHistory(Long clientId) {
        return transactionRepository.findByCompteSource_ClientIdOrCompteDest_ClientId(clientId, clientId);
    }
}
