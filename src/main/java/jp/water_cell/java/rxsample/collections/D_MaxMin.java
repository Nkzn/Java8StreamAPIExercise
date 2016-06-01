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
        return maxBy(Observable.from(shop.getCustomers()), customer -> customer.getOrders().size())
                .toBlocking()
                .single()
                .get(0);
    }

    public Product getMostExpensiveOrderedProduct(Customer customer) {
        // Return the most expensive ordered product
        return maxBy(Observable.from(new C_FlatMap().getOrderedProducts(customer)), product -> product.getPrice())
                .toBlocking()
                .single()
                .get(0);
    }
}
