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
    private Sprite sprite;

    @Override
    public void init(Game game) {
        System.out.println("main scene initialized");

        // forgive me, gods of programming
        pos = new Vector2().x(GetScreenWidth() / 3).y(GetScreenHeight() / 4);
        sprite = ResourceManager.getSprite("C:\\Users\\aditc\\dev\\Orbital\\examples\\src\\main\\resources\\fastj_icon.png");
    }

    @Override
    public void update(Game game, float fps) {
        sprite.resize(new Vector2().x(450).y(300));
        game.getRenderer().drawTexture(sprite, pos);
    }

    @Override
    public void dispose(Game game) {

    }
}
