package dev.yeff.orbital.audio;

import dev.yeff.orbital.resources.AudioClip;
import dev.yeff.orbital.resources.Music;
import dev.yeff.orbital.util.Log;
import dev.yeff.orbital.util.RaylibUtil;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static com.raylib.Raylib.*;
import static java.util.stream.IntStream.*;

/**
 * Manages everything related to audio, like playing and pausing audio, controlling volume and more.
 *
 * @author YeffyCodeGit
 */
public class AudioManager {
    @Getter
    private static final List<Music> musicStreams = new ArrayList<>();

    // Disable constructor
    private AudioManager() { }

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
        PlaySound(RaylibUtil.getAsRaylibSound(audio));
    }

    /**
     * Pauses a currently playing audio clip.
     *
     * @param audio The clip to pause.
     */
    public static void pauseAudioClip(AudioClip audio) {
        if (audio.isPlaying())
            PauseSound(RaylibUtil.getAsRaylibSound(audio));
        else
            throw new IllegalStateException("Audio clip is not playing, cannot pause.");
    }

    /**
     * Resumes a paused audio clip.
     *
     * @param audio The audio clip to resume.
     */
    public static void resumeAudioClip(AudioClip audio) {
        ResumeSound(RaylibUtil.getAsRaylibSound(audio));
    }

    /**
     * Plays a given music stream.
     *
     * @param music The music to play.
     */
    public static void playMusic(Music music) {
        PlayMusicStream(RaylibUtil.getAsRaylibMusic(music));
    }

    /**
     * Pauses a currently playing music stream.
     *
     * @param music The music to pause.
     */
    public static void pauseMusic(Music music) {
        if (music.isPlaying())
            PauseMusicStream(RaylibUtil.getAsRaylibMusic(music));
        else
            throw new IllegalStateException("Audio clip is not playing, cannot pause.");
    }

    /**
     * Resumes a paused music stream.
     *
     * @param music The music to resume.
     */
    public static void resumeMusic(Music music) {
        ResumeMusicStream(RaylibUtil.getAsRaylibMusic(music));
    }

    /**
     * Updates the music stream; should be called every frame.
     *
     * @param music The music stream to update.
     */
    public static void updateMusic(Music music) {
        UpdateMusicStream(RaylibUtil.getAsRaylibMusic(music));
    }

    /**
     * Adds a music stream to the audio manager to update later.
     *
     * @param music The music stream to add.
     */
    public static void addMusicStream(Music music) {
        musicStreams.add(music);
    }

    /**
     * Removes a music stream from the audio manager.
     *
     * @param music The music stream to remove.
     */
    public static void removeMusicStream(Music music) {
        //noinspection StringEquality
        musicStreams.removeIf(musicStream -> musicStream.getPath() == music.getPath());
    }

    /**
     * Updates all the stored music streams.
     */
    public static void updateMusicStreams() {
        musicStreams.forEach(AudioManager::updateMusic);
    }
}