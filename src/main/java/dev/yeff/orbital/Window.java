package dev.yeff.orbital;

import dev.yeff.orbital.io.KeyListener;
import dev.yeff.orbital.io.MouseListener;
import dev.yeff.orbital.util.Time;
import org.lwjgl.opengl.GL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

import static org.lwjgl.glfw.Callbacks.glfwFreeCallbacks;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.NULL;

/**
 * The main class used to create a game using the Orbital Game Engine.
 *
 * @author YeffyCodeGit
 * @version 0.0.1
 */
public class Window {
    private String title;
    private int width, height;

    // GLFW window pointer
    private long glfwWindow;

    private static Logger LOGGER = LoggerFactory.getLogger(Window.class);

    private ArrayList<Scene> scenes;
    private Scene currentScene;

    public Window(String title, int width, int height, ArrayList<Scene> scenes) {
        this.title = title;
        this.width = width;
        this.height = height;
        this.scenes = scenes;

        this.currentScene = scenes.get(0);
    }

    /**
     * Creates the window, starts the game loop and runs the current scene being used.
     */
    public void run() {
        init();
        update();

        // Free the window callbacks and destroy the window
        glfwFreeCallbacks(glfwWindow);
        glfwDestroyWindow(glfwWindow);

        // Terminate GLFW and free the error callback
        glfwTerminate();
    }

    /**
     * Initializes OpenGL, GLFW, registers the input callbacks and initializes the current scene being used.
     */
    private void init() {
        // Initialize GLFW
        if (!glfwInit())
            throw new IllegalStateException("Unable to initialize GLFW");

        // Configure GLFW
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);
        glfwWindowHint(GLFW_MAXIMIZED, GLFW_TRUE);

        // Create the window
        glfwWindow = glfwCreateWindow(this.width, this.height, this.title, NULL, NULL);

        if (glfwWindow == NULL)
            throw new IllegalStateException("Unable to create GLFW window");

        // Mouse Callbacks
        glfwSetCursorPosCallback(glfwWindow, MouseListener::mousePosCallback);
        glfwSetMouseButtonCallback(glfwWindow, MouseListener::mouseButtonCallback);
        glfwSetScrollCallback(glfwWindow, MouseListener::mouseScrollCallback);

        // Keyboard Callbacks
        glfwSetKeyCallback(glfwWindow, KeyListener::keyCallback);

        // Make OpenGL context current and enable VSync
        glfwMakeContextCurrent(glfwWindow);
        glfwSwapInterval(1);

        glfwShowWindow(glfwWindow);

        // This line is critical for LWJGL's interoperation with GLFW's
        // OpenGL context, or any context that is managed externally.
        // LWJGL detects the context that is current in the current thread,
        // creates the GLCapabilities instance and makes the OpenGL
        // bindings available for use.
        GL.createCapabilities();

        // Run the provided scene
        currentScene.init(this);
    }

    /**
     * Runs the game loop and updates the current scene being used.
     */
    private void update() {
        float beginTime = Time.getTime();
        float endTime;
        float dt = 0;

        setBackground(1.0f, 1.0f, 1.0f, 1.0f);

        while (!glfwWindowShouldClose(glfwWindow)) {
            glfwPollEvents();

            glClear(GL_COLOR_BUFFER_BIT);

            if (dt >= 0)
                currentScene.update(this, dt);

            glfwSwapBuffers(glfwWindow);

            // Record the current time
            endTime = Time.getTime();

            // Subtract the current time by the begin time, to get the time it took to run the game loop
            dt = endTime - beginTime;
            beginTime = endTime;

        }
    }

    /**
     * Sets the background color of the window.
     *
     * @param r The red value.
     * @param g The green value.
     * @param b The blue value.
     * @param a The alpha value.
     */
    public void setBackground(float r, float g, float b, float a) {
        glClearColor(r, g, b, a);
    }

//    public void useScene(int sceneIndex) {
//        if (sceneIndex <= scenes.size()) {
//            currentScene = scenes.get(sceneIndex);
//            currentScene.init(this);
//        }
//        else {
//            throw new IndexOutOfBoundsException("No scene found at that index.");
//        }
//    }
}