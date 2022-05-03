package dev.yeff.orbital.resources;


import dev.yeff.orbital.audio.AudioManager;

import java.io.File;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

/**
 * Stores all types of resources during runtime, and lets users add and dispose resources.
 *
 * @author YeffyCodeGit
 */
@SuppressWarnings("ConstantConditions")
public class ResourceManager {
    // Disable constructor
    private ResourceManager() { }

    private static final Map<String, Sprite> SPRITES = new HashMap<>();
    private static final Map<String, Font> FONTS = new HashMap<>();
    private static final Map<String, AudioClip> AUDIO_CLIPS = new HashMap<>();
    private static final Map<String, Music> MUSIC_STREAMS = new HashMap<>();


    // SPRITES


    /**
     * Gets a sprite if stored in the resource manager, otherwise adds it to the resource manager and returns it.
     *
     * @param path The path of the sprite.
     * @throws IllegalStateException If there was an error loading the sprite.
     * @return The sprite resource.
     */
    public static <T> Sprite getSprite(Class<T> klass, String path) {
        File file;

        try {
            file = new File(klass.getClassLoader().getResource(path).toURI());
        } catch (URISyntaxException e) {
            throw new IllegalStateException(e.toString());
        }

        if (file.exists()) {
            if (!SPRITES.containsKey(file.getAbsolutePath())) {
                SPRITES.put(file.getAbsolutePath(), new Sprite(file.getAbsolutePath()));
            }

            return SPRITES.get(file.getAbsolutePath());
        } else {
            throw new IllegalStateException("Sprite does not exist at location '" + file.getAbsolutePath() + "'");
        }
    }

    /**
     * Removes the sprite from the resource manager.
     *
     * @param sprite The sprite.
     */
    public static void disposeSprite(Sprite sprite) {
        File file = new File(sprite.getPath());

        if (SPRITES.containsKey(file.getAbsolutePath())) {
            //noinspection SuspiciousMethodCalls
            SPRITES.remove(sprite);

            sprite.dispose();
        } else {
            throw new IllegalStateException("Sprite is not loaded in resource manager, cannot dispose.");
        }
    }

    /**
     * Checks if a sprite exists in the resource manager.
     *
     * @param sprite The sprite.
     * @return If the sprite exists in the resource manager.
     */
    public static boolean spriteExists(Sprite sprite) {
        File file = new File(sprite.getPath());

        return SPRITES.containsKey(file.getAbsolutePath());
    }


    // FONTS


    /**
     * Gets a font if stored in the resource manager, otherwise adds it to the resource manager and returns it.
     *
     * @param path The path of the font file.
     * @throws IllegalStateException If there was an error loading the sprite.
     * @return The font resource.
     */
    public static <T> Font getFont(Class<T> klass, String path) {
        File file;

        try {
            file = new File(klass.getClassLoader().getResource(path).toURI());
        } catch (URISyntaxException e) {
            throw new IllegalStateException(e.toString());
        }

        if (file.exists()) {
            if (!FONTS.containsKey(file.getAbsolutePath())) {
                FONTS.put(file.getAbsolutePath(), new Font(file.getAbsolutePath()));
            }

            return FONTS.get(file.getAbsolutePath());
        } else {
            throw new IllegalStateException("Font does not exist at location '" + file.getAbsolutePath() + "'");
        }
    }

    /**
     * Removes the font from the resource manager.
     *
     * @param font The font.
     */
    public static void disposeFont(Font font) {
        File file = new File(font.getPath());

        if (FONTS.containsKey(file.getAbsolutePath())) {
            //noinspection SuspiciousMethodCalls
            FONTS.remove(font);

            font.dispose();
        } else {
            throw new IllegalStateException("Font is not loaded in resource manager, cannot dispose.");
        }
    }

    /**
     * Checks if a font exists in the resource manager.
     *
     * @param font The font.
     * @return If the font exists in the resource manager.
     */
    public static boolean fontExists(Font font) {
        File file = new File(font.getPath());

        return FONTS.containsKey(file.getAbsolutePath());
    }


    // AUDIO CLIPS


    /**
     * Gets an audio clip if stored in the resource manager, otherwise adds it to the resource manager and returns it.
     *
     * @param path The path of the audio file.
     * @throws IllegalStateException If there was an error loading the sprite.
     * @return The audio clip.
     */
    public static <T> AudioClip getAudioClip(Class<T> klass, String path) {
        File file;

        try {
            file = new File(klass.getClassLoader().getResource(path).toURI());
        } catch (URISyntaxException e) {
            throw new IllegalStateException(e.toString());
        }

        if (file.exists()) {
            if (!AUDIO_CLIPS.containsKey(file.getAbsolutePath())) {
                AUDIO_CLIPS.put(file.getAbsolutePath(), new AudioClip(file.getAbsolutePath()));
            }

            return AUDIO_CLIPS.get(file.getAbsolutePath());
        } else {
            throw new IllegalStateException("Audio clip does not exist at location '" + file.getAbsolutePath() + "'");
        }
    }

    /**
     * Removes the audio clip from the resource manager.
     *
     * @param clip The audio clip.
     */
    public static void disposeAudioClip(AudioClip clip) {
        File file = new File(clip.getPath());

        if (AUDIO_CLIPS.containsKey(file.getAbsolutePath())) {
            //noinspection SuspiciousMethodCalls
            AUDIO_CLIPS.remove(clip);

            clip.dispose();
        } else {
            throw new IllegalStateException("Audio clip is not loaded in resource manager, cannot dispose.");
        }
    }

    /**
     * Checks if an audio clip exists in the resource manager.
     *
     * @param clip The audio clip.
     * @return If the audio clip exists in the resource manager.
     */
    public static boolean audioClipExists(AudioClip clip) {
        File file = new File(clip.getPath());

        return AUDIO_CLIPS.containsKey(file.getAbsolutePath());
    }


    // MUSIC


    /**
     * Gets a music resource if stored in the resource manager, otherwise adds it to the resource manager and returns it.
     *
     * @param path The path of the music file.
     * @throws IllegalStateException If there was an error loading the sprite.
     * @return The music object.
     */
    public static <T> Music getMusicStream(Class<T> klass, String path) {
        File file;

        try {
            file = new File(klass.getClassLoader().getResource(path).toURI());
        } catch (URISyntaxException e) {
            throw new IllegalStateException(e.toString());
        }

        if (file.exists()) {
            if (!MUSIC_STREAMS.containsKey(file.getAbsolutePath())) {
                Music m = new Music(file.getAbsolutePath());

                MUSIC_STREAMS.put(file.getAbsolutePath(), m);
                AudioManager.addMusicStream(m);
            }

            AudioManager.addMusicStream(MUSIC_STREAMS.get(file.getAbsolutePath()));
            return MUSIC_STREAMS.get(file.getAbsolutePath());
        } else {
            throw new IllegalStateException("Music file does not exist at location '" + file.getAbsolutePath() + "'");
        }
    }

    /**
     * Removes the music resource from the resource manager.
     *
     * @param music The music stream.
     */
    public static void disposeMusicStream(Music music) {
        File file = new File(music.getPath());

        if (MUSIC_STREAMS.containsKey(file.getAbsolutePath())) {
            //noinspection SuspiciousMethodCalls
            MUSIC_STREAMS.remove(music);

            AudioManager.removeMusicStream(music);
            music.dispose();
        } else {
            throw new IllegalStateException("Audio clip is not loaded in resource manager, cannot dispose.");
        }
    }

    /**
     * Checks if a music resource exists in the resource manager.
     *
     * @param music The music stream.
     * @return If the music resource exists in the resource manager.
     */
    public static boolean musicStreamExists(Music music) {
        File file = new File(music.getPath());

        return MUSIC_STREAMS.containsKey(file.getAbsolutePath());
    }
}
