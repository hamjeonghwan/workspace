package kr.or.ddit.basic;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import Dao.prodDao;
import Dao.prodDaoImpl;
import VO.LprodVO;
import VO.ProdVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


public class prodTestControl implements Initializable {


		
	@FXML 
	ComboBox<String> combolprod;
	@FXML 
	ComboBox<String> comboprod;
	@FXML 
	TableView<ProdVO> tProd;
	@FXML 
	TableColumn<ProdVO,String> prod_id;
	@FXML 
	TableColumn<ProdVO,String> prod_name;
	@FXML 
	TableColumn<ProdVO,String> prod_lgu;
	@FXML 
	TableColumn<ProdVO,String> prod_buyer;
	@FXML 
	TableColumn<ProdVO,String> prod_cost;
	@FXML 
	TableColumn<ProdVO,String> prod_price;
	@FXML 
	TableColumn<ProdVO,String> prod_sale;
	@FXML 
	TableColumn<ProdVO,String> prod_outline;
	@FXML 
	TableColumn<ProdVO,String> prod_detail;

	private prodDao prodDao;
	private List<LprodVO> lprodList;
	private List<ProdVO> prodList; 

	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		List<String> lprodName =prodDao.LprodName();
		ObservableList<String> lpName=FXCollections.observableArrayList(lprodName);
		combolprod.setItems(lpName);
	}
  
	
	 
	
}
