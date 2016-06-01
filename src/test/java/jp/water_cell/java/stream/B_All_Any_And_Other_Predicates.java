package jp.water_cell.java.stream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class B_All_Any_And_Other_Predicates implements ITestBase {

    B_AllAnyAndOtherPredicates sut;

    @Before
    public void setUp() {
        sut = new B_AllAnyAndOtherPredicates();
    }

    @Test
    public void testCustomerIsFromCity() {
        Assert.assertTrue(sut.isFrom(customers().get(lucas), Canberra));
        Assert.assertFalse(sut.isFrom(customers().get(lucas), Budapest));
    }

    @Test public void testAllCustomersAreFromCity() {
        Assert.assertFalse(sut.checkAllCustomersAreFrom(shop(), Canberra));
    }

    @Test public void testAnyCustomerIsFromCity() {
        Assert.assertTrue(sut.hasCustomerFrom(shop(), Canberra));
    }

    @Test public void testCountCustomersFromCity() {
        Assert.assertEquals(Long.valueOf(2), sut.countCustomersFrom(shop(), Canberra));
    }

    @Test public void testAnyCustomerFromCity() {
        Assert.assertEquals(customers().get(lucas), sut.findAnyCustomerFrom(shop(), Canberra));
    }
}
