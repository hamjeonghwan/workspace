package main;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import service.IProdService;
import service.ProdServiceImpl;
import vo.ProdVO;

public class ProdInfoController implements Initializable {
	
	private IProdService prodService;
	
	public ProdInfoController() {
		prodService = ProdServiceImpl.getInstance();
	}
	
	@FXML
	ComboBox<String> lProd;
	@FXML
	ComboBox<String> prodName;
	@FXML
	TableView<ProdVO> table;
	@FXML
	TableColumn<ProdVO, String> prod_IdCol;
	@FXML
	TableColumn<ProdVO, String> prod_NameCol;
	@FXML
	TableColumn<ProdVO, String> prod_LguCol;
	@FXML
	TableColumn<ProdVO, String> prod_BuyerCol;
	@FXML
	TableColumn<ProdVO, Integer> prod_CostCol;
	@FXML
	TableColumn<ProdVO, Integer> prod_PriceCol;
	@FXML
	TableColumn<ProdVO, Integer> prod_SaleCol;
	@FXML
	TableColumn<ProdVO, String> prod_OutlineCol;
	@FXML
	TableColumn<ProdVO, String> prod_DetailCol;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		List<String> list = prodService.getLprod();
		ObservableList<String> data = FXCollections.observableArrayList(list);
		lProd.setItems(data);
		
		lProd.valueProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				List<String> list = prodService.getProdName(newValue);
				ObservableList<String> data = FXCollections.observableArrayList(list);
				prodName.setItems(data);
			}
		});
		
		prodName.valueProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				String lp = lProd.getSelectionModel().getSelectedItem().toString();
				
				HashMap<String, String> hsmap = new HashMap<>();
				
				hsmap.put("prod_Lgu", lp);
				hsmap.put("prod_Name", newValue);
				
				System.out.println(hsmap.get("prod_Lgu"));
				System.out.println(hsmap.get("prod_Name"));
				List<ProdVO> list = prodService.getProd(hsmap);
				
				System.out.println(list.size());
				
				ObservableList<ProdVO> data = FXCollections.observableArrayList(list);
				setTable(data);
			}
		});
		
	}
	
	private void setTable(ObservableList<ProdVO> data) {
		table.setItems(data);
		
		prod_IdCol.setCellValueFactory(new PropertyValueFactory<>("prod_Id"));
		prod_NameCol.setCellValueFactory(new PropertyValueFactory<>("prod_Name"));
		prod_LguCol.setCellValueFactory(new PropertyValueFactory<>("prod_Lgu"));
		prod_BuyerCol.setCellValueFactory(new PropertyValueFactory<>("prod_Buyer"));
		prod_CostCol.setCellValueFactory(new PropertyValueFactory<>("prod_Cost"));
		prod_PriceCol.setCellValueFactory(new PropertyValueFactory<>("prod_Price"));
		prod_SaleCol.setCellValueFactory(new PropertyValueFactory<>("prod_Sale"));
		prod_OutlineCol.setCellValueFactory(new PropertyValueFactory<>("prod_Outline"));
		prod_DetailCol.setCellValueFactory(new PropertyValueFactory<>("prod_Detail"));
	}
	

}
