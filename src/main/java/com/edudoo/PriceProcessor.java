package com.edudoo;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PriceProcessor {

    private Stream<ClosingPrice> prices;

    public PriceProcessor(InputStream pricesStream){
        this.prices = new BufferedReader(new InputStreamReader(pricesStream)).
                lines().map(ClosingPrice::tryParse)
                .filter(Optional::isPresent).map(Optional::get);
    }

    public List<ClosingPrice> lastDayPrices(){
        return prices.filter(ClosingPrice::lastDayOfMonth).collect(Collectors.toList());
    }
}
