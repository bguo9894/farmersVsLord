import React, { useState } from 'react';
import '../styles/tailwind.css';

interface CardProps {
  rank: string;
  suit: string;
  style?: React.CSSProperties; // Optional style property for custom styling
}

/**
 * Card component to display a single playing card.
 * @param {CardProps} props - Properties containing rank and suit of the card.
 * @returns {JSX.Element} The JSX code to display a card.
 */
const Card: React.FC<CardProps> = ({ rank, suit, style }) => {
  const [isSelected, setIsSelected] = useState(false); // Track if the card is selected
  const isRedSuit = suit === '♥' || suit === '♦'; // Determine if the suit should be red
  const isJoker = rank === 'JOKER'; // Check if the card is a Joker
  const cardColor = isJoker
    ? suit === '大'
      ? 'text-red-500' // Big Joker with red text
      : 'text-black' // Small Joker with black text
    : isRedSuit
    ? 'text-red-500' // Red suits have red text
    : 'text-black'; // Black suits have black text

  // Handle card click event to toggle selection
  const handleCardClick = () => {
    setIsSelected(!isSelected);
  };

  return (
    <div
      className={`card w-20 h-28 rounded-lg border-2 bg-white flex flex-col justify-between p-1 ${cardColor} ${isSelected ? 'transform -translate-y-4' : ''} transition-transform duration-200 relative`}
      style={style}
      onClick={handleCardClick}
      // The main card container. It uses Tailwind CSS classes for size, border, background color, and text color.
    >
      {isJoker ? (
        <>
          {/* Display for Joker cards */}
          <div className="absolute top-1 left-1 flex flex-col items-center leading-none z-10">
            <span>J</span>
            <span>O</span>
            <span>K</span>
            <span>E</span>
            <span>R</span>
          </div>
          <div className="absolute bottom-1 right-1 flex flex-col items-center transform rotate-180 leading-none z-10">
            <span>J</span>
            <span>O</span>
            <span>K</span>
            <span>E</span>
            <span>R</span>
          </div>
        </>
      ) : (
        <>
          {/* Display for standard cards */}
          <div className="absolute top-1 left-1 leading-none z-10">
            <div className="card-rank text-lg">{rank}</div>
            <div className="card-suit text-xl">{suit}</div>
          </div>
          <div className="absolute bottom-1 right-1 transform rotate-180 leading-none z-10">
            <div className="card-rank text-lg">{rank}</div>
            <div className="card-suit text-xl">{suit}</div>
          </div>
        </>
      )}
    </div>
  );
};

export default Card;