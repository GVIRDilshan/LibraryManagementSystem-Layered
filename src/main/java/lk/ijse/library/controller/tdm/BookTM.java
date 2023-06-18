package lk.ijse.library.controller.tdm;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.library.bo.BOFactory;
import lk.ijse.library.bo.custom.BookBO;
import lk.ijse.library.dto.BookDTO;
//import lk.ijse.library.Model.BookModel;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BookTM implements Initializable {


    @FXML
    private TableView<BookDTO> tblBooks;

    @FXML
    private TableColumn<?, ?> colBookID;

    @FXML
    private TableColumn<?, ?> colBookName;

    @FXML
    private TableColumn<?, ?> colAutorID;

    @FXML
    private TableColumn<?, ?> colPublisherID;

    @FXML
    private TableColumn<?, ?> colSupplierID;

    @FXML
    private TableColumn<?, ?> colQty;

    BookBO bookBO = (BookBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.BOOK);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tblBooks.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblBooks.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblBooks.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("author"));
        tblBooks.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("Publisher"));
        tblBooks.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("Supplier"));
        tblBooks.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("qty"));

        ArrayList<BookDTO> books;
        try {
            books = bookBO.loadAllBooks();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        tblBooks.setItems(FXCollections.observableArrayList(books));
    }
}
