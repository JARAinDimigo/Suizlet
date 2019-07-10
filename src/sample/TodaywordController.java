package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class TodaywordController {
    @FXML
    public ListView<String> EngList;
    public ListView<String> KorList;
    public Button LoadALL;
    public Button EngOnly;
    public Button KorOnly;
    public Button home;

    @FXML
    public void LoadALL(ActionEvent event) throws IOException {
        Clear();
        Kor_Load();
        Eng_Load();
    }

    @FXML
    public void EngOnly(ActionEvent event) throws IOException {
        Clear();
        Eng_Load();
    }

    @FXML
    public void KorOnly(ActionEvent evnet) throws IOException {
        Clear();
        Kor_Load();
    }

    @FXML
    private void Eng_Load() throws IOException {
        String URL = "https://learn.dict.naver.com/m/endic/wordbook/mhs/100006/200068/words.nhn?filterType=0&orderType=2&pageNo=2";
        Document doc = Jsoup.connect(URL).get();
        Elements elem = doc.select(".words");
        String str = elem.text();
        String[] list = str.split("\\s");
        for(String english : list) {
            EngList.getItems().add(english);
        }
    }

    @FXML
    private void Kor_Load() throws IOException {
        String URL = "https://learn.dict.naver.com/m/endic/wordbook/mhs/100006/200068/words.nhn?filterType=0&orderType=2&pageNo=2";
        Document doc = Jsoup.connect(URL).get();
        Elements elem = doc.select(".txt_ct2");
        String str = elem.text();
        System.out.println(str);
        String[] list = str.split("\\[");
        for(int i=1; i<list.length; i++) {
            KorList.getItems().add(list[i]);
        }
    }

    @FXML
    public void Clear() {
        EngList.getItems().clear();
        KorList.getItems().clear();
    }

    @FXML
    public void buttonClick(ActionEvent event) throws IOException {

        Stage stage = (Stage) home.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("intro.fxml"));

        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();

        IntroController ctrl = loader.getController();
    }
}
