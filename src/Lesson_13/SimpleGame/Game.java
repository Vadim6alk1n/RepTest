package Lesson_13.SimpleGame;

import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Game implements Runnable{
    Stage window;
    Scene screen;
    VBox root;
    SimpleGame_Controller controller;
    GraphicsContext gc;
    int fps;

    Player player;
    ArrayList<Target> targets;
    ArrayList<Bullet> bullets;
    ArrayList<Bullet> enemybullets;

    Image playerimage;
    Image targetimage;

    Integer lives;
    Integer score;
    Integer bulletframe;
    boolean pause;

    public void Restart()
    {
        player.speed = 5.0f;
        player.x = (float)screen.getWidth()/2;
        player.y = (float)screen.getHeight()/2;
        player.w = 50;
        player.h = 50;
        lives = 5;
        bulletframe = 300;
        score = 0;
        pause = false;
        //arrays
        targets = new ArrayList<>();
        bullets = new ArrayList<>();
        enemybullets = new ArrayList<>();
        targets.add(new Target(screen.getWidth(),screen.getHeight()));
        targets.add(new Target(screen.getWidth(),screen.getHeight()));
        targets.add(new Target(screen.getWidth(),screen.getHeight()));
        updateLives();
    }

    public Game(Stage stage, Scene scene, VBox root,SimpleGame_Controller controller)
    {
        window = stage;
        screen = scene;
        fps = 60;
        this.root = root;
        this.controller = controller;
        controller.game = this;
    }
    public void init()
    {
        //canvas where field will be drawn
        var canvas = new Canvas(screen.getWidth(), screen.getHeight());
        //mouse event only for canvas
        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED,this::press);
        canvas.addEventHandler(MouseEvent.MOUSE_MOVED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Input.MouseMove(mouseEvent);
            }
        });
        gc = canvas.getGraphicsContext2D();
        root.getChildren().add(canvas);
        window.show();

        //Keyboard events
        screen.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                Input.handleKeyboardPress(keyEvent);
            }
        });
        screen.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                Input.handleKeyboardRelease(keyEvent);
            }
        });
        //Create player
        player = new Player();
        Restart();
        pause = true;
        playerimage = new Image("data/NobleRanger.png");
        targetimage = new Image("data/target.png");
    }

    private void press(MouseEvent e) {
        if (e.getButton() == MouseButton.PRIMARY)
        {
            double mx = e.getX();
            double my = e.getY();
            Bullet b = new Bullet();
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
    private void CreateEnemyBullet()
    {
        double bx,by;
        double br = 5;
        while (true) {
            bx = Math.random() * 1000;
            by = Math.random() * 1000;
            if (player.x*player.x-bx*bx+player.y*player.y-by*by > br + 200)
            {
                break;
            }
        }
        Bullet b = new Bullet();
        b.x = bx;
        b.y = by;
        b.vx = player.x - bx;
        b.vy = player.y - by;
        b.speed = 2;
        double l = Math.sqrt(b.vx*b.vx+b.vy*b.vy);
        b.vx = (b.vx / l)*b.speed;
        b.vy = (b.vy / l)*b.speed;
        enemybullets.add(b);
    }

    public void updateLives()
    {
        controller.livecount.setText(lives.toString());
    }

    @Override
    public void run() {
        int frametime = 1000/fps;
        long currenttime = System.currentTimeMillis();
        long diff;
        int currentframe = 0;
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
            currentframe++;
            render();
            if (!pause) {
                update();
                if (bulletframe != 0 && currentframe % bulletframe == 0) {
                    CreateEnemyBullet();
                }
            }
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
        System.out.println(Input.mx + ":" + Input.my);
        //Input
        if (Input.keyPressed[Input.key_w]) {
            player.y -= player.speed;
        }
        if (Input.keyPressed[Input.key_s]) {
            player.y += player.speed;
        }
        if (Input.keyPressed[Input.key_a]) {
            player.x -= player.speed;
        }
        if (Input.keyPressed[Input.key_d]) {
            player.x += player.speed;
        }
        if (Input.keyClick[Input.key_a]) {


        }
        //Bullets move
        ArrayList<Bullet> removebullets = new ArrayList<>();
        for (var b : bullets) {
            b.x += b.vx;
            b.y += b.vy;
            b.tickLiveTime--;
            if (b.tickLiveTime <= 0) {
                removebullets.add(b);
            }
        }
        for (var b : removebullets) {
            bullets.remove(b);
        }
        //Targets
        ArrayList<Target> removetargets = new ArrayList<>();
        for (var t : targets) {
            for (var b : bullets) {
                if (b.collides(t)) {
                    removetargets.add(t);
                }
            }
        }
        for (var t : removetargets) {
            if (targets.remove(t)) {
                targets.add(new Target(screen.getWidth(), screen.getHeight()));
                String score = controller.scorecount.getText();
                Integer scoreint = Integer.parseInt(score);
                scoreint++;
                controller.scorecount.setText(scoreint.toString());
            }

        }
        //Enemybullets
        removebullets.clear();
        for (var b : enemybullets) {
            b.x += b.vx;
            b.y += b.vy;
            b.tickLiveTime--;
            if (b.tickLiveTime <= 0 || b.collides(player)) {
                removebullets.add(b);
            }
            if (b.collides(player)) {
                lives--;
                updateLives();
                if (lives==0)
                    pause = true;
            }
        }
        for (var b : removebullets) {
            enemybullets.remove(b);
        }
        Input.update();
    }

    public void render()
    {
        //clear all screen
        gc.clearRect(0,0,1024,1000);
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
        gc.setFill(Color.RED);
        for (var t : enemybullets) {
            gc.fillOval(t.x-t.r,t.y-t.r,t.r,t.r);
        }
    }
}
