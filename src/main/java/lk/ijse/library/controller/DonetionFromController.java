package lk.ijse.library.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import lk.ijse.library.dto.Donetion;
import lk.ijse.library.dto.Exibition;
import lk.ijse.library.model.DonetionModelDTO;
import lk.ijse.library.model.ExibitionModelDTO;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DonetionFromController implements Initializable {
    @FXML
    private AnchorPane root;

    @FXML
    private JFXTextField txtDonetionID;

    @FXML
    private JFXTextField txtAmmount;

    @FXML
    private JFXTextArea txtReview;

    @FXML
    private JFXTextField txtDonetBy;

    @FXML
    private JFXComboBox<?> cmbExibitionID;

    public void btnOnAdd(ActionEvent actionEvent) throws SQLException {
        String donetionID = txtDonetionID.getText();
        String ammount = txtAmmount.getText();
        String review = txtReview.getText();
        String donetBy = txtDonetBy.getText();
        String exibitionID = String.valueOf(cmbExibitionID.getValue());

        Donetion donetion = new Donetion();
        donetion.setDonetionId(donetionID);
        donetion.setDonetionName(donetBy);
        donetion.setAmmount(Double.parseDouble(ammount));
        donetion.setReview(review);
        donetion.setExibitionId(exibitionID);

        boolean d1 = DonetionModelDTO.DonetionAdd(donetion);
    }

    public void onSelectCmbExibitonID(ActionEvent actionEvent) throws SQLException {
        Exibition exibition  = ExibitionModelDTO.searchFrom((String) cmbExibitionID.getValue());

    }
    public void loadExibitionIds() throws SQLException {
        ArrayList<String> ExibitionIds = ExibitionModelDTO.loadAllExibitionIds();

        ObservableList ids = FXCollections.observableArrayList();

        for (String id : ExibitionIds){
            ids.add(id);
        }
        cmbExibitionID.setItems(ids);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            loadExibitionIds();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
