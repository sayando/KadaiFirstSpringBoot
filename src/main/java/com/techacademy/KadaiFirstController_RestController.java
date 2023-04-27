package com.techacademy;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class KadaiFirstController_RestController {
  //指定日の曜日を画面に表示する
    @GetMapping("/dayofweek/{date}")
    public String dispDayOfWeek(@PathVariable String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyymmdd");
        try {
            // 日付文字列をLocalDateに変換
            LocalDate localDate = LocalDate.parse(date, formatter);
            // 曜日を取得
            String dayOfWeek = localDate.getDayOfWeek().toString();
            return dayOfWeek;
        } catch (DateTimeParseException e) {
            return "Invalid date format. Please specify in yyyymmdd format.";
        }
    }
}
