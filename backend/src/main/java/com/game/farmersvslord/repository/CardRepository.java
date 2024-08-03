package com.game.farmersvslord.repository;

import com.game.farmersvslord.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for Card entity.
 * Extends JpaRepository to provide CRUD operations.
 */
public interface CardRepository extends JpaRepository<Card, Long> {
}