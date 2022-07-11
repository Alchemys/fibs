package com.townsendsoftware.exercises.fibs_example;

import com.townsendsoftware.exercises.fibs_example.utils.LogUtils;
import com.townsendsoftware.exercises.fibs_example.cli.CliProcessor;
import com.townsendsoftware.exercises.fibs_example.generators.GenerateFibonacciSequence;
import java.util.List;
import org.apache.commons.collections4.CollectionUtils;

import static com.townsendsoftware.exercises.fibs_example.constants.FibsConstants.SYSTEM_LINE_SEP;

/*
Copyright 2022 Townsend Software, All rights reserved
Version : 1.0.0
Date    : 2022-07-08
Author  : Jeffrey T. Jones

Author does not assume any responsibility for the use or abuse of this code.  
This code is simply an experiment and is intended for educational purposes only.
That being said, if you wish to use this code in part or in whole, please acknowledge the original author.
*/

public class FibsApp {

    public static void main(String[] args) {
  
      CliProcessor cliConfig = new CliProcessor();
  
      if (cliConfig.parseArguments(args)) {
        // Successfully parsed the command line arguments.
  
        if (cliConfig.iterationCount <= 50 && cliConfig.iterationCount > 0 ) {
          // We now have the expected iteration count, run the Fibonacci Sequence
          List<Long> sequences = GenerateFibonacciSequence.generateSequence(0, 1, cliConfig.iterationCount);
          if (CollectionUtils.isNotEmpty(sequences)) {
            StringBuilder sbForPrint = new StringBuilder();
            long seqCount = 0;
            for (Long seqVal : sequences) {
              sbForPrint.append(seqVal);
              sbForPrint.append(", ");
              if (seqCount % 10 == 0 && seqCount > 0) {
                sbForPrint.append(SYSTEM_LINE_SEP);
              }
              seqCount++;
            }
            LogUtils.logMessage(String.format("%sRequested sequence:%s%s%s", SYSTEM_LINE_SEP, SYSTEM_LINE_SEP, sbForPrint.toString(), SYSTEM_LINE_SEP));
          } else {
            LogUtils.logMessage("Failed to generate a sequence.");
          }

        } else {
            LogUtils.logMessage(String.format("Provided iteration count [%s], is out of range.  Must be between 1 and 50", cliConfig.iterationCount));
        }

      } else {
        LogUtils.logMessage("ERROR: Failed to parse command line arguments.");
      }
    }
}