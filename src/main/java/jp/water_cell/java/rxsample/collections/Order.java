package jp.water_cell.java.rxsample.collections;

import java.util.List;

public class Order {

    private final List<Product> products;
    private final boolean isDelivered;

    public Order(List<Product> products, boolean isDelivered) {
        this.products = products;
        this.isDelivered = isDelivered;
    }

    public List<Product> getProducts() {
        return products;
    }

    public boolean isDelivered() {
        return isDelivered;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (isDelivered != order.isDelivered) return false;
        return !(products != null ? !products.equals(order.products) : order.products != null);

    }

    @Override
    public int hashCode() {
        int result = products != null ? products.hashCode() : 0;
        result = 31 * result + (isDelivered ? 1 : 0);
        return result;
    }
}
