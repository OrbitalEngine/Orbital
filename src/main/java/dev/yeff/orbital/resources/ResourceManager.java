package dev.yeff.orbital.resources;


import java.awt.*;
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
    private static Map<String, TextFont> fonts = new HashMap<>();

    // SPRITES
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

    public static boolean spriteExists(String path) {
        File file = new File(path);

        if (sprites.containsKey(file.getAbsolutePath()))
            return true;
        else
            return false;
    }


    // FONTS
    public static TextFont getFont(String path) {
        File file = new File(path);

        if (file.exists()) {
            if (!fonts.containsKey(file.getAbsolutePath())) {
                fonts.put(file.getAbsolutePath(), new TextFont(file.getAbsolutePath()));
            }

            return fonts.get(file.getAbsolutePath());
        } else {
            throw new IllegalStateException("Sprite does not exist at location '" + file.getAbsolutePath() + "'");
        }
    }

    public static void disposeFont(String path) {
        File file = new File(path);

        if (fonts.containsKey(file.getAbsolutePath())) {
            TextFont font = fonts.get(file.getAbsolutePath());
            fonts.remove(path);

            font.dispose();
        } else {
            throw new IllegalStateException("Sprite is not loaded in resource manager, cannot dispose.");
        }
    }

    public static boolean fontExists(String path) {
        File file = new File(path);

        if (fonts.containsKey(file.getAbsolutePath()))
            return true;
        else
            return false;
    }
}
