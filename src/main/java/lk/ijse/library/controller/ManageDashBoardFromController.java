package lk.ijse.library.controller;

import javafx.animation.AnimationTimer;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import lk.ijse.library.dto.IssuseDTO;
import lk.ijse.library.dto.ReturnDTO;
import lk.ijse.library.Model.IssuseModel;
import lk.ijse.library.Model.ReturnModel;
import net.sf.jasperreports.engine.*;

import java.io.*;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ManageDashBoardFromController implements Initializable {

    public Label dateLbl;

    public Label timeLbl;
    @FXML
    private AnchorPane root;

    @FXML
    private AnchorPane MainPane;

    @FXML
    private AnchorPane dashBoardPane;
    @FXML
    private Label lblTopic;

    @FXML
    private TableView<IssuseDTO> tblIssuse;

    @FXML
    private TableColumn<?, ?> coliid;

    @FXML
    private TableColumn<?, ?> colBookId;

    @FXML
    private TableColumn<?, ?> colIssuseDate;

    @FXML
    private TableColumn<?, ?> colMemberID;

    @FXML
    private TableColumn<?, ?> colDueDate;

    @FXML
    private TableColumn<?, ?> colIssuseQty;

    @FXML
    private TableView<ReturnDTO> tblReturn;

    @FXML
    private TableColumn<?, ?> colReturnID;

    @FXML
    private TableColumn<?, ?> colReturnDate;

    @FXML
    private TableColumn<?, ?> colIssuseID;

    @FXML
    private TableColumn<?, ?> colBookID;

    @FXML
    private LineChart<?, ?> barChart;

    @FXML
    private Text txtDate;

    @FXML
    private Text txtTime;

    @FXML
    private Pane ReportPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        BarCharts();
        realDateTimes();
        IssuseTableView();
        ReturnTableView();

    }
    public void ReturnTableView(){
        tblReturn.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("ReturnId"));
        tblReturn.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("ReturnDate"));
        tblReturn.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("IssuseId"));
        tblReturn.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("IssuseDate"));
        tblReturn.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("BookId"));

        ArrayList<ReturnDTO> returns;
        try {
            returns = ReturnModel.loadAllReturnas();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        tblReturn.setItems(FXCollections.observableArrayList(returns));
    }
    public void IssuseTableView(){
        tblIssuse.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("issusId"));
        tblIssuse.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("bookId"));
        tblIssuse.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("issusDate"));
        tblIssuse.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("memberId"));
        tblIssuse.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        tblIssuse.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("issuseQty"));

        ArrayList<IssuseDTO> issuses;
        try {
            issuses = IssuseModel.loadAllIssuse();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        tblIssuse.setItems(FXCollections.observableArrayList(issuses));

    }
    public void realDateTimes(){
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                txtDate.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                txtTime.setText(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
            }
        };
        timer.start();
    }
    public void BarCharts(){
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("first Week");
        series1.getData().add(new XYChart.Data("Day 1",3));
        series1.getData().add(new XYChart.Data("Day 2",49));
        series1.getData().add(new XYChart.Data("Day 3",25));
        series1.getData().add(new XYChart.Data("Day 4",41));
        series1.getData().add(new XYChart.Data("Day 5",77));

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Second week");
        series2.getData().add(new XYChart.Data("Day 1",5));
        series2.getData().add(new XYChart.Data("Day 2",19));
        series2.getData().add(new XYChart.Data("Day 3",16));
        series2.getData().add(new XYChart.Data("Day 4",45));
        series2.getData().add(new XYChart.Data("Day 5",80));
//        series2.getData().add(new XYChart.Data("Day 6",50));

        XYChart.Series series3 = new XYChart.Series();
        series3.setName("3rd week");
        series3.getData().add(new XYChart.Data("Day 1",0));
        series3.getData().add(new XYChart.Data("Day 2",45));
        series3.getData().add(new XYChart.Data("Day 3",35));
        series3.getData().add(new XYChart.Data("Day 4",28));
        series3.getData().add(new XYChart.Data("Day 5",90));

        XYChart.Series series4 = new XYChart.Series();
        series3.setName("4th week");
        series4.getData().add(new XYChart.Data("Day 1",1));
        series4.getData().add(new XYChart.Data("Day 2",34));
        series4.getData().add(new XYChart.Data("Day 3",26));
        series4.getData().add(new XYChart.Data("Day 4",76));
        series4.getData().add(new XYChart.Data("Day 5",90));

        barChart.getData().addAll(series1,series2,series3,series4);

    }
    public void GoMember(javafx.event.ActionEvent actionEvent) throws IOException {
        Node node;
        node = FXMLLoader.load(getClass().getResource("/view/MemberManageFrom.fxml"));
        MainPane.getChildren().setAll(node);
        lblTopic.setText("MemberFrom");
    }
    public void GoBook(ActionEvent actionEvent) throws IOException {
        Node node;
        node = FXMLLoader.load(getClass().getResource("/view/BookManageFrom.fxml"));
        MainPane.getChildren().setAll(node);
        lblTopic.setText("BookFrom");
    }
    public void GoIssuse(ActionEvent actionEvent) throws IOException {
        Node node;
        node = FXMLLoader.load(getClass().getResource("/view/IssuseFrom.fxml"));
        MainPane.getChildren().setAll(node);
        lblTopic.setText("Issuse From");
    }
    public void GoReturn(ActionEvent actionEvent) throws IOException {
        Node node;
        node = FXMLLoader.load(getClass().getResource("/view/ReturnFrom.fxml"));
        MainPane.getChildren().setAll(node);
        lblTopic.setText("Return From");
    }
    public void goAutor(ActionEvent actionEvent) throws IOException {
        Node node;
        node = FXMLLoader.load(getClass().getResource("/view/AutorAddFrom.fxml"));
        MainPane.getChildren().setAll(node);
        lblTopic.setText("Autor From");
    }
    public void GoPublishers(ActionEvent actionEvent) throws IOException {
        Node node;
        node = FXMLLoader.load(getClass().getResource("/view/PublisherAddFrom.fxml"));
        MainPane.getChildren().setAll(node);
        lblTopic.setText("Publisher From");
    }
    public void GoSuppliers(ActionEvent actionEvent) throws IOException {
        Node node;
        node = FXMLLoader.load(getClass().getResource("/view/SupplierAddFrom.fxml"));
        MainPane.getChildren().setAll(node);
        lblTopic.setText("Supplier From");
    }
    public void GoDashBoard(ActionEvent actionEvent) throws IOException {
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
    public void GetReport(ActionEvent actionEvent) throws IOException, JRException, SQLException {
//        InputStream input=new FileInputStream(new File("F:\\rep\\LibraryManagementSystem\\src\\main\\resources\\Report\\Wood.jrxml"));
//        JasperDesign jasperDesign = JRXmlLoader.load(input);
//        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
//
//        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,null, DBConnection.getInstance().getConnection());
//
//        JasperViewer.viewReport(jasperPrint,false);
        Node node;
        node = FXMLLoader.load(getClass().getResource("/view/ReportServiesFrom.fxml"));
        MainPane.getChildren().setAll(node);
        lblTopic.setText("Report From");
    }
    public void getEmail(ActionEvent actionEvent) throws IOException {
        Node node;
        node = FXMLLoader.load(getClass().getResource("/view/EmailFrom.fxml"));
        MainPane.getChildren().setAll(node);
        lblTopic.setText("Send Email");
    }
    public void GoDonetions(ActionEvent actionEvent) throws IOException {
        Node node;
        node = FXMLLoader.load(getClass().getResource("/view/DonetionFrom.fxml"));
        MainPane.getChildren().setAll(node);
        lblTopic.setText("Send Email");
    }
    public void GoExibitions(ActionEvent actionEvent) throws IOException {
        Node node;
        node = FXMLLoader.load(getClass().getResource("/view/ExibitionsFrom.fxml"));
        MainPane.getChildren().setAll(node);
        lblTopic.setText("Exibitions From");
    }
    public void GoMemberView(ActionEvent actionEvent) throws IOException {
        Node node;
        node = FXMLLoader.load(getClass().getResource("/view/MemberTableFrom.fxml"));
        MainPane.getChildren().setAll(node);
        lblTopic.setText("Member Table View");
    }
    public void GoAutorViwe(ActionEvent actionEvent) throws IOException {
        Node node;
        node = FXMLLoader.load(getClass().getResource("/view/AutorTableFrom.fxml"));
        MainPane.getChildren().setAll(node);
        lblTopic.setText("Autor Table From");
    }
    public void GoSupplierView(ActionEvent actionEvent) throws IOException {
        Node node;
        node = FXMLLoader.load(getClass().getResource("/view/SupplierTableFrom.fxml"));
        MainPane.getChildren().setAll(node);
        lblTopic.setText("Supplier Table From");
    }
    public void GoPublisherView(ActionEvent actionEvent) throws IOException {
        Node node;
        node = FXMLLoader.load(getClass().getResource("/view/publisherTableFrom.fxml"));
        MainPane.getChildren().setAll(node);
        lblTopic.setText("publisher Table From");
    }
    public void ShowAllFines(ActionEvent actionEvent) throws IOException {
        Node node;
        node = FXMLLoader.load(getClass().getResource("/view/FineMoneyTableFrom.fxml"));
        MainPane.getChildren().setAll(node);
        lblTopic.setText("FineMoney Table From");
    }
    public void GoBookView(ActionEvent actionEvent) throws IOException {
        Node node;
        node = FXMLLoader.load(getClass().getResource("/view/BookTableFrom.fxml"));
        MainPane.getChildren().setAll(node);
        lblTopic.setText("Book Table View");
    }
}