package Lesson_13.SimpleGame;

public class Bullet {
    Bullet()
    {
        tickLiveTime=300;
        speed = 5;
        r = 5;
    }
    boolean collides(Target t)
    {
        return ((x-t.x)*(x-t.x) + (y-t.y)*(y-t.y)) < ((r*r)+(t.r*t.r));
    }
    boolean collides(Player t)
    {
        return ((x-t.x)*(x-t.x) + (y-t.y)*(y-t.y)) < ((r*r)+(t.h*t.w));
    }
    double x;
    double y;
    float r;
    double vx;
    double vy;
    double speed;
    int tickLiveTime;
}
