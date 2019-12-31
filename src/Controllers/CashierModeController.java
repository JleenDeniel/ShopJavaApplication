package Controllers;

import connectivity.ConnectionClass;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class CashierModeController {
    @FXML
    private Button findGoodByCodeBtn;
    @FXML
    private TextField codeField;


    public void findGoodBtnClick(javafx.event.ActionEvent event){
        String code  = codeField.getText();
        int id = 0;
        String name = "";
//        Pane pane = new Pane();
//        Label lbl = new javafx.scene.control.Label(code);
//        pane.getChildren().addAll(lbl);
//        Scene scene =   new Scene(pane);
//        Stage stage = new Stage();
//        stage.setScene(scene);
//        stage.show();
        try{
            ConnectionClass connection = new ConnectionClass();
            String sql = "select id_good, gname from goods where GVENDOR_CODE =" + code + ";";
            ResultSet res = connection.execQuery(sql);
            res.next();
            id = res.getInt(1);
            name = res.getString(2);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

}
