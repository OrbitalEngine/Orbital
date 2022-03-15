package dev.yeff.scenes;

import dev.yeff.orbital.Game;
import dev.yeff.orbital.resources.ResourceManager;
import dev.yeff.orbital.resources.Sprite;
import dev.yeff.orbital.scenes.Scene;

import static com.raylib.Jaylib.RED;
import static com.raylib.Raylib.*;

public class MainScene implements Scene {
    private Sprite fastj;

    @Override
    public void init(Game game) {
        System.out.println("main scene initialized");

        // forgive me, gods of programming
        fastj = ResourceManager.getSprite("C:\\Users\\aditc\\dev\\Orbital\\examples\\src\\main\\resources\\fastj_icon.png");
    }

    @Override
    public void update(Game game, float fps) {
        game.getRenderer().drawTexture(fastj, new Vector2().x(GetScreenWidth() / 3).y(GetScreenHeight() / 4));
    }

    @Override
    public void dispose(Game game) {
        ResourceManager.disposeSprite("C:\\Users\\aditc\\dev\\Orbital\\examples\\src\\main\\resources\\fastj_icon.png");
    }
}