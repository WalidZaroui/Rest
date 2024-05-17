package com.example.soapproject.service;

import com.example.soapproject.models.Commande;
import com.example.soapproject.models.Plat;
import com.example.soapproject.repository.CommandeRepository;
import com.example.soapproject.repository.PlatRepository;
import com.example.soapproject.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommandeServiceImpl implements CommandeService {

    @Autowired
    private CommandeRepository commandeRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PlatRepository platRepository;

    @Override
    public List<Commande> getAllCommandes() {
        return commandeRepository.findAll();
    }

    @Override
    public Commande getCommandeById(Long id) {
        return commandeRepository.findById(id).orElse(null);
    }

    @Override
    public Commande createCommande(Commande commande) {
        // Set the client for the commande
        commande.setClient(clientRepository.findById(commande.getClient().getId()).orElse(null));

        // Set the plats for the commande
        List<Plat> plats = commande.getPlats();
        for (int i = 0; i < plats.size(); i++) {
            plats.set(i, platRepository.findById(plats.get(i).getId()).orElse(null));
        }
        commande.setPlats(plats);

        return commandeRepository.save(commande);
    }

    @Override
    public Commande updateCommande(Commande commande) {
        return commandeRepository.save(commande);
    }

    @Override
    public void deleteCommande(Long id) {
        commandeRepository.deleteById(id);
    }
}
