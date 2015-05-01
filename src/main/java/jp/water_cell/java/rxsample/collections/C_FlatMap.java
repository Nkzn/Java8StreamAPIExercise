package jp.water_cell.java.rxsample.collections;

import com.google.common.primitives.Chars;

import java.util.List;
import java.util.Set;

import rx.Observable;

public class C_FlatMap implements ICollectionUtils {

    void example() {

        List<Character> result = Observable.from(listOf("abc", "12"))
                .flatMap(string -> Observable.from(Chars.asList(string.toCharArray())))
                .toList()
                .toBlocking()
                .single();

        Chars.asList('a', 'b', 'c', '1', '2').equals(result);
    }

    public Set<Product> getOrderedProducts(Customer customer) {
        // Return all products ordered by customer
        // TODO
        return null;
    }

    public Set<Product> getAllOrderedProducts(Shop shop) {
        // Return all products ordered by all customers
        // TODO
        return null;
    }
}
