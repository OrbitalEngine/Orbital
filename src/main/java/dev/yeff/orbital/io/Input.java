package dev.yeff.orbital.io;

public class Input {
    private static Keyboard keyboard = new Keyboard();
    private static Mouse mouse = new Mouse();

    public static Keyboard getKeyboard() { return keyboard; }
    public static Mouse getMouse() { return mouse; }
}
