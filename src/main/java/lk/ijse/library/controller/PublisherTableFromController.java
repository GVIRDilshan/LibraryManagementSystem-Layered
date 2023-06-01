package lk.ijse.library.controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.library.dto.Publisher;
import lk.ijse.library.model.PublisherModelDTO;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PublisherTableFromController implements Initializable {
    @FXML
    private TableView<Publisher> tblPublisher;

    @FXML
    private TableColumn<?, ?> colPublisherID;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colBookID;

    @FXML
    private TableColumn<?, ?> colDate;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tblPublisher.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("PublisherID"));
        tblPublisher.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("PublisherName"));
        tblPublisher.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("BookID"));
        tblPublisher.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("PublishDate"));

        tblPublisher.refresh();

        ArrayList<Publisher> publishers;
        try {
            publishers = PublisherModelDTO.loadAllPublisher();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        tblPublisher.setItems(FXCollections.observableArrayList(publishers));
    }
}
