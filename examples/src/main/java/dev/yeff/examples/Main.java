package dev.yeff.examples;

import dev.yeff.examples.scenes.MainScene;
import dev.yeff.orbital.Scene;
import dev.yeff.orbital.Window;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Scene> scenes = new ArrayList<>();
        scenes.add(new MainScene());

        Window window = new Window("Hello World", 400, 400, scenes);
        //window.useScene(0);
        window.run();
    }
}
