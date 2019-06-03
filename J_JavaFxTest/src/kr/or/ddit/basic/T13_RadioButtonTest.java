package kr.or.ddit.basic;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class T13_RadioButtonTest extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
	
		ToggleGroup group = new ToggleGroup(); 
			
			ImageView	icon =new ImageView();
		
		RadioButton radioButton1 = new RadioButton("HOME");
		
		radioButton1.setToggleGroup(group);
		radioButton1.setUserData("Home");
		
		
		RadioButton radioButton2 = new RadioButton("CALEDAR");
		radioButton2.setToggleGroup(group);
		radioButton2.setUserData("Calendar");
		
		RadioButton radioButton3 = new RadioButton("CONTACTS");
		radioButton3.setToggleGroup(group);
		radioButton3.setUserData("Contacts");
		
		group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {

			@Override
			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
				// TODO Auto-generated method stub
				if(group.getSelectedToggle().getUserData() != null) {
					String url = group.getSelectedToggle().getUserData().toString();
					Image img = new Image(getClass().getResourceAsStream("images/" + url + ".jpg"));
					icon.setImage(img);
				}
			}
		});
		radioButton1.setSelected(true);
		
		HBox hBox = new HBox();
		VBox vBox = new VBox();
		
		vBox.getChildren().addAll(radioButton1, radioButton2, radioButton3);
		vBox.setSpacing(10);
		
		hBox.getChildren().addAll(vBox, icon);
		hBox.setSpacing(50);
		hBox.setPadding(new Insets(10));
		
		Scene scene =new Scene(hBox, 250, 150);
		primaryStage.setTitle("라디오버튼 연습");
		primaryStage.setScene(scene);
		primaryStage.show();
			
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
