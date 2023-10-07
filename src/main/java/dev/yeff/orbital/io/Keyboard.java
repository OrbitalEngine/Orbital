package dev.yeff.orbital.io;

import static com.raylib.Raylib.*;

import dev.yeff.orbital.util.Callback;
import org.bytedeco.javacpp.BytePointer;

/**
 * Provides functions for receiving input from the keyboard.
 *
 * @author YeffyCodeGit
 */
public class Keyboard {
  /**
   * Checks if a keyboard key is being held down.
   *
   * @param key The key to check for.
   * @return If the key is held down or not.
   */
  public boolean isKeyDown(Keys key) {
    return IsKeyDown(key.getKeycode());
  }

  /**
   * Checks if a keyboard key is not being held down.
   *
   * @param key The key to check for.
   * @return If the key is not held down or not.
   */
  public boolean isKeyUp(Keys key) {
    return IsKeyUp(key.getKeycode());
  }

  /**
   * Checks if a keyboard key is being pressed once.
   *
   * @param key The key to check for.
   * @return If the key is being pressed.
   */
  public boolean isKeyPressed(Keys key) {
    return IsKeyPressed(key.getKeycode());
  }

  /**
   * Invokes a {@code Callback<T>} when a keyboard key is pressed.
   *
   * @param key The key to check for.
   * @param callback The callback to invoke when the key is pressed/
   */
  public void onKeyPressed(Keys key, Callback<Integer> callback) {
    if (GetKeyPressed() == key.getKeycode()) {
      callback.invoke(key.getKeycode());
    }
  }

  /**
   * Gets the contents copied in the system clipboard.
   *
   * @return The contents copied in the system clipboard.
   */
  public String getClipboardContents() {
    return GetClipboardText().getString();
  }

  /**
   * Copies a string into the system clipboard.
   *
   * @param contents The content to copy.
   */
  public void setClipboardContents(String contents) {
    SetClipboardText(new BytePointer(contents));
  }
}
