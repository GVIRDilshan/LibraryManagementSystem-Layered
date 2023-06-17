package lk.ijse.library.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.library.bo.BOFactory;
import lk.ijse.library.bo.custom.PublisherBO;
import lk.ijse.library.dto.PublisherDTO;
import lk.ijse.library.entity.Publisher;
import lk.ijse.library.util.Regex;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ManagePublishersFromController {
    @FXML
    private AnchorPane root;

    @FXML
    private Label lbl1;

    @FXML
    private JFXTextField txtPublisherID;

    @FXML
    private JFXTextField txtPublisherName;

    @FXML
    private JFXTextField txtBookID;

    @FXML
    private JFXTextField txtEnterPbID;

    PublisherBO publisherBO = (PublisherBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.PUBLISHER);

    public void OnDelete(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        String publisherID = txtEnterPbID.getText();

        boolean P2 = publisherBO.publisherDelete(publisherID);

        if (P2){
            clear();
        }
    }

    public void OnSearch(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String publisherSearchID = txtEnterPbID.getText();

        Publisher p1 = publisherBO.publishersearchFrom(publisherSearchID);

        PublisherDTO p2 = new PublisherDTO();

        txtPublisherID.setText(p1.getPublisherID());
        txtPublisherName.setText(p1.getPublisherName());
        txtBookID.setText(p1.getBookID());
    }

    public void OnUpdate(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String PublisherID = txtPublisherID.getText();
        String PublisherName = txtPublisherName.getText();
        String BookID = txtBookID.getText();

        PublisherDTO publisher = new PublisherDTO();
        publisher.setPublisherID(PublisherID);
        publisher.setPublisherName(PublisherName);
        publisher.setBookID(BookID);

         boolean b1 = publisherBO.publisherUpdate(publisher);

         if (b1){
             clear();
         }
    }

    public void OnAdd(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String PublisherID = txtPublisherID.getText();
        String PublisherName = txtPublisherName.getText();
        String BookID = txtBookID.getText();

        PublisherDTO publisher = new PublisherDTO();

        publisher.setPublisherID(PublisherID);
        publisher.setPublisherName(PublisherName);
        publisher.setPublishDate(String.valueOf(LocalDate.now()));
        publisher.setBookID(BookID);

        boolean P1 = publisherBO.publisherAdd(publisher);

        if (P1){
            clear();
        }
    }

    public void PublisherNameOnAction(KeyEvent keyEvent) {
        Pattern compile= Regex.getNamePattern();
        Matcher matcher=compile.matcher(txtPublisherName.getText());
        boolean matches= matcher.matches();
        if (matches){
            lbl1.setStyle("-fx-background-color: #2ecc71;");
        }else{
            lbl1.setStyle("-fx-background-color: #c0392b;");
        }
    }
    public void clear(){
        txtPublisherID.setText("");
        txtPublisherName.setText("");
        txtBookID.setText("");
    }
}