package dev.yeff.orbital.graphics;

import lombok.Getter;

public class Gradient {
    @Getter
    private Color startingColor;
    @Getter
    private Color endingColor;

    public Gradient(Color startingColor, Color endingColor) {
        this.startingColor = startingColor;
        this.endingColor = endingColor;
    }
}
