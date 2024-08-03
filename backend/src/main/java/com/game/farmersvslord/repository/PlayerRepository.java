package com.game.farmersvslord.repository;

import com.game.farmersvslord.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for Player entity.
 * Extends JpaRepository to provide CRUD operations.
 */
public interface PlayerRepository extends JpaRepository<Player, Long> {
    /**
     * Find a player by their name.
     *
     * @param name The name of the player.
     * @return The player with the given name.
     */
    Player findByName(String name);
}