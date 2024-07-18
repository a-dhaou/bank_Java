package com.example.ProjetTekup.Bank.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ProjetTekup.Bank.models.Compte;
import com.example.ProjetTekup.Bank.services.CompteService;

@RequestMapping("Comptes") // cette ligne va permettre de diriger un service vers un contrôleur précis, donc la classe CompteController va traiter chaque request qui a pour url: http/localhost8080/comptes
@CrossOrigin("*")
// @CrossOrigin("http://localhost:4200"): indique l'url du front depuis lequel on va accepter les requêtes, ou on va accepter les requêtes qui viennent seulement du front angular qui a le port 4200 et non le front react, ou vue par exemple.
// @CrossOrigin("*"): indique que on va accepter les requêtes qui viennent de n'importe quel frontend sur n'importe quel port (d'où vient la notion de spring security)

@RestController
public class CompteController {
    @Autowired
    public CompteService compteService;

    @GetMapping
    public List<Compte> getAll() {
        return compteService.getAllComptes();
    }

    @GetMapping("/{id}")
    public Compte getById(@PathVariable Long id) {
        return compteService.getCompteById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        compteService.deleteCompteById(id);
    }

    @PostMapping
    public Compte addCompte(@RequestBody Compte compte) {
        return compteService.addCompte(compte);
    }

    @PutMapping
    public Compte editCompte(@RequestBody Compte compte) {
        return compteService.updateCompte(compte);
    }
}
