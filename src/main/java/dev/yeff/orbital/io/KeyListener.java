package dev.yeff.orbital.io;

import static org.lwjgl.glfw.GLFW.GLFW_PRESS;
import static org.lwjgl.glfw.GLFW.GLFW_RELEASE;

/**
 * Class storing keyboard input callbacks and functions to receive input from the keyboard.
 *
 * @author YeffyCodeGit
 * @version 0.0.1
 */
public class KeyListener {
    private static KeyListener instance;
    private boolean keyPressed[] = new boolean[350];

    private KeyListener() {}

    /**
     * Returns the single instance of the class.
     *
     * @return The KeyListener instance.
     */
    public static KeyListener getInstance() {
        if (KeyListener.instance == null)
            KeyListener.instance = new KeyListener();

        return KeyListener.instance;
    }

    /**
     * Callback for OpenGL to get keyboard input.
     *
     * @param window The window pointer.
     * @param key The key pressed.
     * @param scancode The scan code.
     * @param action The action, like press or release.
     * @param mods The modifier keys.
     */
    public static void keyCallback(long window, int key, int scancode, int action, int mods) {
        if (action == GLFW_PRESS)
            getInstance().keyPressed[key] = true;
        else if (action == GLFW_RELEASE)
            getInstance().keyPressed[key] = false;
    }

    /**
     * Checks if a key on the keyboard is held down.
     *
     * @param keyCode The key to check.
     * @return If the key is held down or not.
     */
    public static boolean isKeyDown(int keyCode) {
        return getInstance().keyPressed[keyCode];
    }
}
