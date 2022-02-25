package dev.yeff.examples;

import dev.yeff.examples.scenes.MainScene;
import dev.yeff.examples.scenes.TriangleScene;
import dev.yeff.orbital.Scene;
import dev.yeff.orbital.Window;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Scene> scenes = new ArrayList<>();
        Window window = new Window("Hello World", 400, 400, scenes);

        scenes.add(new MainScene());
        scenes.add(new TriangleScene());

        window.useScene(0);
        window.run();
    }
}
