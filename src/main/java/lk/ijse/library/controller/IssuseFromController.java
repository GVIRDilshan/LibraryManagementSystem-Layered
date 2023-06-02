package lk.ijse.library.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.library.dto.BookDTO;
import lk.ijse.library.dto.IssuseDTO;
import lk.ijse.library.dto.MemberDTO;
import lk.ijse.library.model.BookModel;
import lk.ijse.library.model.EmailModel;
import lk.ijse.library.model.IssuseModel;
import lk.ijse.library.model.MemberModel;

import javax.mail.MessagingException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class IssuseFromController implements Initializable {

    @FXML
    private AnchorPane root;

    @FXML
    private JFXComboBox<?> cmbBookID;

    @FXML
    private JFXComboBox<?> cmbMemberID;

    @FXML
    private Label lblBookName;

    @FXML
    private Label lblLocalDate;

    @FXML
    private Label lblMemberName;

    @FXML
    private Label lblQty;

    @FXML
    private Label lblContact;

    @FXML
    private JFXTextField txtIssuseID;

    @FXML
    private JFXTextField txtQty;

    @FXML
    private DatePicker DatePiker;


    IssuseDTO issuse = new IssuseDTO();

    @FXML
    void OnBack(ActionEvent event) {
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

    @FXML
    void OnIssuse(ActionEvent event) throws SQLException, MessagingException, ParseException {
        String IssuseID = txtIssuseID.getText();
        String Qty = txtQty.getText();
        String dueDate = String.valueOf(DatePiker.getValue());
        String BookID = String.valueOf(cmbBookID.getValue());
        String memberID = String.valueOf(cmbMemberID.getValue());
        String IssuseQty = txtQty.getText();

     //   Issuse issuse = new Issuse();
        issuse.setIssusId(IssuseID);
        issuse.setDueDate(dueDate);
        issuse.setIssusDate(String.valueOf(LocalDate.now()));
        issuse.setBookId(BookID);
        issuse.setMemberId(memberID);
        issuse.setIssuseQty(IssuseQty);


        System.out.println(Qty+" "+issuse.getIssusDate()+" "+issuse.getDueDate()+" "+issuse.getIssusId()+" "+issuse.getMemberId());

        boolean i1 = IssuseModel.issuseFrom(issuse,Qty,BookID);

        EmailModel.sendMail("librarys586@gmail.com" , "csaywdwsfqnjxjep" , lblContact.getText(), "Hi "+lblMemberName.getText()+" You'r Book is Issuse Sucses fully Completed \n"+"You'r IssuseId is : "+txtIssuseID.getText()+"\nBook Id : "+cmbBookID.getValue()+"\nDueDate is :"+DatePiker.getValue()+"\nPlease return your book by the date we have notified. Otherwise, after that date, fines will be added.\n"+"Thank you...."+lblMemberName.getText()+" for visiting our library.");


    }
    private void setOrderDate() {
        lblLocalDate.setText(String.valueOf(LocalDate.now()));
    }

    @FXML
    void OnSelectBookID(ActionEvent event) throws SQLException {
        BookDTO book = BookModel.searchFrom((String) cmbBookID.getValue());
        lblBookName.setText(book.getName());
        lblQty.setText(String.valueOf(book.getQty()));
    }

    @FXML
    void OnSelectMemberID(ActionEvent event) throws SQLException {
        MemberDTO member = MemberModel.searchFrom((String) cmbMemberID.getValue());
        lblMemberName.setText(member.getName());
        lblContact.setText(member.getEmail());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setOrderDate();
        try {
            loadBookIds();
            loadMemersIds();
            //generateNextIssuseId();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void loadBookIds() throws SQLException {
        ArrayList<String> BookIds = BookModel.loadAllBookIds();

        ObservableList ids = FXCollections.observableArrayList();

        for (String id : BookIds){
            ids.add(id);
        }
        cmbBookID.setItems(ids);
    }
    public void loadMemersIds() throws SQLException {
        ArrayList<String> MemberIds = MemberModel.loadAllMemberIds();

        ObservableList ids = FXCollections.observableArrayList();

        for (String id : MemberIds){
            ids.add(id);
        }
        cmbMemberID.setItems(ids);
    }
    public void clear(){
        txtIssuseID.setText("");
        txtQty.setText("");
     //   txtBookQty.setText("");
    }
    public void DateDiff() throws ParseException {

        String date1 = issuse.getIssusDate();
        String date2 = issuse.getDueDate();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/mm/yyyy");

        Date d1 = simpleDateFormat.parse(date1);
        Date d2 = simpleDateFormat.parse(date2);

        long DateDiff = d2.getTime() - d1.getTime();

        System.out.println("Date Diff is : "+DateDiff/3600000/24+" Days");
    }

}
