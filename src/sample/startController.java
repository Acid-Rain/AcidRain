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
            alert.setTitle("메뉴얼");
            alert.setHeaderText("메뉴얼");
            alert.setContentText("\n" +
                    "게임소개\n" +
                    "‘극성비’ 단어 게임에 오신 것을 환영합니다.\n" +
                    "하늘에서 떨어지는 단어들!\n" +
                    "단어들을 입력하고 분해해 주세요!\n" +
                    "\n" +
                    "게임 규칙\n" +
                    "하늘에서 단어가 랜덤하게 떨어지면 아래에 있는 입력창에 그 단어를 입력하면 단어가 분해된다.\n" +
                    "n라운드 까지 있으며 라운드가 올라갈수록 단어가 떨어지는 속도가 증가한다.\n" +
                    "단어를 분해하지 못하고 땅에 떨어지면 하트 한 개가 소모된다.\n" +
                    "파란색 단어를 입력하면 체력이 1 증가한다.\n" +
                    "하트는 총 3개가 있으며 모든 하트가 소모될 시 게임이 종료된다.\n" +
                    "단어 한 개당 10점씩 점수가 오른다.\n" +
                    "\n" +
                    "3. 게임 시작 버튼을 누르면 2개의 캐릭터를 고를 수 있고 그 후 이름 설정.\n" +
                    "4. 시작 버튼을 누르면 게임 시작.\n" +
                    "5. 게임 종료 시 점수, 이름, 캐릭터가 랭킹에 점수별로 등록");

            alert.showAndWait();
        });
        exitButton.setOnMouseClicked(event -> {
            Platform.exit();
            System.exit(0);
        });
    }
}
