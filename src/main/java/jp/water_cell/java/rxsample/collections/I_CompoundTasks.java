package jp.water_cell.java.rxsample.collections;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jp.water_cell.java.rxsample.collections.models.Customer;
import jp.water_cell.java.rxsample.collections.models.Product;
import jp.water_cell.java.rxsample.collections.models.Shop;
import rx.Observable;

import static rx.math.operators.OperatorMinMax.maxBy;

public class I_CompoundTasks implements ICollectionUtils {

    public Set<Customer> getCustomersWhoOrderedProduct(Shop shop, Product product) {
        // Return the set of customers who ordered the specified product
        List<Customer> list = Observable.from(shop.getCustomers())
                .filter(customer -> new C_FlatMap().getOrderedProducts(customer).contains(product))
                .toList()
                .toBlocking()
                .single();

        return new HashSet<>(list);
    }

    public Product getMostExpensiveDeliveredProduct(Customer customer) {
        // Return the most expensive among delivered products
        // (use Order.isDelivered flag)
        Observable<Product> productObservable = Observable.from(customer.getOrders())
                .filter(order -> order.isDelivered())
                .flatMap(order1 -> Observable.from(order1.getProducts()));

        return maxBy(productObservable, product -> product.getPrice())
                .toBlocking()
                .single()
                .get(0);
    }

    public Integer getNumberOfTimesProductWasOrdered(Shop shop, Product product) {
        // Returns number of times the given product was ordered.
        // Note: a customer may order the same product for several times.
        return Observable.from(shop.getCustomers())
                .flatMap(customer -> Observable.from(getOrderedProductsList(customer)))
                .filter(product1 -> product.equals(product1))
                .count()
                .toBlocking()
                .single();
    }

    private List<Product> getOrderedProductsList(Customer customer) {
        return Observable.from(customer.getOrders())
                .flatMap(order -> Observable.from(order.getProducts()))
                .toList()
                .toBlocking()
                .single();
    }
}
