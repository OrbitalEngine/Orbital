package dev.yeff.orbital;

public class Time {
    public static float startTime = System.nanoTime();

    public static float getTime() {
        return (float) (System.nanoTime() / 1000000000.0f);
    }
}
