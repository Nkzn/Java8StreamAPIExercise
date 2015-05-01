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
}
