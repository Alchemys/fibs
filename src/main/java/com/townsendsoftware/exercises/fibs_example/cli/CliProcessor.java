package com.townsendsoftware.exercises.fibs_example.cli;

import com.townsendsoftware.exercises.fibs_example.utils.LogUtils;

import lombok.extern.slf4j.Slf4j;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

@Slf4j
public class CliProcessor {

  @Option(name = "-i", required = true, usage = "Iteration Count. Valid values 1 - 50.")
  public Long iterationCount;

  public boolean parseArguments(String[] args) {
    CmdLineParser cliParser = new CmdLineParser(this);
    try {
      cliParser.parseArgument(args);
      printArgs();
      return true;
    } catch (CmdLineException e) {
      System.err.println(e.getMessage());
      cliParser.printUsage(System.err);
      return false;
    }
  }

  protected void printArgs() {
    log.info("IterationCount: [{}]", iterationCount);
  }

}
