package com.estudo;

import com.estudo.vehicles.Vehicle;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;

public class CongestionTaxCalculator {

    public int getTax(Vehicle vehicle, List<LocalDateTime> dates)
    {
        LocalDateTime intervalStart = dates.get(0);
        int totalFee = 0;

        for (int i = 0; i < dates.size() ; i++) {
            LocalDateTime date = dates.get(i);
            int nextFee = GetTollFee(date, vehicle);
            int tempFee = GetTollFee(intervalStart, vehicle);

            long diffInMillies = Duration.between(intervalStart, date).toMillis();
            long minutes = diffInMillies/1000/60;

            if (minutes <= 60)
            {
                if (totalFee > 0) totalFee -= tempFee;
                if (nextFee >= tempFee) tempFee = nextFee;
                totalFee += tempFee;
            }
            else
            {
                totalFee += nextFee;
            }
        }

        if (totalFee > 60) totalFee = 60;
        return totalFee;
    }

    public int GetTollFee(LocalDateTime date, Vehicle vehicle)
    {
        if (IsTollFreeDate(date) || vehicle.isTollFree()) return 0;

        int hour = date.getHour();
        int minute = date.getMinute();

        if (hour == 6 && minute >= 0 && minute <= 29) return 8;
        else if (hour == 6 && minute >= 30 && minute <= 59) return 13;
        else if (hour == 7 && minute >= 0 && minute <= 59) return 18;
        else if (hour == 8 && minute >= 0 && minute <= 29) return 13;
        else if (hour >= 8 && hour <= 14 && minute >= 30 && minute <= 59) return 8;
        else if (hour == 15 && minute >= 0 && minute <= 29) return 13;
        else if (hour == 15 && minute >= 0 || hour == 16 && minute <= 59) return 18;
        else if (hour == 17 && minute >= 0 && minute <= 59) return 13;
        else if (hour == 18 && minute >= 0 && minute <= 29) return 8;
        else return 0;
    }

    private Boolean IsTollFreeDate(LocalDateTime date)
    {
        int year = date.getYear();
        int month = date.plusMonths(1).getMonthValue();
        int day = date.getDayOfWeek().plus( 1).getValue();
        int dayOfMonth = date.getDayOfMonth();

        if (day == Calendar.SATURDAY || day == Calendar.SUNDAY) return true;

        if (year == 2013)
        {
            if ((month == 1 && dayOfMonth == 1) ||
            (month == 3 && (dayOfMonth == 28 || dayOfMonth == 29)) ||
            (month == 4 && (dayOfMonth == 1 || dayOfMonth == 30)) ||
            (month == 5 && (dayOfMonth == 1 || dayOfMonth == 8 || dayOfMonth == 9)) ||
            (month == 6 && (dayOfMonth == 5 || dayOfMonth == 6 || dayOfMonth == 21)) ||
            (month == 7) ||
            (month == 11 && dayOfMonth == 1) ||
            (month == 12 && (dayOfMonth == 24 || dayOfMonth == 25 || dayOfMonth == 26 || dayOfMonth == 31)))
            {
                return true;
            }
        }
        return false;
    }
}