package com.example.soapproject.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data

public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "email")
    private String email;

    @Column(name = "telephone")
    private String telephone;

    @OneToMany(mappedBy = "client")
    private List<Commande> commandes;

    // Getters and Setters
}
