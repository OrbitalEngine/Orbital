package dev.yeff.orbital.resources;

import com.raylib.Raylib;

import static com.raylib.Raylib.LoadSound;

/**
 * Represents any audio clip, to be used by the audio manager.
 *
 * @author YeffyCodeGit
 * @version 0.0.1
 */
public class AudioClip {
    private Raylib.Sound sound;

    public AudioClip(String path) {
        sound = LoadSound(path);
    }

    /**
     * Returns the raylib version of the audio clip. This function is mainly meant to be used internally by the engine.
     *
     * @return The raylib version of the audio clip.
     */
    public Raylib.Sound asRaylibSound() {
        return sound;
    }
}
