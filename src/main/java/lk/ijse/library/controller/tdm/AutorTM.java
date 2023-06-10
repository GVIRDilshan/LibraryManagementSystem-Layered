package lk.ijse.library.controller.tdm;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.library.dto.AutorDTO;
import lk.ijse.library.model.AutorModel;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AutorTM implements Initializable {

    @FXML
    private TableView<AutorDTO> tblAutor;

    @FXML
    private TableColumn<?, ?> colAutorID;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colBookName;

    @FXML
    private TableColumn<?, ?> colBookID;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tblAutor.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("AutorID"));
        tblAutor.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("AutorName"));
        tblAutor.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("BookName"));
        tblAutor.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("BookID"));

        tblAutor.refresh();

        ArrayList<AutorDTO> autors;
        try {
            autors = AutorModel.loadAllAutors();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        tblAutor.setItems(FXCollections.observableArrayList(autors));
    }
}
