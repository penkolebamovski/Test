/**
 * @author Ivaylo Penev(ipenev91@gmail.com) on 10/13/15.
 */
public class ProductSlot {
    public Product product;
    public int currentQuantity;
    public int maxQuantity;

    public ProductSlot(Product product,int currentQuantity,int maxQuantity) {
        this.product = product;
        this.maxQuantity = maxQuantity;
        this.currentQuantity = currentQuantity;
    }
}
