package Lesson_13.SimpleGame;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;


public class Input {
    static final int key_w = 0;
    static final int key_a = 1;
    static final int key_s = 2;
    static final int key_d = 3;

    public static boolean keyPressed[];
    public static boolean keyClick[];
    public static double mx,my;
    static
    {
        keyPressed = new boolean[4];
        keyClick = new boolean[4];
    }
    public static void MouseMove(MouseEvent e)
    {
        mx = e.getX();
        my = e.getY();
    }
    public static void handleKeyboardPress(KeyEvent keyEvent)
    {
        KeyCode key = keyEvent.getCode();
        if (key==KeyCode.W)
        {
            keyPressed[key_w]=true;
            keyClick[key_w]=true;
        }
        if (key==KeyCode.S)
        {
            keyPressed[key_s]=true;
            keyClick[key_s]=true;
        }
        if (key==KeyCode.A)
        {
            keyPressed[key_a]=true;
            keyClick[key_a]=true;
        }
        if (key==KeyCode.D)
        {
            keyPressed[key_d]=true;
            keyClick[key_d]=true;
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
    public static void update()
    {
        for (int i=0;i<4;i++)
        {
            keyClick[i]=false;
        }
    }
}
