package lk.ijse.library.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import lk.ijse.library.dto.MemberDTO;
import lk.ijse.library.model.EmailModel;
import lk.ijse.library.model.MemberModel;

import javax.mail.MessagingException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class EmailFromController implements Initializable {
    @FXML
    private AnchorPane root;

    @FXML
    private JFXTextArea txtWriteEmail;

    @FXML
    private JFXComboBox<?> cmdSelectEmail;

    public void OnSelectEmail(ActionEvent actionEvent) throws SQLException {
        MemberDTO member = MemberModel.searchFrom((String) cmdSelectEmail.getValue());

    }

    public void OnSend(ActionEvent actionEvent) throws MessagingException {
        /*System.out.println("Start");

        Mail mail = new Mail(); //creating an instance of Mail class
        mail.setMsg("Hi");//email message
        mail.setTo("ishanravindu975@gmail.com"); //receiver's mail
        mail.setSubject("Test"); //email subject

        Thread thread = new Thread(mail);
        thread.start();

        System.out.println("end");*/

        EmailModel.sendMail("librarys586@gmail.com" , "csaywdwsfqnjxjep" , String.valueOf(cmdSelectEmail.getValue()), txtWriteEmail.getText());

    }
    public void loadAllEmail() throws SQLException {
        ArrayList<String> EmailIds = MemberModel.loadAllMemberEmails();

        ObservableList mails = FXCollections.observableArrayList();

        for (String id : EmailIds){
            mails.add(id);
        }
        cmdSelectEmail.setItems(mails);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            loadAllEmail();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
