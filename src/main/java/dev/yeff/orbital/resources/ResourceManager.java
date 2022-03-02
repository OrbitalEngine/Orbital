package dev.yeff.orbital.resources;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static org.lwjgl.opengl.GL13.*;

public class ResourceManager {
    private static Map<String, Shader> shaders = new HashMap<>();
    private static Map<String, Texture> textures = new HashMap<>();

    private static Map<Integer, Integer> texSlots = new HashMap<>() {{
        put(0,  GL_TEXTURE0);
        put(1,  GL_TEXTURE1);
        put(2,  GL_TEXTURE2);
        put(3,  GL_TEXTURE3);
        put(4, GL_TEXTURE4);
        put(5, GL_TEXTURE5);
        put(6, GL_TEXTURE6);
        put(7, GL_TEXTURE7);
        put(8, GL_TEXTURE8);
        put(9, GL_TEXTURE9);
        put(10, GL_TEXTURE10);
        put(11,  GL_TEXTURE11);
        put(12,  GL_TEXTURE12);
        put(13,  GL_TEXTURE13);
        put(14,  GL_TEXTURE14);
        put(15, GL_TEXTURE15);
        put(16, GL_TEXTURE16);
        put(17, GL_TEXTURE17);
        put(18, GL_TEXTURE18);
        put(19, GL_TEXTURE19);
        put(20, GL_TEXTURE20);
        put(21,  GL_TEXTURE21);
        put(22,  GL_TEXTURE22);
        put(23,  GL_TEXTURE23);
        put(24,  GL_TEXTURE24);
        put(25, GL_TEXTURE25);
        put(26, GL_TEXTURE26);
        put(27, GL_TEXTURE27);
        put(28, GL_TEXTURE28);
        put(29, GL_TEXTURE29);
        put(30, GL_TEXTURE30);
        put(31, GL_TEXTURE31);
    }};

    public static Shader getShader(String resourceName) {
        File file = new File(resourceName);

        if (!file.exists()) {
            throw new IllegalStateException("The shader file does not exist at " + resourceName);
        }

        if (shaders.containsKey(file.getAbsolutePath())) {
            return ResourceManager.shaders.get(file.getAbsolutePath());
        } else {
            Shader shader = new Shader(resourceName);
            shader.compile();
            ResourceManager.shaders.put(file.getAbsolutePath(), shader);

            return shader;
        }
    }

    public static Texture getTexture(String resourceName, int slot) {
        File file = new File(resourceName);

        int texSlot = texSlots.get(slot);

        if (!file.exists()) {
            throw new IllegalStateException("The image file does not exist at " + resourceName);
        }

        if (ResourceManager.textures.containsKey(file.getAbsolutePath())) {
            glActiveTexture(texSlot);
            ResourceManager.textures.get(file.getAbsolutePath()).bind();
            return ResourceManager.textures.get(file.getAbsolutePath());
        } else {
            Texture texture = new Texture(resourceName);
            ResourceManager.textures.put(file.getAbsolutePath(), texture);
            glActiveTexture(texSlot);
            texture.bind();
            return texture;
        }
    }
}
