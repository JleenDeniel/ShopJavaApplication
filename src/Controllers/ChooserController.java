package Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.StackPane;
import shopLogic.User;

import javax.jws.soap.SOAPBinding;
import java.io.IOException;

public class ChooserController {
    @FXML
    public ChoiceBox choiceOfMode = new ChoiceBox();

    ObservableList<String> modes = FXCollections.observableArrayList("Inventory", "Goods", "Cashier", "Administration");








}
