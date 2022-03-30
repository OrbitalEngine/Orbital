package dev.yeff.orbital.audio;

import dev.yeff.orbital.resources.AudioClip;
import dev.yeff.orbital.resources.Music;
import dev.yeff.orbital.util.Log;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static com.raylib.Raylib.*;

/**
 * Manages everything related to audio, like playing and pausing audio, controlling volume and more.
 *
 * @author YeffyCodeGit
 * @version 0.0.1
 */
public class AudioManager {
    @Getter
    private List<Music> musicStreams;

    public AudioManager() {
        musicStreams = new ArrayList<>();
    }

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

    /**
     * Updates the music stream; should be called every frame.
     *
     * @param music The music stream to update.
     */
    public void updateMusic(Music music) {
        UpdateMusicStream(music.asRaylibMusic());
    }

    /**
     * Adds a music stream to the audio manager to update later.
     *
     * @param music The music stream to add.
     */
    public void addMusicStream(Music music) {
        musicStreams.add(music);
    }

    /**
     * Removes a music stream from the audio manager.
     *
     * @param music The music stream to remove.
     */
    public void removeMusicStream(Music music) {
        IntStream.range(0, musicStreams.size())
                .filter(i -> musicStreams.get(i).getPath() == music.getPath())
                .findFirst()
                .ifPresent(i -> musicStreams.remove(i));
    }

    /**
     * Updates all the stored music streams.
     */
    public void updateMusicStreams() {
        musicStreams.forEach(this::updateMusic);
    }
}
