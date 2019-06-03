package kr.or.ddit.basic;

import java.util.Optional;

import javax.swing.text.html.Option;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

public class T08_AlertTest extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Alert alertInformation = new Alert(AlertType.INFORMATION);
		alertInformation.setTitle("INFORMATION");
		alertInformation.setHeaderText("정보야~~");
		
		alertInformation.setContentText("INFORMATION Alert 창 입니다");
		alertInformation.showAndWait(); // Alert 창 보이기
		// ======================================
		Alert alertError = new Alert(AlertType.ERROR);
		alertError.setTitle("ERROR");
		alertError.setHeaderText("에러야~~");
		alertError.setContentText("ERROR Alert 창 입니다");
		alertError.showAndWait(); // Alert 창 보이기
		// ======================================

		Alert alertWarning = new Alert(AlertType.WARNING);
		alertWarning.setTitle("WARNING");
		alertWarning.setHeaderText("경고야~~");
		alertWarning.setContentText("WARNING Alert 창 입니다");
		alertWarning.showAndWait(); // Alert 창 보이기

		// ======================================
		Alert alertConfirm = new Alert(AlertType.CONFIRMATION);
		alertWarning.setTitle("CONFIRMATION");
		alertWarning.setContentText("CONFIRMATION Alert 창 입니다");

		// Alert창을 보여주고 사용자가 누른 버튼값 읽어오기
		ButtonType confirmResult = alertConfirm.showAndWait().get();

		if (confirmResult == ButtonType.OK) {
			System.out.println("Ok 버튼을 눌렀습니다");
		} else if (confirmResult == ButtonType.CANCEL) {
			System.out.println("취소 버튼을 눌렀습니다");
		}
		// ======================================
		// javascript의 prompt창과 같은 기능
		// 기본값은 생략가능
		TextInputDialog javaPrompt = new TextInputDialog("기본값");

		javaPrompt.setTitle("Prompt창");
		javaPrompt.setHeaderText("TextInputDialog창 입니다");

		// 창을 보이고 입력한 값을 읽어오기
		Optional<String> result = javaPrompt.showAndWait();
		String strResult = null;

		if (result.isPresent()) {
			strResult = result.get();
		}
		System.out.println("읽어온 값 : " + strResult);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
