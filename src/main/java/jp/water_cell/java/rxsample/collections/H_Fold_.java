package jp.water_cell.java.rxsample.collections;

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
                            // TODO
                            return null;
                        })
                .toBlocking()
                .single();
    }
}
