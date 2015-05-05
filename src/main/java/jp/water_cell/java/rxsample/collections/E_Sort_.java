package jp.water_cell.java.rxsample.collections;

import java.util.List;

import jp.water_cell.java.rxsample.collections.models.Customer;
import jp.water_cell.java.rxsample.collections.models.Shop;
import rx.Observable;

public class E_Sort_ implements ICollectionUtils {

    void sample() {
        List<String> result = Observable.just("a", "bbb", "cc")
                .toSortedList((s1, s2) -> s1.length() - s2.length())
                .toBlocking()
                .single();

        assert result.equals(listOf("a", "cc", "bbb"));
    }

    public List<Customer> getCustomersSortedByNumberOfOrders(Shop shop) {
        // Return customers sorted by number of orders they made
        // TODO
        return null;
    }
}
