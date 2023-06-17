package lk.ijse.library.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.library.bo.BOFactory;
import lk.ijse.library.bo.custom.IssuseBO;
import lk.ijse.library.bo.custom.ReturnBO;
import lk.ijse.library.dto.IssuseDTO;
import lk.ijse.library.dto.ReturnDTO;
import lk.ijse.library.Model.IssuseModel;
import lk.ijse.library.Model.ReturnModel;


import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ManageReturnFromController implements Initializable {
    @FXML
    private AnchorPane root;

    @FXML
    private JFXTextField txtIssuseID;

    @FXML
    private JFXTextField txtReturnID;

    @FXML
    private Label lblIssueID;

    @FXML
    private Label lblBookID;

    @FXML
    private Label lblMemberID;

    @FXML
    private Label lblIssuseDate;

    @FXML
    private Label lblDueDate;

    @FXML
    private Label lblQty;

    @FXML
    private Label lblMemebrEmail;

    @FXML
    private TableView<ReturnDTO> tblReturns;

    @FXML
    private TableColumn<?, ?> colReturnID;

    @FXML
    private TableColumn<?, ?> ReturnDate;

    @FXML
    private TableColumn<?, ?> colIssuseID;

    @FXML
    private TableColumn<?, ?> ColIssuseDate;

    @FXML
    private TableColumn<?, ?> colBookID;

    IssuseDTO issuse = new IssuseDTO();

    ReturnBO returnBO = (ReturnBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.RETURN);
    IssuseBO issuseBO =(IssuseBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ISSUSE);

    public ManageReturnFromController() throws SQLException {
    }


    public void GoIssuse(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        String IssueseID = txtIssuseID.getText();

        IssuseDTO issuse  = issuseBO.searchIssuseFrom(IssueseID);

        lblIssueID.setText(issuse.getIssusId());
        lblBookID.setText(issuse.getBookId());
        lblDueDate.setText(issuse.getDueDate());
        lblIssuseDate.setText(issuse.getIssusDate());
        lblQty.setText(issuse.getIssuseQty());
        lblMemberID.setText(issuse.getMemberId());

    }



    public void GoReturn(ActionEvent actionEvent) throws SQLException {

        String IssuseId = txtIssuseID.getText();
        String ReturnId = txtReturnID.getText();
        String ReturnDate = String.valueOf(LocalDate.now());
        String BookId = lblBookID.getText();
        String IssuseDate = lblIssuseDate.getText();
        String BookQty = lblQty.getText();


        ReturnDTO return1 = new ReturnDTO();
        return1.setIssuseId(IssuseId);
        return1.setReturnId(ReturnId);
        return1.setReturnDate(ReturnDate);
        return1.setBookId(BookId);
        return1.setIssuseDate(IssuseDate);

        boolean b1 = returnBO.returnSet(return1,BookQty,BookId,IssuseId);
        System.out.println(return1.getIssuseId()+" "+return1.getReturnId()+" "+return1.getBookId()+" " +
                " "+return1.getReturnDate()+" "+return1.getIssuseDate());

      //  EmailModel.sendMail("librarys586@gmail.com" , "csaywdwsfqnjxjep" , lblContact.getText(), "Hi "+lblMemberID.getText()+" You'r Book is Issuse Sucses fully Completed \n"+"Return Date is ToDay : "+LocalDate.now()+"\"You'r IssuseId is : "+txtIssuseID.getText()+"\nBook Id : "+cmbBookID.getValue()+"\nDueDate is :"+DatePiker.getValue()+"\nPlease return your book by the date we have notified. Otherwise, after that date, fines will be added.\n"+"Thank you...."+lblMemberName.getText()+" for visiting our library.");


    }

    public void ReturnTableView(){
        tblReturns.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("ReturnId"));
        tblReturns.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("ReturnDate"));
        tblReturns.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("IssuseId"));
        tblReturns.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("IssuseDate"));
        tblReturns.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("BookId"));

        ArrayList<ReturnDTO> returns;
        try {
            returns = returnBO.loadAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        tblReturns.setItems(FXCollections.observableArrayList(returns));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ReturnTableView();
    }

}
