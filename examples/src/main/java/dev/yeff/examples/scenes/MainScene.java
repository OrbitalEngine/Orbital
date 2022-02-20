package dev.yeff.examples.scenes;

import dev.yeff.orbital.Scene;
import dev.yeff.orbital.Window;
import dev.yeff.orbital.io.KeyListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.lwjgl.glfw.GLFW.*;

public class MainScene implements Scene {
    private static Logger LOGGER = LoggerFactory.getLogger(MainScene.class);

    private float r, g, b, a;
    private boolean fadeToBlack, fadeToRed;

    @Override
    public void init() {
        LOGGER.info("initialized");
        this.r = 0;
        this.g = 0;
        this.b = 0;
        this.a = 0;
    }

    @Override
    public void update(Window window, float delta) {
        if (KeyListener.isKeyDown(GLFW_KEY_ESCAPE))
            System.exit(0);

        if (KeyListener.isKeyDown(GLFW_KEY_W)) {
            fadeToBlack = true;
        } else if (KeyListener.isKeyDown(GLFW_KEY_S)) {
            fadeToRed = true;
        }

        if (fadeToBlack) {
            r = Math.max(r - 0.01f, 0);
            g = Math.max(g - 0.01f, 0);
            b = Math.max(b - 0.01f, 0);
            a = Math.max(a - 0.01f, 0);

            window.setBackground(r, g, b, a);

            LOGGER.info("Color({}, {}, {}, {})", r, g, b, a);
        } else if (fadeToRed) {
            r = Math.max(r - 0.01f, 1);
            g = Math.max(g - 0.01f, 0);
            b = Math.max(b - 0.01f, 0);
            a = Math.max(a - 0.01f, 0);

            window.setBackground(r, g, b, a);

            LOGGER.info("Color({}, {}, {}, {})", r, g, b, a);
        }

        //LOGGER.info("FPS: {}", 1 / delta);
    }
}
