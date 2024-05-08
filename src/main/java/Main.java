import com.estudo.CongestionTaxCalculator;
import com.estudo.Motorbike;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd H:m:ss");
        List<String> stringDates = Arrays.asList("2013-01-14 21:00:00", "2013-01-15 21:00:00", "2013-02-07 06:23:27"
                                                , "2013-02-07 15:27:00", "2013-02-08 06:27:00", "2013-02-08 06:20:27"
                                                , "2013-02-08 14:35:00", "2013-02-08 15:29:00", "2013-02-08 15:47:00"
                                                , "2013-02-08 16:01:00", "2013-02-08 16:48:00", "2013-02-08 17:49:00"
                                                , "2013-02-08 18:29:00", "2013-02-08 18:35:00", "2013-03-26 14:25:00", "2013-03-28 14:07:27");

        String dateInString = "2013-01-14 21:00:00";
        List<LocalDateTime> formatedDates = new ArrayList<>();
        stringDates.stream().forEach((stringDate) -> {
            formatedDates.add(LocalDateTime.parse(stringDate, formatter));
        });

        formatedDates.stream().forEach((i) -> System.out.println(i.toString()));

        CongestionTaxCalculator calculator = new CongestionTaxCalculator();
        //System.out.println(calculator.getTax(new Motorbike().getVehicleType(), date));

    }
}
