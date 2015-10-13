/**
 * @author Ivaylo Penev(ipenev91@gmail.com) on 10/13/15.
 */
public class OrderProduct {

    public String name;
    public int quantity;
    public double deliverPrice;
    public double sellPrice;


    public OrderProduct(String name,int quantity,double deliverPrice, double sellPrice) {
        this.name = name;
        this.deliverPrice = deliverPrice;
        this.sellPrice  = sellPrice;
    }
}
