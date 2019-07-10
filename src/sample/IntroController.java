package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class IntroController {
    @FXML
    private Button TodayWord;
    @FXML
    private Button SearchWord;

    @FXML
    public void buttonClick(ActionEvent event) throws IOException {

        Stage stage = (Stage) TodayWord.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("todayword.fxml"));

        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
        TodaywordController ctrl = loader.getController();
    }

    @FXML
    public void buttonClick2(ActionEvent event) throws IOException {

        Stage stage = (Stage) SearchWord.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SearchWord.fxml"));

        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();

        SearchwordController ctrl = loader.getController();
    }
}
