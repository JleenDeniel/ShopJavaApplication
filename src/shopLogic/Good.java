package shopLogic;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Good {
    private String goodName;
    private String goodPrice;
    private String goodExpireDate;
    private String goodCode;
    private String goodPlace;

    private Integer goodQuantity;
    private Integer goodType;


    public Good(String goodName, String goodPrice, String goodExpireDate, String goodCode, String goodPlace, Integer goodQuantity, Integer goodType) {
        this.goodName = goodName;
        this.goodPrice = goodPrice;
        this.goodExpireDate = goodExpireDate;
        this.goodCode = goodCode;
        this.goodPlace = goodPlace;
        this.goodQuantity = goodQuantity;
        this.goodType = goodType;
    }

    public void setGoodName(String value){goodName = value; }
    public String getGoodName(){return goodName; }


    public void setGoodPrice(String value){goodPrice = value; }
    public String getGoodPrice(){return goodPrice; }


    public void setGoodExpireDate(String value){goodExpireDate = value; }
    public String getGoodExpireDate(){return goodExpireDate; }

    public void setGoodCode(String value){goodCode = value; }
    public String getGoodCode(){return goodCode; }

    public void setGoodPlace(String value){goodPlace = value; }
    public String getGoodPlace(){return goodPlace; }

    public void setGoodQuantity(int value){goodQuantity = value; }
    public int getGoodQuantity(){return goodQuantity; }

    public void setGoodType(int value){goodType = value; }
    public int getGoodType(){return goodType;}


}
