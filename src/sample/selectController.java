package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

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
    public static int playertype=0;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        male.setOnMouseClicked(event -> nextStep(1));
        female.setOnMouseClicked(event -> nextStep(2));
    }

    private void nextStep(int playerType){
        playertype = playerType;
        try {
            GridPane root = FXMLLoader.load(getClass().getResource("sample.fxml"));
            Scene scene = new Scene(root);
            Main.getPrimaryST().setScene(scene);
            Main.getPrimaryST().show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
