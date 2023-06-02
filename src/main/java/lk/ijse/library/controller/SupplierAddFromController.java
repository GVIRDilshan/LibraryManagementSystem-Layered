package lk.ijse.library.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.library.dto.SupplierDTO;
import lk.ijse.library.model.SupplierModel;
import javafx.scene.control.Label;
import lk.ijse.library.util.Regex;

import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SupplierAddFromController {
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

    public void OnAdd(ActionEvent actionEvent) throws SQLException {
        String SupplierID = txtSupllierID.getText();
        String SupplierName = txtSupplierName.getText();
        String SupplierAddress = txtSupplierAddress.getText();
        String SupplierContact = txtContact.getText();
        String BookID = txtBookID.getText();

        SupplierDTO supplier = new SupplierDTO();

        supplier.setSupplierID(SupplierID);
        supplier.setSupplierName(SupplierName);
        supplier.setSupplierAddress(SupplierAddress);
        supplier.setSupplierContact(SupplierContact);
        supplier.setBookID(BookID);

        boolean S1 = SupplierModel.SupplierAdd(supplier);

    }

    public void OnUpdate(ActionEvent actionEvent) throws SQLException {
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

        boolean s2 = SupplierModel.updateMember(supplier);

    }

    public void OnDelete(ActionEvent actionEvent) throws SQLException {
        String SupplierID = txtSearchID.getText();

        boolean s3 = SupplierModel.deleteFrom(SupplierID);

        if(s3) {
//            Alerts alerts = new Alerts();
//            alerts.notification("Member Delete Sucses....!", "Memebr Delete");
            clear();
        }
    }

    public void OnSearch(ActionEvent actionEvent) throws SQLException {

        String SupplierID = txtSearchID.getText();

        SupplierDTO S1 = SupplierModel.searchFrom(SupplierID);

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