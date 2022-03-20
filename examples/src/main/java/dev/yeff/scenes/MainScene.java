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

import static com.raylib.Raylib.*;

public class MainScene implements Scene {
    private Vector2 pos;
    private Vector2f test;
    private Sprite sprite;

    @Override
    public void init(Game game) {
        Log.info(MainScene.class, "main scene initialized");

        // forgive me, gods of programming
        pos = new Vector2().x(game.getWidth() / 2).y(game.getHeight() / 2);
        test = new Vector2f(5, 5);

        Log.info(MainScene.class, String.format("X: %s, Y: %s", test.getX(), test.getY()));

        test.add(new Vector2f(5, 5));

        Log.info(MainScene.class, String.format("X: %s, Y: %s", test.getX(), test.getY()));

        test.subtract(new Vector2f(5, 5));

        Log.info(MainScene.class, String.format("X: %s, Y: %s", test.getX(), test.getY()));

        test.multiply(new Vector2f(2, 2));

        Log.info(MainScene.class, String.format("X: %s, Y: %s", test.getX(), test.getY()));

        test.divide(new Vector2f(2, 2));

        Log.info(MainScene.class, String.format("X: %s, Y: %s", test.getX(), test.getY()));

        test.zero();

        Log.info(MainScene.class, String.format("X: %s, Y: %s", test.getX(), test.getY()));

        sprite = ResourceManager.getSprite("C:\\Users\\aditc\\dev\\Orbital\\examples\\src\\main\\resources\\Orbital.png");
    }

    @Override
    public void update(Game game, float fps) {
//        if (Input.getKeyboard().isKeyDown(Keys.W)) pos.y(pos.y() - 5);
//        if (Input.getKeyboard().isKeyDown(Keys.S)) pos.y(pos.y() + 5);
//        if (Input.getKeyboard().isKeyDown(Keys.A)) pos.x(pos.x() - 5);
//        if (Input.getKeyboard().isKeyDown(Keys.D)) pos.x(pos.x() + 5);
//
//
//        sprite.resize(new Vector2().x(300).y(300));
//        game.getRenderer().drawTexture(sprite, pos);

        game.getRenderer().drawCircle(Colors.RED, pos, 60.0f);
    }

    @Override
    public void dispose(Game game) {
        Log.info(MainScene.class, "disposed main scene");
    }
}
