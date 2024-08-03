package com.game.farmersvslord.service;

import com.game.farmersvslord.model.Card;
import com.game.farmersvslord.model.Game;
import com.game.farmersvslord.model.Player;
import com.game.farmersvslord.repository.CardRepository;
import com.game.farmersvslord.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Service layer for managing game logic and state.
 */
@Service
public class GameService {
    private final CardRepository cardRepository;
    private final PlayerRepository playerRepository;

    private Game currentGame;
    private Player currentTurn;

    public GameService(CardRepository cardRepository, PlayerRepository playerRepository) {
        this.cardRepository = cardRepository;
        this.playerRepository = playerRepository;
    }

    /**
     * Starts a new game with the specified player names.
     * Initializes the game state, shuffles cards, and deals them to players.
     *
     * @param playerNames List of player names.
     * @return The created Game object.
     */
    public Game startNewGame(List<String> playerNames) {
        List<Player> players = new ArrayList<>();
        for (String name : playerNames) {
            Player player = new Player();
            player.setName(name);
            playerRepository.save(player);
            players.add(player);
        }

        // Shuffle and deal cards logic
        List<Card> deck = generateDeck();
        shuffleAndDeal(deck, players);

        // Set the game and the first player to play
        this.currentGame = new Game(1L, players, deck.subList(deck.size() - 3, deck.size()));
        this.currentTurn = players.get(0); // Assume the first player is the landlord

        return this.currentGame;
    }

    /**
     * Retrieves the list of players in the current game.
     * 
     * @return List of players.
     */
    public List<Player> getPlayers() {
        return currentGame != null ? currentGame.getPlayers() : new ArrayList<>();
    }

    /**
     * Retrieves the bottom cards of the current game.
     * 
     * @return List of bottom cards.
     */
    public List<Card> getBottomCards() {
        return currentGame != null ? currentGame.getBottomCards() : new ArrayList<>();
    }

    /**
     * Generates a standard deck of cards.
     * 
     * @return List of generated cards.
     */
    private List<Card> generateDeck() {
        List<Card> deck = new ArrayList<>();
        String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };
        String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };
        int id = 1;
        for (String suit : suits) {
            for (String rank : ranks) {
                deck.add(new Card((long) id++, suit, rank, calculateCardValue(rank)));
            }
        }
        // Add Jokers
        deck.add(new Card((long) id++, "Joker", "Black", 16));
        deck.add(new Card((long) id++, "Joker", "Red", 17));
        return deck;
    }

    /**
     * Calculates the value of a card based on its rank.
     * 
     * @param rank The rank of the card.
     * @return The value of the card.
     */
    private int calculateCardValue(String rank) {
        switch (rank) {
            case "2":
                return 15;
            case "A":
                return 14;
            case "K":
                return 13;
            case "Q":
                return 12;
            case "J":
                return 11;
            default:
                return Integer.parseInt(rank);
        }
    }

    /**
     * Shuffles the deck and deals cards to the players.
     * 
     * @param deck    The deck of cards.
     * @param players The list of players.
     */
    private void shuffleAndDeal(List<Card> deck, List<Player> players) {
        // Shuffle deck
        java.util.Collections.shuffle(deck, new Random());

        // Deal cards
        int playerIndex = 0;
        for (int i = 0; i < deck.size() - 3; i++) {
            players.get(playerIndex).getHand().add(deck.get(i));
            playerIndex = (playerIndex + 1) % players.size();
        }
    }

    /**
     * Process a player's move, checking if the played cards are valid according to
     * game rules.
     * Switches turn to the next player if move is valid.
     *
     * @param playerId    The ID of the player making the move.
     * @param playedCards List of cards the player wants to play.
     * @return true if the move is valid and processed, false otherwise.
     */
    public boolean playCards(Long playerId, List<Card> playedCards) {
        // Find the player
        Player player = playerRepository.findById(playerId).orElse(null);
        if (player == null || !player.equals(currentTurn)) {
            return false; // Invalid player or not the player's turn
        }

        // Validate the move
        if (!isValidMove(playedCards)) {
            return false;
        }

        // Remove cards from the player's hand
        player.getHand().removeAll(playedCards);
        playerRepository.save(player);

        // Check if the player has won
        if (player.getHand().isEmpty()) {
            determineWinner(player);
            return true;
        }

        // Switch to the next player
        switchTurn();
        return true;
    }

    /**
     * Checks if the played cards are a valid move according to the game rules.
     * 
     * @param playedCards The cards the player wants to play.
     * @return true if the move is valid, false otherwise.
     */
    private boolean isValidMove(List<Card> playedCards) {
        // Implement validation logic based on game rules
        return true;
    }

    /**
     * Switches turn to the next player.
     */
    private void switchTurn() {
        List<Player> players = currentGame.getPlayers();
        int currentIndex = players.indexOf(currentTurn);
        currentTurn = players.get((currentIndex + 1) % players.size());
    }

    /**
     * Determines the winner and handles game-over logic.
     * 
     * @param winner The player who won the game.
     */
    private void determineWinner(Player winner) {
        // Implement logic to handle the winner
        // For example, update scores, record the game result, etc.
    }

    /**
     * Retrieves the current player's hand.
     * 
     * @param playerId The ID of the player.
     * @return The list of cards in the player's hand.
     */
    public List<Card> getPlayerHand(Long playerId) {
        Player player = playerRepository.findById(playerId).orElse(null);
        return player != null ? player.getHand() : new ArrayList<>();
    }

    /**
     * Retrieves the current turn player.
     * 
     * @return The player whose turn it is to play.
     */
    public Player getCurrentTurn() {
        return currentTurn;
    }
}