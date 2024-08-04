import React from 'react';
import PlayerHand from './PlayerHand';

const exampleCards = [
  { rank: '8', suit: '♠' }, { rank: '8', suit: '♣' }, { rank: '10', suit: '♥' }, 
  { rank: 'J', suit: '♠' }, { rank: 'Q', suit: '♦' }, { rank: 'K', suit: '♠' }, 
  { rank: 'A', suit: '♣' }, { rank: 'A', suit: '♦' }, { rank: 'K', suit: '♥' }, 
  { rank: 'JOKER', suit: '大' }, { rank: 'JOKER', suit: '小' },
  { rank: '2', suit: '♠' }, { rank: '3', suit: '♣' }, { rank: '4', suit: '♦' },
  { rank: '5', suit: '♠' }, { rank: '6', suit: '♣' }, { rank: '7', suit: '♦' }
];

/**
 * GameTable component to display the game table and player hands.
 * @returns {JSX.Element} The JSX code to display the game table.
 */
const GameTable = () => {
  return (
    <div className="game-table">
      {/* Other components like dealer hand, etc. */}
      <PlayerHand cards={exampleCards} />
    </div>
  );
};

export default GameTable;