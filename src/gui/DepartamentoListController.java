package gui;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Departamento;

public class DepartamentoListController implements Initializable{

	@FXML
	private TableView<Departamento> tvDepartamento;
	
	@FXML
	private TableColumn<Departamento, Integer> tcId;
	
	@FXML
	private TableColumn<Departamento, String> tcNome;
	
	@FXML
	private Button btnNovo;
	
	@FXML
	public void onBtnNovoAction() {
		System.out.println("onBtnNovoAction");
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {	
		initializeNodes();
	}

	private void initializeNodes() {
		tcId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tcNome.setCellValueFactory(new PropertyValueFactory<>("nome"));

		Stage stage = (Stage) Main.getMainScene().getWindow();
		
		tvDepartamento.prefHeightProperty().bind(stage.heightProperty());
	}
}
