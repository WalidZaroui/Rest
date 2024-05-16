package com.example.soapproject.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data

public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "commande_plat",
            joinColumns = @JoinColumn(name = "commande_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "plat_id", referencedColumnName = "id")
    )
    private List<Plat> plats;

    @Column(name = "total")
    private Double total;

    // Getters and Setters
}