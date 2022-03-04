package dev.yeff.orbital.example;

import dev.yeff.orbital.Game;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(60.0f, 300.0f, 300.0f, "Hello, World!");
        game.start();
    }
}
