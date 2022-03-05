package dev.yeff.orbital.example;

import dev.yeff.orbital.Game;
import dev.yeff.orbital.example.scenes.MainScene;
import dev.yeff.orbital.example.scenes.OtherScene;
import dev.yeff.orbital.scenes.Scene;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Scene> scenes = new HashMap<String, Scene>() {{
            put("Main", new MainScene());
            put("Other", new OtherScene());
        }};

        Game game = new Game(60.0f, 300.0f, 250.0f, "Hello, World!", scenes);
        game.start("Main");
    }
}
