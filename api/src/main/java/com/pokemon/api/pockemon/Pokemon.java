package com.pokemon.api.pockemon;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pokemon")
@Getter
@Setter
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String imagefront;
    private String imageback;
    private int quantity;

    public Pokemon() {}

    public Pokemon(String name, String imagefront, String imageback, int quantity) {
        this.name = name;
        this.imagefront = imagefront;
        this.imageback = imageback;
        this.quantity = quantity;
    }
}