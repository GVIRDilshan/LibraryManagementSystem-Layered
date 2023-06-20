package lk.ijse.library.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.library.bo.BOFactory;
import lk.ijse.library.bo.custom.AutorBO;
import lk.ijse.library.bo.custom.BookBO;
import lk.ijse.library.bo.custom.PublisherBO;
import lk.ijse.library.bo.custom.SupplierBO;
import lk.ijse.library.dto.*;
import lk.ijse.library.entity.Publisher;
import lk.ijse.library.entity.Supplier;
import lk.ijse.library.Model.*;
import lombok.SneakyThrows;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ManageBooksFromController implements Initializable {

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
    private TableView<BookDTO> tblBooks;

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

    BookBO bookBO = (BookBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.BOOK);
    SupplierBO supplierBO = (SupplierBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.SUPPLIER);
    PublisherBO publisherBO = (PublisherBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.PUBLISHER);
    AutorBO autorBO = (AutorBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.AUTOR);

    @FXML
    void OnAdd(ActionEvent event) throws SQLException, ClassNotFoundException {

        BookDTO book = new BookDTO();

        book.setId(txtBookID.getText());
        book.setName(txtBookName.getText());
        book.setQty(Integer.parseInt(txtBookQty.getText()));
        book.setAuthor(String.valueOf(cmbAutorId.getValue()));
        book.setSupplier(String.valueOf(cmbSupplierId.getValue()));
        book.setPublisher(String.valueOf(cmbPulisherID.getValue()));

     //   System.out.println(book.getId()+" "+book.getName()+" "+book.getQty());

        boolean b1 = bookBO.bookAdd(book);
      //  boolean b1 = BookModel.BookAdd(book);
        tableLoad();
    }

    @FXML
    void OnSelectPulisherID(ActionEvent event) throws SQLException, ClassNotFoundException {
       /* PublisherDTO publisher = PublisherModel.searchFrom((String) cmbPulisherID.getValue());*/
        Publisher publisher = publisherBO.publishersearchFrom((String)cmbPulisherID.getValue());
        lblPublisherName.setText(publisher.getPublisherName());

    }

    @FXML
    void OnSelectSuplierId(ActionEvent event) throws SQLException, ClassNotFoundException {
        Supplier supplier =  supplierBO.supplierSearchFrom((String)cmbSupplierId.getValue());
        lblSupplierName.setText(supplier.getSupplierName());
    }

    @FXML
    void onSelectAutorId(ActionEvent event) throws SQLException, ClassNotFoundException {
        AutorDTO autor = autorBO.autorsearchFrom((String) cmbAutorId.getValue());
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

    public void tableLoad() throws SQLException {
        ArrayList<BookDTO> books = BookModel.loadAllBooks();
        this.tblBooks.setItems(FXCollections.observableArrayList(books));
    }

    public void OnUpdate(ActionEvent actionEvent) throws SQLException {
        String BookId = txtBookID.getText();
        String BookName = txtBookName.getText();
        String AutorId = String.valueOf(cmbAutorId.getValue());
        String PublisherId = String.valueOf(cmbPulisherID.getValue());
        String SupplierId = String.valueOf(cmbSupplierId.getValue());
        String Qty = txtBookQty.getText();

        BookDTO book = new BookDTO();
        book.setId(BookId);
        book.setName(BookName);
        book.setAuthor(AutorId);
        book.setPublisher(PublisherId);
        book.setSupplier(SupplierId);
        book.setQty(Integer.parseInt(Qty));

        boolean b1 = BookModel.updateBook(book);
    }

    public void OnDelete(ActionEvent actionEvent) throws SQLException {

        System.out.println("Hi");

        String BookID = txtSearchBookID.getText();

        boolean d1 = BookModel.deleteFrom(BookID);
        tableLoad();

        if (d1) {
            new Alert(Alert.AlertType.CONFIRMATION, "member Adding Sucses....!").show();
            clear();
        }
    }

    public void OnSearch(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String SearchID = txtSearchBookID.getText();

        BookDTO b1 = bookBO.booksearchFrom(SearchID);

        txtBookID.setText(b1.getId());
        txtBookName.setText(b1.getName());
        txtBookQty.setText(String.valueOf(b1.getQty()));

    }

    public void loadAutorIds() throws SQLException {
        ArrayList<String> AutorIds = autorBO.loadAllAutorIds();

        ObservableList ids = FXCollections.observableArrayList();

        for (String id : AutorIds) {
            ids.add(id);
        }
        cmbAutorId.setItems(ids);
    }

    public void loadPublisherIds() throws SQLException, ClassNotFoundException {
        ArrayList<String> PublisherIds = publisherBO.loadAllPublisherIds();

        ObservableList ids = FXCollections.observableArrayList();

        for (String id : PublisherIds) {
            ids.add(id);
        }
        cmbPulisherID.setItems(ids);
    }

    public void loadSupplierIds() throws SQLException, ClassNotFoundException {
        ArrayList<String> SupplierIds = supplierBO.loadAllSupplierIds();

        ObservableList ids = FXCollections.observableArrayList();

        for (String id : SupplierIds) {
            ids.add(id);
        }
        cmbSupplierId.setItems(ids);

    }

    public void clear() {
        txtBookID.setText("");
        txtBookName.setText("");
        txtBookQty.setText("");
    }
}