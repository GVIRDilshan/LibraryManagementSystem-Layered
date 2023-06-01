package lk.ijse.library.controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.library.dto.Supplier;
import lk.ijse.library.model.SupplierModelDTO;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SupplierTableFromController implements Initializable {
    @FXML
    private TableView<Supplier> tblSuppliers;

    @FXML
    private TableColumn<?, ?> colSupplierID;

    @FXML
    private TableColumn<?, ?> colSupplierName;

    @FXML
    private TableColumn<?, ?> colConact;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colBookID;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tblSuppliers.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("SupplierID"));
        tblSuppliers.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("SupplierName"));
        tblSuppliers.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("SupplierContact"));
        tblSuppliers.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("SupplierAddress"));
        tblSuppliers.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("BookID"));

        tblSuppliers.refresh();

        ArrayList<Supplier> suppliers;
        try {
            suppliers = SupplierModelDTO.loadAllSuppliers();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        tblSuppliers.setItems(FXCollections.observableArrayList(suppliers));
    }
}
