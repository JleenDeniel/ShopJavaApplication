package Controllers;

import connectivity.ConnectionClass;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import javafx.event.ActionEvent;

import java.sql.SQLException;

public class MainWindowController {
    @FXML
    private TableView goodsTable;
    @FXML
    private Button addToGoodsBtn;
    @FXML
    private TextField goodNameField, goodPriceField, codeGoodField, expireDateField,
                      placeGoodField, quaintityGoodField, typeGoodField;




    public void AddToGoods(ActionEvent event){
        String name = goodNameField.getText();
        String price = goodPriceField.getText();
        String code  = codeGoodField.getText();
        String expire = expireDateField.getText();
        String place = placeGoodField.getText();
        int quaintity = Integer.parseInt(quaintityGoodField.getText());
        int type = Integer.parseInt(typeGoodField.getText());
        try{
            ConnectionClass connection = new ConnectionClass();
            connection.addToGoods(name, price, code, expire, place, quaintity, type);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
