package dev.yeff.orbital.graphics;

import dev.yeff.orbital.Game;
import dev.yeff.orbital.audio.AudioManager;
import dev.yeff.orbital.ecs.Component;
import dev.yeff.orbital.ecs.GameObject;
import dev.yeff.orbital.ecs.components.RenderShapeComponent;
import dev.yeff.orbital.ecs.components.TransformComponent;
import dev.yeff.orbital.io.Keys;
import dev.yeff.orbital.math.Vector2f;
import dev.yeff.orbital.resources.AudioClip;
import dev.yeff.orbital.util.Log;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.raylib.Raylib.*;

/**
 * Class which manages the window, game loop, and updates scenes.
 *
 * @author YeffyCodeGit
 * @version 0.0.1
 */
public class Window {
    private Vector2f size;
    private String title;
    private Game game;


    public Window(Game game) {
        this.game = game;
        this.size = game.getSize();
        this.title = game.getTitle();

        Log.info(Window.class, "Created window with width " + size.x + ", height " + size.y);
    }

    /**
     *  Starts window, configures it, and initializes the scene.
     */
    public void start() {
        InitAudioDevice();
        SetConfigFlags(FLAG_WINDOW_RESIZABLE);

        // Disables the logs from raylib, so I can implement my own logging system
        SetTraceLogLevel(LOG_NONE);
        SetExitKey(KEY_ESCAPE);
        InitWindow((int) size.x, (int) size.y, title);
        SetTargetFPS(60);

        game.getCurrentScene().initInternal(game);
        game.getCurrentScene().init(game);

        update();
    }

    /**
     * Runs the game loop and updates the scene. This function also disposes the scene after game loop ends.
     */
    private void update() {
        List<GameObject> renderObjects = new ArrayList<>();

        while (!WindowShouldClose()) {
            BeginDrawing();

            Renderer.fillBackground(Colors.WHITE);
            AudioManager.updateMusicStreams();

            game.getCurrentScene().update(game, GetFPS());

            for (GameObject obj : game.getCurrentScene().getObjects()) {
                obj.update(game);

                if (obj.hasComponent(TransformComponent.class) && (obj.hasComponent(RenderShapeComponent.class)))
                    renderObjects.add(obj);
            }

            Renderer.updateRenderObjects(renderObjects);
            Renderer.performRenders();

            EndDrawing();
        }

        game.getCurrentScene().dispose(game);
        Log.info(Window.class, "Closing window..");

        CloseWindow();
        CloseAudioDevice();
    }
}
