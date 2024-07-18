package com.example.ProjetTekup.Bank.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    private double solde;
    private String typeCompte;
    public Compte() {
    }

    // Constructeur avec paramètres
    public Compte(double solde, String typeCompte) {
        this.solde = solde;
        this.typeCompte = typeCompte;
    }

    // Getters et Setters
    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public String getTypeCompte() {
        return typeCompte;
    }

    public void setTypeCompte(String typeCompte) {
        this.typeCompte = typeCompte;
    }

    @Override
    public String toString() {
        return "Compte [accountId=" + accountId + ", solde=" + solde + ", typeCompte=" + typeCompte + "]";
    }
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "compteSource")
private List<Transaction> transactionsCommeSource;

@OneToMany(mappedBy = "compteDest")
private List<Transaction> transactionsCommeDest;

    
}
