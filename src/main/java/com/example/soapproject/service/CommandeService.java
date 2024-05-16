package com.example.soapproject.service;

import com.example.soapproject.models.Commande;
import java.util.List;

public interface CommandeService {
    List<Commande> getAllCommandes();
    Commande getCommandeById(Long id);
    Commande createCommande(Commande commande);
    Commande updateCommande(Commande commande);
    void deleteCommande(Long id);
}