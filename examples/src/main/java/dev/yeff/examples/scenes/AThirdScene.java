package dev.yeff.examples.scenes;

import dev.yeff.orbital.Scene;
import dev.yeff.orbital.Window;
import dev.yeff.orbital.io.KeyListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.lwjgl.glfw.GLFW.GLFW_KEY_A;

public class AThirdScene implements Scene {
    private static Logger LOGGER = LoggerFactory.getLogger(AThirdScene.class);

    @Override
    public void init(Window window) {
        LOGGER.info("initialized the third scene");
    }

    @Override
    public void update(Window window, float delta) {
        if (KeyListener.isKeyDown(GLFW_KEY_A)) {
            window.useScene(2);
        }
    }
}
