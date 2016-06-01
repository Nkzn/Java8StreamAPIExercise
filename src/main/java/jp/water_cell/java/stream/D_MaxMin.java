package jp.water_cell.java.stream;

import jp.water_cell.java.stream.models.Customer;
import jp.water_cell.java.stream.models.Product;
import jp.water_cell.java.stream.models.Shop;

import java.util.stream.Stream;

public class D_MaxMin implements ICollectionUtils {

    void example() {
        String longestString = Stream.of("aaa", "bbbbb", "cc", "ddddd")
                .max((s1, s2) -> Integer.compare(s1.length(), s2.length()))
                .get();
    }

    public Customer getCustomerWithMaximumNumberOfOrders(Shop shop) {
        // Return a customer who ordered maximum number of orders
        return null;
    }

    public Product getMostExpensiveOrderedProduct(Customer customer) {
        // Return the most expensive ordered product
        return null;
    }
}
