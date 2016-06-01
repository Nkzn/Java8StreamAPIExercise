package jp.water_cell.java.stream;

import org.apache.commons.collections4.CollectionUtils;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import jp.water_cell.java.stream.models.Product;
import jp.water_cell.java.stream.models.Shop;

public class H_Fold_ implements ICollectionUtils {

    void sample() {
        Integer result = Stream.of(1, 2, 3, 4)
                .reduce((partProduct, element) -> partProduct * element)
                .get();

        assert result.equals(24);
    }

    public Set<Product> getProductsOrderedByAllCustomers(Shop shop) {
        // Return set of products ordered by every customer
        Set<Product> allOrderedProducts = new C_FlatMap().getAllOrderedProducts(shop);
        return shop.getCustomers().stream()
                .reduce(allOrderedProducts,
                        (orderedByAll, customer) -> intersection(orderedByAll, new C_FlatMap().getOrderedProducts(customer)),
                        (products1, products2) -> null);
    }

    /** return set of products included both of sets */
    private Set<Product> intersection(Set<Product> original, Set<Product> remove) {
        return new HashSet<>(CollectionUtils.intersection(original, remove));
    }
}
