package lk.ijse.library.controller.tdm;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.library.bo.BOFactory;
import lk.ijse.library.bo.custom.MemberBO;
import lk.ijse.library.dto.MemberDTO;
import lk.ijse.library.Model.MemberModel;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MemberTM implements Initializable {

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<MemberDTO> tblMembers;

    @FXML
    private TableColumn<?, ?> colMemberID;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colContact;

    @FXML
    private TableColumn<?, ?> colAge;

    @FXML
    private TableColumn<?, ?> colEmail;

    @FXML
    private TableColumn<?, ?> colGender;

    MemberBO memberBO = (MemberBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.MEMBER);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tblMembers.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblMembers.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblMembers.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));
        tblMembers.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("contact"));
        tblMembers.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("age"));
        tblMembers.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("email"));
        tblMembers.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("Gender"));

        tblMembers.refresh();

        ArrayList<MemberDTO> members;
        try {
            members = memberBO.loadAllMember();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        tblMembers.setItems(FXCollections.observableArrayList(members));
    }

    public void onBack(ActionEvent actionEvent) {
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
}