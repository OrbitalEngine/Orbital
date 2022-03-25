package dev.yeff.scenes;

import dev.yeff.orbital.Game;
import dev.yeff.orbital.io.Input;
import dev.yeff.orbital.io.Keys;
import dev.yeff.orbital.math.Vector2f;
import dev.yeff.orbital.resources.ResourceManager;
import dev.yeff.orbital.resources.TextFont;
import dev.yeff.orbital.scenes.Scene;

public class MenuScene implements Scene {
    private TextFont font;

    @Override
    public void init(Game game) {
        font = ResourceManager.getFont("C:\\Users\\aditc\\dev\\Orbital\\examples\\src\\main\\resources\\Roboto-Regular.ttf");

        System.out.println("menu scene initialized");
    }

    @Override
    public void update(Game game, float fps) {
        if (Input.getKeyboard().isKeyDown(Keys.SPACE))
            game.loadScene("Main");

        game.getRenderer().drawString(
                "This is a Orbital demo, \npress Spacebar to go to the actual 'game'.",
                60.0f,
                new Vector2f(game.getSize().x / 4, game.getSize().y / 3),
                font
        );
    }

    @Override
    public void dispose(Game game) {
        System.out.println("menu scene disposed");
    }
}
