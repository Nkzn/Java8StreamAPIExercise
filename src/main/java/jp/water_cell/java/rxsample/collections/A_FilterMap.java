package jp.water_cell.java.rxsample.collections;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import rx.Observable;

public class A_FilterMap implements ICollectionUtils {

    void example0(List<Integer> list) {
        Integer positiveNumbers = Observable.from(list).filter(integer -> integer > 0).toBlocking().single();
        Integer squares = Observable.from(list).map(integer -> integer * integer).toBlocking().single();
    }

    public Set<City> getCitiesCustomersAreFrom(Shop shop) {
        // Return the set of cities the customers are from
        List<City> cities = Observable.from(shop.getCustomers())
                .map(customer -> customer.getCity())
                .toList()
                .toBlocking()
                .single();

        return new HashSet<>(cities);
    }


    public List<Customer> getCustomersFrom(Shop shop, City city) {
        // Return the list of the customers who live in the given city
        return Observable.from(shop.getCustomers())
                .filter( customer -> customer.getCity().equals(city) )
                .toList()
                .toBlocking()
                .single();
    }
}