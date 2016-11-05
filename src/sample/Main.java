package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.ArrayList;

public class Main extends Application {



    public static Stage getPrimaryST() {
        return primaryST;
    }

    public static void setPrimaryST(Stage primaryST) {
        Main.primaryST = primaryST;
    }

    private static Stage primaryST;



    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryST = primaryStage;
        GridPane root = FXMLLoader.load(getClass().getResource("start.fxml"));
        primaryStage.setTitle("Acidrain");
        Scene scene = new Scene(root, 1024, 768);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setOnCloseRequest(event -> {
            Platform.exit();
            System.exit(0);
        });
        scene.setOnMouseClicked(event -> System.out.println("X-"+event.getX()+" Y-"+event.getY()));

//        ArrayList<Label> labels = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            labels.add(new Label(words[(int) (Math.random() * 10)]));
//            try {
//                Controller.getHbox1().getChildren();
//            } catch (NullPointerException e) {
//                e.printStackTrace();
//            }
//        }


    }


    public static void main(String[] args) {
        launch(args);
    }
}
