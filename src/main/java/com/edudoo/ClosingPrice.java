package com.edudoo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Optional;

public class ClosingPrice {

    private static final Logger logger = LoggerFactory.getLogger(ClosingPrice.class);

    @JsonFormat(pattern = "yyyy-MM-dd")
    private final LocalDate date;
    private final String close;

    private ClosingPrice(String input){
        if(input == null || input.length() < 1){
            throw new IllegalArgumentException("Not a valid price input");
        }
        String[] columns = input.split(",");
        if(columns.length < 4){
            throw new IllegalArgumentException("Not a valid price input");
        }
        date = LocalDate.parse(columns[0]);
        close = columns[4];
    }

    public static Optional<ClosingPrice> tryParse(String line){
        try {
            return Optional.of(new ClosingPrice(line));
        }catch (IllegalArgumentException | DateTimeParseException e){
            logger.debug("Cannot parse line {}", line);
            return Optional.empty();
        }
    }

    public LocalDate getDate() {
        return date;
    }

    public boolean lastDayOfMonth(){
        return date.lengthOfMonth() == date.getDayOfMonth();
    }

    public String getClose() {
        return close;
    }

    @Override
    public String toString() {
        return "ClosingPrice{" +
                "date='" + date + '\'' +
                ", close='" + close + '\'' +
                '}';
    }
}
