package jp.water_cell.java.rxsample.collections;

import java.util.List;
import java.util.Set;

import rx.Observable;

public class A_FilterMap implements ICollectionUtils {

    void example0(List<Integer> list) {
        Integer positiveNumbers = Observable.from(list).filter(integer -> integer > 0).toBlocking().single();
        Integer squares = Observable.from(list).map(integer -> integer * integer).toBlocking().single();
    }

    public Set<City> getCitiesCustomersAreFrom(Shop shop) {
        // TODO
        return null;
    }


    public List<Customer> getCustomersFrom(Shop shop, City city) {
        // TODO
        return null;
    }
}
