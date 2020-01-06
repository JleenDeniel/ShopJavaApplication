package Controllers;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import connectivity.ConnectionClass;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.util.Callback;
import shopLogic.Good;

/**
 * FXML Controller class
 *
 */
public class StorageModeController implements Initializable {
//todo https://devcolibri.com/javafx-2-%D0%BA%D0%B0%D0%BA-%D0%B2%D1%8B%D0%B2%D0%B5%D1%81%D1%82%D0%B8-%D0%B4%D0%B0%D0%BD%D0%BD%D1%8B%D0%B5-%D0%B2-tableview/
    @FXML
    private TextField goodnameField;
    @FXML
    private TextField goodPriceField;
    @FXML
    private DatePicker goodExpireDatePicker;
    @FXML
    private TextField goodCode;
    @FXML
    private TextField goodPlaceField;
    @FXML
    private TextField goodQuantityField;

    @FXML
    private TableColumn<Good, String> nameCol, priceCol, expireCol, codeCol, placeCol;
    @FXML
    private TableColumn<Good, Integer> quaintityCol, typeCol;

    @FXML
    private Button btnSave;
    @FXML
    private ComboBox<String> goodTypeBox;
    @FXML
    Label lblStatus;

    @FXML
    TableView tblData;

    private ObservableList<Good> storage = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    ConnectionClass connection = new ConnectionClass();

    public StorageModeController() throws SQLException {
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        goodTypeBox.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8");
        initData();
        tblData.setItems(storage);

        nameCol.setCellValueFactory(new PropertyValueFactory<Good, String >("goodName"));
        priceCol.setCellValueFactory(new PropertyValueFactory<Good, String >("goodPrice"));
        expireCol.setCellValueFactory(new PropertyValueFactory<Good, String >("goodExpireDate"));
        codeCol.setCellValueFactory(new PropertyValueFactory<Good, String >("goodCode"));
        placeCol.setCellValueFactory(new PropertyValueFactory<Good, String >("goodPlace"));
        quaintityCol.setCellValueFactory(new PropertyValueFactory<Good, Integer>("goodQuantity"));
        typeCol.setCellValueFactory(new PropertyValueFactory<Good, Integer>("goodType"));

    }

    @FXML
    private void HandleEvents(MouseEvent event) {
        //check if not empty
        if (goodCode.getText().isEmpty() || goodnameField.getText().isEmpty() || goodPriceField.getText().isEmpty() || goodExpireDatePicker.getValue().equals(null)) {
            lblStatus.setTextFill(Color.TOMATO);
            lblStatus.setText("Enter all details");
        } else {
            saveData();
        }

    }

    private void clearFields() {
        goodnameField.clear();
        goodPriceField.clear();
        goodCode.clear();
        goodPlaceField.clear();
        goodQuantityField.clear();
    }

    private String saveData() {

        try {
            connection.addToGoods(goodnameField.getText(), goodPriceField.getText(), setDateForConnector(goodExpireDatePicker.getValue().toString()), goodCode.getText(),
                    goodPlaceField.getText(), Integer.parseInt(goodQuantityField.getText()), Integer.parseInt(goodTypeBox.getValue()));

            lblStatus.setTextFill(Color.GREEN);
            lblStatus.setText("Added Successfully");

            clearFields();
            return "Success";

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            lblStatus.setTextFill(Color.TOMATO);
            lblStatus.setText(ex.getMessage());
            return "Exception";
        }
    }


    //only fetch columns
    private void initData() {
        String SQL = "SELECT * from goods";
        try {
            ResultSet res = connection.execQuery(SQL);
            while(res.next()){
                storage.add(new Good(res.getString(2), res.getString(3), res.getString(4),
                        res.getString(5), res.getString(6), res.getInt(7), res.getInt(8)));
            }

        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());

        }
    }

    public String setDateForConnector(String value){
        String res = new String();
        char[] year = new char[4];
        char[] month = new char[2];
        char[] day = new char[2];
        value.getChars(6, 9, year, 0);
        value.getChars(3, 4, month, 0);
        value.getChars(0, 1, day, 0);
        res.join( year.toString(),"-", month.toString(),"-", day.toString());
        return res;
    }

}
