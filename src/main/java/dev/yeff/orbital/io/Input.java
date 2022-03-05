package dev.yeff.orbital.io;

public class Input {
    private static KeyboardInput keyboard = new KeyboardInput();
    private static MouseInput mouse = new MouseInput();

    public static KeyboardInput getKeyboard() {
        return keyboard;
    }

    public static MouseInput getMouse() {
        return mouse;
    }
}
