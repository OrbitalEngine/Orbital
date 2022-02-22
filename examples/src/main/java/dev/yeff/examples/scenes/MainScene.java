package dev.yeff.examples.scenes;

import dev.yeff.orbital.Scene;
import dev.yeff.orbital.Window;
import dev.yeff.orbital.io.KeyListener;
import org.lwjgl.BufferUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL30.glBindVertexArray;
import static org.lwjgl.opengl.GL30.glGenVertexArrays;

public class MainScene implements Scene {
    private static Logger LOGGER = LoggerFactory.getLogger(MainScene.class);

    private String vertexShaderSrc = "#version 330 core\n" +
            "layout (location = 0) in vec3 aPos;\n" +
            "\n" +
            "void main()\n" +
            "{\n" +
            "    gl_Position = vec4(aPos.x, aPos.y, aPos.z, 1.0);\n" +
            "}";

    private String fragmentShaderSrc = "#version 330 core\n" +
            "out vec4 FragColor;\n" +
            "\n" +
            "void main()\n" +
            "{\n" +
            "    FragColor = vec4(1.0f, 0.5f, 0.2f, 1.0f);\n" +
            "}";

    private int vertexId, fragmentId, program;
    private int vaoId, vboId, eboId;

    private float[] vertexArray = {
            // vertices                // colors
            0.5f, -0.5f,  0.0f,        1.0f, 0.0f, 0.0f, 1.0f, // bottom right
            -0.5f, 0.5f,  0.0f,        0.0f, 1.0f, 0.0f, 1.0f, // top left
            0.5f,  0.5f,  0.0f,        0.0f, 0.0f, 1.0f, 1.0f, // top right
            -0.5f, -0.5f, 0.0f,        1.0f, 1.0f, 1.0f, 1.0f, // top left
    };


    // IMPORTANT: Must be in counter-clockwise order
    private int[] elementArray = {
            2, 1, 0,
            0, 1, 3
    };


    @Override
    public void init(Window window) {
        LOGGER.info("initialized");

        // Compile the vertex shader
        vertexId = glCreateShader(GL_VERTEX_SHADER);
        glShaderSource(vertexId, vertexShaderSrc);
        glCompileShader(vertexId);

        int success = glGetShaderi(vertexId, GL_COMPILE_STATUS);
        if (success == GL_FALSE) {
            int len = glGetShaderi(vertexId, GL_INFO_LOG_LENGTH);

            LOGGER.error("default.glsl vertex shader compilation failed");
            LOGGER.error(glGetShaderInfoLog(vertexId, len));
            return;
        }

        // Compile the fragment shader
        fragmentId = glCreateShader(GL_FRAGMENT_SHADER);
        glShaderSource(fragmentId, fragmentShaderSrc);
        glCompileShader(fragmentId);

        success = glGetShaderi(fragmentId, GL_COMPILE_STATUS);
        if (success == GL_FALSE) {
            int len = glGetShaderi(fragmentId, GL_INFO_LOG_LENGTH);

            LOGGER.error("default.glsl fragment shader compilation failed");
            LOGGER.error(glGetShaderInfoLog(fragmentId, len));
            return;
        }

        // Link shaders and check for errors
        program = glCreateProgram();
        glAttachShader(program, vertexId);
        glAttachShader(program, fragmentId);
        glLinkProgram(program);

        success = glGetProgrami(program, GL_LINK_STATUS);
        if (success == GL_FALSE) {
            int len = glGetProgrami(program, GL_INFO_LOG_LENGTH);

            LOGGER.error("default.glsl shader linking failed");
            LOGGER.error(glGetProgramInfoLog(program, len));
            return;
        }

        vaoId = glGenVertexArrays();
        glBindVertexArray(vaoId);

        // Create a float buffer of verticies
        FloatBuffer vertexBuffer = BufferUtils.createFloatBuffer(vertexArray.length);
        vertexBuffer.put(vertexArray).flip();

        // Create Vertex Buffer Object and upload the vertex buffer
        vboId = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vboId);
        glBufferData(GL_ARRAY_BUFFER, vertexBuffer, GL_STATIC_DRAW);

        // Create the indicies and upload
        IntBuffer elementBuffer = BufferUtils.createIntBuffer(elementArray.length);
        elementBuffer.put(elementArray).flip();

        eboId = glGenBuffers();
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, eboId);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER, elementBuffer, GL_STATIC_DRAW);

        // Add the vertex attrib pointers
        int positionSize = 3;
        int colorSize = 4;
        int vertexSizeInBytes = (positionSize + colorSize) * Float.BYTES;

        glVertexAttribPointer(0, positionSize, GL_FLOAT, false, vertexSizeInBytes, 0);
        glEnableVertexAttribArray(0);

        glVertexAttribPointer(1, colorSize, GL_FLOAT, false, vertexSizeInBytes, positionSize * Float.BYTES);
        glEnableVertexAttribArray(1);
    }

    @Override
    public void update(Window window, float delta) {
        if (KeyListener.isKeyDown(GLFW_KEY_ESCAPE))
            System.exit(0);

        // Bind shader program
        glUseProgram(program);
        // Bind the VAO that we're using
        glBindVertexArray(vaoId);

        // Enable the vertex attribute pointers
        glEnableVertexAttribArray(0);
        glEnableVertexAttribArray(1);

        glDrawElements(GL_TRIANGLES, elementArray.length, GL_UNSIGNED_INT, 0);

        // Unbind everything
        glDisableVertexAttribArray(0);
        glDisableVertexAttribArray(1);
        glBindVertexArray(0);
        glUseProgram(0);


        //LOGGER.info("FPS: {}", 1 / delta);
    }
}
