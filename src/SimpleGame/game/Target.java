package SimpleGame.game;

public class Target {
    Target(double w,double h) {

        x = (float)Math.random()*(float)w;
        y = (float)Math.random()*(float)h;
        r = 20;
        speedx = 2;
        speedy = 2;
    }
     Target(float w1, float h2, boolean h) {
        x = w1;
        y= h2;
         r = 20;
         speedx = 2;
         speedy = 2;
    }

    float x;
    float y;
    float r;
    float vx;
    float vy;
    float speedx;
    float speedy;

}
