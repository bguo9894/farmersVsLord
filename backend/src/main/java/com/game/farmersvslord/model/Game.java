package com.game.farmersvslord.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

/**
 * Represents the game state and logic for Farmers vs Lord (斗地主).
 */
@Entity
public class Game {
    @Id
    private Long id;
    @OneToMany
    private List<Player> players;
    @OneToMany
    private List<Card> bottomCards;

    /**
     * Default constructor for JPA.
     */
    public Game() {
    }

    /**
     * Parameterized constructor to create a game instance.
     *
     * @param id          Unique identifier for the game.
     * @param players     List of players participating in the game.
     * @param bottomCards List of bottom cards for the game.
     */
    public Game(Long id, List<Player> players, List<Card> bottomCards) {
        this.id = id;
        this.players = players;
        this.bottomCards = bottomCards;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Card> getBottomCards() {
        return bottomCards;
    }

    public void setBottomCards(List<Card> bottomCards) {
        this.bottomCards = bottomCards;
    }
}