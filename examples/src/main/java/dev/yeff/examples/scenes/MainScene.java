package dev.yeff.examples.scenes;

import dev.yeff.orbital.Scene;
import dev.yeff.orbital.Window;
import dev.yeff.orbital.io.KeyListener;
import dev.yeff.orbital.renderer.GameObject;
import dev.yeff.orbital.renderer.Renderer;
import dev.yeff.orbital.resources.ResourceManager;
import dev.yeff.orbital.resources.Shader;
import dev.yeff.orbital.resources.Texture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL13.GL_TEXTURE0;
import static org.lwjgl.opengl.GL13.glActiveTexture;

public class MainScene implements Scene {
    private static Logger LOGGER = LoggerFactory.getLogger(MainScene.class);

    private Shader shader;
    private Texture texture;
    private GameObject object;
    private Renderer renderer;

    private float[] vertexArray = {
            // vertices                // colors                    // UV Coordinates
            0.5f, -0.5f,  0.0f,        1.0f, 0.0f, 0.0f, 1.0f,      1, 1, // bottom right
            -0.5f, 0.5f,  0.0f,        0.0f, 1.0f, 0.0f, 1.0f,      0, 0, // top left
            0.5f,  0.5f,  0.0f,        0.0f, 0.0f, 1.0f, 1.0f,      1, 0, // top right
            -0.5f, -0.5f, 0.0f,        1.0f, 1.0f, 1.0f, 1.0f,      0, 1, // top left
    };


    // IMPORTANT: Must be in counter-clockwise order
    private int[] elementArray = {
            2, 1, 0,
            0, 1, 3
    };


    @Override
    public void init(Window window) {
        LOGGER.info("initialized");

        // Get renderer from the window
        renderer = window.getRenderer();

        // Get the shader resource
        shader = ResourceManager.getShader("examples/src/assets/shaders/default.glsl");

        // Get the texture resource
        texture = ResourceManager.getTexture("examples/src/assets/textures/testImage.jpg", 0);

        // Create the object
        object = new GameObject(vertexArray, elementArray, shader);
        object.create();
    }

    @Override
    public void update(Window window, float delta) {
        if (KeyListener.isKeyDown(GLFW_KEY_ESCAPE))
            System.exit(0);

        if (KeyListener.isKeyDown(GLFW_KEY_W))
            window.useScene(1);

        shader.uploadTexture("TEX_SAMPLER", 0);

        renderer.renderGameObject(object);
    }

    @Override
    public void dispose(Window window) {
        object.dispose();
        shader.detach();
    }
}