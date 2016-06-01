package jp.water_cell.java.stream.models;

import java.util.List;

public class Shop {

    private final String name;
    private final List<Customer> customers;

    public Shop(String name, List<Customer> customers) {
        this.name = name;
        this.customers = customers;
    }

    public String getName() {
        return name;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Shop shop = (Shop) o;

        if (name != null ? !name.equals(shop.name) : shop.name != null) return false;
        return !(customers != null ? !customers.equals(shop.customers) : shop.customers != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (customers != null ? customers.hashCode() : 0);
        return result;
    }
}
