
package drassistant;

import getway.AuthGetway;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

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

public class LoginController implements Initializable {

    @FXML
    private TextField tfUserName;
    @FXML
    private PasswordField pfPassword;
    @FXML
    private Button btnLogin;

    AuthGetway auth = new AuthGetway();


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void btnLoginOnAction(ActionEvent event) {
        if (isValid()) {
            if (auth.authenticate(tfUserName.getText(), pfPassword.getText())) {
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("/view/Home.fxml"));
                    root.getStylesheets().add("../css/main.css");
                    Scene scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.setTitle("NHPB - Home");
                    stage.setScene(scene);
                    stage.show();

                    Stage nStage = (Stage) btnLogin.getScene().getWindow();
                    nStage.close();

                } catch (IOException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Username or password doesn't match");
                alert.setHeaderText("Username or password doesn't match");
                alert.show();
            }
        }
    }

    @FXML
    private void hlForgetPassword(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/auth/ForgetPassword.fxml"));
            root.getStylesheets().add("../css/main.css");
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("NHPB - Forget Password");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



    private boolean isValid() {
        boolean valid = false;
        if (tfUserName.getText().isEmpty() || pfPassword.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("All field required");
            alert.setHeaderText("Please enter your username and password to login");
            alert.show();
            valid = false;
        } else {
            valid = true;
        }
        return valid;
    }

}
