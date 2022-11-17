
package drassistant;

import database.TableSchema;
import getway.AuthGetway;
import java.io.File;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
public class DrAssistant extends Application {

    AuthGetway auth = new AuthGetway();

    @Override
    public void start(Stage stage) throws Exception {
        if (auth.totalUser() == 0) {
            Parent root = FXMLLoader.load(getClass().getResource("/view/Registration.fxml"));
            root.getStylesheets().add("../css/main.css");
            Scene scene = new Scene(root);
            stage.setTitle("NHPB - Registration");
            stage.setScene(scene);
            stage.show();

        } else {
            Parent root = FXMLLoader.load(getClass().getResource("/view/Login.fxml"));
            root.getStylesheets().add("../css/main.css");
            Scene scene = new Scene(root);
            stage.setTitle("NHPB - Login");
            stage.setScene(scene);
            stage.show();
        }
    }


    public static void main(String[] args) {
        String path = System.getProperty("user.home");
        new File(path + "\\Documents\\NHPB").mkdir();
        TableSchema.connect();
        launch(args);
    }

}
