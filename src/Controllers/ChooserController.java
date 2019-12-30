package Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import javafx.scene.control.ChoiceBox;


public class ChooserController {
    @FXML
    public ChoiceBox choiceOfMode = new ChoiceBox();

    ObservableList<String> modes = FXCollections.observableArrayList("Inventory", "Goods", "Cashier", "Administration");








}
