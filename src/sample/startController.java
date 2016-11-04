package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Vector;

public class startController implements Initializable {
    @FXML
    private Button startButton;
    @FXML
    private Button helpButton;
    @FXML
    private Button exitButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        startButton.setOnMouseClicked(event -> {
            try {
                GridPane root = FXMLLoader.load(getClass().getResource("select.fxml"));
                Scene scene = new Scene(root);
                Main.getPrimaryST().setScene(scene);
                Main.getPrimaryST().show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        helpButton.setOnMouseClicked(event -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Look, an Information Dialog");
            alert.setContentText("I have a great message for you!");

            alert.showAndWait();
        });
        exitButton.setOnMouseClicked(event -> {
            Platform.exit();
            System.exit(0);
        });
    }
}
