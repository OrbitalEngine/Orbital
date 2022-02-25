package dev.yeff.orbital.renderer;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.lwjgl.opengl.GL11.GL_FALSE;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL20.glGetShaderInfoLog;

/**
 * Wrapper class over a shader. Simplifies the process of creating a shader from a file.
 *
 * @author YeffyCodeGit
 * @version 0.0.1
 */
public class Shader {
    private static final Logger LOGGER = LoggerFactory.getLogger(Shader.class);
    private int shaderProgramID, vertexID, fragmentID;

    private String vertexSource, fragmentSource, filepath;

    public Shader(String filepath) {
        this.filepath = filepath;
        try {
            String source = new String(Files.readAllBytes(Paths.get(filepath)));
            String[] splitString = source.split("(#type)( )+([a-zA-Z]+)");

            // Find the first pattern after #type 'pattern'
            int index = source.indexOf("#type") + 6;
            int eol = source.indexOf("\r\n", index);
            String firstPattern = source.substring(index, eol).trim();

            // Find the second pattern after #type 'pattern'
            index = source.indexOf("#type", eol) + 6;
            eol = source.indexOf("\r\n", index);
            String secondPattern = source.substring(index, eol).trim();

            if (firstPattern.equals("vertex")) {
                vertexSource = splitString[1];
            } else if (firstPattern.equals("fragment") || firstPattern.equals("frag")) {
                fragmentSource = splitString[1];
            } else {
                throw new IOException("Unexpected token '" + firstPattern + "'");
            }

            if (secondPattern.equals("vertex")) {
                vertexSource = splitString[2];
            } else if (secondPattern.equals("fragment") || secondPattern.equals("frag")) {
                fragmentSource = splitString[2];
            } else {
                throw new IOException("Unexpected token '" + secondPattern + "'");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Loads and compiles the vertex and fragment shaders, and link it and build the shader program.
     */
    public void compile() {
        // Load and compile the vertex shader
        vertexID = glCreateShader(GL_VERTEX_SHADER);
        glShaderSource(vertexID, vertexSource);
        glCompileShader(vertexID);

        // Check for errors in compilation
        int success = glGetShaderi(vertexID, GL_COMPILE_STATUS);
        if (success == GL_FALSE) {
            int len = glGetShaderi(vertexID, GL_INFO_LOG_LENGTH);
            LOGGER.error("'{}' vertex shader compilation failed.", filepath);
            LOGGER.error(glGetShaderInfoLog(vertexID, len));
        }

        // Load and compile the fragment shader
        fragmentID = glCreateShader(GL_FRAGMENT_SHADER);
        glShaderSource(fragmentID, fragmentSource);
        glCompileShader(fragmentID);

        // Check for errors in compilation
        success = glGetShaderi(fragmentID, GL_COMPILE_STATUS);
        if (success == GL_FALSE) {
            int len = glGetShaderi(fragmentID, GL_INFO_LOG_LENGTH);
            LOGGER.error("'{}' fragment shader compilation failed.", filepath);
            LOGGER.error(glGetShaderInfoLog(fragmentID, len));
        }

        // Link shaders and check for errors
        shaderProgramID = glCreateProgram();
        glAttachShader(shaderProgramID, vertexID);
        glAttachShader(shaderProgramID, fragmentID);
        glLinkProgram(shaderProgramID);

        // Check for linking errors
        success = glGetProgrami(shaderProgramID, GL_LINK_STATUS);
        if (success == GL_FALSE) {
            int len = glGetProgrami(shaderProgramID, GL_INFO_LOG_LENGTH);
            LOGGER.error("'{}' shader linking failed.", filepath);
            LOGGER.error(glGetShaderInfoLog(shaderProgramID, len));
        }
    }

    /**
     * Makes OpenGL use the built shader program. The {@code compile} function must be called before {@code use} is called.
     */
    public void use() {
        // Bind shader program
        glUseProgram(shaderProgramID);
    }

    /**
     * Makes OpenGl stop using the built shader program.
     */
    public void detach() {
        glUseProgram(0);
    }
}