package jp.water_cell.java.stream;

import com.google.common.primitives.Chars;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import jp.water_cell.java.stream.models.Customer;
import jp.water_cell.java.stream.models.Product;
import jp.water_cell.java.stream.models.Shop;

public class C_FlatMap implements ICollectionUtils {

    void example() {

        List<Character> result = listOf("abc", "12").stream()
                .flatMap(string -> Chars.asList(string.toCharArray()).stream())
                .collect(Collectors.toList());

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
