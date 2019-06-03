package kr.or.ddit.basic;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;

public class T14_ListViewTest extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		ListView<String> list = new ListView<>();
		Label label = new Label();
		label.setFont(new Font(20.0));
		
		// ListView에 들어갈 데이터 구성하기 방법1
		ObservableList<String> data = FXCollections.observableArrayList(
					"green", "gold", "red", "blue", "black", "brown", "blueviolet", "pink", "yellow", "chocolate"
				);
		
		VBox vBox = new VBox(10);
		
		// list.setItems(data); 
		
		
		//방법2
		list.getItems().addAll("green", "gold", "red", "blue", "black", "brown", "blueviolet", "pink", "yellow", "chocolate");
		
		list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				// TODO Auto-generated method stub
				label.setText(newValue);
				label.setTextFill(Color.web(newValue));
			}
		});
		list.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
			
			@Override
			public ListCell<String> call(ListView<String> param) {
				return new ListCell<String>() {
					protected void updateItem(String item, boolean empty) {
						super.updateItem(item, empty);
						Rectangle rect = new Rectangle(100, 20);
						if(item != null) {
							rect.setFill(Color.web(item)); // 4각형 내부 색칠하기
							setGraphic(rect);	// 값 변경하기 
							// 변경되는 데이터가 문자열이면 setText() 메서드를 사용한다 
							
							Label lbText = new Label(item);
							lbText.setTextFill(Color.web(item));
							
							HBox hBox2 = new HBox(10);
							hBox2.getChildren().addAll(rect, lbText);
							
							setGraphic(hBox2);
							
						}
					}
				};
			}	
		});
		
		vBox.getChildren().addAll(list, label);
		
		Scene scene =new Scene(vBox);
		primaryStage.setTitle("ListView 연습");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
