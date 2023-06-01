package lk.ijse.library.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.library.dto.Autor;
import lk.ijse.library.model.AutorModelDTO;
import lk.ijse.library.util.Regex;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AutorAddFromController implements Initializable {
    @FXML
    private AnchorPane root;

    @FXML
    private JFXTextField txtAutorID;

    @FXML
    private JFXTextField txtAutorName;

    @FXML
    private JFXTextField txtBookID;

    @FXML
    private JFXTextField txtBookName;

    @FXML
    private JFXTextField txtEnterAutorID;

    @FXML
    private Label lbl1;

    @FXML
    private Label lbl2;

    @FXML
    private Label lbl3;

    @FXML
    private Label lbl4;

    public void OnDelete(ActionEvent actionEvent) throws SQLException {
        String AutorID = txtAutorID.getText();

        boolean d1 = AutorModelDTO.deleteFrom(AutorID);

        if(d1) {
            new Alert(Alert.AlertType.CONFIRMATION,"Autor Delete Sucses....!").show();
            clear();
        }
    }

    public void OnSearch(ActionEvent actionEvent) throws SQLException {
        String AutorID = txtEnterAutorID.getText();

        Autor autor = AutorModelDTO.searchFrom(AutorID);

        txtAutorID.setText(autor.getAutorID());
        txtAutorName.setText(autor.getAutorName());
        txtBookID.setText(autor.getBookID());
        txtBookName.setText(autor.getBookName());

    }

    public void OnUpdate(ActionEvent actionEvent) throws SQLException {
        String AutorID = txtAutorID.getText();
        String AutorsName = txtAutorName.getText();
        String BookID = txtBookID.getText();
        String BookName = txtBookName.getText();

        Autor autor1 = new Autor();
        autor1.setAutorID(AutorID);
        autor1.setAutorName(AutorsName);
        autor1.setBookName(BookName);
        autor1.setBookID(BookID);

        boolean A1 = AutorModelDTO.updateAutor(autor1);

        if(A1) {
            new Alert(Alert.AlertType.CONFIRMATION,"Autor Updating Sucses....!").show();
            clear();
            clear();
        }

    }

    public void OnAdd(ActionEvent actionEvent) throws SQLException {
        String AutorID = txtAutorID.getText();
        String AutorName = txtAutorName.getText();
        String BookName = txtBookName.getText();
        String BookID = txtBookID.getText();

        Autor autor = new Autor();

        autor.setAutorID(AutorID);
        autor.setAutorName(AutorName);
        autor.setBookName(BookName);
        autor.setBookID(BookID);

        boolean b1 = AutorModelDTO.AutorAdd(autor);

        if(b1) {
            new Alert(Alert.AlertType.CONFIRMATION,"Autor Adding Sucses....!").show();
            clear();
        }

    }
    public void clear(){
        txtAutorID.setText("");
        txtAutorName.setText("");
        txtBookID.setText("");
        txtBookName.setText("");
    }
    private void setTurnId() {
        try {
            String newTurnId = AutorModelDTO.genarateTurnId();
            txtAutorID.setText(newTurnId);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setTurnId();
        txtAutorID.setEditable(false);
    }
    @FXML
    void AuthorNameOnAction(KeyEvent event) {
        Pattern compile= Regex.getNamePattern();
        Matcher matcher=compile.matcher(txtAutorName.getText());
        boolean matches= matcher.matches();
        if (matches){
            lbl2.setStyle("-fx-background-color: #2ecc71;");
        }else{
            lbl2.setStyle("-fx-background-color: #c0392b;");
        }
    }

    @FXML
    void BookNameOnAction(KeyEvent event) {
        Pattern compile= Regex.getNamePattern();
        Matcher matcher=compile.matcher(txtBookName.getText());
        boolean matches= matcher.matches();
        if (matches){
            lbl4.setStyle("-fx-background-color: #2ecc71;");
        }else{
            lbl4.setStyle("-fx-background-color: #c0392b;");
        }
    }

}
