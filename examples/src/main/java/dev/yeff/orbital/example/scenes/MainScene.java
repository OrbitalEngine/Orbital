package dev.yeff.orbital.example.scenes;

import dev.yeff.orbital.Game;
import dev.yeff.orbital.io.Input;
import dev.yeff.orbital.scenes.Scene;
import dev.yeff.orbital.scenes.SceneManager;

import java.awt.event.KeyEvent;

public class MainScene implements Scene {
    @Override
    public void init(Game game) {
        System.out.println("initialized scene");
    }

    @Override
    public void update(Game game, float deltaTime) {
        Input input = game.getInput();

        if (input.getKeyboard().isKeyDown(KeyEvent.VK_A)) {
            game.loadScene("Other");
        }
    }
}
