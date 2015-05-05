package jp.water_cell.java.rxsample;

import org.junit.Before;
import org.junit.Test;

import jp.water_cell.java.rxsample.collections.E_Sort_;

import static org.junit.Assert.assertEquals;

public class E_Sort implements ITestBase {
    
    E_Sort_ sut;
    
    @Before
    public void setUp() {
        sut = new E_Sort_();
    }

    @Test
    public void testGetCustomersSortedByNumberOfOrders() {
        assertEquals(sortedCustomers(), sut.getCustomersSortedByNumberOfOrders(shop()));
    }
}
