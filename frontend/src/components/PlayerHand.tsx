import React from 'react';
import Card from './Card';
import '../styles/tailwind.css';

interface PlayerHandProps {
  cards: Array<{ rank: string; suit: string }>; // Array of card objects with rank and suit.
}

/**
 * PlayerHand component to display a player's hand of cards.
 * @param {PlayerHandProps} props - Properties containing an array of card objects.
 * @returns {JSX.Element} The JSX code to display the player's hand of cards.
 */
const PlayerHand: React.FC<PlayerHandProps> = ({ cards }) => {
  return (
    <div
      className="player-hand flex justify-center items-center absolute bottom-8 left-1/2 transform -translate-x-1/2 overflow-visible"
      // Set overflow to visible to ensure selected cards are not cut off
    >
      {cards.map((card, index) => (
        <div
          key={index}
          style={{
            marginLeft: index > 0 ? '-1.5rem' : '0', // Overlap cards slightly
            zIndex: index, // Ensure the cards on the right are on top
          }}
        >
          <Card rank={card.rank} suit={card.suit} />
        </div>
      ))}
    </div>
  );
};

export default PlayerHand;