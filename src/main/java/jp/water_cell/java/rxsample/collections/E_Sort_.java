package jp.water_cell.java.rxsample.collections;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import jp.water_cell.java.rxsample.collections.models.Customer;
import jp.water_cell.java.rxsample.collections.models.Shop;

public class E_Sort_ implements ICollectionUtils {

    void sample() {
        List<String> result = Stream.of("a", "bbb", "cc")
                .sorted((s1, s2) -> s1.length() - s2.length())
                .collect(Collectors.toList());

        assert result.equals(listOf("a", "cc", "bbb"));
    }

    public List<Customer> getCustomersSortedByNumberOfOrders(Shop shop) {
        // Return customers sorted by number of orders they made
        return Observable.from(shop.getCustomers())
                .toSortedList((customer1, customer2) -> customer1.getOrders().size() - customer2.getOrders().size())
                .toBlocking()
                .single();
    }
}
