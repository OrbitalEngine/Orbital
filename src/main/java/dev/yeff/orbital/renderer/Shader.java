package dev.yeff.orbital.renderer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Scanner;

import static org.lwjgl.opengl.GL20.*;

public class Shader {
    private static final Logger LOGGER = LoggerFactory.getLogger(Shader.class);
    private int programId, vertexShaderId, fragmentShaderId;

    public Shader(String vertexShader, String fragmentShader)  {
        programId = glCreateProgram();

        createVertexShader(vertexShader);
        createFragmentShader(fragmentShader);
    }


    private void createVertexShader(String shaderCode) {
        vertexShaderId = createShader(shaderCode, GL_VERTEX_SHADER);
    }

    private void createFragmentShader(String shaderCode) {
        fragmentShaderId = createShader(shaderCode, GL_FRAGMENT_SHADER);
    }

    private int createShader(String shaderCode, int shaderType) {
        int shaderId = glCreateShader(shaderType);

        glShaderSource(shaderId, shaderCode);
        glCompileShader(shaderId);

        glAttachShader(programId, shaderId);

        return shaderId;
    }

    public void link() {
        glLinkProgram(programId);

        if (vertexShaderId != 0) {
            glDetachShader(programId, vertexShaderId);
        }
        if (fragmentShaderId != 0) {
            glDetachShader(programId, fragmentShaderId);
        }

        glValidateProgram(programId);
    }

    public void bind() {
        glUseProgram(programId);
    }

    public void unbind() {
        glUseProgram(0);
    }

    public void dispose() {
        unbind();

        if (programId != 0) {
            glDeleteProgram(programId);
        }
    }
}