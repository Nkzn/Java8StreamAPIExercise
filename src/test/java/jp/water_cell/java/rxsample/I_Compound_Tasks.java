package jp.water_cell.java.rxsample;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import jp.water_cell.java.rxsample.collections.I_CompoundTasks;
import jp.water_cell.java.rxsample.collections.models.Shop;

public class I_Compound_Tasks implements ITestBase {

    I_CompoundTasks sut;
    
    @Before
    public void setUp() {
        sut = new I_CompoundTasks();
    }
    
    @Test
    public void testGetCustomersWhoOrderedProduct() {
        Assert.assertEquals(setOf(customers().get(reka), customers().get(asuka)), sut.getCustomersWhoOrderedProduct(shop(), idea));
    }

    @Test public void testMostExpensiveDeliveredProduct() {
        Shop testShop = shop("test shop for 'most expensive delivered product'",
            customer(lucas, Canberra,
                order(false, idea),
                order(reSharper)
            )
        );
        Assert.assertEquals(reSharper, sut.getMostExpensiveDeliveredProduct(testShop.getCustomers().get(0)));
    }

    @Test public void testNumberOfTimesEachProductWasOrdered() {
        Assert.assertEquals(Long.valueOf(3), sut.getNumberOfTimesProductWasOrdered(shop(), reSharper));
    }
    
}
