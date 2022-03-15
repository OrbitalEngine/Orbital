package dev.yeff.orbital.graphics;

import dev.yeff.orbital.Game;

import static com.raylib.Jaylib.RAYWHITE;
import static com.raylib.Raylib.*;

public class Window {
    private int height, width;
    private String title;
    private Game game;
    private Renderer renderer;


    public Window(Game game) {
        this.game = game;
        this.width = game.getWidth();
        this.height = game.getHeight();
        this.title = game.getTitle();
        this.renderer = game.getRenderer();
    }

    public void start() {
        SetConfigFlags(FLAG_WINDOW_RESIZABLE);
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

        game.getCurrentScene().dispose(game);
        CloseWindow();
    }
}
