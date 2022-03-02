package dev.yeff.orbital.resources;

import org.lwjgl.BufferUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.stb.STBImage.*;

public class Texture {
    private String filepath;
    private int texID;

    private static final Logger LOGGER = LoggerFactory.getLogger(Texture.class);

    public Texture(String filepath) {
        this.filepath = filepath;

        // Generate texture on GPU
        texID = glGenTextures();
        glBindTexture(GL_TEXTURE_2D, texID);

        // Set texture parameters
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_REPEAT);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_REPEAT);

        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);

        IntBuffer width = BufferUtils.createIntBuffer(1),
                  height = BufferUtils.createIntBuffer(1),
                  channels = BufferUtils.createIntBuffer(1);

        ByteBuffer image = stbi_load(filepath, width, height, channels, 0);

        if (image != null) {
            // 3 channels mean RGB
            // 4 channels mean RGBA
            // more or less, throw an error
            int textureChannels = switch (channels.get(0)) {
                case 3 -> GL_RGB;
                case 4 -> GL_RGBA;
                default -> throw new IllegalStateException("Unexpected value: " + channels.get(0));
            };

            glTexImage2D(
                    GL_TEXTURE_2D,
                    0,
                    textureChannels,
                    width.get(0),
                    height.get(0),
                    0,
                    textureChannels,
                    GL_UNSIGNED_BYTE,
                    image
            );
        } else {
            LOGGER.error("Could not load image '{}' because {}", filepath, stbi_failure_reason());
            return;
        }

        stbi_image_free(image);
    }

    public void bind() {
        glBindTexture(GL_TEXTURE_2D, texID);
    }

    public void unbind() {
        glBindTexture(GL_TEXTURE_2D, 0);
    }
}
