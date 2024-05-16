package com.example.soapproject.controllers;

import com.example.soapproject.models.Commande;
import com.example.soapproject.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/commandes")
public class RestControllerCommande {

    @Autowired
    private CommandeService commandeService;

    @GetMapping
    public List<Commande> getAllCommandes() {
        return commandeService.getAllCommandes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Commande> getCommandeById(@PathVariable Long id) {
        Commande commande = commandeService.getCommandeById(id);
        if (commande != null) {
            return ResponseEntity.ok(commande);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Commande createCommande(@RequestBody Commande commande) {
        return commandeService.createCommande(commande);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Commande> updateCommande(@RequestBody Commande commande, @PathVariable Long id) {
        Commande existingCommande = commandeService.getCommandeById(id);
        if (existingCommande != null) {
            commande.setId(id); // Ensure the correct item is updated
            return ResponseEntity.ok(commandeService.updateCommande(commande));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCommande(@PathVariable Long id) {
        if (commandeService.getCommandeById(id) != null) {
            commandeService.deleteCommande(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}