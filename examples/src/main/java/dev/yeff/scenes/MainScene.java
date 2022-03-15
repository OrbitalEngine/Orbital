package dev.yeff.scenes;

import dev.yeff.orbital.Game;
import dev.yeff.orbital.resources.ResourceManager;
import dev.yeff.orbital.resources.Sprite;
import dev.yeff.orbital.scenes.Scene;

import static com.raylib.Jaylib.BLACK;
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
        fastj = ResourceManager.getSprite("C:\\Users\\aditc\\dev\\Orbital\\examples\\src\\main\\resources\\fastj_icon.png");

        game.getRenderer().drawTexture(fastj, new Vector2().x(GetScreenWidth() / 3).y(GetScreenHeight() / 4));
        game.getRenderer().drawRect(RED, new Vector2().x(50).y(80), 70);
        game.getRenderer().drawCircle(RED, new Vector2().x(80).y(350), 70);
        game.getRenderer().drawLine(new Vector2().x(18).y(42), new Vector2().x(game.getWidth() - 18).y(42), BLACK);
    }
}
