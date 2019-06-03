package kr.or.ddit.basic;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class FxExam implements Initializable{

	@FXML TextField name;
	@FXML Label la2;
	@FXML Label la3;
	@FXML Button btn1;
	@FXML TextArea txtResult;
	@FXML RadioButton man;
	@FXML RadioButton woman;
	@FXML CheckBox trip;
	@FXML CheckBox hiking;
	@FXML CheckBox book;
	@FXML CheckBox go;
	@FXML CheckBox chess;
	@FXML CheckBox game;
	@FXML CheckBox tennis;
	@FXML CheckBox badminton;
	@FXML ToggleGroup gender;


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		man.setToggleGroup(gender);
		woman.setToggleGroup(gender);
		man.setUserData("남");
		woman.setUserData("여");
		
	}

	@FXML 
	public void btnClick() {
		CheckBox[] chkBoxs = new CheckBox[] {trip, hiking, book, go, chess, game, tennis, badminton};
		
		String hobby1 = "";
		String sex = null;
		if(gender.getSelectedToggle().getUserData() != null) {
			sex = gender.getSelectedToggle().getUserData().toString();
		}
		
		for(int i = 0; i < chkBoxs.length; i++) {
			if(chkBoxs[i].isSelected()) {
				hobby1 += chkBoxs[i].getText() + "  " ;
				
			}
		}
		
		txtResult.setText("이름 : " + name.getText() + "\n성별 : " + sex + "\n취미 : " + hobby1);
	}
	
}
