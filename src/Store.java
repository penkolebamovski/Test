import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Ivaylo Penev(ipenev91@gmail.com) on 10/13/15.
 */
public class Store {

    private HashMap<String, ProductSlot> products = new HashMap<>();

    private List<OrderProduct> orderList = new ArrayList<>();

    public void addProduct(Product product, int currentQuantity, int maxQuantity) {

        if (product.getName().equals("")) {
            throw new IllegalArgumentException("Product with empty name is added.");
        }
        if (product.price < 0) {
            throw new IllegalArgumentException("Negative price add to product");
        }
        if (maxQuantity < 0) {
            throw new IllegalArgumentException("Negative max quantity is add");
        }
        if (currentQuantity < 0) {
            throw new IllegalArgumentException("Negative current quantity added.");
        }
        products.put(product.getName(), new ProductSlot(product, currentQuantity, maxQuantity));
    }

    public int add(String name, int quantity) {  // add more quantity to currentQuantity;

        ProductSlot product = products.get(name);

        if (product.currentQuantity + quantity > product.maxQuantity) {
            throw new IllegalArgumentException("try to add quantity more than max quantity");
        }
        return product.currentQuantity += quantity;
    }

    public void register(OrderProduct order) {
        orderList.add(order);
    }

    public int sellOrderedProduct(OrderProduct product, int sellQuantity) {
        orderList.add(product);

        return product.quantity -= sellQuantity;
    }

    public int sell(String name, int sellQuantity) {

        if (!products.containsKey(name)) {
            throw new IllegalArgumentException("Product do not exist");
        }

        ProductSlot product = products.get(name);


        if (product.currentQuantity - sellQuantity < 0) {
            throw new IllegalArgumentException("Not enough product for sale");
        }
        return product.currentQuantity -= sellQuantity;
    }

    public double profit() {
        double total = 0.0;
        double profit = 0.0;
        for (int i = 0; i < orderList.size(); i++) {
            OrderProduct orderProduct = orderList.get(i);

            profit = (orderProduct.sellPrice-orderProduct.deliverPrice)*orderProduct.quantity;

            total+= profit;
        }
        return profit;
    }

}
