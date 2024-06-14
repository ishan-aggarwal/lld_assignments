package com.example.tttundostarter.controllers;

import com.example.tttundostarter.exceptions.EmptyMovesException;
import com.example.tttundostarter.exceptions.InvalidMoveException;
import com.example.tttundostarter.models.Game;
import com.example.tttundostarter.models.GameState;
import com.example.tttundostarter.models.Player;

import java.util.List;

public class GameController {
    public Game startGame(int dimension, List<Player> players) throws Exception {
        return Game.getBuilder()
                .setDimension(dimension)
                .setPlayers(players)
                .build();
    }

    public void makeMove(Game game) throws InvalidMoveException {
        game.makeMove();
    }

    public void displayBoard(Game game) {
        game.displayBoard(game.getBoard());
    }

    public Player getWinner(Game game) {
        return game.getWinner();
    }

    public void undo(Game game) throws EmptyMovesException {
        game.undo();
    }

    public GameState getGameState(Game game) {
        return game.getGameState();
    }
}
