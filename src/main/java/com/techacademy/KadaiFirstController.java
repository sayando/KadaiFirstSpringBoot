package com.techacademy;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Calendar;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KadaiFirstController {

    @GetMapping("/dayofweek/{date}")
    public String dispDayOfWeek(@PathVariable String date) {
      //import java.util.Calendar;
        Calendar cal = Calendar.getInstance();
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(4, 6));
        int day = Integer.parseInt(date.substring(6, 8));
        cal.set(year,month-1,day);
        LocalDate localDate = LocalDate.of(year, month, day);
        int dayOfWeek = localDate.getDayOfWeek().getValue();
        switch (cal.get(Calendar.DAY_OF_WEEK))  {
            case Calendar.SUNDAY:
                return "Sunday";
            case Calendar.MONDAY:
                return "Monday";
            case Calendar.TUESDAY:
                return "Tuesday";
            case Calendar.WEDNESDAY:
                return "Wednesday";
            case Calendar.THURSDAY:
                return "Thursday";
            case Calendar.FRIDAY:
                return "Friday";
            case Calendar.SATURDAY:
                return "Saturday";
            default:
                return "Invalid day of week";
        }
    }

    @GetMapping("/plus/{num1}/{num2}")
    public int calcPlus(@PathVariable int num1, @PathVariable int num2) {
       return num1 + num2;
     }
    @GetMapping("/minus/{num1}/{num2}")
    public int calcMinus(@PathVariable int num1, @PathVariable int num2) {
       return num1 - num2;
     }
    @GetMapping("/times/{num1}/{num2}")
    public int calcTimes(@PathVariable int num1, @PathVariable int num2) {
       return num1 * num2;
     }
}