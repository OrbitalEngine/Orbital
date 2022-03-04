package dev.yeff.orbital;

public class Game {
    private boolean isRunning;
    private static final float UPDATE_CAP = 1.0f / 60.0f;

    public void start() {
        isRunning = true;
        run();
    }


    public void run() {
        float lastTime = Time.getTime();
        float lag = 0.0f;

        while (true) {
            float current = Time.getTime();
            float elapsed = current - lastTime;
            lastTime = current;
            lag += elapsed;

            while (lag >= UPDATE_CAP) {
                lag -= UPDATE_CAP;

                System.out.println(UPDATE_CAP / lag);
            }
        }
    }
}
