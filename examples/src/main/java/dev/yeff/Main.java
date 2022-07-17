package dev.yeff;

import dev.yeff.orbital.Game;
import dev.yeff.orbital.math.Vector2f;
import dev.yeff.orbital.scenes.Scene;
import dev.yeff.scenes.CollisionScene;
import dev.yeff.scenes.MainScene;
import dev.yeff.scenes.MenuScene;
import dev.yeff.scenes.TestScene;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Scene> scenes = Map.of(
                "Main", new MainScene(),
                "Collision", new CollisionScene(),
                "Menu", new MenuScene(),
                "Test", new TestScene()
        );

        Game game = new Game(new Vector2f(975, 900), "Hello", scenes, false, 60.0f);
        game.start("Test");
    }
}
