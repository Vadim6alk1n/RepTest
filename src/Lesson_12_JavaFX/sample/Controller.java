package Lesson_12_JavaFX.sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class Controller {
    @FXML
    public Label mycounter;
    public static Label actualcounter;

    @FXML
    public void initialize()
    {
        actualcounter = mycounter;
    }
    public static void IncreaseCounter()
    {
        String msg = actualcounter.getText();
        String[] strarr = msg.split(":");
        Integer newInt = Integer.parseInt(strarr[1]) + 1;
        actualcounter.setText(strarr[0] + ":" + newInt);
    }
}
