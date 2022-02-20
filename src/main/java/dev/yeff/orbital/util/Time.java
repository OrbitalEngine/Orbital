package dev.yeff.orbital.util;

public class Time {
    public static float startTime = System.nanoTime();

    /**
    Returns the time elapsed since the application started.

    @return The time elapsed
     */
    public static float getTime() {
        // 1E-9 is 0.000000001 in decimal, or simply, 1 nanosecond

        return (float) ((System.nanoTime() - startTime) * 1E-9);
    }
}
