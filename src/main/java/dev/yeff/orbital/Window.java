package dev.yeff.orbital;

import dev.yeff.orbital.io.KeyListener;
import dev.yeff.orbital.io.MouseListener;
import dev.yeff.orbital.util.Time;
import org.lwjgl.opengl.GL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.lwjgl.glfw.Callbacks.glfwFreeCallbacks;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.NULL;

public class Window {
    private String title;
    private Scene scene;
    private int width, height;

    // GLFW window pointer
    private long glfwWindow;

    private static Logger LOGGER = LoggerFactory.getLogger(Window.class);

    public Window(String title, int width, int height, Scene scene) {
        this.title = title;
        this.width = width;
        this.height = height;
        this.scene = scene;
    }

    public void run() {
        init();
        update();

        // Free the window callbacks and destroy the window
        glfwFreeCallbacks(glfwWindow);
        glfwDestroyWindow(glfwWindow);

        // Terminate GLFW and free the error callback
        glfwTerminate();
    }

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
        scene.init();
    }

    private void update() {
        float beginTime = Time.getTime();
        float endTime;

        setBackground(1.0f, 1.0f, 1.0f, 1.0f);

        while (!glfwWindowShouldClose(glfwWindow)) {
            glfwPollEvents();

            glClear(GL_COLOR_BUFFER_BIT);
            glfwSwapBuffers(glfwWindow);

            // Record the current time
            endTime = Time.getTime();

            // Subtract the current time by the begin time, to get the time it took to run the game loop
            float dt = endTime - beginTime;
            beginTime = endTime;

            scene.update(this, dt);
        }
    }

    public void setBackground(float r, float g, float b, float a) {
        glClearColor(r, g, b, a);
    }
}