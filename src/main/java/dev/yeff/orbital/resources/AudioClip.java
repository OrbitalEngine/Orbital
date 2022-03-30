package dev.yeff.orbital.resources;

import com.raylib.Raylib;
import dev.yeff.orbital.interfaces.Disposable;
import lombok.Getter;

import static com.raylib.Raylib.*;

/**
 * Represents any audio clip, to be used by the audio manager.
 *
 * @author YeffyCodeGit
 * @version 0.0.1
 */
public class AudioClip implements Disposable {
    private Raylib.Sound sound;

    @Getter
    private String path;

    public AudioClip(String path) {
        this.path = path;
        sound = LoadSound(path);
    }

    /**
     * Returns a boolean if the audio clip is playing or not.
     *
     * @return If the audio clip is playing or not.
     */
    public boolean isPlaying() {
        return IsSoundPlaying(sound);
    }

    /**
     * Returns the raylib version of the audio clip. This function is mainly meant to be used internally by the engine.
     *
     * @return The raylib version of the audio clip.
     */
    public Raylib.Sound asRaylibSound() {
        return sound;
    }

    /**
     * Unloads the audio clip from memory.
     */
    @Override
    public void dispose() {
        UnloadSound(sound);
    }
}
