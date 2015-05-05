package jp.water_cell.java.rxsample;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import jp.water_cell.java.rxsample.collections.H_Fold_;
import jp.water_cell.java.rxsample.collections.models.Shop;

public class H_Fold implements ITestBase {

    H_Fold_ sut;

    @Before
    public void setUp() {
        sut = new H_Fold_();
    }

    @Test
    public void testGetProductsOrderedByAllCustomers() {
        Shop testShop = shop("test shop for 'fold'",
            customer(lucas, Canberra,
                order(idea),
                order(webStorm)
            ),
            customer(reka, Budapest,
                order(idea),
                order(youTrack)
            ));

        Assert.assertEquals(setOf(idea), sut.getProductsOrderedByAllCustomers(testShop));
    }

}
