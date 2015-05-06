package jp.water_cell.java.rxsample.collections;

import java.util.Set;

import jp.water_cell.java.rxsample.collections.models.Customer;
import jp.water_cell.java.rxsample.collections.models.Product;
import jp.water_cell.java.rxsample.collections.models.Shop;

public class I_CompoundTasks implements ICollectionUtils {

    public Set<Customer> getCustomersWhoOrderedProduct(Shop shop, Product product) {
        // Return the set of customers who ordered the specified product
        // TODO
        return null;
    }

    public Product getMostExpensiveDeliveredProduct(Customer customer) {
        // Return the most expensive among delivered products
        // (use Order.isDelivered flag)
        // TODO
        return null;
    }

    public Integer getNumberOfTimesProductWasOrdered(Shop shop, Product product) {
        // Returns number of times the given product was ordered.
        // Note: a customer may order the same product for several times.
        // TODO
        return null;
    }

}
