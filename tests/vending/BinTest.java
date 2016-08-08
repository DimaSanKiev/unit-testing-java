package vending;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinTest {

    private Bin bin;

    @Before
    public void setUp() throws Exception {
        bin = new Bin(10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void restockingWithDifferentItemsIsNotAllowed() throws Exception {
        bin.restock("Cheetos", 1, 100, 50);
        bin.restock("Doritos", 1, 100, 50);
    }

    @Test
    public void whenEmptyPriceIsZero() throws Exception {
        assertEquals(0, bin.getItemPrice());
    }

    @Test
    public void whenEmptyNameIsNull() throws Exception {
        assertNull(bin.getItemName());
    }

    @Test
    public void overstockingNotAllowed() throws Exception {
        bin.restock("Fritos", 2600, 100, 50);
    }
}