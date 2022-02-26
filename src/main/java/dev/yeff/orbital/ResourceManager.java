package dev.yeff.orbital;

import dev.yeff.orbital.renderer.Shader;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ResourceManager {
    private static Map<String, Shader> shaders = new HashMap<>();

    public static Shader getShader(String resourceName) {
        File file = new File(resourceName);

        if (shaders.containsKey(file.getAbsolutePath())) {
            return ResourceManager.shaders.get(file.getAbsolutePath());
        } else {
            Shader shader = new Shader(resourceName);
            shader.compile();
            ResourceManager.shaders.put(file.getAbsolutePath(), shader);

            return shader;
        }
    }
}
