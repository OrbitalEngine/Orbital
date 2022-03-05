package dev.yeff.orbital;

import dev.yeff.orbital.graphics.Window;
import dev.yeff.orbital.io.Input;
import dev.yeff.orbital.io.KeyboardInput;
import dev.yeff.orbital.io.MouseInput;
import dev.yeff.orbital.util.Time;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Game {
    private boolean isRunning;
    private static float UPDATE_CAP = 0;
    private float width, height;
    private String title;

    private Input input;
    private Window window;

    public Game(float updateCap, float width, float height, String title) {
        UPDATE_CAP = 1.0f / updateCap;
        this.width = width;
        this.height = height;
        this.title = title;
    }

    public void start() {
        window = new Window(width, height, title);

        window.getCanvas().addKeyListener(input.getKeyboard());
        window.getCanvas().addMouseListener(input.getMouse());

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

//            if (input.getMouse().isButtonDown(MouseEvent.BUTTON1)) {
//                System.out.println("left clicked");
//            } else if (input.getKeyboard().isKeyDown(KeyEvent.VK_A)) {
//                System.out.println("a was pressed");
//            }

            if (input.getMouse().isButtonDown(MouseEvent.BUTTON2)) {
                System.out.println("mouse button 2 was pressed");
            } else if (input.getKeyboard().isKeyDown(KeyEvent.VK_W)) {
                System.out.println("w key was pressed");
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

    public Input getInput() {
        return input;
    }
}
