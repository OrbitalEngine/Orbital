package dev.yeff.orbital.util;

/**
 * Utility class to get useful time-based data.
 *
 * @author YeffyCodeGit
 * @version 0.0.1
 */
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
