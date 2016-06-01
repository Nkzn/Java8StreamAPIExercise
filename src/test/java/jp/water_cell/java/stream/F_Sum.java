package jp.water_cell.java.stream;

import org.junit.Before;
import org.junit.Test;

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
