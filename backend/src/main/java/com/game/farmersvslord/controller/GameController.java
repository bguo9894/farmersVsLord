package com.game.farmersvslord.controller;

import com.game.farmersvslord.model.Card;
import com.game.farmersvslord.model.Game;
import com.game.farmersvslord.model.Player;
import com.game.farmersvslord.service.GameService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for handling game-related requests.
 */
@RestController
@RequestMapping("/game")
public class GameController {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    /**
     * Starts a new game with the provided player names.
     * 
     * @param playerNames List of player names.
     * @return The created Game object.
     */
    @PostMapping("/start")
    public Game startNewGame(@RequestBody List<String> playerNames) {
        return gameService.startNewGame(playerNames);
    }

    /**
     * Allows a player to play a set of cards.
     * 
     * @param playerId    The ID of the player.
     * @param playedCards The list of cards the player wants to play.
     * @return true if the move was successful, false otherwise.
     */
    @PostMapping("/play/{playerId}")
    public boolean playCards(@PathVariable Long playerId, @RequestBody List<Card> playedCards) {
        return gameService.playCards(playerId, playedCards);
    }

    /**
     * Retrieves the list of players in the game.
     * 
     * @return List of players.
     */
    @GetMapping("/players")
    public List<Player> getPlayers() {
        return gameService.getPlayers();
    }

    /**
     * Retrieves the bottom cards for the game.
     * 
     * @return List of bottom cards.
     */
    @GetMapping("/bottom-cards")
    public List<Card> getBottomCards() {
        return gameService.getBottomCards();
    }

    /**
     * Retrieves the hand of a specific player.
     * 
     * @param playerId The ID of the player.
     * @return List of cards in the player's hand.
     */
    @GetMapping("/player-hand/{playerId}")
    public List<Card> getPlayerHand(@PathVariable Long playerId) {
        return gameService.getPlayerHand(playerId);
    }

    /**
     * Retrieves the player whose turn it is to play.
     * 
     * @return The player whose turn it is.
     */
    @GetMapping("/current-turn")
    public Player getCurrentTurn() {
        return gameService.getCurrentTurn();
    }
}