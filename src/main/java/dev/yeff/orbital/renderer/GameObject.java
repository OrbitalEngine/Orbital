package dev.yeff.orbital.renderer;

import org.lwjgl.BufferUtils;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL15.GL_STATIC_DRAW;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL20.glDisableVertexAttribArray;
import static org.lwjgl.opengl.GL30.glBindVertexArray;
import static org.lwjgl.opengl.GL30.glGenVertexArrays;

public class GameObject {
    private float[] vertexArray;
    private int[] elementArray;

    private int vaoID, vboID, eboID;

    public GameObject(float[] vertexArray, int[] elementArray) {
        this.vertexArray = vertexArray;
        this.elementArray = elementArray;
    }

    private int getVertexSizeInBytes(int posSize, int colorSize) {
        return (posSize + colorSize) * Float.BYTES;
    }

    public void create() {
        vaoID = glGenVertexArrays();
        glBindVertexArray(vaoID);

        // Create a float buffer of verticies
        FloatBuffer vertexBuffer = BufferUtils.createFloatBuffer(vertexArray.length);
        vertexBuffer.put(vertexArray).flip();

        // Create VBO and upload the vertex buffer
        vboID = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vboID);
        glBufferData(GL_ARRAY_BUFFER, vertexBuffer, GL_STATIC_DRAW);

        // Create the indices and upload
        IntBuffer elementBuffer = BufferUtils.createIntBuffer(elementArray.length);
        elementBuffer.put(elementArray).flip();

        eboID = glGenBuffers();
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, eboID);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER, elementBuffer, GL_STATIC_DRAW);

        // Add the vertex attrib pointers
        int positionSize = 3;
        int colorSize = 4;
        int vertexSizeInBytes = getVertexSizeInBytes(positionSize, colorSize);

        glVertexAttribPointer(0, positionSize, GL_FLOAT, false, vertexSizeInBytes, 0);
        glEnableVertexAttribArray(0);

        glVertexAttribPointer(1, colorSize, GL_FLOAT, false, vertexSizeInBytes, positionSize * Float.BYTES);
        glEnableVertexAttribArray(1);
    }

    public void use() {
        // Bind the VAO that we're using
        glBindVertexArray(vaoID);

        // Enable the vertex attribute pointers
        glEnableVertexAttribArray(0);
        glEnableVertexAttribArray(1);
    }

    public void dispose() {
        // Unbind everything
        glDisableVertexAttribArray(0);
        glDisableVertexAttribArray(1);
        glBindVertexArray(0);
    }
}
