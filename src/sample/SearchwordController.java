package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SearchwordController implements Initializable {
    @FXML private WebView Dic;
    @FXML public Button start;
    @FXML public Button outgo;

    WebEngine webEngine;

    public void buttonClick(ActionEvent event) throws IOException {

        Stage stage = (Stage) outgo.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("intro.fxml"));

        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();

        IntroController ctrl = loader.getController();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        webEngine = Dic.getEngine();
        webEngine.load("https://endic.naver.com/popManager.nhn?sLn=kr&m=miniPopMain");
    }
}

