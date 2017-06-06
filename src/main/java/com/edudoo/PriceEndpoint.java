package com.edudoo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class PriceEndpoint {

    @Value("classpath:SPY.csv")
    private Resource spyCSV;

    @RequestMapping("/price/last-day-closes/sample")
    public List<ClosingPrice> lastDayCloses() throws IOException {
        return new PriceProcessor(spyCSV.getInputStream()).lastDayPrices();
    }

    @RequestMapping(value = "/price/last-day-closes", method = RequestMethod.POST)
    public List<ClosingPrice> lastDayClosesUpload(@RequestParam MultipartFile file) throws IOException {
        return new PriceProcessor(file.getInputStream()).lastDayPrices();
    }
}
