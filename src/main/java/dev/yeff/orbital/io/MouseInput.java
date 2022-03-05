package dev.yeff.orbital.io;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class MouseInput extends MouseAdapter {
    private boolean[] buttons = new boolean[4];

    @Override
    public void mouseClicked(MouseEvent e) {
        buttons[e.getButton()] = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        buttons[e.getButton()] = false;
    }
    
    public boolean isButtonDown(int buttonCode) {
        return buttons[buttonCode];
    }
}
