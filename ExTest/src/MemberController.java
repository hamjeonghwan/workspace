
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;

public class MemberController implements Initializable {

	@FXML
	Label id;
	@FXML
	Label name;
	@FXML
	Label tel;
	@FXML
	Label addr;
	@FXML
	TextField txtId;
	@FXML
	TextField txtName;
	@FXML
	TextField txtTel;
	@FXML
	TextField txtAddr;
	@FXML
	Button add;
	@FXML
	Button update;
	@FXML
	Button delete;
	@FXML
	Button check;
	@FXML
	Button cancel;
	@FXML
	TableView<Member> table = new TableView<>();
	@FXML
	TableColumn<Member, String> tableId;
	@FXML
	TableColumn<Member, String> tableName;
	@FXML
	TableColumn<Member, String> tableTel;
	@FXML
	TableColumn<Member, String> tableAddr;

	ObservableList<Member> data = FXCollections.observableArrayList(new Member("hhj2019", "한정환", "2222-2222", "대전"));

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		txtId.setPromptText("회원ID");
		txtName.setPromptText("회원 이름");
		txtTel.setPromptText("회원 번호");
		txtAddr.setPromptText("회원 주소");

		tableId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableName.setCellValueFactory(new PropertyValueFactory<>("name"));
		tableTel.setCellValueFactory(new PropertyValueFactory<>("tel"));
		tableAddr.setCellValueFactory(new PropertyValueFactory<>("addr"));

		table.setItems(data);

	}

	@FXML
	public void btnAdd() {
		add.setDisable(true);
		update.setDisable(true);
		delete.setDisable(true);
		cancel.setDisable(false);
		check.setDisable(false);

		check.setOnAction(e -> {
			if (txtId.getText().isEmpty() || txtName.getText().isEmpty() || txtTel.getText().isEmpty()
					|| txtAddr.getText().isEmpty()) {
				System.out.println("빈 항목이 있습니다.");
				return;
			}

			data.add(new Member(txtId.getText(), txtName.getText(), txtTel.getText(), txtAddr.getText()));

			infoMsg("작업 결과", txtId.getText() + "님 정보를 추가했습니다.");

		});

		cancel.setOnAction(e -> {
			txtId.clear();
			txtName.clear();
			txtTel.clear();
			txtAddr.clear();

			add.setDisable(false);
			update.setDisable(false);
			delete.setDisable(false);
			cancel.setDisable(false);
			check.setDisable(false);

		});
	}

	@FXML
	public void btnUpdate() {
		add.setDisable(true);
		update.setDisable(true);
		delete.setDisable(true);
		check.setDisable(false);
		cancel.setDisable(false);

		check.setOnAction(e -> {
			if (table.getSelectionModel().isEmpty()) { // 선택한 항목이 없을때.
				errMsg("작업 오류", "수정할 자료를 선택한 후 수정하세요.");
				return;
			}

			if (txtId.getText().isEmpty() || txtName.getText().isEmpty() || txtTel.getText().isEmpty()
					|| txtAddr.getText().isEmpty()) {
				errMsg("작업 오류", "빈 항목이 있습니다.");

				return;
			}

			data.set(table.getSelectionModel().getSelectedIndex(),
					new Member(txtId.getText(), txtName.getText(), txtTel.getText(), txtAddr.getText()));

			infoMsg("작업 결과", txtId.getText() + "님 정보를 수정했습니다.");
		});

		cancel.setOnAction(e -> {
			txtId.clear();
			txtName.clear();
			txtTel.clear();
			txtAddr.clear();

			add.setDisable(false);
			update.setDisable(false);
			delete.setDisable(false);
			cancel.setDisable(false);
			check.setDisable(false);

		});
	}

	@FXML
	public void btnDelete() {

		add.setDisable(true);
		update.setDisable(true);
		delete.setDisable(true);
		check.setDisable(false);
		cancel.setDisable(false);
		check.setOnAction(e -> {
			if (table.getSelectionModel().isEmpty()) { // 선택한 항목이 없을때.
				errMsg("작업 오류", "삭제할 자료를 선택한 후 삭제하세요.");
				return;
			}

			data.remove(table.getSelectionModel().getSelectedIndex());

			infoMsg("작업 결과", txtId.getText() + "님 정보를 삭제했습니다.");
		});

		cancel.setOnAction(e -> {
			txtId.clear();
			txtName.clear();
			txtAddr.clear();
			txtTel.clear();

			add.setDisable(false);
			update.setDisable(false);
			delete.setDisable(false);
			cancel.setDisable(false);
			check.setDisable(false);

		});
	}

	@FXML
	public void btnCancel() {

	}

	public void errMsg(String headerText, String msg) {
		Alert errAlert = new Alert(AlertType.ERROR);
		errAlert.setTitle("오류");
		errAlert.setHeaderText(headerText);
		errAlert.setContentText(msg);
		errAlert.showAndWait();
	}

	public void infoMsg(String headerText, String msg) {
		Alert infoAlert = new Alert(AlertType.INFORMATION);
		infoAlert.setTitle("정보 확인");
		infoAlert.setHeaderText(headerText);
		infoAlert.setContentText(msg);
		infoAlert.showAndWait();
	}

	public class Member {
		private String id;
		private String name;
		private String tel;
		private String addr;

		public Member(String id, String name, String tel, String addr) {
			super();
			this.id = id;
			this.name = name;
			this.tel = tel;
			this.addr = addr;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getTel() {
			return tel;
		}

		public void setTel(String tel) {
			this.tel = tel;
		}

		public String getAddr() {
			return addr;
		}

		public void setAddr(String addr) {
			this.addr = addr;
		}

	}

}
