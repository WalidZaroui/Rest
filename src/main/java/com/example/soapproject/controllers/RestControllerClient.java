package com.example.soapproject.controllers;

import com.example.soapproject.models.Client;
import com.example.soapproject.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class RestControllerClient {

    @Autowired
    private ClientService clientService;

    @GetMapping("/{nom}")
    public ResponseEntity<Client> getClientByNom(@PathVariable String nom) {
        Client client = clientService.getClientByNom(nom);
        if (client != null) {
            return ResponseEntity.ok(client);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClient();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id) {
        try {
            Client client = clientService.getClientById(id);
            return ResponseEntity.ok(client);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Client createClient(@RequestBody Client client) {
        System.out.println("Received client: " + client);
        return clientService.createClient(client);
    }

    @PutMapping
    public Client updateClient(@RequestBody Client client) {
        System.out.println("Received client for update: " + client);
        return clientService.updateClient(client);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable Long id) {
        try {
            clientService.deleteClient(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
