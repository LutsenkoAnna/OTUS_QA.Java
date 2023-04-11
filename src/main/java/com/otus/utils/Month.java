package com.otus.utils;

public enum Month {

  ЯНВ("01"),
  ФЕВ("02"),
  МАР("03"),
  АПР("04"),
  МАЯ("05"),
  ИЮН("06"),
  ИЮЛ("07"),
  АВГ("08"),
  СЕН("09"),
  ОКТ("10"),
  НОВ("11"),
  ДЕК("12");

  private String num;

  Month(String num) {
    this.num = num;
  }

  public String getNum() {
    return num;
  }
}
