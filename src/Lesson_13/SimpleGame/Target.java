package Lesson_13.SimpleGame;

public class Target {
    Target(double w,double h) {
        x = (float)Math.random()*(float)(w-100) + 100;
        y = (float)Math.random()*(float)(h-100) + 100;
        r = 20;
    }
    float x;
    float y;
    float r;
}
