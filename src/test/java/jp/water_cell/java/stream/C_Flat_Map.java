package jp.water_cell.java.stream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class C_Flat_Map implements ITestBase {

    C_FlatMap sut;

    @Before
    public void setUp() {
        sut = new C_FlatMap();
    }

    @Test
    public void testGetOrderedProductsSet() {
        Assert.assertEquals(setOf(idea), sut.getOrderedProducts(customers().get(reka)));
    }

    @Test
    public void testGetAllOrderedProducts() {
        Assert.assertEquals(orderedProducts(), sut.getAllOrderedProducts(shop()));
    }

}
