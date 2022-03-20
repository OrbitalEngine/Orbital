package dev.yeff;

import dev.yeff.orbital.Game;
import dev.yeff.orbital.scenes.Scene;
import dev.yeff.scenes.MainScene;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Scene> scenes = Map.of(
                "Main", new MainScene()
        );

        Game game = new Game(975, 900, "Hello", scenes);
        game.start("Main");
    }
}
