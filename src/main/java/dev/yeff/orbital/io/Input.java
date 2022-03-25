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

    public static Keyboard getKeyboard() { return keyboard; }
    public static Mouse getMouse() { return mouse; }
}
