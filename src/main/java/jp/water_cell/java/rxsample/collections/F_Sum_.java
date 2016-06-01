package jp.water_cell.java.rxsample.collections;

import jp.water_cell.java.rxsample.collections.models.Customer;

import java.util.stream.Stream;

public class F_Sum_ {

    void example() {
        Integer sum = Stream.of(1, 5, 3).reduce(0, (prev, curr) -> prev += curr);
    }

    public Double getTotalOrderPrice(Customer customer) {
        // Returns the sum of prices of all products ordered by customer.
        // Note: a customer may order the same product for several times.
        return customer.getOrders().stream()
                .flatMap(order -> order.getProducts().stream())
                .map(product -> product.getPrice())
                .reduce(0d, (sum, price) -> sum += price);
    }
}
