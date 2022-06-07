package dev.yeff.orbital.resources;

import com.raylib.Raylib;
import dev.yeff.orbital.interfaces.Disposable;
import lombok.Getter;

import static com.raylib.Raylib.*;

/**
 * Represents a large streamed audio file, to be used by the audio manager. This class should be used for longer audio files. For smaller clips, use {@code AudioClip}.
 *
 * @author YeffyCodeGit
 */
public class Music implements Disposable {
    private Raylib.Music rawMusic;

    @Getter
    private String path;

    public Music(String path) {
        this.path = path;
        rawMusic = LoadMusicStream(path);
    }

    /**
     * Sets if music should loop or not.
     *
     * @param shouldLoop If it should loop or not.
     */
    public void loop(boolean shouldLoop) {
        rawMusic.looping(shouldLoop);
    }

    /**
     * Returns a boolean if the music is playing or not.
     *
     * @return If the music is playing or not.
     */
    public boolean isPlaying() {
        return IsMusicStreamPlaying(rawMusic);
    }

    /**
     * Makes the music loop infinitely.
     */
    public void loopMusic() {
        rawMusic.looping(true);
    }


    /**
     * Unloads the music stream from memory.
     */
    @Override
    public void dispose() {
        UnloadMusicStream(rawMusic);
    }
}
