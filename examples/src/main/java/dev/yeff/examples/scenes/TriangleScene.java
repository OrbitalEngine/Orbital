package dev.yeff.examples.scenes;

import dev.yeff.orbital.ResourceManager;
import dev.yeff.orbital.Scene;
import dev.yeff.orbital.Window;
import dev.yeff.orbital.io.KeyListener;
import dev.yeff.orbital.renderer.GameObject;
import dev.yeff.orbital.renderer.Renderer;
import dev.yeff.orbital.renderer.Shader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.lwjgl.glfw.GLFW.GLFW_KEY_W;

public class TriangleScene implements Scene {
    private static Logger LOGGER = LoggerFactory.getLogger(MainScene.class);

    private Shader shader;
    private GameObject object;
    private Renderer renderer;

    private float[] vertexArray = {
            // vertices                // colors
            0.5f, -0.5f,  0.0f,        1.0f, 0.0f, 0.0f, 1.0f, // bottom right
            -0.5f, 0.5f,  0.0f,        1.0f, 0.0f, 0.0f, 1.0f, // top left
            0.5f,  0.5f,  0.0f,        1.0f, 0.0f, 0.0f, 1.0f, // top right
    };


    // IMPORTANT: Must be in counter-clockwise order
    private int[] elementArray = {
            0, 1, 2
    };

    @Override
    public void init(Window window) {
        renderer = window.getRenderer();

        // Get the shader resource
        shader = ResourceManager.getShader("examples/src/assets/shaders/default.glsl");

        object = new GameObject(vertexArray, elementArray, shader);
        object.create();
    }

    @Override
    public void update(Window window, float delta) {
        renderer.renderGameObject(object);

        if (KeyListener.isKeyDown(GLFW_KEY_W))
            window.useScene(0);
    }

    @Override
    public void dispose(Window window) {
        object.dispose();
        shader.detach();
    }
}
