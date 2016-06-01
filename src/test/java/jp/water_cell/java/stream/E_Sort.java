package jp.water_cell.java.stream;

import org.junit.Before;
import org.junit.Test;

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
