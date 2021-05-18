package Lesson_12_JavaFX.Conway;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import Lesson_12_JavaFX.sample.Controller;

import java.util.Collections;

public class ConwayMain extends Application {

    //launch app
    public static void main(String[] args) {
        launch(args);
    }

    //consts for cell states
    final int deadcell = 0;
    final int alivecell = 1;
    Pane root;
    GraphicsContext gc;
    int screenWidth;
    int screenHeight;

    int[][] field; //game field
    int[][] tmpfield; //next game field
    int fieldwidth;
    int fieldheight;

    //mouse interaction variables
    private boolean mousePressed;
    private int cellswapedx;
    private int cellswapedy;
    final int clicktypeLButton = 1;
    final int clicktypeRButton = 2;
    final int clicktypeMButton = 3;
    private int clicktype;       //which mouse button was clicked
    private int cellswapedfirst; //first cell value that was swaped

    @Override
    public void init() throws Exception {
        super.init();
        screenWidth = 1000;
        screenHeight = 1000;
        initField(50,50);
        mousePressed = false;
    }

    //create field
    public void initField(int w, int h)
    {
        fieldwidth = w;
        fieldheight = h;
        field = new int[w+2][];
        tmpfield = new int[w+2][];
        for (int i = 0;i<w+2;i++)
        {
            field[i] = new int[h+2];
            tmpfield[i] = new int[h+2];
        }
        fillField(deadcell);
        for (int i=0;i<=fieldwidth;i++) field[i][0] = deadcell;
        for (int i=0;i<=fieldwidth;i++) field[i][fieldheight+1] = deadcell;
        for (int i=0;i<=fieldheight;i++) field[0][i] = deadcell;
        for (int i=0;i<=fieldheight;i++) field[fieldwidth+1][i] = deadcell;
    }
    //fill all field with some value
    public void fillField(int v)
    {
        for (int i=1; i<=fieldheight;i++)
        {
            for (int j=1;j<=fieldwidth;j++)
            {
                field[j][i] = v;
            }
        }
    }
    //fill all field with random value
    public void randomizeField()
    {
        for (int i=1; i<=fieldheight;i++)
        {
            for (int j=1;j<=fieldwidth;j++)
            {
                field[j][i] = (int)(Math.random()*2);
            }
        }
    }
    //invert value and remember what cell was swapped
    private void swapcell(int x,int y)
    {
        if (field[x][y] == alivecell) field[x][y] = deadcell;
        else field[x][y] = alivecell;
        cellswapedx = x;
        cellswapedy = y;
        render(gc);
    }
    //mouse pressed event
    private void press(MouseEvent e) {
        //Left mouse button
        if (e.getButton() == MouseButton.PRIMARY)
        {
            clicktype = clicktypeLButton;
        }
        //Right mouse button
        if (e.getButton() == MouseButton.SECONDARY)
        {
            clicktype = clicktypeRButton;
        }
        //Middle mouse button
        if (e.getButton() == MouseButton.MIDDLE)
        {
            clicktype = clicktypeMButton;
        }

        //calculate cell
        double mx = e.getX();
        double my = e.getY();
        int cw = (screenWidth)/fieldwidth;
        int ch = (screenHeight-200)/fieldheight;
        int cx = (int)(mx / cw) + 1;
        int cy = (int)(my / ch) + 1;
        System.out.println(mx + " : " + my);
        System.out.println(cx + " : " + cy);
        //if middle then invert cell
        if (clicktype == clicktypeMButton)
        {
            swapcell(cx,cy);
            return;
        }
        //if left then make cells alive
        if (clicktype == clicktypeLButton)
        {
            cellswapedfirst = alivecell;
        }
        //if right then make cells dead
        else if (clicktype == clicktypeRButton) {
            cellswapedfirst = deadcell;
        }
        //remember selected cell
        cellswapedx = cx;
        cellswapedy = cy;
        if (field[cx][cy] != cellswapedfirst) swapcell(cx,cy);
        //redraw field
        render(gc);
    }
    //mouse moved event
    private void moved(MouseEvent e)
    {
        //calculate cell coordinates
        double mx = e.getX();
        double my = e.getY();
        int cw = (screenWidth)/fieldwidth;
        int ch = (screenHeight-200)/fieldheight;
        int cx = (int)(mx / cw) + 1;
        int cy = (int)(my / ch) + 1;
        if (cellswapedx == cx && cellswapedy == cy) return; // if current cell was already changed then skip
        if (clicktype == clicktypeMButton) //if middle then swap
        {
            swapcell(cx,cy);
            return;
        }

        cellswapedx = cx;
        cellswapedy = cy;
        field[cx][cy] = cellswapedfirst;
        render(gc);
    }

    @Override
    public void start(Stage primaryStage) {
        root = new Pane();
        primaryStage.setTitle("Conway");
        primaryStage.setScene( new Scene(root,screenWidth,screenHeight));
        //canvas where field will be drawn
        var canvas = new Canvas(screenWidth, screenHeight-200);
        canvas.setLayoutY(200);
        //mouse event only for canvas
        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED,this::press);
        canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED,this::moved);
        //graphics context of canvas which will be used for drawing field
        gc = canvas.getGraphicsContext2D();

        //UI
        var stepButton = new Button("Next step");
        stepButton.setLayoutX(20);
        stepButton.setLayoutY(20);
        //generate next generation
        stepButton.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                updateField();
                render(gc);
            }
        });

        var randButton = new Button("Randomize!!!");
        randButton.setLayoutX(100);
        randButton.setLayoutY(20);
        randButton.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
               randomizeField();
               render(gc);
            }
        });

        var clearButton = new Button("Clear");
        clearButton.setLayoutX(200);
        clearButton.setLayoutY(20);
        clearButton.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                fillField(deadcell);
                render(gc);
            }
        });

        //Field generation fields
        var widthtextfield = new TextField();
        widthtextfield.setLayoutX(600);
        widthtextfield.setLayoutY(20);
        widthtextfield.setMaxWidth(50);
        //when clicked on textfield set it's style to none(default)
        widthtextfield.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                widthtextfield.setStyle("");
            }
        });

        var heighttextfield = new TextField();
        heighttextfield.setLayoutX(660);
        heighttextfield.setLayoutY(20);
        heighttextfield.setMaxWidth(50);
        heighttextfield.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                heighttextfield.setStyle("");
            }
        });

        //Create new field button
        var createButton = new Button("Create");
        createButton.setLayoutX(720);
        createButton.setLayoutY(20);
        createButton.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                //Read new field size from textfields
                String wstr = widthtextfield.getText();
                String hstr = heighttextfield.getText();
                int w;
                int h;
                //try to parse them to int
                try
                {
                    w = Integer.parseInt(wstr);
                    h = Integer.parseInt(hstr);
                    boolean err = false;
                    //if invalid values
                    if (!(w>0 && w< 200))
                    {
                        //Error
                        err = true;
                        widthtextfield.setStyle("-fx-effect: innershadow(one-pass-box, red, 100, 0.1, 1, 1);");
                    }
                    if (!(h>0 && h< 200))
                    {
                        //Error
                        err = true;
                        heighttextfield.setStyle("-fx-effect: innershadow(one-pass-box, red, 100, 0.1, 1, 1);");
                    }
                    if (err) return;
                    initField(w,h);
                    render(gc);

                }catch (Exception e)
                {
                    System.out.println(e.getMessage());
                }
            }
        });
        //add all ui to root
        root.getChildren().add(widthtextfield);
        root.getChildren().add(heighttextfield);
        root.getChildren().add(createButton);
        root.getChildren().add(stepButton);
        root.getChildren().add(randButton);
        root.getChildren().add(clearButton);
        root.getChildren().add(canvas);

        render(gc);
        primaryStage.show();

    }
    //generate new generation
    private void updateField()
    {
        for(int y=1;y<=fieldheight;y++)
        {
            for(int x=1;x<=fieldwidth;x++)
            {
                int n = 0;
                if (field[x-1][y-1]==alivecell) n++;
                if (field[x-1][y]==alivecell) n++;
                if (field[x-1][y+1]==alivecell) n++;
                if (field[x][y-1]==alivecell) n++;
                if (field[x][y+1]==alivecell) n++;
                if (field[x+1][y-1]==alivecell) n++;
                if (field[x+1][y]==alivecell) n++;
                if (field[x+1][y+1]==alivecell) n++;

                if (field[x][y]==deadcell)
                {
                    if (n==3) {
                        tmpfield[x][y] = alivecell;
                    }
                    else
                    {
                        tmpfield[x][y] = deadcell;
                    }
                }
                else
                {
                    if (n<2 || n>3)
                    {
                        tmpfield[x][y] = deadcell;
                    }
                    else
                    {
                        tmpfield[x][y] = alivecell;
                    }
                }
            }
        }
        var t = field;
        field = tmpfield;
        tmpfield = t;
    }

    private void render(GraphicsContext gc) {
        //clear all screen
        gc.clearRect(0,0,1000,1000);
        //cell size
        int cw = (screenWidth)/fieldwidth;
        int ch = (screenHeight-200)/fieldheight;
        //draw field
        for( int y = 1;y<=fieldheight;y++)
        {
            for (int x = 1;x<=fieldwidth;x++)
            {
                if (field[x][y]==alivecell)
                    gc.setFill(Color.BLACK);
                else
                    gc.setFill(Color.WHITESMOKE);
                gc.fillRect((x-1) * cw,(y-1)*ch,cw,ch);
            }
        }
        //Draw grid
        for( int y = 1;y<=fieldheight;y++)
        {
            for (int x = 1;x<=fieldwidth;x++)
            {
                gc.setFill(Color.DARKGRAY);
                gc.strokeRect((x-1) * cw,(y-1)*ch,cw,ch);
            }
        }
    }
}
