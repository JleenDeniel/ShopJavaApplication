package Controllers;

import connectivity.ConnectionClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;


public class CashierModeController {
    @FXML
    private Button findGoodByCodeBtn, makePayment;
    @FXML
    private Label sumLabel;
    @FXML
    private TextArea receiptArea;

    private ArrayList<String> arrayOfGoods = new ArrayList<String>();
    private int currentSum;
    private String cardnumber;
    private int idPayment;


    public void setCardnumber(String cardnumber){
        this.cardnumber = cardnumber;
    }

    public String getCardnumber(){
        return cardnumber;
    }

    public void setIdPayment(int idPayment){
        this.idPayment = idPayment;
    }

    public int getIdPayment(){
        return this.idPayment;
    }

    public void addNewGood(String name_good){
        this.arrayOfGoods.add(name_good);
    }
    public Integer getCurrentSum(){
        return currentSum;
    }
    public void setCurrentSum(int sum){
        this.currentSum = sum;
    }
    public void updateSum(int price){
        this.currentSum = this.currentSum + price;
    }

    public void findGoodBtnClick(javafx.event.ActionEvent event){

        TextInputDialog input = new TextInputDialog();
        input.showAndWait();
        String code = input.getEditor().getText();
        int id_good;
        String name_good;
        int price;
        try{
            ConnectionClass connection = new ConnectionClass();
            String sql = "select id_good, gname, gprice from goods where GVENDOR_CODE =" + code + ";";
            ResultSet res = connection.execQuery(sql);

            if(res.next()){
            id_good = res.getInt(1);
            name_good = res.getString(2);
            price = res.getInt(3);


            String sqlId = "Select max(payment_id) from history_payments;";
            ResultSet resId = connection.execQuery(sqlId);
            resId.next();
             if(getIdPayment() == 0) {
                 setIdPayment(1 + resId.getInt(1));
                 makeTheNewReceipt();
             }

            addToAssist(id_good, getIdPayment());

             addNewGood(name_good);
             updateSum(price);
             sumLabel.setText(getCurrentSum().toString());
             receiptArea.appendText(name_good + "..." + price +'\n');

            }
            else{
                 Alert alert = new Alert(Alert.AlertType.INFORMATION);
                 alert.setTitle("Ошибка");
                 alert.setHeaderText(" ");
                 alert.setContentText("Товар с таким артикулом не найден.");
                 alert.show();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void makePaymentBtn(javafx.event.ActionEvent event) throws SQLException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        Optional<ButtonType> option = alert.showAndWait();

        if(option.get() == ButtonType.OK){
            updateReceipt();
            setCardnumber("0");
            setIdPayment(0);
            setCurrentSum(0);
            sumLabel.setText("");
            receiptArea.clear();
        }

    }

    public void makeTheNewReceipt(int sum, String cardnumber) throws SQLException {
        ConnectionClass connection = new ConnectionClass();
        String sql3 = "Insert into history_payments(cardnumber, price) values(" + cardnumber + "," + sum +");";
        connection.execUpdate(sql3);
    }

    public void makeTheNewReceipt() throws SQLException {
        ConnectionClass connection = new ConnectionClass();
        String sql3 = "Insert into history_payments(price, cardnumber) values(0, 1);";
        connection.execUpdate(sql3);
    }

    public void updateReceipt() throws SQLException {
        ConnectionClass connection = new ConnectionClass();
        String sql = "";
        if(getCardnumber().equals("0")) {
            sql = "Update history_payments set price = " + getCurrentSum() + " where payment_id =" + getIdPayment() + ";";
        }
        else {
            sql = "Update history_payments set price = " + getCurrentSum() +
                    ", cardnumber =" + getCardnumber() + " where payment_id =" + getIdPayment() + ";";
        }
        connection.execUpdate(sql);
    }

    public void addToAssist(int id_good, int id_payment) throws SQLException {
        ConnectionClass connection = new ConnectionClass();
        String sql2 = "Insert into assistTable(id_good, payment_id) values(" + id_good + "," + id_payment + ");";
        connection.execUpdate(sql2);
    }

    public void setCardnumBtn(ActionEvent event){
        TextInputDialog setCard = new TextInputDialog();
        setCard.showAndWait();
        String cardnum = setCard.getEditor().getText();
        setCardnumber(cardnum);
    }


}
