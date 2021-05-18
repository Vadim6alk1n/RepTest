package SimpleGame.game;

import SimpleGame.game.Target;

public class Bullet {
    Bullet()
    {
        tickLiveTime=300;
        speed = 6;
        r = 5;
    }
    boolean collides(Target t)
    {
        return ((x-t.x)*(x-t.x) + (y-t.y)*(y-t.y)) < ((r*r)+(t.r*t.r));
    }

    double x;
    double y;
    float r;
    double vx;
    double vy;
    double speed;
    int tickLiveTime;
}
