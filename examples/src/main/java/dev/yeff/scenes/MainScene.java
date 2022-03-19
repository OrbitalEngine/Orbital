package dev.yeff.scenes;

import dev.yeff.orbital.Game;
import dev.yeff.orbital.graphics.Colors;
import dev.yeff.orbital.io.Input;
import dev.yeff.orbital.io.Keys;
import dev.yeff.orbital.resources.ResourceManager;
import dev.yeff.orbital.resources.Sprite;
import dev.yeff.orbital.scenes.Scene;

import static com.raylib.Jaylib.RED;
import static com.raylib.Raylib.*;

public class MainScene implements Scene {
    private Vector2 pos;

    @Override
    public void init(Game game) {
        System.out.println("main scene initialized");

        // forgive me, gods of programming
        pos = new Vector2().x(GetScreenWidth() / 3).y(GetScreenHeight() / 4);
    }

    @Override
    public void update(Game game, float fps) {
//        if (Input.getKeyboard().isKeyDown(Keys.W)) pos.y(pos.y() - 5);
//        if (Input.getKeyboard().isKeyDown(Keys.S)) pos.y(pos.y() + 5);
//        if (Input.getKeyboard().isKeyDown(Keys.A)) pos.x(pos.x() - 5);
//        if (Input.getKeyboard().isKeyDown(Keys.D)) pos.x(pos.x() + 5);
//
//        game.getRenderer().drawCircle(Colors.LIME_GREEN, pos, 50.0f);

        Input.getKeyboard().onKeyPressed(Keys.W, (key) -> System.out.println(key));
    }

    @Override
    public void dispose(Game game) {

    }
}
