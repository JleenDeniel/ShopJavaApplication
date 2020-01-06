package Controllers;

import connectivity.ConnectionClass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import shopLogic.Good;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StorageModeController {
    public TableColumn<Good, String> goodNameCol;
    public TableColumn<Good, String> goodPriceCol;
    public TableColumn<Good, String> expireDateCol;
    public TableColumn<Good, String> codeCol;
    public TableColumn<Good, String> goodPlaceCol;
    public TableColumn<Good, Integer> goodQuaintCol;
    public TableColumn<Good, Integer> goodTypeCol;
    @FXML
    private TableView<Good> storageTable;

    //ArrayList<Good> objectsFromDB = new ArrayList<>();
    ObservableList<Good> goods = FXCollections.observableArrayList();

    @FXML
    private void initialize() throws SQLException {
        setStorage();


        goodNameCol.setCellFactory(new PropertyValueFactory("goodName"));
        goodPriceCol.setCellFactory(new PropertyValueFactory("goodPrice"));
        expireDateCol.setCellFactory(new PropertyValueFactory("goodExpireDate"));
        codeCol.setCellFactory(new PropertyValueFactory("goodCode"));
        goodPlaceCol.setCellFactory(new PropertyValueFactory("goodPlace"));
        goodQuaintCol.setCellValueFactory(new PropertyValueFactory("goodQuantity"));
        goodTypeCol.setCellValueFactory(new PropertyValueFactory("goodType"));

        storageTable.getColumns().setAll(goodNameCol, goodPriceCol, expireDateCol, codeCol, goodPlaceCol, goodQuaintCol, goodTypeCol);
        storageTable = new TableView<>(goods);
    }


    public void setStorage() throws SQLException {
        ConnectionClass connection = new ConnectionClass();
        String sql = "Select * from goods;";
        ResultSet res = connection.execQuery(sql);
        // сделать большой запрос всей таблицы, идти пока res.next(), потом сохдать какую нибудь коллекцию и пушить
        //в нее новые обьекты
        while (res.next()){
            goods.add(new Good(res.getString(2), res.getString(3), res.getString(4),
                    res.getString(5), res.getString(6), res.getInt(7), res.getInt(8)));
        }
    }



}
