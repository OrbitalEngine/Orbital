package dev.yeff.orbital.resources;

import com.raylib.Raylib;

import static com.raylib.Raylib.*;

/**
 * Represents a large streamed audio file, to be used by the audio manager.
 *
 * @author YeffyCodeGit
 * @version 0.0.1
 */
public class Music {
    private Raylib.Music rawMusic;

    public Music(String path) {
        rawMusic = LoadMusicStream(path);
    }

    /**
     * Returns a boolean if the music is playing or not.
     *
     * @return If the music is playing or not.
     */
    public boolean isMusicPlaying() {
        return IsMusicStreamPlaying(rawMusic);
    }

    /**
     * Returns the raylib version of the music stream. This function is mainly meant to be used internally by the engine.
     *
     * @return The raylib version of the music stream.
     */
    public Raylib.Music asRaylibMusic() {
        return rawMusic;
    }

    /**
     * Unloads the music stream from memory.
     */
    public void dispose() {
        UnloadMusicStream(rawMusic);
    }
}
