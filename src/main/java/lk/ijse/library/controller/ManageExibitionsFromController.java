package lk.ijse.library.controller;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.AnchorPane;
import lk.ijse.library.bo.BOFactory;
import lk.ijse.library.bo.custom.ExibitionBO;
import lk.ijse.library.dto.ExibitionDTO;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ManageExibitionsFromController implements Initializable {
    @FXML
    private AnchorPane root;

    @FXML
    private JFXTextField txtExibitonD;

    @FXML
    private JFXTextArea txtNotes;

    @FXML
    private DatePicker dateSelect;

    @FXML
    private JFXTextField txtTime;

    ExibitionBO exibitionBO = (ExibitionBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.EXIBITION);

    public void btnSendAllMembers(ActionEvent actionEvent) {

    }

    public void onSave(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        ExibitionDTO exibition = new ExibitionDTO();
        exibition.setExibitionId(txtExibitonD.getText());
        exibition.setExibitionDate(String.valueOf(dateSelect.getValue()));
        exibition.setExibitionTime(txtTime.getText());
        exibition.setExibitionDesc(txtNotes.getText());

        boolean e1 = exibitionBO.exibitionAdd(exibition);

        if (e1) {
            clear();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void clear() {
        txtExibitonD.setText("");
        txtNotes.setText("");
        txtTime.setText("");
    }
}
