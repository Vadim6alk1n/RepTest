package Lesson_13;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JavaFX_FXML extends Application {
    public static void main(String[] args) { launch(args);}

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("res/fxml_ui.fxml"));

        Scene scene = new Scene(root, 500, 400);

        stage.setTitle("FXML Example");
        stage.setScene(scene);
        stage.show();
    }
}
