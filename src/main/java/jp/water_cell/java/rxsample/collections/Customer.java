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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (name != null ? !name.equals(customer.name) : customer.name != null) return false;
        if (city != null ? !city.equals(customer.city) : customer.city != null) return false;
        return !(orders != null ? !orders.equals(customer.orders) : customer.orders != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (orders != null ? orders.hashCode() : 0);
        return result;
    }
}
