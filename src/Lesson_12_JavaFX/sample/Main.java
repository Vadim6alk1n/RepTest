package Lesson_12_JavaFX.sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;

import java.util.Map;

public class Main extends Application {

    private int ScreenWidth;
    private int ScreenHeight;

    private Color RectColor;
    //Application initialization. Init calls before start, but it doesn't have any stage yet.
    @Override
    public void init() throws Exception {
        super.init();
        ScreenHeight = 500;
        ScreenWidth = 1000;
        RectColor = new Color(Math.random(),Math.random(),Math.random(),1);
    }
    //Application start. Create all ui and add scene.
    @Override
    public void start(Stage primaryStage) throws Exception{
        //Main Pane; root
        var root = new Pane();
        //load sample.fxml, take it from resourse. Resources are contained within JAR file.
        Parent sampl = FXMLLoader.load(getClass().getResource("sample.fxml"));


        //Creating a Text object
        Text text = new Text();
        text.setFont(new Font(45));
        text.setX(50);
        text.setY(150);
        text.setText("Ho-ho-ho, it's my text. И оно может в юникод.");

        //drawzone will contain rectangles
        var drawzone = new Group();

        //Buttons
        var buttonPane = new Pane();
        buttonPane.setPrefSize(ScreenWidth-40,100);
        buttonPane.setLayoutX(20);
        buttonPane.setLayoutY(20);

        //button zone view
        var rect = new Rectangle();
        rect.setFill(Color.TRANSPARENT);
        rect.setStroke(Color.DARKGRAY);

        //bind properties. if buttonPane changes property value, then rect also changes it so same value.
        rect.widthProperty().bind(buttonPane.widthProperty());
        rect.heightProperty().bind(buttonPane.heightProperty());

        //Drop shadow effect when mouse is overlapping button
        DropShadow shadow = new DropShadow();
        var button1 = new Button("My Button1");
        button1.setLayoutX(0);
        //add event of overlapped mouse.
        button1.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        button1.setEffect(shadow);
                    }
                });
        //Removing the shadow when the mouse cursor is off
        button1.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        button1.setEffect(null);
                    }
                });

        //Try to update text by button without controller
        Text counter = new Text();
        counter.setLayoutX(50);
        counter.setLayoutY(-5);
        counter.setText("Main counter:0");


        //Mouse clicked event for counter. Calls Controller.IncreaseCounter static method.
        var button2 = new Button("Increase counter");
        button2.setLayoutX(80);
        button2.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Controller.IncreaseCounter();
                String counterstr = counter.getText();
                String[] strarr = counterstr.split(":");
                Integer newInt = Integer.parseInt(strarr[1]) + 1;
                counter.setText(strarr[0] + ":" + newInt);
            }
        });

        //color radio button
        ToggleGroup radioGroup = new ToggleGroup();
        var colorRadio = new RadioButton();
        colorRadio.setText("Randomize Color");
        colorRadio.setLayoutY(40);
        colorRadio.setToggleGroup(radioGroup);
        colorRadio.setSelected(true);
        var colorRadioneg = new RadioButton();
        colorRadioneg.setText("Don't randomize Color");
        colorRadioneg.setLayoutY(60);
        colorRadioneg.setToggleGroup(radioGroup);

        //button creates new rect in drawzone
        var button3 = new Button("Add rectangle to drawzone");
        button3.setLayoutX(ScreenWidth-40-80);
        button3.setLayoutY(40);

        button3.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Rectangle newRect = new Rectangle();
                newRect.setWidth(Math.random()*50+10);
                newRect.setHeight(Math.random()*50+10);
                newRect.setX(Math.random()*(ScreenWidth-100));
                newRect.setY(Math.random()*(ScreenHeight - 100));
                if (colorRadio.isSelected()) {
                    RectColor = new Color(Math.random(), Math.random(), Math.random(), 1);
                }
                newRect.setFill(RectColor);
                drawzone.getChildren().add(newRect);
            }
        });

        //add buttons and rectangle to pane
        buttonPane.getChildren().add(rect);
        buttonPane.getChildren().add(button1);
        buttonPane.getChildren().add(button2);
        buttonPane.getChildren().add(button3);
        buttonPane.getChildren().add(colorRadio);
        buttonPane.getChildren().add(colorRadioneg);
        buttonPane.getChildren().add(counter);

        drawzone.setLayoutX(20);
        drawzone.layoutYProperty().bind(buttonPane.heightProperty());

        //add all to root
        root.getChildren().add(buttonPane);
        root.getChildren().add(text);
        root.getChildren().add(drawzone);
        root.getChildren().add(sampl);


        //add webview
        WebView webView = new WebView();
        webView.getEngine().load("http://google.com");
        VBox vBox = new VBox(webView);
        vBox.setLayoutX(ScreenWidth);
        vBox.setLayoutY(0);
        vBox.setPrefWidth(1000);
        vBox.setPrefHeight(1000);
        root.getChildren().add(vBox);

        //create scene and set it to stage
        var scene = new Scene(root, ScreenWidth, ScreenHeight);
        primaryStage.setTitle("Lines");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    //launch app
    public static void main(String[] args) {
        launch(args);
    }
}
