package dev.yeff.orbital.io;

import lombok.Getter;

/**
 * Stores all types of input classes.
 *
 * @author YeffyCodeGit
 */
public class Input {
    // Disable constructor
    private Input() { }

    @Getter
    private static final Keyboard keyboard = new Keyboard();

    @Getter
    private static final Mouse mouse = new Mouse();
}
