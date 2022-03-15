package dev.yeff.scenes;

import dev.yeff.orbital.Game;
import dev.yeff.orbital.io.Input;
import dev.yeff.orbital.scenes.Scene;
import com.raylib.Raylib.Texture;

import static com.raylib.Jaylib.BLACK;
import static com.raylib.Jaylib.RED;
import static com.raylib.Raylib.*;


public class MainScene implements Scene {
    private Texture tex;

    @Override
    public void init(Game game) {
        System.out.println("main scene initialized");

        // forgive me, gods of programming
        tex = LoadTexture("C:\\Users\\aditc\\dev\\Orbital\\examples\\src\\main\\resources\\fastj_icon.png");
    }

    @Override
    public void update(Game game, float fps) {
        game.getRenderer().drawTexture(tex, new Vector2().x(GetScreenWidth() / 3).y(GetScreenHeight() / 4));
        game.getRenderer().drawRect(RED, new Vector2().x(50).y(80), 70);
        game.getRenderer().drawCircle(RED, new Vector2().x(80).y(350), 70);
        game.getRenderer().drawLine(new Vector2().x(18).y(42), new Vector2().x(game.getWidth() - 18).y(42), BLACK);
    }
}
