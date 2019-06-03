package kr.or.ddit.basic;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class TimeClockController implements Initializable {

	@FXML
	private Label lbTime;
	@FXML
	private Button btnStart;
	@FXML
	private Button btnStop;

	private boolean isStoped;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnStart.setOnAction(e -> {
			handleBtnStart(e);
		});
		btnStop.setOnAction(e -> {
			handleBtnStop(e);
		});
	}

	private void handleBtnStart(ActionEvent e) {
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
				isStoped = false;
				while (!isStoped) {
					try {
						Thread.sleep(500);
						Platform.runLater(new Runnable() {
							// 작업쓰레드가 직접 UI를 변경할 수 없기 때문에 Platform.runLater() 호출.
							// runLater()메서드는 이벤트 큐에 Runnable 객체를 저장하고 즉시 리턴함.
							@Override
							public void run() {
								lbTime.setText(sdf.format(new Date()));

							}
						});
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});

		thread.setDaemon(true); // 데몬쓰레드 설정
		thread.start();
	}

	/**
	 * 멈춤 버튼 누를때 실행됨
	 * 
	 * @param e
	 */
	public void handleBtnStop(ActionEvent e) {
		isStoped = true;
	}

}
