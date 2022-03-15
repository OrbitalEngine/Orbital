package dev.yeff.orbital.resources;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class ResourceManager {
    private static Map<String, Sprite> sprites = new HashMap<>();

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
}
