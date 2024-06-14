package com.example.tttundostarter;

import com.example.tttundostarter.controllers.GameController;
import com.example.tttundostarter.models.Game;
import com.example.tttundostarter.models.GameState;
import com.example.tttundostarter.models.Player;
import com.example.tttundostarter.models.Symbol;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

//@SpringBootApplication
public class TttUndoStarterApplication {

    public static void main(String[] args) throws Exception {
//        SpringApplication.run(TttUndoStarterApplication.class, args);

        GameController gameController = new GameController();
        int dimension = 3;
        List<Player> players = new ArrayList<>();
        players.add(new Player("Player1", new Symbol('X')));
        players.add(new Player("Player2", new Symbol('O')));

        Game game = gameController.startGame(dimension, players);
        //gameController.displayBoard(game);

        while (gameController.getGameState(game).equals(GameState.IN_PROGRESS)) {
            gameController.displayBoard(game);

            gameController.makeMove(game);
        }

        if (gameController.getGameState(game).equals(GameState.DRAW)) {
            //Game DRAW
            System.out.println("Game has DRAWN");
        } else {
            gameController.displayBoard(game);
            System.out.println("Winner is : " + gameController.getWinner(game).getName());
        }
    }

}
