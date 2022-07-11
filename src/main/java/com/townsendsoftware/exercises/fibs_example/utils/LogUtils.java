package com.townsendsoftware.exercises.fibs_example.utils;

import static com.townsendsoftware.exercises.fibs_example.constants.FibsConstants.SYSTEM_LINE_SEP;

public class LogUtils {

  public static void logMessage(String message) {
    System.out.format("%s%s", SYSTEM_LINE_SEP, message);
  }
  
}
