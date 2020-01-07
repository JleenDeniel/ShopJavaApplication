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
import org.json.simple.JSONObject;


import java.io.*;
import java.sql.SQLException;
import java.util.Scanner;

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
        int accessLvl = connection.login(login, password);
        if(accessLvl >= 0) {                // successful connection
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();

            switch (accessLvl){
                case 1:{
                    stage.close();
                    Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/fxml/storageMode.fxml")));
                    stage.setResizable(false);
                    stage.setScene(scene);
                }
                case 2:{
                    stage.close();
                    Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/fxml/cashierMode.fxml")));
                    stage.setResizable(false);
                    stage.setScene(scene);
                }
                case 3:{
                    stage.close();
                    Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/fxml/Chooser.fxml")));
                    stage.setResizable(false);
                    stage.setScene(scene);
                }


                default:
                    statusLabel.setText("В базе данных какое то чучело с неизвестным мне уровнем доступа");

            }

            stage.show();

            //  clearUserFile();

            JSONObject object = new JSONObject();

            object.put("accessLvl", accessLvl);
            object.put("name", loginField.getText());

            try(FileWriter userFile = new FileWriter("src/resources/user.json")){
                userFile.write(object.toJSONString());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }else{
            statusLabel.setText("Такого аккаунта не существует!");
            passwordField.clear();
        }
    }

    public void clearUserFile(){
        try(FileReader reader = new FileReader("src/resources/user.json")){
            Scanner scanner = new Scanner(reader);
            String checkingStr = scanner.nextLine();
            if(checkingStr.length() > 0){
                FileWriter fwOb = new FileWriter("src/resources/user.json", false);
                PrintWriter pwOb = new PrintWriter(fwOb, false);
                pwOb.flush();
                pwOb.close();
                fwOb.close();
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
