package shopLogic;

import java.util.ArrayList;

public class Payment {
    private int idBuyer;
    private int idPayment;
    private ArrayList arrayOfGoods;
    private Integer currentSum;

    /*
    What should the program do to create a new Payment?
    1: You should make a new row in history_payments
    2: You should choose the good, while you choosing a good, program should add a new row in
    assist table with current payment_id and with chosen id_good.
    3: When you stop choosing goods, you should choose the buyer, if he got the
    card, else you should choose that there is no card of buyer.
     */
    public Payment(int idBuyer, int idPayment, int[] arrayOfGoods) {

    }

    public Payment() {
        idBuyer = 0;
        idPayment = 0;
        arrayOfGoods = new ArrayList();
        currentSum = 0;
    }

    public void setIdBuyer(int idBuyer){
        this.idBuyer = idBuyer;
    }
    public void setIdPayment(int idPayment){
        this.idPayment = idPayment;
    }
    public void setArrayOfGoods(ArrayList arrayOfGoods){
        this.arrayOfGoods = arrayOfGoods;
    }

    public Integer getCurrentSum(){
        return this.currentSum;
    }

    public void addToArrayOfGoods(String name, Integer price){
        this.arrayOfGoods.add(name);
        this.currentSum += price;
    }



}
