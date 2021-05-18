package Lesson_12_JavaFX.SimpleGame;

public class Target {
    Target(double w,double h) {
        x = (float)Math.random()*(float)w;
        y = (float)Math.random()*(float)h;
        r = 20;
    }
    float x;
    float y;
    float r;
}
