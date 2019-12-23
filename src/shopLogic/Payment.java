package shopLogic;

public class Payment {
    private int idBuyer;
    private int idPayment;
    private int[] arrayOfGoods;

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

    public void setIdBuyer(int idBuyer){
        this.idBuyer = idBuyer;
    }
    public void setIdPayment(int idPayment){
        this.idPayment = idPayment;
    }
    public void setArrayOfGoods(int[] arrayOfGoods){
        this.arrayOfGoods = arrayOfGoods;
    }



}
