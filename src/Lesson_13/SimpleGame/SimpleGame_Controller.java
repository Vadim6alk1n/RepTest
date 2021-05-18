package Lesson_13.SimpleGame;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.text.Text;

public class SimpleGame_Controller {
    public Game game;
    @FXML
    public Text scorecount;
    @FXML
    public Text livecount;
    @FXML
    public void restartlevel()
    {
        scorecount.setText("0");
        game.Restart();
    }

    @FXML
    public void quitgame()
    {
        Platform.exit();
        System.exit(0);
    }
    @FXML
    public void aboutaction()
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About Simple Game");
        alert.setHeaderText(null);
        alert.setContentText("This is about menu dialog!\n" +
                             "Program made for Progmeistars lecture purpose");

        alert.showAndWait();
    }
}
