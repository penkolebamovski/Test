import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Ivaylo Penev(ipenev91@gmail.com) on 10/13/15.
 */
public class StoreTests {


    Store store = new Store();

    @Test
    public void sellProduct() throws Exception {

        store.addProduct(new Product("apple", 1.20), 30, 45);
        store.add("apple", 15);

        assertThat(store.sell("apple", 5), is(40));
    }

    @Test
    public void sellTwoProducts() throws Exception {


        store.addProduct(new Product("apple", 1.20), 30, 45);
        store.addProduct(new Product("orange", 1.00), 20, 30);

        store.add("apple", 15);
        store.add("orange", 10);

        assertThat(store.sell("apple", 5), is(40));
        assertThat(store.sell("orange", 5), is(25));
    }

    @Test(expected = IllegalArgumentException.class)
    public void sellNotExistingProduct() throws Exception {

        store.addProduct(new Product("apple", 1.20), 30, 45);

        store.add("apple", 10);

        assertThat(store.sell("kiwi", 5), is(30));
    }

    @Test(expected = IllegalArgumentException.class)
    public void sellProductWithQuantityMoreThanAddQuantity() throws Exception {
        store.addProduct(new Product("apple", 1.20), 30, 45);

        assertThat(store.sell("apple", 35), is(-5));
    }

    @Test
    public void profitAfterSellProduct() throws Exception {

        OrderProduct apple = new OrderProduct("apple", 50, 1.40, 1.45);

        store.register(apple);

        store.sellOrderedProduct(apple, 10);

        assertThat(store.profit(), is(equalTo(0.5000000000000004)));

    }

    @Test(expected = IllegalArgumentException.class)
    public void addProductWithEmptyProductName() throws Exception {
        store.addProduct(new Product("", 1.20), 30, 45);

    }

    @Test(expected = IllegalArgumentException.class)

    public void addProductWithNegativePrice() throws Exception {
        store.addProduct(new Product("orange", -1.20), 25, 40);

    }
    @Test(expected = IllegalArgumentException.class)
    public void addProductWithNegativeMaxQuantity() throws Exception {
        store.addProduct(new Product("orange", 1.20), 30, -45);

    }
    @Test(expected = IllegalArgumentException.class)
    public void addProdctWithNegativeCurrentQuantity() throws Exception {
        store.addProduct(new Product("apple", 1.20), -30, 45);
    }
}
