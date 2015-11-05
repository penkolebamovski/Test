/**
 * @author Ivaylo Penev(ipenev91@gmail.com) on 10/13/15.
 */
public class Product {

    private String name;

    public int price;

    public Product(String name, int price) {

        this.name = name;

        this.price = price;
    }

    public String getName() {
        return name;
    }
}
