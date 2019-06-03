package kr.or.ddit.basic.paging;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import javafx.scene.Node;
import javafx.scene.control.Pagination;

public class PagingController implements Initializable {

	@FXML
	private TableView<MemberVo> tableView;
	@FXML
	private TableColumn<MemberVo, String> id;
	@FXML
	private TableColumn<MemberVo, String> name;
	@FXML
	private TableColumn<MemberVo, String> address;
	private ObservableList<MemberVo> allTableData, currebtPageData;
	@FXML Pagination pagination;
	private int from, to, itemsForPage;
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		id.setCellValueFactory(new PropertyValueFactory<>("id"));
		name.setCellValueFactory(new PropertyValueFactory<>("name"));
		address.setCellValueFactory(new PropertyValueFactory<>("address"));
		
		allTableData = FXCollections.observableArrayList(
					new MemberVo("1", "홍길동1", "인재개발완"),
					new MemberVo("2", "홍길동2", "인재개발완"),
					new MemberVo("3", "홍길동3", "인재개발완"),
					new MemberVo("4", "홍길동4", "인재개발완"),
					new MemberVo("5", "홍길동5", "인재개발완"),
					new MemberVo("6", "홍길동6", "인재개발완"),
					new MemberVo("7", "홍길동7", "인재개발완"),
					new MemberVo("8", "홍길동8", "인재개발완"),
					new MemberVo("9", "홍길동9", "인재개발완"),
					new MemberVo("10", "홍길동10", "인재개발완"),
					new MemberVo("11", "홍길동11", "인재개발완"),
					new MemberVo("12", "홍길동12", "인재개발완"),
					new MemberVo("13", "홍길동13", "인재개발완"),
					new MemberVo("14", "홍길동14", "인재개발완"),
					new MemberVo("15", "홍길동15", "인재개발완"),
					new MemberVo("16", "홍길동16", "인재개발완"));
		
		itemsForPage =5;
		int totItemCnt = allTableData.size();
		int totPagCnt = totItemCnt%itemsForPage==0 ? totItemCnt/itemsForPage : totItemCnt/itemsForPage+1;
		// 전체 페이지 수 설정
		pagination.setPageCount(totPagCnt);
		
		// 방법1(Callback타입의 익명객체 생성)
		pagination.setPageFactory(new Callback<Integer, Node>() {
			
			@Override
			public Node call(Integer pageIndex) {
				System.out.println(pageIndex +1);
				from = pageIndex * itemsForPage;
				to = from + itemsForPage -1;
				tableView.setItems(getTableTableViewData(from, to));
				return tableView;
			}

		});
		// 방법2(람다식)
//		pagination.setPageFactory((Integer pageIndex) ->{
//			from = pageIndex * itemsForPage;
//			to = from + itemsForPage -1;
//			tableView.setItems(getTableTableViewData(from, to));
//			return tableView;
//		});
	}
		/**
		 * TableView에 채워줄 데이터를 가져오는 메서드
		 * @author pc13
		 * @param from
		 * @param to
		 * @return
		 */
		
		
		private ObservableList<MemberVo> getTableTableViewData(int from, int to) {
			// TODO Auto-generated method stub
			currebtPageData = FXCollections.observableArrayList(); // 현재페이지 데이터 초기화
			int totSize = allTableData.size();
			
			for(int i = from; i <= to && i < totSize; i++) {
				currebtPageData.add(allTableData.get(i));
			}
			return currebtPageData;
		
	}

}
