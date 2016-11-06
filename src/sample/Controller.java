package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Vector;

public class Controller implements Initializable {
    Vector<Text> Texts = new Vector<>(); // 동시에 접근하는 경우가 빈번하기 때문에 Vector로 선언

    private String words[] = {"신체질량지수", "청춘예찬", "입법고시", "신록예찬", "직할시장", "지식정보화시대", "황사현상", "노블레스 오블리주", "지성감천", "천우신조", "정신일도", "효도", "신호등", "메일", "카페", "블로그", "사전", "뉴스", "증권", "부동산", "지도", "영화", "책", "스케치북", "전통시장", "코스피", "충성", "공경", "우애", "근검", "절약", "국가", "민족", "국기", "국화", "태극기", "무궁화", "교사", "가정", "학생", "교훈", "학교", "가훈", "건국이념", "경부고속전철", "홍익인간", "핵가족", "구문론", "문장론", "우편번호", "전화번호", "십이지신", "춘하추동", "동서남북", "춘분", "청명", "성인군자", "대통령", "사법고시", "명예퇴직", "훈장", "특별시장", "도지사", "주연배우", "주인공", "인공위성", "환경보호", "프로그램", "올림픽", "리더십", "인터넷", "노트북", "헤어스타일", "스타킹", "에어콘", "아마추어", "아르바이트", "유토피아", "스포츠맨쉽", "산타클로스", "새마을운동", "이사장", "고아원", "기부", "안산", "시흥", "원주", "서울", "스트레스", "시계", "돼지", "하이힐", "수소", "헬륨", "리튬", "베릴륨", "붕소", "탄소", "질소", "산소", "플루오린", "네온", "나트륨", "마그네슘", "알루미늄", "규소", "인", "황", "염소", "아르곤", "칼륨", "칼슘", "스칸듐", "티탄", "바나듐", "크롬", "망간", "철", "코발트", "니켈", "구리", "아연", "갈륨", "게르마늄", "비소", "셀렌", "브롬", "크립톤", "루비듐", "스트론튬", "이트륨", "지르코늄", "니오브", "몰리브덴", "테크네튬", "루테늄", "로듐", "팔라듐", "은", "카드뮴", "인듐", "주석", "안티몬", "요오드", "크세논", "세슘", "바륨", "란탄", "세륨", "프라세오디뮴", "네오디뮴", "프로메튬", "사마륨", "유로퓸", "가돌리늄", "테르븀", "디스프로슘", "홀뮴", "에르븀", "이테르븀", "탄탈", "텅스텐", "레늄", "오스뮴", "이리듐", "백금", "금", "수은", "탈륨", "납", "비스무트", "폴로늄", "아스타틴", "라돈", "프란슘", "라듐", "악티늄", "토륨", "프로트악티늄", "우라늄", "넵투늄", "플루토늄", "아메리슘", "쿼륨", "버클륨", "칼라포르늄", "아인시타이늄", "페르뮴", "멘델레븀", "노벨륨", "로렌슘", "러더퍼듐", "두브늄", "스보르기움", "보륨", "하슘", "마이트네륨", "다름슈타튬", "뢴트게늄", "우눈븀", "제노포비아", "동부정맥", "심방조기박동", "다소성 심방빈맥", "심실조기박동", "방실접합부성 이탈박동", "다형성 심실빈맥", "뇌내출혈", "경정맥", "후궁절제술", "충수돌기염", "관상동맥우회술", "에프네프린", "동맥관개존", "심실중격결손", "블러드컬쳐", "크레아틴", "흉복부대동맥류", "대사성산증", "애국가", "백두산", "가나", "가봉", "과테말라", "그리스", "기니", "나이지리아", "남수단공화국", "남아프리카공화국", "네덜란드", "네팔", "노르웨이", "뉴질랜드", "대한민국", "덴마크", "도미니카공화국", "독일", "라오스", "러시아", "레바논", "룩셈부르크", "리비아", "마다가스카르", "말레이시아", "멕시코", "모로코", "몰디브", "몽골", "미국", "미얀마", "바티칸시국", "방글라데시", "베네수엘라", "베트남", "벨기에", "볼리비아", "부탄", "불가리아", "브라질", "사우디아라비아", "수단", "스리랑카", "스웨덴", "스위스", "스페인", "슬로바키아", "슬로베니아", "시리아", "시에라리온", "싱가포르", "아르헨티나", "아이슬란드", "아이티", "아일랜드", "아프가니스탄", "알제리", "앙골라", "에스파냐", "에스토니아", "에콰도르", "에티오피아", "엘살바도르", "예멘", "영국", "오스트리아", "오스트레일리아", "온두라스", "요르단", "우루과이", "우주베키스탄", "우크라이나", "이라크", "이란", "이스라엘", "이탈리아", "인도", "인도네시아", "일본", "자메이카", "잠비아", "중국", "중앙아프리카공화국", "체코", "칠레", "카자흐스탄", "카타르", "캄보디아", "캐나다", "콜롬비아", "콩고", "콩고민주공화국", "쿠바", "크로아티아", "타이", "태국", "타이완", "터키", "토고", "튀니지", "헝가리", "홍콩", "양적완화", "디폴트", "리니언시제도", "어닝 서프라이즈", "어닝 쇼크", "디마케팅", "매몰비용", "엥겔지수", "라면", "국물", "육수", "메밀", "우동", "튀김", "찹쌀", "보리", "조", "수수", "콩", "팥", "녹두", "밤", "잡곡밥", "야채", "육류", "비빔밥", "버섯", "해산물", "만두", "노인", "유아", "환자", "흰죽", "약식", "쌀국수", "김치만두", "흰떡국", "조랭이떡", "곰국", "소고기무국", "명엽채", "마늘", "방울토마토", "제육덮밥", "어묵볶음", "연근조림", "숙주나물", "푸딩", "부대찌개", "생선", "옥수수", "도토리묵", "깍두기", "바나나", "치즈볼", "우유", "반계탕", "가지나물", "불고기", "나쵸", "딸기", "단무지", "떡갈비", "견과류", "피자", "스파게티", "오이", "피클", "감자탕", "호박", "느타리버섯", "키위", "핫도그", "참치", "메추리알", "청포묵", "파인애플", "카레라이스", "치즈", "우거지해장국", "미트볼", "요구르트", "탕수육", "짜장면", "짬뽕", "탕평채", "양파", "망고", "연두부", "햄버거", "호떡", "콩자반", "사과", "콩나물국", "스팸", "쇠고기스프", "동그랑땡", "춘권튀김", "미역국", "삼겹살", "보쌈", "양배추", "귤", "문어", "하늘"};
    @FXML
    private Button startButton1;
    @FXML
    private Pane gamePane;
    @FXML
    private TextField textInput;
    @FXML
    private ProgressBar lifeBar;
    int wordsTyped = 0; // 없앤 단어의 수
    int life = 100; // 생명

    public ImageView getPlayer() {
        return player;
    }

    public void setPlayer(ImageView player) {
        this.player = player;
    }

    private ImageView player; //플레이어타입(캐릭터)객체 변수

    String appMain = System.getProperty("user.dir");
    String gender;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        player = selectController.playertype; //플레이어 선택 화면에서 캐릭터 정보를 넘겨받아옴
        gender = player.getImage().impl_getUrl().endsWith("woman_excited.png")?"woman":"man";
        player.setFitWidth(150);
        player.setFitHeight(150);
        player.setLayoutX(1024 - 150);
        player.setLayoutY(768 - 150);
        player.setImage(new Image("file:"+appMain+"/src/sample/img/"+gender+"_normal.png"));
        gamePane.getChildren().add(player);

        startButton1.setOnAction(event -> { //게임 시작하는 버튼에 이벤트 바인딩
            startButton1.setVisible(false); // 시작버튼을 보이지않도록 수정
            Texts = new Vector<Text>(); // 모든 단어들이 저장될 벡터 생성
            textInput.requestFocus(); //시작시 글씨입력칸에 커서 생성
            try {
                game(1000, 1); //1초마다 단어가 1개씩 생성되서 떨어짐
            } catch (InterruptedException e) { //예외처리가 일어날 시 쓰레드 잠시 중단
                e.printStackTrace(); //예외처리가 일어난 부분 확인하는 것
            }
        });

        textInput.setOnKeyPressed(event -> { //event에 있는 값을 받아서
            if (event.getCode().equals(KeyCode.ENTER)) { //event에 있는 getCode에서 KeyCode가 엔터이면
                System.out.println("Enter Key Pressed."); //출력
                boolean isCorrect = false;
                for (int i = 0; i < Texts.size(); i++) { //모든 레이블을 체크하여 글자가 일치하는 요소가 있을 경우 요소를 지우고 입력칸을 비움
                    if (Texts.get(i).getText().equals(textInput.getText())) { //레이블에 입력한 것과 떨어지는 요소중 글자가 같게된다면
                        delWord(i); // 단어 삭제
                        textInput.setText(""); // 단어 입력칸을 빈칸으로
                        isCorrect = true;
                    }
                }
                if(isCorrect){
                    player.setImage(new Image("file:"+appMain+"/src/sample/img/"+gender+"_laughing.png"));
                } else player.setImage(new Image("file:"+appMain+"/src/sample/img/"+gender+"_upset.png"));
            }
        });
    }

    private void game(int interval, int genAmount) throws InterruptedException { // interval:단어가 떨어지는 간격(ms) genAmount:페이즈마다 생성되는 단어 수
//        private Task<Void> task = null;
        life = 100; //생명을 100으로
        lifeBar.setProgress(life / 100); //게임에 있는 생명바 표시
//        lifeBar.progressProperty().bind(task.progressProperty());
        wordsTyped = 0; //자신이 타이핑한 갯수
        new Thread(() -> {
            while (life > 0) { //생명이 0보다 클 동안
                Platform.runLater(() -> { //작업 스레드가 작업 UI를 직접 변경이 불가하므로 event에 저장된 Runnable들은 저장된 순서에 따라 불러옴
                    Texts.forEach(Text -> Text.setLayoutY(Text.getLayoutY() + 50)); // 단어를 아래로 한 단위 이동
                    for (int i = 0; i < genAmount; i++) Texts.add(genWord()); // 단어를 젠하여 리스트에 추가
                });
                for (int i = 0; i < Texts.size(); i++) { //모든 레이블을 체크하여 화면 밖으로 나갔을 경우 요소를 삭제함
                    if (Texts.get(i).getLayoutY() > 768) { //단어들이 화면 Y축의 768보다 클 경우
                        life -= 10; //생명 10 감소
                        lifeBar.setProgress(life / 100.0f); // 프로그레스바는 0.0 ~ 1.0의 값을 가지므로 나누어준다
                        System.out.println("Life decreased. Life : " + life + "\nProgressbar set : " + life / 100.0f); //출력
                        delWord(i); //단어 삭제
                        player.setImage(new Image("file:"+appMain+"/src/sample/img/"+gender+"_upset.png"));
                    }
                }
                try {
                    Thread.sleep(interval); //Interval의 값만큼 시간 간격을 준다.
                } catch (InterruptedException e) { //예외처리가 일어날 시 쓰레드 잠시 중단
                    e.printStackTrace(); //예외처리가 일어난 부분 확인하는 것
                }
            }
            Texts.forEach(Text -> Text.setVisible(false)); //모든 단어를 숨긴다
            Texts.clear(); // Texts의 모든 요소를 삭제
            gamePane.getChildren().removeAll(); //gamepane의 모든 요소 삭제
            player.setImage(new Image("file:"+appMain+"/src/sample/img/"+gender+"_excited.png"));
            startButton1.setVisible(true); //시작버튼을 보이도록 수정
        }).start(); // 스레드를 시작
        /*
        게임을 진행하는 스레드를 생성합니다.
        UI를 관리하는 스레드 자체에 sleep을 주게 되면 UI가 모래시계가 돌면서 멈추는 현상이 발생합니다.
        그렇게 때문에 매인 흐름에서 벗어나는 스레드를 하나 만들고, 그 안에서 다시 UI를 관리할 수 있는 스레드를 생성합니다.
        그리고 sleep의 경우에는 UI를 관리하는 스레드에 주지 않고, 새로 만든 외부 흐름에 주게 됩니다.
        */
    }

    private Text genWord() { //화면 상단에 단어를 생성하는 함수
        System.out.println("Genning Word."); //출력
        Text l = new Text(); //Text 단어 객체 생성
        gamePane.getChildren().add(l); //화면에 단어객체 추가
        l.setText(words[(int) (Math.random() * 426)]); // 단어 배열에서 단어를 랜덤으로 설정
        l.setLayoutY(0); //Y축이 0이 됨
        l.setLayoutX(new Random().nextInt(1000)); //X축좌표 1000범위에서 랜덤으로 객체 생성
        DropShadow borderGlow = new DropShadow();
        borderGlow.setColor(Color.AQUA);
        borderGlow.setOffsetX(0f);
        borderGlow.setOffsetY(0f);
        l.setEffect(borderGlow);
        l.setVisible(true); //단어객체를 화면에 표시
        return l; //생성한 단어 객체 리턴
    }

//    private boolean isExists(List<Integer> l, int num){
//        Iterator<Integer> iter = l.iterator();
//        while (iter.hasNext()){
//            if (iter.next() == num){
//                return true;
//            }
//        }
//        return false;
//    }

    private void delWord(int index) { //화면에 단어를 삭제하는 함수
        Texts.get(index).setVisible(false); // 받아온 인덱스의 단어를 보이지 않도록 설정
//        Platform.runLater(() -> gamePane.getChildren().remove(Texts.get(index)));
        Texts.remove(index); //인덱스 삭제
    }
}
