import React from 'react';
import GameTable from './components/GameTable';
import './App.css';

/**
 * App component - The main component of the application.
 * This component renders the GameTable component.
 * @returns {JSX.Element} The JSX code to display the main application.
 */
const App: React.FC = () => {
  return (
    <div className="app">
      <GameTable />
    </div>
  );
};

export default App;