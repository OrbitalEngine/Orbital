package dev.yeff.orbital.resources;

import static com.raylib.Raylib.*;

import com.raylib.Raylib;
import dev.yeff.orbital.interfaces.Disposable;
import lombok.Getter;

/**
 * Represents a text font, which can be used by the {@code Renderer}.
 *
 * @author YeffyCodeGit
 */
public class Font implements Disposable {
  private Raylib.Font font;

  @Getter private String path;

  public Font(String path) {
    this.path = path;
    font = LoadFont(path);
  }

  /**
   * Returns the raylib version of the font. This function is mainly meant to be used internally by
   * the engine internally.
   *
   * @return The raylib version of the font.
   */
  public Raylib.Font asRaylibFont() {
    return font;
  }

  /** Unloads the font from memory. */
  @Override
  public void dispose() {
    UnloadFont(font);
  }
}
