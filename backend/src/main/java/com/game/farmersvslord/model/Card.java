package com.game.farmersvslord.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * Represents a card in the game.
 */
@Entity
public class Card {
    @Id
    private Long id;
    private String suit;
    private String rank;
    private int value;

    /**
     * Default constructor for JPA.
     */
    public Card() {
    }

    /**
     * Parameterized constructor to create a card instance.
     *
     * @param id    Unique identifier for the card.
     * @param suit  Suit of the card (e.g., Hearts, Diamonds).
     * @param rank  Rank of the card (e.g., 2, 3, King).
     * @param value Numeric value of the card for game logic.
     */
    public Card(Long id, String suit, String rank, int value) {
        this.id = id;
        this.suit = suit;
        this.rank = rank;
        this.value = value;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}