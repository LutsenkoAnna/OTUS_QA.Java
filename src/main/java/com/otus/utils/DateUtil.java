package com.otus.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateUtil {

  public LocalDate parseDateFromString(String date) {
    int day = LocalDate.MIN.getDayOfMonth();
    int year = LocalDate.now().getYear();
    String month = Month.ЯНВ.getNum();

    String regexDay = "\\d\\d?";
    String regexYear = "\\d\\d\\d\\d";
    String regexMonth = "янв|фев|мар|апр|мая|июн|июл|авг|сен|окт|ноя|дек";

    Pattern patternDay = Pattern.compile(regexDay);
    Pattern patternMonth = Pattern.compile(regexMonth);
    Pattern patternYear = Pattern.compile(regexYear);

    Matcher matcherDay = patternDay.matcher(date);
    Matcher matcherMonth = patternMonth.matcher(date);
    Matcher matcherYear = patternYear.matcher(date);

    if (matcherDay.find()) {
      day = Integer.parseInt(matcherDay.group(0));
    }
    if (matcherYear.find()) {
      year = Integer.parseInt(matcherYear.group(0));
    }
    if (matcherMonth.find()) {
      month = Month.valueOf(matcherMonth.group(0).toUpperCase(Locale.ROOT)).getNum();
    }

    String result = year + "-" + month + "-" + (day > 9 ? day : "0" + day);
    return LocalDate.parse(result, DateTimeFormatter.ofPattern("uuuu-MM-dd"));
  }
}
