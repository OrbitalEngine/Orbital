package dev.yeff.orbital;

import dev.yeff.orbital.graphics.Window;
import dev.yeff.orbital.util.Time;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Game {
    private boolean isRunning;
    private static float UPDATE_CAP = 0;
    private float width, height;
    private String title;

    private KeyListener listener;
    private Window window;

    public Game(float updateCap, float width, float height, String title) {
        UPDATE_CAP = 1.0f / updateCap;
        this.width = width;
        this.height = height;
        this.title = title;
    }

    public void start() {
        window = new Window(width, height, title);
        listener = new KeyListener();
        window.getCanvas().addKeyListener(listener);

        isRunning = true;
        run();
    }

    private void run() {
        float lastTime = Time.getTime();
        float lag = 0.0f;

        while (true) {
            float current = Time.getTime();
            float elapsed = current - lastTime;
            lastTime = current;
            lag += elapsed;

            if (listener.isKeyDown(KeyEvent.VK_W) == true) {
                System.out.println("up");
            } else if (listener.isKeyDown(KeyEvent.VK_S)) {
                System.out.println("down");
            }

            while (lag >= UPDATE_CAP) {
                lag -= UPDATE_CAP;

                window.update();
            }
        }
    }

    public Canvas getFrame() {
        return window.getCanvas();
    }
}
