package jp.water_cell.java.rxsample.collections;

import java.util.List;
import java.util.function.Predicate;

import jp.water_cell.java.rxsample.collections.models.City;
import jp.water_cell.java.rxsample.collections.models.Customer;
import jp.water_cell.java.rxsample.collections.models.Shop;

public class B_AllAnyAndOtherPredicates implements ICollectionUtils {

    void example(List<Integer> list) {

        Predicate<Integer> isZero = integer -> integer == 0;

        Boolean hasZero = list.stream().anyMatch(isZero);

        Boolean allZeros = list.stream().allMatch(isZero);

        long numberOfZeros = list.stream().filter(isZero).count();

        Integer firstPositiveNumber = list.stream().filter(integer -> integer > 0).findFirst().get();
    }

    public Boolean isFrom(Customer customer, City city) {
        // Return true if the customer is from the given city
        return customer.getCity().equals(city);
    }

    public Boolean checkAllCustomersAreFrom(Shop shop, City city) {
        // Return true if all customers are from the given city
        return shop.getCustomers().stream()
                .allMatch(customer -> isFrom(customer, city));
    }

    public Boolean hasCustomerFrom(Shop shop, City city) {
        // Check there is at least one customer from the given city
        return shop.getCustomers().stream()
                .anyMatch(customer -> isFrom(customer, city));
    }

    public Long countCustomersFrom(Shop shop, City city) {
        // Returns the number of customers from the given city
        return shop.getCustomers().stream()
                .filter(customer -> isFrom(customer, city))
                .count();
    }

    public Customer findAnyCustomerFrom(Shop shop, City city) {
        // Return a customer who lives in the given city or null if there is none
        return shop.getCustomers().stream()
                .filter(customer -> isFrom(customer, city))
                .findFirst()
                .get();
    }
}
