

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Member extends Application{

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Pane root = FXMLLoader.load(getClass().getResource("Member.fxml"));
		
		Scene scene = new Scene(root);
		primaryStage.setTitle("컨트롤 객체 연습");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}

}
