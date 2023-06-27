package lk.ijse.library.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.library.bo.BOFactory;
import lk.ijse.library.bo.custom.SupplierBO;
import lk.ijse.library.dto.SupplierDTO;
import lk.ijse.library.entity.Supplier;
import javafx.scene.control.Label;
import lk.ijse.library.util.Regex;

import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ManageSuppliersFromController {
    @FXML
    private AnchorPane root;

    @FXML
    private Label lbl1;

    @FXML
    private Label lbl2;

    @FXML
    private Label lbl3;

    @FXML
    private JFXTextField txtSupllierID;

    @FXML
    private JFXTextField txtSupplierName;

    @FXML
    private JFXTextField txtContact;

    @FXML
    private JFXTextField txtBookID;

    @FXML
    private JFXTextField txtSupplierAddress;

    @FXML
    private JFXTextField txtSearchID;

    SupplierBO supplierBO = (SupplierBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.SUPPLIER);

    public void OnBack(ActionEvent actionEvent) {
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

    public void OnAdd(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        SupplierDTO supplier = new SupplierDTO();

        supplier.setSupplierID(txtSupllierID.getText());
        supplier.setSupplierName(txtSupplierName.getText());
        supplier.setSupplierAddress(txtSupplierAddress.getText());
        supplier.setSupplierContact(txtContact.getText());
        supplier.setBookID(txtBookID.getText());

        boolean S1 = supplierBO.supplierAdd(supplier);

        if(S1) {
            new Alert(Alert.AlertType.CONFIRMATION,"Supplier Add Sucses....!").show();
            clear();
        }
    }

    public void OnUpdate(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String SupplierID      =  txtSupllierID.getText();
        String SupplierName    =  txtSupplierName.getText();
        String SupplierContact =  txtContact.getText();
        String SupplierAddress =  txtSupplierAddress.getText();
        String BookID          =  txtBookID.getText();

        SupplierDTO supplier = new SupplierDTO();

        supplier.setSupplierID(SupplierID);
        supplier.setSupplierName(SupplierName);
        supplier.setSupplierContact(SupplierContact);
        supplier.setSupplierAddress(SupplierAddress);
        supplier.setBookID(BookID);

        boolean s2 = supplierBO.supplierUpdate(supplier);
    }

    public void OnDelete(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String SupplierID = txtSearchID.getText();

        boolean s3 = supplierBO.supplierDelete(SupplierID);

        if(s3) {
            clear();
        }
    }

    public void OnSearch(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        String SupplierID = txtSearchID.getText();

        Supplier S1 = supplierBO.supplierSearchFrom(SupplierID);

        txtSupllierID.setText(S1.getSupplierID());
        txtSupplierName.setText(S1.getSupplierName());
        txtContact.setText(S1.getSupplierContact());
        txtSupplierAddress.setText(S1.getSupplierAddress());
        txtBookID.setText(S1.getBookID());

    }
    public void clear(){
        txtSupllierID.setText("");
        txtSupplierName.setText("");
        txtSupplierAddress.setText("");
        txtContact.setText("");
        txtBookID.setText("");
    }
    @FXML
    void SuplierAddressOnAction(KeyEvent event) {
        Pattern compile= Regex.getAddressPattern();
        Matcher matcher=compile.matcher(txtSupplierAddress.getText());
        boolean matches= matcher.matches();
        if (matches){
            lbl3.setStyle("-fx-background-color: #2ecc71;");
        }else{
            lbl3.setStyle("-fx-background-color: #c0392b;");
        }
    }

    @FXML
    void SuplierConractOnAction(KeyEvent event) {
        Pattern compile= Regex.getMobilePattern();
        Matcher matcher=compile.matcher(txtContact.getText());
        boolean matches= matcher.matches();
        if (matches){
            lbl2.setStyle("-fx-background-color: #2ecc71;");
        }else{
            lbl2.setStyle("-fx-background-color: #c0392b;");
        }
    }

    @FXML
    void suplierNameOnAction(KeyEvent event) {
        Pattern compile= Regex.getNamePattern();
        Matcher matcher=compile.matcher(txtSupplierName.getText());
        boolean matches= matcher.matches();
        if (matches){
            lbl1.setStyle("-fx-background-color: #2ecc71;");
        }else{
            lbl1.setStyle("-fx-background-color: #c0392b;");
        }
    }
}