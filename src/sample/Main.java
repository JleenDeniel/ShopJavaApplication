package sample;


import connectivity.ConnectionClass;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;


public class Main extends Application {
    private static String userEmail;
    private static  String userPassword;
    private int userAccessLvl;

    public void setUserAccessLvl(int userAccessLvl){
        this.userAccessLvl = userAccessLvl;
    }


    @Override
    public void start(Stage stage) throws IOException, SQLException {
        ConnectionClass connection = new ConnectionClass();

        //Parent root = FXMLLoader.load(getClass().getResource("../fxml/login.fxml"));
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Welcome");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0 , 2, 1);

        Label userName = new Label("User:");
        grid.add(userName, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label password = new Label("Password:");
        grid.add(password, 0 ,2);

        PasswordField passwordField = new PasswordField();
        grid.add(passwordField, 1, 2);

        Button btn = new Button("Sign in");
        grid.add(btn, 1, 3);

        Scene scene = new Scene(grid, 300, 275);
        stage.setScene(scene);
        stage.show();

        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                userEmail = userTextField.getText();
                userPassword = passwordField.getText();
                try {

                    if(connection.login(userEmail, userPassword) >= 0){
                        setUserAccessLvl(connection.login(userEmail, userPassword));
                        Node node = (Node) event.getSource();
                        Stage stage = (Stage) node.getScene().getWindow();
                        stage.close();
                        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/fxml/mainWindow.fxml")));
                        stage.setScene(scene);
                        stage.show();
                    }else{
                        userTextField.clear();
                        passwordField.clear();
                        btn.setText("Не сущeствует учетной записи");
                    }
                } catch (SQLException | IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }






    public static void main(String[] args) {
        launch(args);
    }
}
