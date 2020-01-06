package shopLogic;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Good {
    private StringProperty goodName;
    private StringProperty goodPrice;
    private StringProperty goodExpireDate;
    private StringProperty goodCode;
    private StringProperty goodPlace;

    private IntegerProperty goodQuantity;
    private IntegerProperty goodType;


    public Good(String goodName, String goodPrice, String goodExpireDate, String goodCode, String goodPlace, Integer goodQuantity, Integer goodType) {
        this.goodName = new SimpleStringProperty(goodName);
        this.goodPrice = new SimpleStringProperty(goodPrice);
        this.goodExpireDate = new SimpleStringProperty(goodExpireDate);
        this.goodCode = new SimpleStringProperty(goodCode);
        this.goodPlace = new SimpleStringProperty(goodPlace);
        this.goodQuantity = new SimpleIntegerProperty(goodQuantity);
        this.goodType = new SimpleIntegerProperty(goodType);
    }

    public void setGoodName(String value){goodNameProperty().set(value); }
    public String getGoodName(){return goodNameProperty().get(); }
    public StringProperty goodNameProperty(){
        if(goodName == null) goodName = new SimpleStringProperty(this, "goodName");
        return goodName;
    }

    public void setGoodPrice(String value){goodPriceProperty().set(value); }
    public String getGoodPrice(){return goodPriceProperty().get(); }
    public StringProperty goodPriceProperty(){
        if(goodPrice == null) goodPrice = new SimpleStringProperty(this, "goodPrice");
        return goodPrice;
    }

    public void setGoodExpireDate(String value){goodExpireDateProperty().set(value); }
    public String getGoodExpireDate(){return goodExpireDateProperty().get(); }
    public StringProperty goodExpireDateProperty(){
        if(goodExpireDate == null) goodExpireDate = new SimpleStringProperty(this, "goodExpireDate");
        return goodExpireDate;
    }
    public void setGoodCode(String value){goodCodeProperty().set(value); }
    public String getGoodCode(){return goodCodeProperty().get(); }
    public StringProperty goodCodeProperty(){
        if(goodCode == null) goodCode = new SimpleStringProperty(this, "goodCode");
        return goodCode;
    }
    public void setGoodPlace(String value){goodPlaceProperty().set(value); }
    public String getGoodPlace(){return goodPlaceProperty().get(); }
    public StringProperty goodPlaceProperty(){
        if(goodPlace == null) goodPlace = new SimpleStringProperty(this, "goodPlace");
        return goodPlace;
    }
    public void setGoodQuantity(int value){goodQuantityProperty().set(value); }
    public int getGoodQuantity(){return goodQuantityProperty().get(); }
    public IntegerProperty goodQuantityProperty(){
        if(goodQuantity == null) goodQuantity = new SimpleIntegerProperty(this, "goodQuantity");
        return goodQuantity;
    }
    public void setGoodType(int value){goodTypeProperty().set(value); }
    public int getGoodType(){return goodTypeProperty().get(); }
    public IntegerProperty goodTypeProperty(){
        if(goodType == null) goodType = new SimpleIntegerProperty(this, "goodType");
        return goodType;
    }

}
