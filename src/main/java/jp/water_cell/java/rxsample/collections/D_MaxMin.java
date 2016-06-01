package jp.water_cell.java.rxsample.collections;

import jp.water_cell.java.rxsample.collections.models.Customer;
import jp.water_cell.java.rxsample.collections.models.Product;
import jp.water_cell.java.rxsample.collections.models.Shop;

import java.util.stream.Stream;

public class D_MaxMin implements ICollectionUtils {

    void example() {
        String longestString = Stream.of("aaa", "bbbbb", "cc", "ddddd")
                .max((s1, s2) -> Integer.compare(s1.length(), s2.length()))
                .get();
    }

    public Customer getCustomerWithMaximumNumberOfOrders(Shop shop) {
        // Return a customer who ordered maximum number of orders
        return shop.getCustomers().stream()
                .max((c1, c2) -> Integer.compare(c1.getOrders().size(), c2.getOrders().size()))
                .get();
    }

    public Product getMostExpensiveOrderedProduct(Customer customer) {
        // Return the most expensive ordered product
        return new C_FlatMap().getOrderedProducts(customer).stream()
                .max((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()))
                .get();
    }
}
