package jp.water_cell.java.stream;

import jp.water_cell.java.stream.models.Customer;
import jp.water_cell.java.stream.models.Product;
import jp.water_cell.java.stream.models.Shop;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class I_CompoundTasks implements ICollectionUtils {

    public Set<Customer> getCustomersWhoOrderedProduct(Shop shop, Product product) {
        // Return the set of customers who ordered the specified product
        return shop.getCustomers().stream()
                .filter(customer -> new C_FlatMap().getOrderedProducts(customer).contains(product))
                .collect(Collectors.toSet());
    }

    public Product getMostExpensiveDeliveredProduct(Customer customer) {
        // Return the most expensive among delivered products
        // (use Order.isDelivered flag)
        return customer.getOrders().stream()
                .filter(order -> order.isDelivered())
                .flatMap(order1 -> order1.getProducts().stream())
                .max((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()))
                .get();
    }

    public Long getNumberOfTimesProductWasOrdered(Shop shop, Product product) {
        // Returns number of times the given product was ordered.
        // Note: a customer may order the same product for several times.
        return shop.getCustomers().stream()
                .flatMap(customer -> getOrderedProductsList(customer).stream())
                .filter(product1 -> product.equals(product1))
                .count();
    }

    private List<Product> getOrderedProductsList(Customer customer) {
        return customer.getOrders().stream()
                .flatMap(order -> order.getProducts().stream())
                .collect(Collectors.toList());
    }
}
