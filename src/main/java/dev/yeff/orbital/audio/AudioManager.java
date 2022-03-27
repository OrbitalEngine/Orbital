package dev.yeff.orbital.audio;

import dev.yeff.orbital.resources.AudioClip;
import dev.yeff.orbital.resources.Music;

import static com.raylib.Raylib.*;

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

    /**
     * Pauses a currently playing audio clip.
     *
     * @param audio The clip to pause.
     */
    public static void pauseAudioClip(AudioClip audio) {
        if (audio.isClipPlaying())
            PauseSound(audio.asRaylibSound());
        else
            throw new IllegalStateException("Audio clip is not playing, cannot pause.");
    }

    /**
     * Resumes a paused audio clip.
     *
     * @param audio The audio clip to resume.
     */
    public static void resumeAudioClip(AudioClip audio) {
        ResumeSound(audio.asRaylibSound());
    }

    /**
     * Plays a given music stream.
     *
     * @param music The music to play.
     */
    public static void playMusic(Music music) {
        PlayMusicStream(music.asRaylibMusic());
    }

    /**
     * Pauses a currently playing music stream.
     *
     * @param music The music to pause.
     */
    public static void pauseMusic(Music music) {
        if (music.isMusicPlaying())
            PauseMusicStream(music.asRaylibMusic());
        else
            throw new IllegalStateException("Audio clip is not playing, cannot pause.");
    }

    /**
     * Resumes a paused music stream.
     *
     * @param music The music to resume.
     */
    public static void resumeMusic(Music music) {
        ResumeMusicStream(music.asRaylibMusic());
    }
}
