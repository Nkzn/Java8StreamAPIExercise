package jp.water_cell.java.stream;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class A_Filter_Map implements ITestBase {

    A_FilterMap sut;

    @Before
    public void setUp() {
        sut = new A_FilterMap();
    }

    @Test
    public void testCitiesCustomersAreFrom() {
        assertThat(setOf(Canberra, Vancouver, Budapest, Ankara, Tokyo), is(sut.getCitiesCustomersAreFrom(shop())));
    }

    @Test
    public void testCustomersFromCity() {
        assertThat(listOf(customers().get(lucas), customers().get(cooper)), is(sut.getCustomersFrom(shop(), Canberra)));
    }

}
