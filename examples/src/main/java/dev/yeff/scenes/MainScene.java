package dev.yeff.scenes;

import dev.yeff.orbital.Game;
import dev.yeff.orbital.io.Input;
import dev.yeff.orbital.scenes.Scene;
import com.raylib.Raylib.Texture;

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
        System.out.println(String.format("X: %s, Y: %s", Input.getMouse().getMousePos().x(), Input.getMouse().getMousePos().y()));

        game.getRenderer().drawTexture(tex, new Vector2().x(GetScreenWidth() / 3).y(GetScreenHeight() / 4));
    }
}
