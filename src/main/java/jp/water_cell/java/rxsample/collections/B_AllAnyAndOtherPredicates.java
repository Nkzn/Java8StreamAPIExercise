package jp.water_cell.java.rxsample.collections;

import java.util.List;

import jp.water_cell.java.rxsample.collections.models.City;
import jp.water_cell.java.rxsample.collections.models.Customer;
import jp.water_cell.java.rxsample.collections.models.Shop;
import rx.Observable;
import rx.functions.Func1;

public class B_AllAnyAndOtherPredicates implements ICollectionUtils {

    void example(List<Integer> list) {

        Func1<Integer, Boolean> isZero = integer -> integer == 0;

        Boolean hasZero = Observable.from(list).exists(isZero).toBlocking().single();

        Boolean allZeros = Observable.from(list).all(isZero).toBlocking().single();

        Integer numberOfZeros = Observable.from(list).filter(isZero).count().toBlocking().single();

        Integer firstPositiveNumber = Observable.from(list).first(integer -> integer > 0).toBlocking().single();
    }

    public Boolean isFrom(Customer customer, City city) {
        // Return true if the customer is from the given city
        return customer.getCity().equals(city);
    }

    public Boolean checkAllCustomersAreFrom(Shop shop, City city) {
        // Return true if all customers are from the given city
        return Observable.from(shop.getCustomers())
                .all(customer -> isFrom(customer, city))
                .toBlocking()
                .single();
    }

    public Boolean hasCustomerFrom(Shop shop, City city) {
        // Check there is at least one customer from the given city
        return Observable.from(shop.getCustomers())
                .exists(customer -> isFrom(customer, city))
                .toBlocking()
                .single();
    }

    public Integer countCustomersFrom(Shop shop, City city) {
        // Returns the number of customers from the given city
        return Observable.from(shop.getCustomers())
                .filter(customer -> isFrom(customer, city))
                .count()
                .toBlocking()
                .single();
    }

    public Customer findAnyCustomerFrom(Shop shop, City city) {
        // Return a customer who lives in the given city or null if there is none
        return Observable.from(shop.getCustomers())
                .first(customer -> isFrom(customer, city))
                .toBlocking()
                .single();
    }
}
