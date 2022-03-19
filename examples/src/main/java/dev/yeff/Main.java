package dev.yeff;

import dev.yeff.orbital.Game;
import dev.yeff.orbital.resources.Sprite;
import dev.yeff.orbital.scenes.Scene;
import dev.yeff.scenes.MainScene;
import dev.yeff.scenes.OtherScene;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Scene> scenes = Map.of(
                "Main", new MainScene(),
                "Other", new OtherScene()
        );

        Game game = new Game(975, 900, "Hello", scenes);
        game.start("Main");
    }
}
