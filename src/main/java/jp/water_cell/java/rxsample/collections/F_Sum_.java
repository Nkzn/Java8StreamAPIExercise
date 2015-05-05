package jp.water_cell.java.rxsample.collections;

import jp.water_cell.java.rxsample.collections.models.Customer;
import rx.Observable;

import static rx.math.operators.OperatorSum.*;

public class F_Sum_ {

    void example() {
        Integer sum = sumIntegers(Observable.just(1, 5, 3))
                .toBlocking()
                .single();
    }

    public Double getTotalOrderPrice(Customer customer) {
        // Returns the sum of prices of all products ordered by customer.
        // Note: a customer may order the same product for several times.
        // TODO
        return null;
    }
}
