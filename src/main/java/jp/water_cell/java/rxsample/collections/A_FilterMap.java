package jp.water_cell.java.rxsample.collections;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import jp.water_cell.java.rxsample.collections.models.City;
import jp.water_cell.java.rxsample.collections.models.Customer;
import jp.water_cell.java.rxsample.collections.models.Shop;

public class A_FilterMap implements ICollectionUtils {

    void example0(List<Integer> list) {
        List<Integer> positiveNumbers = list.stream().filter(integer -> integer > 0).collect(Collectors.toList());
        List<Integer> squares = list.stream().map(integer -> integer * integer).collect(Collectors.toList());
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
