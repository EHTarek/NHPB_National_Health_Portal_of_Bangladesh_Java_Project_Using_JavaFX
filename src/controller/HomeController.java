
package controller;

import css.BtnCss;
import getway.AuthGetway;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.User;

/**
 *
 * @author 
 * 
 * Md. Tariqul Islam - 191002037
 * Omit Kumar        - 191002120
 * Joy Kumar Majumder- 191002121
 * Sonia Akter Mona  - 191002197
 * Abdur Razzak      - 191002206
 * 
 */

public class HomeController implements Initializable {

    @FXML
    private StackPane mainContent;
    @FXML
    private Button btnHome;
    @FXML
    private Button btnPrescription;
    @FXML
    private Button btnTemplate;
    @FXML
    private Button btnPatient;
    @FXML
    private Button btnDrug;
    @FXML
    private Button btnSetting;

    BtnCss css = new BtnCss();
    User user = new User();
    AuthGetway auth = new AuthGetway();
    
    
    
    @FXML
    private Label lblFullName;
    @FXML
    private Label lblUserName;


    @Override
    public void initialize(URL url, ResourceBundle rb) {

        user = auth.getUser();
        lblFullName.setText(user.getFullName());
        lblUserName.setText(user.getUserName() + " (Doctor)");

        try {
            mainContent.getChildren().clear();
            mainContent.getChildren().add(FXMLLoader.load(getClass().getResource("/view/HomeContent.fxml")));
            homeActive();
            Platform.runLater(() -> {
                user = auth.getUser();
                System.out.println(user.getFullName());
            });
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void homeOnAction(ActionEvent event) {
        Stage stage = (Stage) btnSetting.getScene().getWindow();
        stage.setTitle("Home - NHPB");
        try {
            mainContent.getChildren().clear();
            mainContent.getChildren().add(FXMLLoader.load(getClass().getResource("/view/HomeContent.fxml")));
            homeActive();
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void prescriptionOnAction(ActionEvent event) {
        Stage stage = (Stage) btnSetting.getScene().getWindow();
        stage.setTitle("Prescription - NHPB");
        try {
            mainContent.getChildren().clear();
            mainContent.getChildren().add(FXMLLoader.load(getClass().getResource("/view/prescription/Prescriptions.fxml")));
            prescriptionActive();
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void templateOnAction(ActionEvent event) {
        Stage stage = (Stage) btnSetting.getScene().getWindow();
        stage.setTitle("Template - NHPB");
        try {
            mainContent.getChildren().clear();
            mainContent.getChildren().add(FXMLLoader.load(getClass().getResource("/view/template/Templates.fxml")));
            templateActive();
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void patientOnAction(ActionEvent event) {
        Stage stage = (Stage) btnSetting.getScene().getWindow();
        stage.setTitle("Patient - NHPB");
        try {
            mainContent.getChildren().clear();
            mainContent.getChildren().add(FXMLLoader.load(getClass().getResource("/view/patient/Patients.fxml")));
            patientActive();
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void drugOnAction(ActionEvent event) {
        Stage stage = (Stage) btnSetting.getScene().getWindow();
        stage.setTitle("Drug - NHPB");
        try {
            mainContent.getChildren().clear();
            mainContent.getChildren().add(FXMLLoader.load(getClass().getResource("/view/drug/Drugs.fxml")));
            drugActive();
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void settingOnAction(ActionEvent event) {
        Stage stage = (Stage) btnSetting.getScene().getWindow();
        stage.setTitle("Setting - NHPB");
        try {
            mainContent.getChildren().clear();
            mainContent.getChildren().add(FXMLLoader.load(getClass().getResource("/view/Setting.fxml")));
            settingActive();
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handleLogOutButton(ActionEvent event) throws IOException {
        FXMLLoader fXMLLoader = new FXMLLoader();
        fXMLLoader.setLocation(getClass().getResource("/view/Login.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fXMLLoader.load());
        stage.setScene(scene);
        stage.setTitle("NHPB - Login");
        stage.show();

        Stage nStage = (Stage) mainContent.getScene().getWindow();
        nStage.close();
    }

    private void homeActive() {
        btnHome.setStyle(css.homeActive);
        btnPrescription.setStyle("");
        btnTemplate.setStyle("");
        btnPatient.setStyle("");
        btnDrug.setStyle("");
        btnSetting.setStyle("");
    }

    private void prescriptionActive() {
        btnPrescription.setStyle(css.prescriptionActive);
        btnHome.setStyle("");
        btnTemplate.setStyle("");
        btnPatient.setStyle("");
        btnDrug.setStyle("");
        btnSetting.setStyle("");
    }

    private void templateActive() {
        btnTemplate.setStyle(css.templateActive);
        btnHome.setStyle("");
        btnPrescription.setStyle("");
        btnPatient.setStyle("");
        btnDrug.setStyle("");
        btnSetting.setStyle("");
    }

    private void patientActive() {
        btnPatient.setStyle(css.patientActive);
        btnHome.setStyle("");
        btnPrescription.setStyle("");
        btnTemplate.setStyle("");
        btnDrug.setStyle("");
        btnSetting.setStyle("");
    }

    private void drugActive() {
        btnDrug.setStyle(css.drugActive);
        btnHome.setStyle("");
        btnPrescription.setStyle("");
        btnTemplate.setStyle("");
        btnPatient.setStyle("");
        btnSetting.setStyle("");
    }

    private void settingActive() {
        btnSetting.setStyle(css.settingActive);
        btnHome.setStyle("");
        btnPrescription.setStyle("");
        btnTemplate.setStyle("");
        btnPatient.setStyle("");
        btnDrug.setStyle("");
    }

    @FXML
    private void handleAbout(ActionEvent event) throws IOException {
        FXMLLoader fXMLLoader = new FXMLLoader();
        fXMLLoader.setLocation(getClass().getResource("/view/other/About.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fXMLLoader.load());
        stage.setScene(scene);
        stage.setTitle("About");
        stage.show();
    }


    @FXML
    private void handleDeveloperStory(ActionEvent event) {

    }

    @FXML
    private void handleFeedBack(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Feedback");
        alert.setHeaderText("Send mail : gub.tarek@gmail.com");
        alert.showAndWait();
    }

}
