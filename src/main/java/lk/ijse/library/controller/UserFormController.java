package lk.ijse.library.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import lk.ijse.library.dto.UserDTO;
import lk.ijse.library.model.UserModel;
import lk.ijse.library.util.Regex;

import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserFormController {

    @FXML
    private AnchorPane root;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtUserName;

    @FXML
    private JFXPasswordField txtPassword;

    @FXML
    void OnBack(MouseEvent event) {
        try {
            Parent view = FXMLLoader.load(this.getClass().getResource("/view/loginForm.fxml"));
            Stage primaryStage = (Stage) root.getScene().getWindow();
            Scene scene = new Scene(view);
            primaryStage.setScene(scene);
            primaryStage.centerOnScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void OnPassword(KeyEvent event) {
        Pattern compile = Regex.getUserName();
        Matcher matcher = compile.matcher(txtPassword.getText());
        boolean matches = matcher.matches();
        if (matches){
            txtPassword.setUnFocusColor(Paint.valueOf("green"));
        }else{
            txtPassword.setUnFocusColor(Paint.valueOf("red"));
        }
    }

    @FXML
    void OnUserName(KeyEvent event) {
        Pattern compile = Regex.getUserName();
        Matcher matcher = compile.matcher(txtUserName.getText());
        boolean matches = matcher.matches();
        if (matches){
            txtUserName.setUnFocusColor(Paint.valueOf("green"));
        }else{
            txtUserName.setUnFocusColor(Paint.valueOf("red"));
        }
    }

    @FXML
    void onName(KeyEvent event) {
        Pattern compile = Regex.getNamePattern();
        Matcher matcher = compile.matcher(txtName.getText());
        boolean matches = matcher.matches();
        if (matches){
            txtName.setUnFocusColor(Paint.valueOf("green"));
        }else{
            txtName.setUnFocusColor(Paint.valueOf("red"));
        }
    }

    @FXML
    void onSingUp(MouseEvent event) throws SQLException {
        String name = this.txtName.getText();
        String userName = this.txtUserName.getText();
        String password = this.txtPassword.getText();

        UserDTO user = new UserDTO();

        user.setName(name);
        user.setUserName(userName);
        user.setPassword(password);

        boolean users = UserModel.singUp(user);
    }
}
