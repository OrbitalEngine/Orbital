package dev.yeff.orbital.graphics;

import dev.yeff.orbital.Game;
import dev.yeff.orbital.util.Log;

import static com.raylib.Raylib.*;

/**
 * Class which manages the window, game loop, and updates scenes.
 *
 * @author YeffyCodeGit
 * @version 0.0.1
 */
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

        Log.info(Window.class, "Created window with width " + width + ", height " + height);
    }

    /**
     *  Starts window, configures it, and initializes the scene.
     */
    public void start() {
        SetConfigFlags(FLAG_WINDOW_RESIZABLE);

        // Disables the logs from raylib, so I can implement my own logging system
        SetTraceLogLevel(LOG_NONE);

        SetExitKey(KEY_ESCAPE);
        InitWindow(width, height, title);
        SetTargetFPS(60);

        game.getCurrentScene().init(game);

        update();
    }

    /**
     * Runs the game loop and updates the scene. This function also disposes the scene after game loop ends.
     */
    private void update() {
        while (!WindowShouldClose()) {
            BeginDrawing();

            renderer.fillBackground(Colors.WHITE);
            game.getCurrentScene().update(game, GetFPS());

            EndDrawing();
        }

        game.getCurrentScene().dispose(game);
        CloseWindow();
        Log.info(Window.class, "Closing window..");
    }
}
