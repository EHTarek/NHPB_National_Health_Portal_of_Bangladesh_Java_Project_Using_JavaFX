
package controller.auth;

import getway.AuthGetway;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
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

public class ChangePasswordController implements Initializable {

    @FXML
    private PasswordField pfCurrent;
    @FXML
    private PasswordField pfNewPass;
    @FXML
    private PasswordField pfRePass;

    User user = new User();

    AuthGetway auth = new AuthGetway();


    @Override
    public void initialize(URL url, ResourceBundle rb) {

        user = auth.getUser();
        System.out.println("Pass : " + user.getPassword());

    }

    @FXML
    private void handleChangePass(ActionEvent event) {
        if (isValid() && isCurrentPassMatch()) {
            if (auth.changePassword(pfNewPass.getText())) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Password change");
                alert.setHeaderText("Password has been changed");
                alert.showAndWait();

                Stage stage = (Stage) pfCurrent.getScene().getWindow();
                stage.close();
            }
        }
    }

    private boolean isValid() {
        boolean isValid = false;
        if (isNotNull() && isPasswordsAreMatch()) {
            isValid = true;
        }
        return isValid;
    }

    private boolean isCurrentPassMatch() {
        boolean isValid = false;
        if (user.getPassword().matches(pfCurrent.getText())) {
            isValid = true;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Current password not match");
            alert.setHeaderText("Current password not match");
            alert.show();
        }
        return isValid;
    }

    private boolean isNotNull() {
        boolean isValid = false;
        if (pfCurrent.getText().isEmpty() || pfNewPass.getText().isEmpty() || pfRePass.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("All field required");
            alert.setHeaderText("All firleds are required");
            alert.setContentText("All text fields are required. please fill all text field");
            alert.show();
            isValid = false;
        } else {
            isValid = true;
        }
        return isValid;
    }

    private boolean isPasswordsAreMatch() {
        boolean isValid = false;
        if (pfNewPass.getText().matches(pfRePass.getText())) {
            isValid = true;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Given password are not match");
            alert.setHeaderText("Your given password age not match");
            alert.show();
        }
        return isValid;
    }

}
