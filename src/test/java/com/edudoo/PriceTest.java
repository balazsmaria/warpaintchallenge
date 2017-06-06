package com.edudoo;

import org.junit.Test;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.Assert.*;

public class PriceTest {

    private static final String TEST = "1993-01-29,43.968700,43.968700,43.750000,43.937500,43.937500,1003200\n";
    private static final String TEST_INVALID = "dsadsa0\n";

    @Test
    public void parseValid(){
        ClosingPrice price = ClosingPrice.tryParse(TEST).get();
        assertEquals(LocalDate.of(1993,1,29), price.getDate());
        assertEquals("43.937500", price.getClose());
    }

    @Test
    public void parseInvalid(){
        Optional<ClosingPrice> closingPrice = ClosingPrice.tryParse(TEST_INVALID);
        assertTrue(!closingPrice.isPresent());
    }

    @Test
    public void parseNoInput(){
        Optional<ClosingPrice> closingPrice = ClosingPrice.tryParse("");
        assertTrue(!closingPrice.isPresent());
        Optional<ClosingPrice> closingPriceNull = ClosingPrice.tryParse(null);
        assertTrue(!closingPriceNull.isPresent());
    }
}