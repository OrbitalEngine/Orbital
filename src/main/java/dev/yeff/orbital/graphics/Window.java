package dev.yeff.orbital.graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Window {
    private JFrame frame;
    private BufferedImage image;
    private Canvas canvas;
    private BufferStrategy bs;
    private Graphics2D g2D;
    private float width, height;

    private final int SCALE = 4;

    public Window(float width, float height, String title) {
        this.width = width;
        this.height = height;

        image = new BufferedImage((int) width, (int) height, BufferedImage.TYPE_INT_RGB);
        canvas = new Canvas();

        Dimension size = new Dimension((int) (width * SCALE), (int) (height * SCALE));
        canvas.setPreferredSize(size);
        canvas.setMaximumSize(size);
        canvas.setMinimumSize(size);

        frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setPreferredSize(size);
        frame.add(canvas, BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        canvas.createBufferStrategy(2);
        bs = canvas.getBufferStrategy();
        g2D = (Graphics2D) bs.getDrawGraphics();
    }

    public void update() {
        g2D.drawImage(image, 0, 0, (int) (width * SCALE), (int) (height * SCALE), null);
        bs.show();
    }

    public Canvas getCanvas() { return canvas; }
}
