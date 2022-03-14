package dev.yeff.orbital.io;

import dev.yeff.orbital.Game;

import static com.raylib.Jaylib.RAYWHITE;
import static com.raylib.Raylib.*;

public class Window {
    private int height, width;
    private String title;
    private Game game;


    public Window(Game game) {
        this.game = game;
        this.width = game.getWidth();
        this.height = game.getHeight();
        this.title = game.getTitle();
    }

    public void start() {
        InitWindow(width, height, title);
        SetTargetFPS(60);

        game.getCurrentScene().init(game);

        update();
    }

    private void update() {
        while (!WindowShouldClose()) {
            BeginDrawing();

            ClearBackground(RAYWHITE);
            game.getCurrentScene().update(game, GetFPS());

            EndDrawing();
        }

        CloseWindow();
    }
}
