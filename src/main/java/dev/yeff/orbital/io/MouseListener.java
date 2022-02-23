package dev.yeff.orbital.io;

import static org.lwjgl.glfw.GLFW.GLFW_PRESS;
import static org.lwjgl.glfw.GLFW.GLFW_RELEASE;

/**
 * Class storing mouse input callbacks and functions to receive input and other data from the mouse.
 *
 * @author YeffyCodeGit
 * @version 0.0.1
 */
public class MouseListener {
    public static MouseListener instance;
    private double scrollX, scrollY;
    private double xPos, yPos, lastY, lastX;
    private boolean mouseButtonPressed[] = new boolean[3];
    private boolean isDragging;

    private MouseListener() {
        this.scrollX = 0.0;
        this.scrollY = 0.0;
        this.xPos = 0.0;
        this.yPos = 0.0;
        this.lastX = 0.0;
        this.lastY = 0.0;
    }

    /**
     * Returns the single instance of the class.
     *
     * @return The MouseListener instance.
     */
    public static MouseListener getInstance() {
        if (MouseListener.instance == null)
            instance = new MouseListener();

        return MouseListener.instance;
    }

    /**
     * Callback for OpenGL to get the mouse position.
     *
     * @param window The window pointer.
     * @param xPos The x position of the mouse.
     * @param yPos The y position of the mouse.
     */
    public static void mousePosCallback(long window, double xPos, double yPos) {
        getInstance().lastX = getInstance().xPos;
        getInstance().lastY = getInstance().yPos;

        getInstance().xPos = xPos;
        getInstance().yPos = yPos;

        getInstance().isDragging = getInstance().mouseButtonPressed[0]
                            || getInstance().mouseButtonPressed[1]
                            || getInstance().mouseButtonPressed[2];
    }

    /**
     * Callback for OpenGL to get if a mouse button was pressed.
     *
     * @param window The window pointer.
     * @param button The mouse button.
     * @param action The action, like press or release.
     * @param mods The modifier keys.
     */
    public static void mouseButtonCallback(long window, int button, int action, int mods) {
        if (action == GLFW_PRESS) {
            if (button < getInstance().mouseButtonPressed.length)
                getInstance().mouseButtonPressed[button] = true;
        } else if (action == GLFW_RELEASE) {
            if (button < getInstance().mouseButtonPressed.length) {
                getInstance().mouseButtonPressed[button] = false;
                getInstance().isDragging = false;
            }
        }
    }

    /**
     * Callback for OpenGL to get the mouse scroll position.
     *
     * @param window The window pointer.
     * @param xOffset The x scroll position.
     * @param yOffset The y scroll position.
     */
    public static void mouseScrollCallback(long window, double xOffset, double yOffset) {
        getInstance().scrollX = xOffset;
        getInstance().scrollY = yOffset;
    }

    /**
     * Resets all the values.
     */
    public static void endFrame() {
        getInstance().scrollX = 0;
        getInstance().scrollY = 0;
        getInstance().lastX = getInstance().xPos;
        getInstance().lastY = getInstance().yPos;
    }

    /**
     * Gets the x position of the mouse.
     *
     * @return The x position of the mouse.
     */
    public static float getX() {
        return (float) getInstance().xPos;
    }

    /**
     * Gets the y position of the mouse.
     *
     * @return The y position of the mouse.
     */
    public static float getY() {
        return (float) getInstance().yPos;
    }

    /**
     * Gets the last x position of the mouse.
     *
     * @return The last x position of the mouse.
     */
    public static float getDx() {
        return (float) (getInstance().lastX - getInstance().xPos);
    }

    /**
     * Gets the last y position of the mouse.
     *
     * @return The last y position of the mouse.
     */
    public static float getDy() {
        return (float) (getInstance().lastY - getInstance().yPos);
    }

    /**
     * Gets the x scroll position of the mouse.
     *
     * @return The x scroll position of the mouse.
     */
    public static float getScrollX() {
        return (float) getInstance().scrollX;
    }

    /**
     * Gets the y scroll position of the mouse.
     *
     * @return The y scroll position of the mouse.
     */
    public static float getScrollY() {
        return (float) getInstance().scrollY;
    }

    /**
     * Gets if the mouse is dragging or not.
     *
     * @return If the mouse is dragging or not.
     */
    public static boolean isDragging() {
        return getInstance().isDragging;
    }

    /**
     * Checks if a mouse button is held down.
     *
     * @param button The mouse button.
     * @return If the mouse button is held down.
     */
    public static boolean mouseButtonDown(int button) {
        if (button < getInstance().mouseButtonPressed.length)
            return getInstance().mouseButtonPressed[button];
        else
            return false;
    }
}
