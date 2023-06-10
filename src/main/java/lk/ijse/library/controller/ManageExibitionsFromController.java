package lk.ijse.library.controller;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.AnchorPane;
import lk.ijse.library.dto.ExibitionDTO;
import lk.ijse.library.model.ExibitionModel;

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

    public void btnSendAllMembers(ActionEvent actionEvent) {

    }

    public void onSave(ActionEvent actionEvent) throws SQLException {
        String ExibitionID = txtExibitonD.getText();
        String ExibitionDate = String.valueOf(dateSelect.getValue());
        String ExibitionTime = txtTime.getText();
        String ExibitionDesc = txtNotes.getText();

        ExibitionDTO exibition = new ExibitionDTO();
        exibition.setExibitionId(ExibitionID);
        exibition.setExibitionDate(ExibitionDate);
        exibition.setExibitionTime(ExibitionTime);
        exibition.setExibitionDesc(ExibitionDesc);

        boolean e1 = ExibitionModel.SaveExibition(exibition);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

//    private void settime() {
//        lblTime.setText(String.valueOf(LocalDate.now()));
//    }
    //  @Override
//    public void initialize(URL location, ResourceBundle resources) {
//        AnimationTimer timer = new AnimationTimer() {
//            @Override
//            public void handle(long now) {
//               // txtDate.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
//                lblTime.setText(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
//            }
//        };
//        timer.start();
//    }
}
