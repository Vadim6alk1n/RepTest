package SimpleGame.game;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class Input {
    static final int key_w = 0;
    static final int key_a = 1;
    static final int key_s = 2;
    static final int key_d = 3;
    static final int key_p = 4;




    public static boolean keyPressed[];
    static
    {
        keyPressed = new boolean[5];
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
        if (key==KeyCode.P) {

            keyPressed[key_p]=true;
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
        if (key==KeyCode.P) {
            keyPressed[key_p]=false;
    }
    }
}
