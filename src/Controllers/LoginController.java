package Controllers;

import connectivity.ConnectionClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import  javafx.scene.control.Button;
import javafx.stage.Stage;
import shopLogic.User;


import java.io.IOException;
import java.sql.SQLException;

public class LoginController {

    public static int i;
    @FXML
    public TextField loginField;
    @FXML
    public PasswordField passwordField;
    @FXML
    public Button loginButton;
    @FXML
    private Label statusLabel;


    public void loginToDB(ActionEvent event) throws SQLException, IOException {
        String login = loginField.getText();
        String password = passwordField.getText();
        ConnectionClass connection = new ConnectionClass();
        if(connection.login(login, password) >= 0) {                // successful connection
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/fxml/Chooser.fxml")));
            stage.setScene(scene);
            stage.show();



        }else{
            statusLabel.setText("Такого аккаунта не существует!");
            passwordField.clear();
        }
    }
}
