package com.task5.storage;

import com.task5.model.Game;
import com.task5.model.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static com.task5.model.GameStatus.NEW;

public class GameStorage {

    private static Map<String, Game> games;
    private static GameStorage instance;

        private GameStorage() {
            games = new HashMap<>();
        }

        public static synchronized GameStorage getInstance() {
            if (instance == null) {
                instance = new GameStorage();
                Game game = new Game();
                game.setBoard(new int[3][3]);
                game.setGameId(UUID.randomUUID().toString());
                Player player = new Player();
                player.setLogin("kolya");
                game.setPlayer1(player);
                game.setStatus(NEW);
                GameStorage.getInstance().setGame(game);
            }
            return instance;
        }


        public Map<String, Game> getGames() {
            return games;
        }

        public void setGame(Game game) {
            games.put(game.getGameId(), game);
        }

        private void installGames(){
            Game game = new Game();
            game.setBoard(new int[3][3]);
            game.setGameId(UUID.randomUUID().toString());
            Player player = new Player();
            player.setLogin("kolya");
            game.setPlayer1(player);
            game.setStatus(NEW);
            GameStorage.getInstance().setGame(game);
        }
    }