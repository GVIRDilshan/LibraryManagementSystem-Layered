package lk.ijse.library.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.library.dto.UserDTO;
import lk.ijse.library.Model.UserModel;

import java.io.IOException;

public class ManageLoginFormController {
    @FXML
    private AnchorPane root;

    @FXML
    private AnchorPane loginPane;

    @FXML
    private JFXTextField txtUserName;

    @FXML
    private JFXPasswordField txtPassWord;

    @FXML
    private JFXButton btnLogin;
    public static AnchorPane rootcopy;

    public static String userId;

    public void initialize(){
        rootcopy = root;
    }

    @FXML
    void OnForgotPassword(ActionEvent event) {

    }

    @FXML
    void OnSingup(ActionEvent event) {
        try {
            Parent view = FXMLLoader.load(this.getClass().getResource("/view/UserForm.fxml"));
            Stage primaryStage = (Stage) root.getScene().getWindow();
            Scene scene = new Scene(view);
            primaryStage.setScene(scene);
            primaryStage.centerOnScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onLogin(ActionEvent event) {
        System.out.println(txtPassWord.getText());
        System.out.println(txtUserName.getText());

        try {
            UserDTO user = UserModel.SearchUser(txtUserName.getText());

            if (user != null && user.getPassword().equals(txtPassWord.getText())) {
                this.userId = user.getName();
                root.getChildren().clear();
                try {
//                    root.getChildren().add(FXMLLoader.load(this.getClass().getResource("/view/Dashboard.fxml")));

                    Stage stage = (Stage) root.getScene().getWindow();
                    stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/view/DashBoardFrom.fxml"))));
                    stage.centerOnScreen();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                new Alert(Alert.AlertType.ERROR,
                        "UserName or Password Error",
                        ButtonType.OK
                ).show();

                txtUserName.clear();
                txtPassWord.clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR,
                    "Sql Error",
                    ButtonType.OK
            ).show();
            txtUserName.clear();
            txtPassWord.clear();
        }
    }

    @FXML
    void passwordOnAction(ActionEvent event) {
        onLogin(new ActionEvent());
    }

    @FXML
    void userNameOnAction(ActionEvent event) {
        onLogin(new ActionEvent());
    }
}
