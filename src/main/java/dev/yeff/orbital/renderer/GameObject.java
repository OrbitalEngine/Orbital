package dev.yeff.orbital.renderer;

import dev.yeff.orbital.io.MouseListener;
import dev.yeff.orbital.util.Time;
import org.lwjgl.BufferUtils;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL15.GL_STATIC_DRAW;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL20.glDisableVertexAttribArray;
import static org.lwjgl.opengl.GL30.glBindVertexArray;
import static org.lwjgl.opengl.GL30.glGenVertexArrays;

/**
 * A class to simplify the creation VAO, VBO and EBOs, and using them.
 *
 * @author YeffyCodeGit
 * @version 0.0.1
 */
public class GameObject {
    private float[] vertexArray;
    private int[] elementArray;
    private Shader shader;

    private int vaoID, vboID, eboID;

    public GameObject(float[] vertexArray, int[] elementArray, Shader shader) {
        this.vertexArray = vertexArray;
        this.elementArray = elementArray;
        this.shader = shader;
    }

    /**
     * Helper function to get the size of all the VAO attributes as bytes.
     *
     * @param posSize The size of the position attribute.
     * @param colorSize The size of the color attribute.
     *
     * @return The full size, in bytes.
     */
    private int getVertexSizeInBytes(int posSize, int colorSize, int uvSize) {
        return (posSize + colorSize + uvSize) * Float.BYTES;
    }

    /**
     * Create the VAO, VBO and EBOs, and set the attribute pointers.
     */
    public void create() {
        shader.compile();

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
        int uvSize = 2;
        int vertexSizeInBytes = getVertexSizeInBytes(positionSize, colorSize, uvSize);

        glVertexAttribPointer(0, positionSize, GL_FLOAT, false, vertexSizeInBytes, 0);
        glEnableVertexAttribArray(0);

        glVertexAttribPointer(1, colorSize, GL_FLOAT, false, vertexSizeInBytes, positionSize * Float.BYTES);
        glEnableVertexAttribArray(1);

        glVertexAttribPointer(2, uvSize, GL_FLOAT, false, vertexSizeInBytes, (positionSize + colorSize) * Float.BYTES);
        glEnableVertexAttribArray(2);
    }

    /**
     * Makes OpenGL use the created VAO and enable the attribute pointers.
     */
    public void use() {
        // Bind shader
        shader.use();

        shader.uploadFloat("uTime", Time.getTime());
        shader.uploadFloat("uMouseX", MouseListener.getX());
        shader.uploadFloat("uMouseY", MouseListener.getY());

        // Bind the VAO that we're using
        glBindVertexArray(vaoID);

        // Enable the vertex attribute pointers
        glEnableVertexAttribArray(0);
        glEnableVertexAttribArray(1);
    }

    /**
     * Makes OpenGL not use the created VAO and disable the attribute pointers.
     */
    public void dispose() {
        // Unbind everything
        glDisableVertexAttribArray(0);
        glDisableVertexAttribArray(1);
        glBindVertexArray(0);

        shader.detach();
    }

    public int[] getElementArray() { return elementArray; }
    public float[] getVertexArray() { return vertexArray; }
}
