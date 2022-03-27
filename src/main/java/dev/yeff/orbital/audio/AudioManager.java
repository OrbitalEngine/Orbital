package dev.yeff.orbital.audio;

import dev.yeff.orbital.resources.AudioClip;

import static com.raylib.Raylib.PlaySound;
import static com.raylib.Raylib.SetMasterVolume;

/**
 * Manages everything related to audio, like playing and pausing audio, controlling volume and more.
 *
 * @author YeffyCodeGit
 * @version 0.0.1
 */
public class AudioManager {
    /**
     * Sets the master volume to play the audio at.
     *
     * @param volume The new volume.
     */
    public static void setVolume(float volume) {
        SetMasterVolume(volume);
    }

    /**
     * Plays a given audio clip.
     *
     * @param audio The clip to play.
     */
    public static void playAudioClip(AudioClip audio) {
        PlaySound(audio.asRaylibSound());
    }
}
