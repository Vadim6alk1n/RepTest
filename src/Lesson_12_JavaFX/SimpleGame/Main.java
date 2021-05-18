package Lesson_12_JavaFX.SimpleGame;

import SimpleGame.game.Game;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application {

    //launch app
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        primaryStage.setTitle("Conway");
        int screenWidth = 1024;
        int screenHeight = 768;
        Scene scene = new Scene(root,screenWidth,screenHeight);
        primaryStage.setScene( scene);

        //create game thread and run it
        SimpleGame.game.Game game = new Game(primaryStage,scene,root);
        game.init();
        Thread gamethread = new Thread(game);
        gamethread.start();

        //when window is closing, kill also all other threads
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent e) {
                Platform.exit();
                System.exit(0);
            }
        });
        //primaryStage.show();
    }
}
