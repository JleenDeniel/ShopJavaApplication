package Controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.io.IOException;



public class ChooserController {
    @FXML
    private ComboBox modeBox;
    @FXML
    private Button chooseModeBtn;


    public void initialize(){
        modeBox.getItems().addAll( "Склад","Касса");
    }

    public void chooseModeClick(ActionEvent event) throws IOException {
        String choosedValue = modeBox.getValue().toString();
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        switch (choosedValue){
            case "Склад":{
                stage.close();
                Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/fxml/storageMode.fxml")));
                stage.setResizable(false);
                stage.setScene(scene);
            }
            case "Касса":{
                stage.close();
                Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/fxml/cashierMode.fxml")));
                stage.setResizable(false);
                stage.setScene(scene);
            }
            default:{
                chooseModeBtn.setText("Ошибка");
            }
        }
        stage.show();
    }
}
