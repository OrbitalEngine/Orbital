package dev.yeff.examples;

import dev.yeff.examples.scenes.MainScene;
import dev.yeff.orbital.Window;

public class Main {
    public static void main(String[] args) {
        Window window = new Window("Hello World", 400, 400, new MainScene());

        window.run();
    }
}
