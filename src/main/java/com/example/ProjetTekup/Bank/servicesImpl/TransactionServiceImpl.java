package com.example.ProjetTekup.Bank.servicesImpl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProjetTekup.Bank.models.Compte;
import com.example.ProjetTekup.Bank.models.Transaction;
import com.example.ProjetTekup.Bank.models.TransactionType;
import com.example.ProjetTekup.Bank.repositories.CompteRepository;
import com.example.ProjetTekup.Bank.repositories.TransactionRepository;
import com.example.ProjetTekup.Bank.services.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private CompteRepository compteRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    @Override
    public Transaction effectuerDepot(Transaction t) {
        // Vérification de la validité du montant
        double montant = t.getMontant();
        if (montant <= 0) {
            throw new IllegalArgumentException("Le montant doit être positif.");
        }

        // Récupération du compte source
        Compte compte = t.getCompteSource();
        if (compte == null || !compteRepository.existsById(compte.getAccountId())) {
            throw new IllegalArgumentException("Compte non trouvé.");
        }

        // Mise à jour du solde du compte
        compte.setSolde(compte.getSolde() + montant);

        // Enregistrement de la mise à jour du compte
        compteRepository.save(compte);

        // Définir les autres propriétés de la transaction
        t.setCompteDest(null); // Pas de compte destinataire pour un dépôt
        t.setTypeTransaction(TransactionType.DEPOT);
        t.setDateTransaction(LocalDateTime.now());

        // Enregistrement de la transaction
        return transactionRepository.save(t);
    }
    @Override
    public Transaction effectuerRetrait(Transaction t) {
        // Vérification de la validité du montant
        double montant = t.getMontant();
        if (montant <= 0) {
            throw new IllegalArgumentException("Le montant doit être positif.");
        }

        // Récupération du compte source
        Compte compte = t.getCompteSource();
        if (compte == null || !compteRepository.existsById(compte.getAccountId())) {
            throw new IllegalArgumentException("Compte non trouvé.");
        }

        // Mise à jour du solde du compte après vérification du solde suffisant
        compte = compteRepository.findById(compte.getAccountId())
                .orElseThrow(() -> new IllegalArgumentException("Compte non trouvé."));
        if (compte.getSolde() < montant) {
            throw new IllegalArgumentException("Solde insuffisant pour effectuer le retrait.");
        }
        compte.setSolde(compte.getSolde() - montant);

        // Enregistrement de la mise à jour du compte
        compteRepository.save(compte);

        // Définir les autres propriétés de la transaction
        t.setCompteDest(null); // Pas de compte destinataire pour un retrait
        t.setTypeTransaction(TransactionType.RETRAIT);
        t.setDateTransaction(LocalDateTime.now());

        // Enregistrement de la transaction
        return transactionRepository.save(t);
    }


    @Override
    public Transaction effectuerVirement(Transaction t) {
        // Vérification de la validité du montant
        double montant = t.getMontant();
        if (montant <= 0) {
            throw new IllegalArgumentException("Le montant doit être positif.");
        }

        // Récupération des comptes source et destination
        Compte compteSource = t.getCompteSource();
        Compte compteDest = t.getCompteDest();
        if (compteSource == null || !compteRepository.existsById(compteSource.getAccountId())) {
            throw new IllegalArgumentException("Compte source non trouvé.");
        }
        if (compteDest == null || !compteRepository.existsById(compteDest.getAccountId())) {
            throw new IllegalArgumentException("Compte destinataire non trouvé.");
        }

        // Mise à jour du solde du compte source après vérification du solde suffisant
        compteSource = compteRepository.findById(compteSource.getAccountId())
                .orElseThrow(() -> new IllegalArgumentException("Compte source non trouvé."));
        if (compteSource.getSolde() < montant) {
            throw new IllegalArgumentException("Solde insuffisant pour effectuer le virement.");
        }
        compteSource.setSolde(compteSource.getSolde() - montant);

        // Mise à jour du solde du compte destinataire
        compteDest = compteRepository.findById(compteDest.getAccountId())
                .orElseThrow(() -> new IllegalArgumentException("Compte destinataire non trouvé."));
        compteDest.setSolde(compteDest.getSolde() + montant);

        // Enregistrement de la mise à jour des comptes
        compteRepository.save(compteSource);
        compteRepository.save(compteDest);

        // Définir les autres propriétés de la transaction
        t.setTypeTransaction(TransactionType.VIREMENT);
        t.setDateTransaction(LocalDateTime.now());

        // Enregistrement de la transaction
        return transactionRepository.save(t);
    }
}
