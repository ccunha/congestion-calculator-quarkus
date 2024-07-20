package com.estudo;

import com.estudo.vehicles.Car;
import com.estudo.vehicles.Motorcycle;
import com.estudo.vehicles.Vehicle;
import io.quarkus.test.junit.QuarkusTest;
import io.smallrye.common.constraint.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class CongestionCalculatorQuarkusTest {

    static List<LocalDateTime> dates = new ArrayList<>();

    void organizeDates(){
        DateTimeFormatter formatterDateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd H:m:ss");
        List<String> stringDates = Arrays.asList("2013-01-14 21:00:00", "2013-01-15 21:00:00", "2013-02-07 06:23:27"
            , "2013-02-07 15:27:00", "2013-02-08 06:27:00", "2013-02-08 06:20:27"
            , "2013-02-08 14:35:00", "2013-02-08 15:29:00", "2013-02-08 15:47:00"
            , "2013-02-08 16:01:00", "2013-02-08 16:48:00", "2013-02-08 17:49:00"
            , "2013-02-08 18:29:00", "2013-02-08 18:35:00", "2013-03-26 14:25:00", "2013-03-28 14:07:27");


        stringDates.stream().forEach((stringDate) -> {
            dates.add(LocalDateTime.parse(stringDate, formatterDateTime));
        });

    }

    @Test
    void testCongestionCalculatorQuarkus() {
        organizeDates();
        Vehicle car = new Car();
        Vehicle motorcycle = new Motorcycle();
        CongestionTaxCalculator calculator = new CongestionTaxCalculator();
        dates.sort(Comparator.naturalOrder());
        int tax;

        //for a free vehicle, the value must be zero
        tax = calculator.getTax(motorcycle, dates);
        Assertions.assertEquals(0, tax);


        tax = calculator.getTax(car, dates);
        System.out.println(tax);

    }

}