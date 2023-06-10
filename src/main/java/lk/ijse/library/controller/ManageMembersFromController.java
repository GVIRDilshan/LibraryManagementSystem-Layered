package lk.ijse.library.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import lk.ijse.library.dto.MemberDTO;
import lk.ijse.library.model.MemberModel;
import lk.ijse.library.util.Regex;

import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ManageMembersFromController {
    @FXML
    private AnchorPane root;

    @FXML
    private TableView<MemberDTO> tblMembers;

    @FXML
    private TableColumn<?, ?> colMemberID;

    @FXML
    private TableColumn<?, ?> ColName;

    @FXML
    private TableColumn<?, ?> colAge;

    @FXML
    private TableColumn<?, ?> colEmail;


    @FXML
    private JFXTextField txtMemberId;

    @FXML
    private JFXTextField txtMemberName;

    @FXML
    private JFXTextField txtMemberAddress;

    @FXML
    private JFXTextField txtMemberContact;

    @FXML
    private JFXTextField txtMemberAge;

    @FXML
    private JFXTextField txtMemberEmail;

    @FXML
    private JFXTextField txtMemberGender;

    @FXML
    private JFXTextField txtMemberIdSearch;

    @FXML
    private Text txt1;
    @FXML
    private Label lbl1;

    @FXML
    private Label lbl2;

    @FXML
    private Label lbl3;

    @FXML
    private Label lbl4;

    @FXML
    private Label lbl5;

    @FXML
    private Label lbl6;

    @FXML
    private Label lbl7;

    MemberDTO member = new MemberDTO();

    @FXML
    void OnAdd(ActionEvent event) throws SQLException {
        String memberId = txtMemberId.getText();
        String memberName = txtMemberName.getText();
        String memberAddress = txtMemberAddress.getText();
        int memberAge = Integer.parseInt(txtMemberAge.getText());
        String memberContact = txtMemberContact.getText();
        String memberEmail = txtMemberEmail.getText();
        String memberGender = txtMemberGender.getText();

/*        Member memberss = new Member();*/

        member.setId(memberId);
        member.setName(memberName);
        member.setAddress(memberAddress);
        member.setAge(memberAge);
        member.setContact(memberContact);
        member.setEmail(memberEmail);
        member.setGender(memberGender);

        boolean member1 = MemberModel.memberAdd(member);

        if (member1) {
            new Alert(Alert.AlertType.CONFIRMATION, "Member Adding Sucses....!").show();
            clear();
        }

    }

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

    public void OnSearch(ActionEvent actionEvent) throws SQLException {
        String SearchID = txtMemberIdSearch.getText();

        MemberDTO m1 = MemberModel.searchFrom(SearchID);

        txtMemberId.setText(m1.getId());
        txtMemberName.setText(m1.getName());
        txtMemberAddress.setText(m1.getAddress());
        txtMemberAge.setText(String.valueOf(m1.getAge()));
        txtMemberEmail.setText(m1.getEmail());
        txtMemberContact.setText(m1.getContact());
        txtMemberGender.setText(m1.getGender());

    }

    public void OnUpdate(ActionEvent actionEvent) throws SQLException {
        String memberId = txtMemberId.getText();
        String memberName = txtMemberName.getText();
        String memberAddress = txtMemberAddress.getText();
        String memberContact = txtMemberContact.getText();
        int memberAge = Integer.parseInt(txtMemberAge.getText());
        String memberEmail = txtMemberEmail.getText();
        String memberGender = txtMemberGender.getText();

//        Member member = new Member();
        member.setId(memberId);
        member.setName(memberName);
        member.setAddress(memberAddress);
        member.setContact(memberContact);
        member.setAge(memberAge);
        member.setEmail(memberEmail);
        member.setGender(memberGender);

        boolean m2 = MemberModel.updateMember(member);

        if (m2) {
            new Alert(Alert.AlertType.CONFIRMATION, "Member Update Sucses....!").show();

            clear();
        }
    }

    public void OnDelete(ActionEvent actionEvent) throws SQLException {

        String memberID = txtMemberId.getText();

        boolean d1 = MemberModel.deleteFrom(memberID);

        if (d1) {
            new Alert(Alert.AlertType.CONFIRMATION, "member Adding Sucses....!").show();
            clear();
        }

    }

    public void clear() {
        txtMemberId.setText("");
        txtMemberName.setText("");
        txtMemberAddress.setText("");
        txtMemberContact.setText("");
        txtMemberAge.setText("");
        txtMemberEmail.setText("");
        txtMemberGender.setText("");
    }

    public void GoView(ActionEvent actionEvent) {
        try {
            Parent view = FXMLLoader.load(this.getClass().getResource("/view/MemberTableFrom.fxml"));
            Stage primaryStage = (Stage) root.getScene().getWindow();
            Scene scene = new Scene(view);
            primaryStage.setScene(scene);
            primaryStage.centerOnScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void MemberContactOnAction(KeyEvent keyEvent) {
        Pattern compile = Regex.getMobilePattern();
        Matcher matcher = compile.matcher(txtMemberContact.getText());
        boolean matches = matcher.matches();
        if (matches) {
            lbl6.setStyle("-fx-background-color: #2ecc71;");
        } else {
            lbl6.setStyle("-fx-background-color: #c0392b;");
        }
    }

    public void memberEmailOnAction(KeyEvent keyEvent) {
        Pattern compile = Regex.getEmailPattern();
        Matcher matcher = compile.matcher(txtMemberEmail.getText());
        boolean matches = matcher.matches();
        if (matches) {
            lbl7.setStyle("-fx-background-color: #2ecc71;");
        } else {
            lbl7.setStyle("-fx-background-color: #c0392b;");
        }
    }

    public void memberNameOnAction(KeyEvent keyEvent) {
        Pattern compile = Regex.getNamePattern();
        Matcher matcher = compile.matcher(txtMemberName.getText());
        boolean matches = matcher.matches();
        if (matches) {
            lbl2.setStyle("-fx-background-color: #2ecc71;");
        } else {
            lbl2.setStyle("-fx-background-color: #c0392b;");
        }
    }

    public void memberAddressOnAction(KeyEvent keyEvent) {
        Pattern compile = Regex.getAddressPattern();
        Matcher matcher = compile.matcher(txtMemberAddress.getText());
        boolean matches = matcher.matches();
        if (matches) {
            lbl3.setStyle("-fx-background-color: #2ecc71;");
        } else {
            lbl3.setStyle("-fx-background-color: #c0392b;");
        }
    }
//    private void setTurnId() {
//        try {
//            String newTurnId = MemberModel.genarateTurnId();
//            txtMemberId.setText(newTurnId);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//        setTurnId();
//        txtMemberId.setEditable(false);
//    }
}