package shopLogic;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Good {
    private SimpleStringProperty goodName;
    private SimpleStringProperty goodPrice;
    private SimpleStringProperty goodExpireDate;
    private SimpleStringProperty goodCode;
    private  SimpleStringProperty goodPlace;
    private SimpleIntegerProperty goodQuantity;
    private SimpleIntegerProperty goodType;


    public Good(String goodName, String goodPrice, String goodExpireDate, String goodCode, String goodPlace, Integer goodQuantity, Integer goodType) {
        this.goodName = new SimpleStringProperty(goodName);
        this.goodPrice = new SimpleStringProperty(goodPrice);
        this.goodExpireDate = new SimpleStringProperty(goodExpireDate);
        this.goodCode = new SimpleStringProperty(goodCode);
        this.goodPlace = new SimpleStringProperty(goodPlace);
        this.goodQuantity = new SimpleIntegerProperty(goodQuantity);
        this.goodType = new SimpleIntegerProperty(goodType);
    }
}
