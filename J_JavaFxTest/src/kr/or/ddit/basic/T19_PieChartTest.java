package kr.or.ddit.basic;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;

public class T19_PieChartTest  extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		PieChart pieChart = new PieChart();
		
		// 차트에 나타낼 데이터 구성하기
		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
				new PieChart.Data("포도", 10000),	
				new PieChart.Data("사과", 6000),	
				new PieChart.Data("배", 14000),	
				new PieChart.Data("복숭아", 5500),	
				new PieChart.Data("키위", 20000),	
				new PieChart.Data("딸기", 10000)
				);
		
		pieChart.setTitle("과일가격");
		pieChart.setLabelLineLength(50);
		pieChart.setLegendSide(Side.RIGHT);
		pieChart.setData(pieChartData);
		
		Scene scene = new Scene(pieChart, 500, 500);
		primaryStage.setScene(scene);
		primaryStage.setTitle("pieChartDataTest");
		primaryStage.show();
		
	}
	public static void main(String[] args) {
		launch(args);
	}
}
