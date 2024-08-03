package com.game.farmersvslord.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

/**
 * Represents a player in the game.
 */
@Entity
public class Player {
    @Id
    private Long id;
    private String name;
    @OneToMany
    private List<Card> hand;

    /**
     * Default constructor for JPA.
     */
    public Player() {
    }

    /**
     * Parameterized constructor to create a player instance.
     *
     * @param id   Unique identifier for the player.
     * @param name Name of the player.
     * @param hand List of cards held by the player.
     */
    public Player(Long id, String name, List<Card> hand) {
        this.id = id;
        this.name = name;
        this.hand = hand;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Card> getHand() {
        return hand;
    }

    public void setHand(List<Card> hand) {
        this.hand = hand;
    }
}