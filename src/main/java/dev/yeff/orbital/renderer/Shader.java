package dev.yeff.orbital.renderer;

import org.joml.*;
import org.lwjgl.BufferUtils;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.io.IOException;
import java.nio.FloatBuffer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

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
    private boolean beingUsed;

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

        LOGGER.info("created new shader");
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
        if (!beingUsed) {
            // Bind shader program
            glUseProgram(shaderProgramID);
            beingUsed = true;
        }
    }

    /**
     * Makes OpenGl stop using the built shader program.
     */
    public void detach() {
        glUseProgram(0);
        beingUsed = false;
    }

    /**
     * Upload a 4x4 matrix to the shader.
     *
     * @param varName The name of the uniform.
     * @param mat4 The 4x4 matrix.
     */
    public void uploadMat4f(String varName, Matrix4f mat4) {
        int varLocation = glGetUniformLocation(shaderProgramID, varName);
        use();
        FloatBuffer matBuffer = BufferUtils.createFloatBuffer(16);
        mat4.get(matBuffer);
        glUniformMatrix4fv(varLocation, false, matBuffer);
    }

    /**
     * Upload a 3x3 matrix to the shader.
     *
     * @param varName The name of the uniform.
     * @param mat3 The 4x4 matrix.
     */
    public void uploadMat3f(String varName, Matrix3f mat3) {
        int varLocation = glGetUniformLocation(shaderProgramID, varName);
        use();
        FloatBuffer matBuffer = BufferUtils.createFloatBuffer(9);
        mat3.get(matBuffer);
        glUniformMatrix3fv(varLocation, false, matBuffer);
    }

    /**
     * Upload a 4 component vector to the shader.
     *
     * @param varName The name of the uniform.
     * @param vec The 4 component vector.
     */
    public void uploadVec4f(String varName, Vector4f vec) {
        int varLocation = glGetUniformLocation(shaderProgramID, varName);
        use();
        glUniform4f(varLocation, vec.x, vec.y, vec.z, vec.w);
    }

    /**
     * Upload a 3 component vector to the shader.
     *
     * @param varName The name of the uniform.
     * @param vec The 3 component vector.
     */
    public void uploadVec3f(String varName, Vector3f vec) {
        int varLocation = glGetUniformLocation(shaderProgramID, varName);
        use();
        glUniform3f(varLocation, vec.x, vec.y, vec.z);
    }

    /**
     * Upload a 2 component vector to the shader.
     *
     * @param varName The name of the uniform.
     * @param vec The 2 component vector.
     */
    public void uploadVec2f(String varName, Vector2f vec) {
        int varLocation = glGetUniformLocation(shaderProgramID, varName);
        use();
        glUniform2f(varLocation, vec.x, vec.y);
    }

    /**
     * Upload a float to the shader.
     *
     * @param varName The name of the uniform.
     * @param val The float value.
     */
    public void uploadFloat(String varName, float val) {
        int varLocation = glGetUniformLocation(shaderProgramID, varName);
        use();
        glUniform1f(varLocation, val);
    }

    /**
     * Upload an integer to the shader.
     *
     * @param varName The name of the uniform.
     * @param val The integer value.
     */
    public void uploadInt(String varName, int val) {
        int varLocation = glGetUniformLocation(shaderProgramID, varName);
        use();
        glUniform1i(varLocation, val);
    }

    /**
     * Upload a texture object to the shader.
     *
     * @param varName The name of the uniform.
     * @param slot The texture slot.
     */
    public void uploadTexture(String varName, int slot) {
        int varLocation = glGetUniformLocation(shaderProgramID, varName);
        use();
        glUniform1i(varLocation, slot);
    }

    /**
     * Upload an array of integers to the shader.
     *
     * @param varName The name of the uniform.
     * @param array The array of integers value.
     */
    public void uploadIntArray(String varName, int[] array) {
        int varLocation = glGetUniformLocation(shaderProgramID, varName);
        use();
        glUniform1iv(varLocation, array);
    }
}