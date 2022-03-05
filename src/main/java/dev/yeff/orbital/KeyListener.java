package dev.yeff.orbital;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class KeyListener extends KeyAdapter {
    private boolean[] keys = new boolean[350];


    @Override
    public void keyPressed(KeyEvent e) {
//        System.out.println(e.getKeyChar() + " pressed");
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
//        System.out.println(e.getKeyChar() + " released");
        keys[e.getKeyCode()] = false;
    }

    public boolean isKeyDown(int keycode) {
        return keys[keycode];
    }
}
