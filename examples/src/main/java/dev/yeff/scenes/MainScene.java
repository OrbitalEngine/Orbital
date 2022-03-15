package dev.yeff.scenes;

import dev.yeff.orbital.Game;
import dev.yeff.orbital.io.Input;
import dev.yeff.orbital.resources.ResourceManager;
import dev.yeff.orbital.resources.Sprite;
import dev.yeff.orbital.scenes.Scene;

import static com.raylib.Jaylib.BLACK;
import static com.raylib.Jaylib.RED;
import static com.raylib.Raylib.*;


public class MainScene implements Scene {
    private Vector2 pos;

    @Override
    public void init(Game game) {
        System.out.println("main scene initialized");

        pos = new Vector2().x(game.getWidth() / 2).y(game.getHeight() / 2);
    }

    @Override
    public void update(Game game, float fps) {
        if (Input.getKeyboard().isKeyDown(KEY_W)) pos.y(pos.y() - 5);
        if (Input.getKeyboard().isKeyDown(KEY_S)) pos.y(pos.y() + 5);
        if (Input.getKeyboard().isKeyDown(KEY_A)) pos.x(pos.x() - 5);
        if (Input.getKeyboard().isKeyDown(KEY_D)) pos.x(pos.x() + 5);

        game.getRenderer().drawCircle(RED, pos, 60);
    }
}
