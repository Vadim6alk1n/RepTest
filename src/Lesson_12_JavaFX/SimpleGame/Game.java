package Lesson_12_JavaFX.SimpleGame;

import SimpleGame.game.Bullet;
import SimpleGame.game.Input;
import SimpleGame.game.Player;
import SimpleGame.game.Target;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Game implements Runnable{
    Stage window;
    Scene screen;
    Pane root;
    GraphicsContext gc;
    int fps;

    SimpleGame.game.Player player;
    ArrayList<SimpleGame.game.Target> targets;
    ArrayList<SimpleGame.game.Bullet> bullets;

    Image playerimage;
    Image targetimage;

    public Game(Stage stage, Scene scene, Pane root)
    {
        window = stage;
        screen = scene;
        fps = 60;
        this.root = root;
    }
    public void init()
    {
        //canvas where field will be drawn
        var canvas = new Canvas(screen.getWidth(), screen.getHeight());
        //mouse event only for canvas
        canvas.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_PRESSED,this::press);
        gc = canvas.getGraphicsContext2D();
        root.getChildren().add(canvas);
        window.show();

        //Keyboard events
        screen.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                SimpleGame.game.Input.handleKeyboardPress(keyEvent);
            }
        });
        screen.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                SimpleGame.game.Input.handleKeyboardRelease(keyEvent);
            }
        });
        //Create player
        player = new Player();
        player.speed = 5.0f;
        player.x = (float)screen.getWidth()/2;
        player.y = (float)screen.getHeight()/2;
        player.w = 50;
        player.h = 50;
        //arrays
        targets = new ArrayList<>();
        bullets = new ArrayList<>();
        targets.add(new SimpleGame.game.Target(screen.getWidth(),screen.getHeight()));
        targets.add(new SimpleGame.game.Target(screen.getWidth(),screen.getHeight()));
        targets.add(new SimpleGame.game.Target(screen.getWidth(),screen.getHeight()));
        playerimage = new Image("data/NobleRanger.png");
        targetimage = new Image("data/target.png");
    }

    private void press(MouseEvent e) {
        if (e.getButton() == MouseButton.PRIMARY)
        {
            double mx = e.getX();
            double my = e.getY();
            SimpleGame.game.Bullet b = new SimpleGame.game.Bullet();
            b.x = player.x;
            b.y = player.y;
            b.vx = mx - player.x;
            b.vy = my - player.y;
            double l = Math.sqrt(b.vx*b.vx+b.vy*b.vy);
            b.vx = (b.vx / l)*b.speed;
            b.vy = (b.vy / l)*b.speed;
            bullets.add(b);
        }
    }

    @Override
    public void run() {
        int frametime = 1000/fps;
        long currenttime = System.currentTimeMillis();
        long diff;
        while (true) {
            //Sleep
            try {
                long newtime = System.currentTimeMillis();
                diff = newtime - currenttime;
                long sleeptime = frametime-diff;
                //debug this!
                if(sleeptime>0)
                    Thread.sleep(sleeptime);
                currenttime = newtime;

            } catch (Exception ex) {

            }

            //cycle
            render();
            update();
            //System.out.println("render");
            // UI update is run on the Application thread
            // Platform.runLater(updater);
            //draw();
        }
    }

    float tx;
    float ty;

    public void update()
    {
        //Input
        if (SimpleGame.game.Input.keyPressed[SimpleGame.game.Input.key_w]) {
            player.y-= player.speed;
        }
        if (SimpleGame.game.Input.keyPressed[SimpleGame.game.Input.key_s]) {
            player.y+= player.speed;
        }
        if (SimpleGame.game.Input.keyPressed[SimpleGame.game.Input.key_a]) {
            player.x-= player.speed;
        }
        if (SimpleGame.game.Input.keyPressed[Input.key_d]) {
            player.x+= player.speed;
        }
        //Bullets move
        ArrayList<Bullet> removebullets = new ArrayList<>();
        for (var b : bullets)
        {
            b.x+=b.vx;
            b.y+=b.vy;
            b.tickLiveTime--;
            if (b.tickLiveTime<=0)
            {
                removebullets.add(b);
            }
        }
        for (var b: removebullets)
        {
            bullets.remove(b);
        }
        //Targets
        ArrayList<SimpleGame.game.Target> removetargets = new ArrayList<>();
        for (var t: targets)
        {
            for (var b:bullets)
            {
                if (b.collides(t))
                {
                    removetargets.add(t);
                }
            }
        }
        for (var t: removetargets)
        {
            if (targets.remove(t))
            {
                targets.add(new Target(screen.getWidth(),screen.getHeight()));
            }

        }
    }

    public void render()
    {
        //clear all screen
        gc.clearRect(0,0,1000,1000);
        gc.setFill(Color.BLACK);
        //Draw player
        gc.drawImage(playerimage,player.x-player.w/2,player.y-player.h/2,player.w,player.h);
        //Draw targets
        for (var t : targets) {
            gc.drawImage(targetimage,t.x-t.r,t.y-t.r,t.r,t.r);
        }
        //Draw bullets
        gc.setFill(Color.GRAY);
        for (var t : bullets) {
            gc.fillOval(t.x-t.r,t.y-t.r,t.r,t.r);
        }
    }
}
