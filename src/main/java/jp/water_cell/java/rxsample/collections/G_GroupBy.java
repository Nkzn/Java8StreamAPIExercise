package jp.water_cell.java.rxsample.collections;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import jp.water_cell.java.rxsample.collections.models.City;
import jp.water_cell.java.rxsample.collections.models.Customer;
import jp.water_cell.java.rxsample.collections.models.Shop;

public class G_GroupBy implements ICollectionUtils {

    public static void main(String[] args) {
        new G_GroupBy().sample();
    }

    void sample() {
        Map<Integer, List<String>> result = Stream.of("a", "b", "ba", "ccc", "ad")
                .collect(Collectors.groupingBy(String::length));

        HashMap<Integer, List<String>> expected = new HashMap<>();
        expected.put(1, listOf("a", "b"));
        expected.put(2, listOf("ba", "ad"));
        expected.put(3, listOf("ccc"));

        assert result.equals(expected);
    }

    public Map<City, List<Customer>> groupCustomersByCity(Shop shop) {
        // Return the map of the customers living in each city
        return shop.getCustomers().stream()
                .collect(Collectors.groupingBy(Customer::getCity));
    }
}
