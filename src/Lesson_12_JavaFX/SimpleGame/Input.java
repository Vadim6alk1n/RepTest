package Lesson_12_JavaFX.SimpleGame;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class Input {
    static final int key_w = 0;
    static final int key_a = 1;
    static final int key_s = 2;
    static final int key_d = 3;

    public static boolean keyPressed[];
    static
    {
        keyPressed = new boolean[4];
    }
    public static void handleKeyboardPress(KeyEvent keyEvent)
    {
        KeyCode key = keyEvent.getCode();
        if (key==KeyCode.W)
        {
            keyPressed[key_w]=true;
        }
        if (key==KeyCode.S)
        {
            keyPressed[key_s]=true;
        }
        if (key==KeyCode.A)
        {
            keyPressed[key_a]=true;
        }
        if (key==KeyCode.D)
        {
            keyPressed[key_d]=true;
        }
    }
    public static void handleKeyboardRelease(KeyEvent keyEvent)
    {
        KeyCode key = keyEvent.getCode();
        if (key==KeyCode.W)
        {
            keyPressed[key_w]=false;
        }
        if (key==KeyCode.S)
        {
            keyPressed[key_s]=false;
        }
        if (key==KeyCode.A)
        {
            keyPressed[key_a]=false;
        }
        if (key==KeyCode.D)
        {
            keyPressed[key_d]=false;
        }
    }
}
