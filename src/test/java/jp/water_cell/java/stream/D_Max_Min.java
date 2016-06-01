package jp.water_cell.java.stream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class D_Max_Min implements ITestBase {

    D_MaxMin sut;

    @Before
    public void setUp() {
        sut = new D_MaxMin();
    }

    @Test
    public void testCustomerWithMaximumNumberOfOrders() {
        Assert.assertEquals(customers().get(reka), sut.getCustomerWithMaximumNumberOfOrders(shop()));
    }

    @Test
    public void testTheMostExpensiveOrderedProduct() {
        Assert.assertEquals(rubyMine, sut.getMostExpensiveOrderedProduct(customers().get(nathan)));
    }

}
