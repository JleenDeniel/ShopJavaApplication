package Controllers;

import connectivity.ConnectionClass;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import shopLogic.Payment;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;



public class CashierModeController {
    @FXML
    private Button findGoodByCodeBtn;
    @FXML
    private TextField codeField;
    @FXML
    private Button addToSum;
    @FXML
    private Label currentGood, sumLabel;


    public void findGoodBtnClick(javafx.event.ActionEvent event){
        String code  = codeField.getText();
        int id = 0;
        String name = "";
        Integer price = 0;
        Payment payment = new Payment();
//        Pane pane = new Pane();
//        Label lbl = new javafx.scene.control.Label(code);
//        pane.getChildren().addAll(lbl);
//        Scene scene =   new Scene(pane);
//        Stage stage = new Stage();
//        stage.setScene(scene);
//        stage.show();
        try{
            ConnectionClass connection = new ConnectionClass();
            String sql = "select id_good, gname, gprice from goods where GVENDOR_CODE =" + code + ";";
            ResultSet res = connection.execQuery(sql);

            if (res.next()){
            id = res.getInt(1);
            name = res.getString(2);
            price = res.getInt(3);
            currentGood.setText(name);
            //payment.addToArrayOfGoods(name, price);
            //sumLabel.setText(payment.getCurrentSum().toString());
            }
            else{
                currentGood.setText("Товар с таким артикулом не найден!");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

}
