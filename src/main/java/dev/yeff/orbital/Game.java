package dev.yeff.orbital;

import dev.yeff.orbital.graphics.Window;
import dev.yeff.orbital.util.Time;

import javax.swing.*;

public class Game {
    private boolean isRunning;
    private static float UPDATE_CAP = 0;
    private float width, height;
    private String title;

    private Window window;

    public Game(float updateCap, float width, float height, String title) {
        UPDATE_CAP = 1.0f / updateCap;
        this.width = width;
        this.height = height;
    }

    public void start() {
        window = new Window(width, height, title);

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


            while (lag >= UPDATE_CAP) {
                lag -= UPDATE_CAP;

                window.update();


//                System.out.println("Frame Rate: " + 1 / elapsed);
//                System.out.println("FPS: " + UPDATE_CAP / lag);
            }
        }
    }

    public JFrame getFrame() {
        return window.getFrame();
    }
}
