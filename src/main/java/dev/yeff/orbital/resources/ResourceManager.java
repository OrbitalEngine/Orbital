package dev.yeff.orbital.resources;


import dev.yeff.orbital.audio.AudioManager;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Stores all types of resources during runtime, and lets users add and dispose resources.
 *
 * @author YeffyCodeGit
 * @version 0.0.1
 */
public class ResourceManager {
    // Disable constructor
    private ResourceManager() { }

    private static Map<String, Sprite> sprites = new HashMap<>();
    private static Map<String, Font> fonts = new HashMap<>();
    private static Map<String, AudioClip> audioClips = new HashMap<>();

    // SPRITES


    /**
     * Gets a sprite if stored in the resource manager, otherwise adds it to the resource manager and returns it.
     *
     * @param path The path of the sprite.
     * @return The sprite resource.
     */
    public static Sprite getSprite(String path) {
        File file = new File(path);

        if (file.exists()) {
            if (!sprites.containsKey(file.getAbsolutePath())) {
                sprites.put(file.getAbsolutePath(), new Sprite(file.getAbsolutePath()));
            }

            return sprites.get(file.getAbsolutePath());
        } else {
            throw new IllegalStateException("Sprite does not exist at location '" + file.getAbsolutePath() + "'");
        }
    }

    /**
     * Removes the sprite from the resource manager.
     *
     * @param path The path of the sprite.
     */
    public static void disposeSprite(String path) {
        File file = new File(path);

        if (sprites.containsKey(file.getAbsolutePath())) {
            Sprite s = sprites.get(path);
            sprites.remove(path);

            s.dispose();
        } else {
            throw new IllegalStateException("Sprite is not loaded in resource manager, cannot dispose.");
        }
    }

    /**
     * Checks if a sprite exists in the resource manager.
     *
     * @param path The path of the sprite.
     * @return If the sprite exists in the resource manager.
     */
    public static boolean spriteExists(String path) {
        File file = new File(path);

        if (sprites.containsKey(file.getAbsolutePath()))
            return true;
        else
            return false;
    }


    // FONTS


    /**
     * Gets a font if stored in the resource manager, otherwise adds it to the resource manager and returns it.
     *
     * @param path The path of the font file.
     * @return The font resource.
     */
    public static Font getFont(String path) {
        File file = new File(path);

        if (file.exists()) {
            if (!fonts.containsKey(file.getAbsolutePath())) {
                fonts.put(file.getAbsolutePath(), new Font(file.getAbsolutePath()));
            }

            return fonts.get(file.getAbsolutePath());
        } else {
            throw new IllegalStateException("Font does not exist at location '" + file.getAbsolutePath() + "'");
        }
    }

    /**
     * Removes the font from the resource manager.
     *
     * @param path The path of the font file.
     */
    public static void disposeFont(String path) {
        File file = new File(path);

        if (fonts.containsKey(file.getAbsolutePath())) {
            Font font = fonts.get(file.getAbsolutePath());
            fonts.remove(path);

            font.dispose();
        } else {
            throw new IllegalStateException("Font is not loaded in resource manager, cannot dispose.");
        }
    }

    /**
     * Checks if a font exists in the resource manager.
     *
     * @param path The path of the font file.
     * @return If the font exists in the resource manager.
     */
    public static boolean fontExists(String path) {
        File file = new File(path);

        if (fonts.containsKey(file.getAbsolutePath()))
            return true;
        else
            return false;
    }


    // AUDIO CLIPS


    /**
     * Gets an audio clip if stored in the resource manager, otherwise adds it to the resource manager and returns it.
     *
     * @param path The path of the audio file.
     * @return The audio clip.
     */
    public static AudioClip getAudioClip(String path) {
        File file = new File(path);

        if (file.exists()) {
            if (!audioClips.containsKey(file.getAbsolutePath())) {
                audioClips.put(file.getAbsolutePath(), new AudioClip(file.getAbsolutePath()));
            }

            return audioClips.get(file.getAbsolutePath());
        } else {
            throw new IllegalStateException("Audio clip does not exist at location '" + file.getAbsolutePath() + "'");
        }
    }

    /**
     * Removes the audio clip from the resource manager.
     *
     * @param path The path of the font file.
     */
    public static void disposeAudioClip(String path) {
        File file = new File(path);

        if (audioClips.containsKey(file.getAbsolutePath())) {
            AudioClip clip = audioClips.get(file.getAbsolutePath());
            fonts.remove(path);

            clip.dispose();
        } else {
            throw new IllegalStateException("Audio clip is not loaded in resource manager, cannot dispose.");
        }
    }

    /**
     * Checks if an audio clip exists in the resource manager.
     *
     * @param path The path of the audio file.
     * @return If the audio clip exists in the resource manager.
     */
    public static boolean audioClipExists(String path) {
        File file = new File(path);

        if (audioClips.containsKey(file.getAbsolutePath()))
            return true;
        else
            return false;
    }
}
