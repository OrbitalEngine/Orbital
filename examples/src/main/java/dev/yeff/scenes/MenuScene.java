package dev.yeff.scenes;

import dev.yeff.orbital.Game;
import dev.yeff.orbital.io.Input;
import dev.yeff.orbital.io.Keys;
import dev.yeff.orbital.scenes.Scene;

public class MenuScene implements Scene {
    @Override
    public void init(Game game) {
        System.out.println("menu scene initialized");
    }

    @Override
    public void update(Game game, float fps) {
        if (Input.getKeyboard().isKeyDown(Keys.SPACE))
            game.loadScene("Main");

        game.getRenderer().drawString("This is a Orbital demo, \npress Spacebar to go to the actual 'game'.", 50.0f, game.getScreenCenter());
    }

    @Override
    public void dispose(Game game) {
        System.out.println("menu scene disposed");
    }
}
