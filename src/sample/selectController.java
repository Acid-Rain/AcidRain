package sample;

import javafx.application.Platform;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Vector;

public class selectController implements Initializable {

    @FXML
    private ImageView male;
    @FXML
    private ImageView female;
    public static ImageView playertype = null;
    String appMain = System.getProperty("user.dir");
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        male.setOnMouseClicked(event -> nextStep(1));
        female.setOnMouseClicked(event -> nextStep(2));
        male.setOnMouseEntered(event -> male.setImage(new Image("file:"+appMain+"/src/sample/img/man_laughing.png")));
        female.setOnMouseEntered(event -> female.setImage(new Image("file:"+appMain+"/src/sample/img/woman_laughing.png")));
        male.setOnMouseExited(event -> male.setImage(new Image("file:"+appMain+"/src/sample/img/man_normal.png")));
        female.setOnMouseExited(event -> female.setImage(new Image("file:"+appMain+"/src/sample/img/woman_normal.png")));
    }

    private void nextStep(int playerType){
        new Thread(()->{
            if(playerType == 1){
                playertype = male;
                male.setImage(new Image("file:"+appMain+"/src/sample/img/man_excited.png"));
                male.setOnMouseEntered(null);
                male.setOnMouseExited(null);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            else {
                playertype = female;
                female.setImage(new Image("file:"+appMain+"/src/sample/img/woman_excited.png"));
                female.setOnMouseEntered(null);
                female.setOnMouseExited(null);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Platform.runLater(() -> {
                try {
                    GridPane root = FXMLLoader.load(getClass().getResource("sample.fxml"));
                    Scene scene = new Scene(root);
                    Main.getPrimaryST().setScene(scene);
                    Main.getPrimaryST().show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }).start();
    }
}
