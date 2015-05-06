package jp.water_cell.java.rxsample.collections;

import org.apache.commons.collections4.CollectionUtils;

import java.util.HashSet;
import java.util.Set;

import jp.water_cell.java.rxsample.collections.models.Product;
import jp.water_cell.java.rxsample.collections.models.Shop;
import rx.Observable;

public class H_Fold_ implements ICollectionUtils {

    void sample() {
        Integer result = Observable.just(1, 2, 3, 4)
                .reduce((partProduct, element) -> partProduct * element)
                .toBlocking()
                .single();

        assert result.equals(24);
    }

    public Set<Product> getProductsOrderedByAllCustomers(Shop shop) {
        // Return set of products ordered by every customer
        Set<Product> allOrderedProducts = new C_FlatMap().getAllOrderedProducts(shop);
        return Observable.from(shop.getCustomers())
                .reduce(allOrderedProducts,
                        (orderedByAll, customer) -> {
                            return intersection(orderedByAll, new C_FlatMap().getOrderedProducts(customer));
                        })
                .toBlocking()
                .single();
    }

    /** return set of products included both of sets */
    private Set<Product> intersection(Set<Product> original, Set<Product> remove) {
        return new HashSet<>(CollectionUtils.intersection(original, remove));
    }
}
