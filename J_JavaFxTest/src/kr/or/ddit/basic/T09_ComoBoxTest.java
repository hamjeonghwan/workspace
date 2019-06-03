package kr.or.ddit.basic;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class T09_ComoBoxTest extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();
		HBox hBox = new HBox();
		TextArea textArea = new TextArea();
		
		ComboBox<String> comboBox = new ComboBox<>();
		comboBox.getItems().addAll("한강", "금강", "영산강", "낙동강");
		comboBox.getItems().addAll("미시시피강");
		comboBox.setValue("한강"); // 처음에 보이는 부분 데이터 셋팅
		
		// ComboBox의 값이 변경될 때의 처리즉 change 이벤트 처리
		comboBox.valueProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				System.out.println(oldValue + " > " + newValue);
				textArea.setText(newValue);
			}
		});
	ObservableList<String>	 fruitList = FXCollections.observableArrayList(
			"사과", "배", "복숭아", "포도", "감"	
			);
	// 객체 생성 및 데이터 초기화 동시에
	ComboBox<String> comboBox2 = new ComboBox<>(fruitList);
	// 데이터를 초기화 후에 추가하기
	comboBox2.getItems().addAll("대추", "호두");
	comboBox2.setValue("포도");
	
	Button button = new Button("확인");
	button.setOnAction(new EventHandler<ActionEvent>() {
		
		@Override
		public void handle(ActionEvent event) {
			if(comboBox.getValue() != null && comboBox2.getValue() != null) {
				textArea.setText(comboBox.getValue() + "지역에는" + comboBox2.getValue() + "가 유명합니다.");
			}
			
		}
	});
	hBox.setSpacing(10);
	hBox.setPadding(new Insets(10));
	hBox.getChildren().addAll(comboBox, comboBox2, button);
	
	root.setTop(hBox);
	root.setCenter(textArea);
	
	Scene scene = new Scene(root, 500, 400);
	primaryStage.setTitle("comboBox연습");
	primaryStage.setScene(scene);
	primaryStage.show();

	
	}
	public static void main(String[] args) {
		launch(args);
	}
}
