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
    public AudioManager() { }

    /**
     * Sets the master volume to play the audio at.
     *
     * @param volume The new volume.
     */
    public void setVolume(float volume) {
        SetMasterVolume(volume);
    }

    /**
     * Plays a given audio clip.
     *
     * @param audio The clip to play.
     */
    public void playAudioClip(AudioClip audio) {
        PlaySound(audio.asRaylibSound());
    }

    /**
     * Pauses a currently playing audio clip.
     *
     * @param audio The clip to pause.
     */
    public void pauseAudioClip(AudioClip audio) {
        if (audio.isPlaying())
            PauseSound(audio.asRaylibSound());
        else
            throw new IllegalStateException("Audio clip is not playing, cannot pause.");
    }

    /**
     * Resumes a paused audio clip.
     *
     * @param audio The audio clip to resume.
     */
    public void resumeAudioClip(AudioClip audio) {
        ResumeSound(audio.asRaylibSound());
    }

    /**
     * Plays a given music stream.
     *
     * @param music The music to play.
     */
    public void playMusic(Music music) {
        PlayMusicStream(music.asRaylibMusic());
    }

    /**
     * Pauses a currently playing music stream.
     *
     * @param music The music to pause.
     */
    public void pauseMusic(Music music) {
        if (music.isPlaying())
            PauseMusicStream(music.asRaylibMusic());
        else
            throw new IllegalStateException("Audio clip is not playing, cannot pause.");
    }

    /**
     * Resumes a paused music stream.
     *
     * @param music The music to resume.
     */
    public void resumeMusic(Music music) {
        ResumeMusicStream(music.asRaylibMusic());
    }
}
