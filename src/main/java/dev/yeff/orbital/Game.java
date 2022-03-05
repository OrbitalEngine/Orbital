package dev.yeff.orbital;

import dev.yeff.orbital.graphics.Window;
import dev.yeff.orbital.io.KeyboardInput;
import dev.yeff.orbital.io.MouseInput;
import dev.yeff.orbital.util.Time;

import java.awt.*;
import java.awt.event.MouseEvent;

public class Game {
    private boolean isRunning;
    private static float UPDATE_CAP = 0;
    private float width, height;
    private String title;

    private KeyboardInput keyListener;
    private MouseInput mouseListener;
    private Window window;

    public Game(float updateCap, float width, float height, String title) {
        UPDATE_CAP = 1.0f / updateCap;
        this.width = width;
        this.height = height;
        this.title = title;
    }

    public void start() {
        window = new Window(width, height, title);
        keyListener = new KeyboardInput();
        mouseListener = new MouseInput();

        window.getCanvas().addKeyListener(keyListener);
        window.getCanvas().addMouseListener(mouseListener);

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

            if (mouseListener.isButtonDown(MouseEvent.BUTTON1)) {
                System.out.println("left clicked");
            } else if (mouseListener.isButtonDown(MouseEvent.BUTTON3)) {
                System.out.println("right clicked");
            } else if (mouseListener.isButtonDown(MouseEvent.BUTTON2)) {
                System.out.println("middle clicked");
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
