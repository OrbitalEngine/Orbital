package dev.yeff;

import dev.yeff.orbital.Game;
import dev.yeff.orbital.scenes.Scene;
import dev.yeff.scenes.MainScene;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        var scenes = new HashMap<String, Scene>() {{
            put("Main", new MainScene());
        }};
        
        Game game = new Game(975, 900, "Hello", scenes);
        game.start("Main");
    }
}
