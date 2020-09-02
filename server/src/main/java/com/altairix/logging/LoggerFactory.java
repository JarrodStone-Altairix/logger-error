package com.altairix.logging;

public class LoggerFactory {

  private static Logger rootLogger = new DefaultLogger("", AdfLogLevel.WARN);

  static Logger doLogger = new DefaultLogger("doLogger", AdfLogLevel.TRACE);

  private static final Object initSync = new Object();

  public static Logger getLogger(String classNm) {
    return rootLogger.newLogger(classNm);
  }

  public static Logger getLogger(String classNm, AdfLogLevel adfLogLvl) {
    return rootLogger.newLogger(classNm, adfLogLvl);
  }

  public static void setRootLogger(Logger rootLog) {
    synchronized (initSync) {
      LoggerFactory.rootLogger = rootLog;
      LoggerFactory.doLogger  = rootLog.newLogger("doLogger", AdfLogLevel.TRACE);
    }
  }
}
