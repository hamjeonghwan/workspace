package kr.or.ddit.basic;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class T10_ComboGugudabMain extends Application{
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = FXMLLoader.load(getClass().getResource("combogugudan.fxml"));
		
		// TODO Auto-generated method stub
//		BorderPane root = new BorderPane();
//		root.setPrefSize(300, 300);
//		
//		HBox hBox = new HBox();
//		hBox.setPadding(new Insets(10));
//		hBox.setSpacing(10);
//		
//		TextArea textAreaResult = new TextArea();
//		textAreaResult.setPrefSize(200, 200);
//		
//		Button buttonDan = new Button("출력");
//		ComboBox<Integer> cmbDan = new ComboBox<>();
//		cmbDan.setPrefWidth(150);
//		
//		ObservableList<Integer> list = FXCollections.observableArrayList(
//				1, 2, 3, 4, 5, 6, 7, 8, 9
//				);
//		
//		cmbDan.setItems(list);
//		
////		cmbDan.setOnAction(new EventHandler<ActionEvent>() {
////			
////			@Override
////			public void handle(ActionEvent event) {
////				int dan = cmbDan.getSelectionModel().getSelectedItem();
////				
////				textAreaResult.setText(dan + "단\n\n");
////				for(int i =1; i <= 9; i++) {
////					int r = dan * i;
////					textAreaResult.appendText(dan + " * " + i + " = " + r + "\n");
////				}
////			}
////		});
//		cmbDan.setOnAction(e->{
//			
//			int dan = cmbDan.getSelectionModel().getSelectedItem();
//			
//			textAreaResult.setText(dan + "단\n\n");
//			for(int i =1; i <= 9; i++) {
//				int r = dan * i;
//				textAreaResult.appendText(dan + " * " + i + " = " + r + "\n");
//			}
//			
//		});
		
//		hBox.getChildren().addAll(cmbDan, buttonDan);
//		
//		root.setTop(hBox);
//		root.setCenter(textAreaResult);
		
		Scene scene = new Scene(root);
		primaryStage.setTitle("콤보박스 구구단");
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	public static void main(String[] args) {
		launch(args);
	}
}
