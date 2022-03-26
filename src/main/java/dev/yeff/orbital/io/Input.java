package dev.yeff.orbital.io;

/**
 * Stores all types of input classes.
 *
 * @author YeffyCodeGit
 * @version 0.0.1
 */
public class Input {
    // Disable constructor
    private Input() { }

    private static Keyboard keyboard = new Keyboard();
    private static Mouse mouse = new Mouse();

    /**
     * Gets the stored keyboard instance.
     *
     * @return The keyboard instance.
     */
    public static Keyboard getKeyboard() { return keyboard; }


    /**
     * Gets the stored mouse instance.
     *
     * @return The mouse instance.
     */
    public static Mouse getMouse() { return mouse; }
}
