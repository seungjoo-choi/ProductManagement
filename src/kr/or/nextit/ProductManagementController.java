package kr.or.nextit;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;

public class ProductManagementController implements Initializable {

	// 제품등록 리스트뷰
	@FXML
	ListView<String> registerListView;
	@FXML
	TextField registerField;
	private ObservableList<String> registerlist;
	@FXML
	Button registerButton;

	// 지출내역 테이블
	@FXML
	TextField expenseField;
	@FXML
	TextField expenseQuantityField;
	@FXML
	TextField expenseCostField;
	@FXML
	TableView<ExpenseModel> expenseTableView;
	@FXML
	TableColumn expenseDateColumn;
	@FXML
	TableColumn<ExpenseModel, String> expenseListColumn;
	@FXML
	TableColumn<ExpenseModel, Integer> expenseQuantityColumn;
	@FXML
	TableColumn<ExpenseModel, Integer> expenseCostColumn;
	private ObservableList<ExpenseModel> expenseListArr;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// 제품명 미입력시 입력버튼 비활성화
		registerButton.setDisable(true);
		registerField.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				if (observable.getValue().intValue() > 0) {
					registerButton.setDisable(false);
				} else {
					registerButton.setDisable(true);
				}
			}
		});
		// 제품 등록
		registerlist = FXCollections.observableArrayList();
		FilteredList<String> filteredList = new FilteredList<String>(registerlist);
		registerListView.setItems(filteredList);

		// 지출내역 등록
		expenseListArr = FXCollections.observableArrayList();
		expenseTableView.setItems(expenseListArr);
		expenseListColumn.setCellValueFactory(param -> param.getValue().expenseListProperty());
		expenseQuantityColumn.setCellValueFactory(param -> param.getValue().expenseQuantityProperty().asObject());
		expenseCostColumn.setCellValueFactory(param -> param.getValue().expenseCostProperty().asObject());

	}

	/* 제품 등록 */
	@FXML
	public void registerAction() {
		registerlist.add(registerField.getText());
		registerField.setText("");
		registerField.requestFocus();
	}

	@FXML
	public void deleteAction() {
		// 선택된 데이터 모델을 가져옴
		int selectedIndex = registerListView.getSelectionModel().getSelectedIndex();
		// 삭제할 항목을 선택하지 않았을때 알림창으로 경고
		if (selectedIndex < 0) {
			new Alert(AlertType.WARNING, "삭제 할 항목을 선택하세요.", ButtonType.OK).show();

		} else {
			registerlist.remove(selectedIndex);
		}
	}

	/* 지출내역 등록 */
	@FXML
	public void expenseReigsterAction() {
		String expenseList = expenseField.getText();
		int expenseQuantity = Integer.parseInt(expenseQuantityField.getText());
		int expenseCost = Integer.parseInt(expenseCostField.getText());
		expenseListArr.add(new ExpenseModel(expenseList, expenseQuantity, expenseCost));
		expenseField.setText("");
		expenseQuantityField.setText("");
		expenseCostField.setText("");
		expenseField.requestFocus();

	}

}
