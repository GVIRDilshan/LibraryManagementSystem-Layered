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
import lk.ijse.library.bo.BOFactory;
import lk.ijse.library.bo.custom.DonetionBO;
import lk.ijse.library.dto.DonetionDTO;
import lk.ijse.library.dto.ExibitionDTO;
import lk.ijse.library.Model.ExibitionModel;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ManageDonetionsFromController implements Initializable {
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

    DonetionBO donetionBO = (DonetionBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.DONETION);

    public void btnOnAdd(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String donetionID = txtDonetionID.getText();
        String ammount = txtAmmount.getText();
        String review = txtReview.getText();
        String donetBy = txtDonetBy.getText();
        String exibitionID = String.valueOf(cmbExibitionID.getValue());

        DonetionDTO donetion = new DonetionDTO();
        donetion.setDonetionId(donetionID);
        donetion.setDonetionName(donetBy);
        donetion.setAmmount(Double.parseDouble(ammount));
        donetion.setReview(review);
        donetion.setExibitionId(exibitionID);

        System.out.println(donetion.getDonetionId()+"" +
                ""+donetion.getDonetionName()+""
                +donetion.getReview()+""+donetion.getAmmount()+""+donetion.getExibitionId());

        boolean d1 = donetionBO.donetionAdd(donetion);
    }

    public void onSelectCmbExibitonID(ActionEvent actionEvent) throws SQLException {
        ExibitionDTO exibition  = ExibitionModel.searchFrom((String) cmbExibitionID.getValue());

    }
    public void loadExibitionIds() throws SQLException {
        ArrayList<String> ExibitionIds = ExibitionModel.loadAllExibitionIds();

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
    public void clear(){
        txtDonetionID.setText("");
        txtAmmount.setText("");
        txtDonetBy.setText("");
        txtReview.setText("");
        cmbExibitionID.setPromptText("");
    }
}
