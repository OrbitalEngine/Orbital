package dev.yeff.orbital.io;

/**
 * Stores all types of input classes.
 *
 * @author YeffyCodeGit
 */
public class Input {
    // Disable constructor
    private Input() { }

    private static final Keyboard keyboard = new Keyboard();
    private static final Mouse mouse = new Mouse();

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
