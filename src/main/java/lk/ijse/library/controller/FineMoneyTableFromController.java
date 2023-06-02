package lk.ijse.library.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import lk.ijse.library.dto.IssuseDTO;
import lk.ijse.library.model.IssuseModel;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FineMoneyTableFromController {

    @FXML
    private AnchorPane root;

    @FXML
    private JFXTextField txtSeachId;

    @FXML
    private Label lblIssuseDate;

    @FXML
    private Label lblDueDate;

    @FXML
    private JFXTextField txtEnterIssuseDate;

    @FXML
    private JFXTextField txtEnterDueDate;

    @FXML
    private Label lblDateDiff;

    @FXML
    private Label lblDateDifff2;

    @FXML
    private JFXTextField txtEnterFineValue;

    @FXML
    private Label lblFinalAnswer;

    public void OnOK2(ActionEvent actionEvent) {
        lblDateDifff2 = lblDateDiff;

        int a1 = Integer.parseInt(lblDateDiff.getText());
        int b1 = Integer.parseInt(txtEnterFineValue.getText());

        int c1;

        c1 = a1 * b1;

        System.out.println("Total is a  : "+c1);

        lblFinalAnswer.setText(String.valueOf(c1));

//        System.out.println("Total : "+b1*a1);

    }
    public void OnSearch(ActionEvent actionEvent) throws SQLException {

        String SearchID = txtSeachId.getText();

        IssuseDTO issuse  = IssuseModel.IssuseSearch(SearchID);

        lblIssuseDate.setText(issuse.getIssusDate());
        lblDueDate.setText(issuse.getDueDate());
    }

    public void OnOk1(ActionEvent actionEvent) throws ParseException {

        String date1 = txtEnterIssuseDate.getText();
        String date2 = txtEnterDueDate.getText();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/mm/dd");

        Date d1 = simpleDateFormat.parse(date1);
        Date d2 = simpleDateFormat.parse(date2);

        long DateDiff = d2.getTime() - d1.getTime();

        System.out.println("Date Diff is : "+DateDiff/3600000/24+" Days");

        lblDateDiff.setText(String.valueOf(DateDiff/3600000/24));

    }
}
