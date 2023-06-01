package lk.ijse.library.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.library.dto.*;
import lk.ijse.library.model.*;
import lombok.SneakyThrows;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BookManageFromController implements Initializable {

    @FXML
    private AnchorPane root;

    @FXML
    private JFXTextField txtBookID;

    @FXML
    private JFXTextField txtBookName;

    @FXML
    private JFXTextField txtBookQty;

    @FXML
    private JFXComboBox<?> cmbPulisherID;

    @FXML
    private JFXComboBox<?> cmbSupplierId;

    @FXML
    private JFXComboBox<?> cmbAutorId;

    @FXML
    private Label lblSupplierName;

    @FXML
    private Label lblAutorName;

    @FXML
    private Label lblPublisherName;

    @FXML
    private TableView<Book> tblBooks;

    @FXML
    private JFXTextField txtSearchBookID;

    @FXML
    private TableColumn<?, ?> colBookID;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colAutor;

    @FXML
    private TableColumn<?, ?> colPublisherID;

    @FXML
    private TableColumn<?, ?> colSupplierID;

    @FXML
    private TableColumn<?, ?> colWty;

    @FXML
    void OnAdd(ActionEvent event) throws SQLException {
        String BookID = txtBookID.getText();
        String BookName = txtBookName.getText();
        int Qty = Integer.parseInt(txtBookQty.getText());

        Book book = new Book();

        book.setId(BookID);
        book.setName(BookName);
        book.setQty(Qty);
        book.setAuthor(String.valueOf(cmbAutorId.getValue()));
        book.setSupplier(String.valueOf(cmbSupplierId.getValue()));
        book.setPublisher(String.valueOf(cmbPulisherID.getValue()));

        boolean b1 = BookModelDTO.BookAdd(book);
        tableLoad();
    }

    @FXML
    void OnBack(ActionEvent event) {
        try {
            Parent view = FXMLLoader.load(this.getClass().getResource("/view/DashBoardFrom.fxml"));
            Stage primaryStage = (Stage) root.getScene().getWindow();
            Scene scene = new Scene(view);
            primaryStage.setScene(scene);
            primaryStage.centerOnScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void OnSelectPulisherID(ActionEvent event) throws SQLException {
        Publisher publisher = PublisherModelDTO.searchFrom((String) cmbPulisherID.getValue());
        lblPublisherName.setText(publisher.getPublisherName());

    }

    @FXML
    void OnSelectSuplierId(ActionEvent event) throws SQLException {
        Supplier supplier = SupplierModelDTO.searchFrom((String) cmbSupplierId.getValue());
        lblSupplierName.setText(supplier.getSupplierName());
    }

    @FXML
    void onSelectAutorId(ActionEvent event) throws SQLException {
        Autor autor = AutorModelDTO.searchFrom((String) cmbAutorId.getValue());
        lblAutorName.setText(autor.getAutorName());
    }

    @SneakyThrows
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tblBooks.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblBooks.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblBooks.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("author"));
        tblBooks.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("Publisher"));
        tblBooks.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("Supplier"));
        tblBooks.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("qty"));

        tblBooks.refresh();

       // txtBookID.setEditable(false);
        tableLoad();
        loadAutorIds();
        loadSupplierIds();
        loadPublisherIds();
     //   setTurnId();
      //  txtBookID.setEditable(false);
    }
    public  void tableLoad() throws SQLException {
        ArrayList<Book> books = BookModelDTO.loadAllBooks();
        this.tblBooks.setItems(FXCollections.observableArrayList(books));
    }

    public void OnUpdate(ActionEvent actionEvent) throws SQLException {
        String BookId = txtBookID.getText();
        String BookName = txtBookName.getText();
        String AutorId = String.valueOf(cmbAutorId.getValue());
        String PublisherId = String.valueOf(cmbPulisherID.getValue());
        String SupplierId = String.valueOf(cmbSupplierId.getValue());
        String Qty = txtBookQty.getText();

        Book book = new Book();
        book.setId(BookId);
        book.setName(BookName);
        book.setAuthor(AutorId);
        book.setPublisher(PublisherId);
        book.setSupplier(SupplierId);
        book.setQty(Integer.parseInt(Qty));

        boolean b1 = BookModelDTO.updateBook(book);
    }

    public void OnDelete(ActionEvent actionEvent) throws SQLException {

        System.out.println("Hi");

        String BookID = txtSearchBookID.getText();

        boolean d1 = BookModelDTO.deleteFrom(BookID);
        tableLoad();

        if(d1) {
            new Alert(Alert.AlertType.CONFIRMATION,"member Adding Sucses....!").show();
            clear();
        }
    }

    public void OnSearch(ActionEvent actionEvent) throws SQLException {
        String SearchID = txtSearchBookID.getText();

        Book b1 = BookModelDTO.searchFrom(SearchID);

        txtBookID.setText(b1.getId());
        txtBookName.setText(b1.getName());
        txtBookQty.setText(String.valueOf(b1.getQty()));


    }
    public void loadAutorIds() throws SQLException {
        ArrayList<String> AutorIds = AutorModelDTO.loadAllAutorIds();

        ObservableList ids = FXCollections.observableArrayList();

        for (String id : AutorIds){
            ids.add(id);
        }
        cmbAutorId.setItems(ids);
    }
    public void loadPublisherIds() throws SQLException {
        ArrayList<String> PublisherIds = PublisherModelDTO.loadAllPublisherIds();

        ObservableList ids = FXCollections.observableArrayList();

        for (String id : PublisherIds){
            ids.add(id);
        }
        cmbPulisherID.setItems(ids);
    }
    public void loadSupplierIds() throws SQLException {
        ArrayList<String> SupplierIds = SupplierModelDTO.loadAllSupplierIds();

        ObservableList ids = FXCollections.observableArrayList();

        for (String id : SupplierIds){
            ids.add(id);
        }
        cmbSupplierId.setItems(ids);

    }
    public void clear(){
        txtBookID.setText("");
        txtBookName.setText("");
        txtBookQty.setText("");
    }
//    private void setTurnId() {
//        try {
//            String newTurnId = BookModel.genarateTurnId();
//            txtBookID.setText(newTurnId);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
}
