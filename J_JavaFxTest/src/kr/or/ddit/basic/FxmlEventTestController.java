package kr.or.ddit.basic;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class FxmlEventTestController implements Initializable {

	@FXML 
	private TextField txtinput;
	@FXML 
	private Button btnOk;
	@FXML 
	private TextField txtResult;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		assert txtinput != null : "fx:id=\"txtinput\"was not injected: " + "check your FXML file 'FxmlEventTest.fxml' .";
		assert btnOk != null : "fx:id=\"btnOk\"was not injected: " + "check your FXML file 'FxmlEventTest.fxml' .";
		assert txtResult  != null : "fx:id=\"txtResult\"was not injected: " + "check your FXML file 'FxmlEventTest.fxml' .";
	}

	@FXML 
	public void btnClick(ActionEvent event) {
		// TF에는 출력할 단을 입력하고 버튼을 누르면 해당 단을 TA영역에 출력하시오
		
		String strDan = txtinput.getText();
		if(!Pattern.matches("^[0-9]+$", strDan)) {
			alertError("출력할 단을 정확히 입력하세요");
			return;
		}
		
		int dan = Integer.parseInt(strDan);
		
		txtResult.setText(dan + "단\n\n");
		for(int i =1; i <= 9; i++) {
			int r = dan * i;
			txtResult.appendText(dan + " * " + i + " = " + r + "\n");
		}
	}

	private void alertError(String msg) {
		// TODO Auto-generated method stub
		Alert alertError = new Alert(AlertType.ERROR);
		
		alertError.setTitle("에러");
		alertError.setContentText(msg);
		alertError.showAndWait();
		}
	}


