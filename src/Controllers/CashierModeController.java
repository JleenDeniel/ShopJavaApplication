package Controllers;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class CashierModeController {
    @FXML
    private Button findGoodByCodeBtn;
    @FXML
    private TextField codeField;


    public void findGoodBtnClick(javafx.event.ActionEvent event){
        String code  = codeField.getText();
        Pane pane = new Pane();
        Label lbl = new javafx.scene.control.Label(code);
        pane.getChildren().addAll(lbl);
        Scene scene =   new Scene(pane);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

}
