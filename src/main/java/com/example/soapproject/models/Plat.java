package com.example.soapproject.models;

import jakarta.persistence.*;
import lombok.Data;


import java.util.List;


@Entity
@Data
public class Plat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "description")
    private String description;

    @Column(name = "prix")
    private Double prix;

    @ManyToMany(mappedBy = "plats")
    private List<Commande> commandes;

    // Getters and Setters
}
