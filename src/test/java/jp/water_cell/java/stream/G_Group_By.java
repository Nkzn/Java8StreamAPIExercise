package jp.water_cell.java.stream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class G_Group_By implements ITestBase {

    G_GroupBy sut;

    @Before
    public void setUp() {
        sut = new G_GroupBy();
    }

    @Test
    public void testGroupCustomersByCity() {
        Assert.assertEquals(groupedByCities(), sut.groupCustomersByCity(shop()));
    }
}
