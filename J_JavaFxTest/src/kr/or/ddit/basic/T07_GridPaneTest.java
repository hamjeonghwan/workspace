package kr.or.ddit.basic;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class T07_GridPaneTest extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		GridPane gridPane = new GridPane();
		gridPane.setPrefSize(270, 200);
		gridPane.setPadding(new Insets(10));
		gridPane.setHgap(10);
		gridPane.setVgap(20);

		Label label1 = new Label("아 이 디  : ");
		Label label2 = new Label("패스워드 : ");

		TextField textField1 = new TextField();
		// 컨트롤의 글자색, 배경색, 배경이미지등은 CSS를 이용하여 설정할 수 있다
		textField1.setStyle("-fx-text-fill:red; -fx-background-color:green;");

		// TextField textField2 = new TextField();
		PasswordField passwordField = new PasswordField();

		Button button1 = new Button("로그인");
		Button button2 = new Button("취 소");

		// GridPane에 컨트롤을 추가하는 방법
		// 객체변수(gridPane).add(추가할 컨트롤, 칸번호, 행번호, colspan수, rowspan수);
		gridPane.add(label1, 1, 1);
		gridPane.add(label2, 1, 2);
		gridPane.add(textField1, 3, 1, 2, 1);
		gridPane.add(passwordField, 3, 2, 2, 1);
		gridPane.add(button1, 3, 4);
		gridPane.add(button2, 4, 4);

		gridPane.setStyle(" -fx-background-color:yellow;");

		Scene scene = new Scene(gridPane);
		primaryStage.setTitle("GridPane연습");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
