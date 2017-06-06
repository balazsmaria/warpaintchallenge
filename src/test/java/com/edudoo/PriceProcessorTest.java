package com.edudoo;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.List;

public class PriceProcessorTest {

    private static final Logger logger = LoggerFactory.getLogger(PriceProcessorTest.class);

    public static final String TEST_CSV = "SPY.csv";

    @Test
    public void process() {
        InputStream inputStream = PriceProcessorTest.class.getClassLoader().getResourceAsStream(TEST_CSV);
        PriceProcessor priceProcessor = new PriceProcessor(inputStream);
        List<ClosingPrice> prices = priceProcessor.lastDayPrices();
        logger.info("Last day prices {}", prices);
        Assert.assertTrue(!prices.isEmpty());
    }

}