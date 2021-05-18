package Lesson_13.SimpleGame;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class MainEntry extends Application {

    //launch app
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        VBox root;
        SimpleGame_Controller controller = new SimpleGame_Controller();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../res/shooter_ui.fxml"));
            fxmlLoader.setController(controller);
            root = (VBox) fxmlLoader.load();
        } catch (Exception e)
        {
            e.printStackTrace();
            root = new VBox();
        }
        primaryStage.setTitle("Simple Game");
        int screenWidth = 1024;
        int screenHeight = 768;
        Scene scene = new Scene(root,screenWidth,screenHeight);
        primaryStage.setScene( scene);

        //create game thread and run it
        Game game = new Game(primaryStage,scene,root,controller);
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
