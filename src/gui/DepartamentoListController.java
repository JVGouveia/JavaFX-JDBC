package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Departamento;
import model.services.DepartamentoService;

public class DepartamentoListController implements Initializable{
	
	private DepartamentoService service;

	@FXML
	private TableView<Departamento> tvDepartamento;
	
	@FXML
	private TableColumn<Departamento, Integer> tcId;
	
	@FXML
	private TableColumn<Departamento, String> tcNome;
	
	@FXML
	private Button btnNovo;
	
	private ObservableList<Departamento> obsList;
	
	@FXML
	public void onBtnNovoAction() {
		System.out.println("onBtnNovoAction");
	}
	
	public void setDepartamentoService(DepartamentoService service) {
		this.service = service;
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
	
	public void updateTableView() {
		if(service == null) {
			throw new IllegalStateException("Servico esta nulo!");
		}
		List<Departamento> list = service.findAll();
		
		obsList = FXCollections.observableArrayList(list);
		tvDepartamento.setItems(obsList);
	}
}
