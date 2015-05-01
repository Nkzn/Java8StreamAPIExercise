package jp.water_cell.java.rxsample.collections;

import java.util.List;

public class Customer {

    private final String name;
    private final City city;
    private final List<Order> orders;

    public Customer(String name, City city, List<Order> orders) {
        this.name = name;
        this.city = city;
        this.orders = orders;
    }

    public String getName() {
        return name;
    }

    public City getCity() {
        return city;
    }

    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public String toString() {
        return String.format("'%s' from %s", name, city.getName());
    }
}
