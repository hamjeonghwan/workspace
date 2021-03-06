package kr.or.ddit.basic;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FxExamMain extends Application{
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Pane root = FXMLLoader.load(getClass().getResource("FxExam.fxml"));
		
		Scene scene = new Scene(root);
		primaryStage.setTitle("컨트롤객체연습");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
}
