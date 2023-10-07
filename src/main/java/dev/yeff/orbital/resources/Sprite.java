package dev.yeff.orbital.resources;

import static com.raylib.Raylib.*;

import com.raylib.Raylib.Texture;
import dev.yeff.orbital.interfaces.Disposable;
import lombok.Getter;
import org.joml.Vector2f;

/**
 * Wrapper class over Raylib's {@code Texture} to simplify loading, unloading, and manipulating the
 * image.
 *
 * @author YeffyCodeGit
 */
public class Sprite implements Disposable {
  @Getter private String path;

  @Getter private Image img;

  @Getter private Texture rawTex;

  public Sprite(String path) {
    this.path = path;
    this.img = LoadImage(path);
    this.rawTex = LoadTextureFromImage(img);
  }

  /**
   * Resizes the texture into the given size, using the NN scaling algorithm.
   *
   * @param newSize The size to resize to.
   */
  public void resize(Vector2f newSize) {
    // Use nearest neighbour scaling algorithm instead of the default bicubic scaling algorithm
    // https://en.wikipedia.org/wiki/Nearest-neighbor_interpolation
    ImageResizeNN(this.img, (int) newSize.x, (int) newSize.y);

    reloadTexture();
  }

  /**
   * Resizes the texture into the given size, using the bicubic scaling algorithm.
   *
   * @param newSize The size to resize to.
   */
  public void resizeBicubic(Vector2f newSize) {
    // Raylib uses the bicubic resizing algorithm by default
    // https://en.wikipedia.org/wiki/Bicubic_interpolation
    ImageResize(this.img, (int) newSize.x, (int) newSize.y);
  }

  /** Flips the sprite on the x-axis. */
  public void flipX() {
    ImageFlipHorizontal(img);

    reloadTexture();
  }

  /** Flips the sprite on the y-axis. */
  public void flipY() {
    ImageFlipVertical(img);

    reloadTexture();
  }

  /** Rotate the sprite clockwise. */
  public void rotateClockwise() {
    ImageRotateCW(img);

    reloadTexture();
  }

  /** Rotate the sprite counter-clockwise. */
  public void rotateCounterClockwise() {
    ImageRotateCCW(img);

    reloadTexture();
  }

  /** Changes the color of the sprite to just black and white. */
  public void greyscale() {
    ImageColorGrayscale(img);

    reloadTexture();
  }

  /** Reloads the texture from the image. */
  private void reloadTexture() {
    this.rawTex = LoadTextureFromImage(this.img);
  }

  /** Unloads the texture and image from memory. */
  @Override
  public void dispose() {
    UnloadImage(img);
    UnloadTexture(rawTex);
  }

  @Override
  public String toString() {
    return String.format("Sprite(path = %s)", path);
  }
}
