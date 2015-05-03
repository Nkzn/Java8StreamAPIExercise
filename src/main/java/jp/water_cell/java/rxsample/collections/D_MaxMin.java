package jp.water_cell.java.rxsample.collections;

import jp.water_cell.java.rxsample.collections.models.Customer;
import jp.water_cell.java.rxsample.collections.models.Product;
import jp.water_cell.java.rxsample.collections.models.Shop;
import rx.Observable;

import static rx.math.operators.OperatorMinMax.*;

public class D_MaxMin implements ICollectionUtils {

    void example() {
        Integer max = max(Observable.just(1, 42, 4))
                .toBlocking()
                .single();

        String longestString = maxBy(Observable.just("aaa", "bbbbb", "cc", "ddddd"), string -> string.length())
                .toBlocking()
                .single()
                .get(0);
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
