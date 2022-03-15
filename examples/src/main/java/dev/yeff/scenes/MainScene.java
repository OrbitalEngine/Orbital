package dev.yeff.scenes;

import com.raylib.Raylib;
import dev.yeff.orbital.Game;
import dev.yeff.orbital.io.Input;
import dev.yeff.orbital.scenes.Scene;
import com.raylib.Raylib.Texture;

import static com.raylib.Jaylib.RAYWHITE;
import static com.raylib.Jaylib.RED;
import static com.raylib.Raylib.*;


public class MainScene implements Scene {

    @Override
    public void init(Game game) {
        System.out.println("main scene initialized");
    }

    @Override
    public void update(Game game, float fps) {
        System.out.println(String.format("X: %s, Y: %s", Input.getMouse().getMousePos().x(), Input.getMouse().getMousePos().y()));

        DrawCircleV(Input.getMouse().getMousePos(), 40, RED);
    }
}
