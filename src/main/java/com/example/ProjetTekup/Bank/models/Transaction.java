package com.example.ProjetTekup.Bank.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "account_id_source")
    private Compte compteSource;

    @ManyToOne
    @JoinColumn(name = "account_id_dest")
    private Compte compteDest;

    private double montant;

    @Enumerated(EnumType.STRING)
    private TransactionType typeTransaction;

    private LocalDateTime dateTransaction;

    public Transaction() {
    }

    public Transaction(Compte compteSource, Compte compteDest, double montant, TransactionType typeTransaction, LocalDateTime dateTransaction) {
        this.compteSource = compteSource;
        this.compteDest = compteDest;
        this.montant = montant;
        this.typeTransaction = typeTransaction;
        this.dateTransaction = dateTransaction;
    }

    // Getters et setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Compte getCompteSource() {
        return compteSource;
    }

    public void setCompteSource(Compte compteSource) {
        this.compteSource = compteSource;
    }

    public Compte getCompteDest() {
        return compteDest;
    }

    public void setCompteDest(Compte compteDest) {
        this.compteDest = compteDest;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public TransactionType getTypeTransaction() {
        return typeTransaction;
    }

    public void setTypeTransaction(TransactionType typeTransaction) {
        this.typeTransaction = typeTransaction;
    }

    public LocalDateTime getDateTransaction() {
        return dateTransaction;
    }

    public void setDateTransaction(LocalDateTime dateTransaction) {
        this.dateTransaction = dateTransaction;
    }
}
