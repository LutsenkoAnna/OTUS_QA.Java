package com.otus.exceptions;

public class DriverNotFoundException extends Exception {

  public DriverNotFoundException(String browser) {
    super(String.format("Driver for %s is not found", browser));
  }

}