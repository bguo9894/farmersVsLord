# Farmers vs Lord (斗地主 WebApp) 🃏🌐

Welcome to Farmers vs Lord, a web-based version of the popular Chinese card game 斗地主 (Dou Di Zhu)! This project is a full-stack application built with React on the front-end and Java (Spring Boot) on the back-end.

## Table of Contents

- [Farmers vs Lord (斗地主 WebApp) 🃏🌐](#farmers-vs-lord-斗地主-webapp-)
  - [Table of Contents](#table-of-contents)
  - [Features](#features)
  - [Installation](#installation)
    - [Prerequisites](#prerequisites)
    - [Clone the repository](#clone-the-repository)
    - [Back-end setup](#back-end-setup)
    - [Front-end setup](#front-end-setup)
  - [Usage](#usage)
  - [Project Structure](#project-structure)
  - [Contributing](#contributing)
  - [License](#license)
  - [Contact](#contact)

## Features

- **Multiplayer:** Play against other players online.
- **Real-time updates:** Live card updates using WebSockets.
- **User-friendly interface:** Interactive and responsive UI with React.
- **Game logic:** Comprehensive game rules and logic implemented in Java.

## Installation

### Prerequisites

- [Node.js](https://nodejs.org/) (v14 or higher)
- [Java JDK](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) (v11 or higher)
- [Maven](https://maven.apache.org/install.html)
- [Git](https://git-scm.com/)

### Clone the repository

```bash
git clone https://github.com/your_username/farmersVsLord.git
cd farmersVsLord
```

### Back-end setup

1. Navigate to the `backend` directory:

    ```bash
    cd backend
    ```

2. Build the project using Maven:

    ```bash
    mvn clean install
    ```

3. Run the Spring Boot application:

    ```bash
    mvn spring-boot:run
    ```

The back-end server should now be running on `http://localhost:8080`.

### Front-end setup

1. Navigate to the `frontend` directory:

    ```bash
    cd ../frontend
    ```

2. Install the required npm packages:

    ```bash
    npm install
    ```

3. Start the React development server:

    ```bash
    npm start
    ```

The front-end should now be running on `http://localhost:3000`.

## Usage

Once both the back-end and front-end servers are running, you can open your web browser and go to `http://localhost:3000` to start playing the game.

## Project Structure

```plaintext
farmersVsLord/
├── backend/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/
│   │   │   │       └── game/
│   │   │   │           ├── model/
│   │   │   │           │   ├── Card.java
│   │   │   │           │   ├── Player.java
│   │   │   │           │   ├── Game.java
│   │   │   │           ├── service/
│   │   │   │           │   ├── GameService.java
│   │   │   │           ├── controller/
│   │   │   │           │   └── GameController.java
│   │   └── resources/
│   │       └── application.properties
│   └── pom.xml
├── frontend/
│   ├── public/
│   └── src/
│       ├── components/
│       │   ├── Board.js
│       │   ├── Card.js
│       │   ├── Player.js
│       │   └── App.js
│       ├── App.css
│       ├── index.js
│       └── setupProxy.js
└── package.json
```

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.

## Contact

For any inquiries or feedback, please contact:

- **Name:** Your Name
- **Email:** your.email@example.com

---
