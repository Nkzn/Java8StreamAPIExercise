package jp.water_cell.java.rxsample;

import org.junit.Before;
import org.junit.Test;

import jp.water_cell.java.rxsample.collections.F_Sum_;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class F_Sum implements ITestBase {

    F_Sum_ sut;

    @Before
    public void setUp() {
        sut = new F_Sum_();
    }

    @Test
    public void testGetTotalOrderPrice() {
        assertThat(148.0, is(sut.getTotalOrderPrice(customers().get(nathan))));
    }
}
