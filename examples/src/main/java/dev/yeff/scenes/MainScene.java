package dev.yeff.scenes;

import dev.yeff.orbital.Game;
import dev.yeff.orbital.graphics.Colors;
import dev.yeff.orbital.io.Input;
import dev.yeff.orbital.io.Keys;
import dev.yeff.orbital.math.Vector2f;
import dev.yeff.orbital.resources.ResourceManager;
import dev.yeff.orbital.resources.Sprite;
import dev.yeff.orbital.scenes.Scene;
import dev.yeff.orbital.util.Log;
import dev.yeff.orbital.math.Math;

import static com.raylib.Raylib.*;

public class MainScene implements Scene {
    private Vector2f pos;
    private Vector2f test;

    @Override
    public void init(Game game) {
        Log.info(MainScene.class, "main scene initialized");

        test = new Vector2f(2, 2);
        Math.dot(test, new Vector2f(2, 2));


        pos = new Vector2f(game.getWidth() / 2, game.getHeight() / 2);
    }

    @Override
    public void update(Game game, float fps) {
        game.getRenderer().fillBackground(Colors.BROWN);

        if (Input.getKeyboard().isKeyDown(Keys.W)) pos.y -= 5;
        if (Input.getKeyboard().isKeyDown(Keys.S)) pos.y += 5;
        if (Input.getKeyboard().isKeyDown(Keys.A)) pos.x -= 5;
        if (Input.getKeyboard().isKeyDown(Keys.D)) pos.x += 5;

        game.getRenderer().drawRect(Colors.RED, pos, 50.0f);
    }

    @Override
    public void dispose(Game game) {
        Log.info(MainScene.class, "disposed main scene");
    }
}
