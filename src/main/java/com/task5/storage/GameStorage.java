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
            }
            return instance;
        }


        public Map<String, Game> getGames() {
            return games;
        }

        public void setGame(Game game) {
            games.put(game.getGameId(), game);
        }

    }