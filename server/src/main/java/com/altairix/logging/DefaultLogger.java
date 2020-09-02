/*
 * Copyright 2012 Altairix Inc.
 */
package com.altairix.logging;

import java.util.logging.Level;
import java.util.logging.LogRecord;

/**
 * Default ADF Logger.
 * <p>
 * This implementation of {@link Logger} that writes to the java.util.logging package.
 */
public class DefaultLogger extends Logger {

  private java.util.logging.Logger logger;

  public DefaultLogger(String loggerNm) {
    this(loggerNm, AdfLogLevel.ERROR);
  }

  public DefaultLogger(String loggerNm, AdfLogLevel adfLogLvl) {
    super(loggerNm);
    logger = java.util.logging.Logger.getLogger(DefaultLogger.class.getName());
    setLevel(adfLogLvl);
  }

  @Override
  public long getThreadId() { return 0; }

  @Override
  public boolean isDebugEnabled() {
    return logger.isLoggable(Level.FINE);
  }

  @Override
  public boolean isErrorEnabled() {
    return logger.isLoggable(Level.SEVERE);
  }

  @Override
  public boolean isInfoEnabled() {
    return logger.isLoggable(Level.INFO);
  }

  @Override
  public boolean isTraceEnabled() {
    return logger.isLoggable(Level.FINEST);
  }

  @Override
  public boolean isWarnEnabled() {
    return logger.isLoggable(Level.WARNING);
  }

  @Override
  public Logger newLogger(String classNm) {
    return new DefaultLogger(classNm);
  }

  @Override
  public Logger newLogger(String classNm, AdfLogLevel adfLogLvl) {
    return new DefaultLogger(classNm, adfLogLvl); }

  @Override
  public void setNativeLevel(AdfLogLevel newLvl) {

    switch (newLvl) {
      case TRACE :
        logger.setLevel(Level.FINEST);
        break;
      case DEBUG:
        logger.setLevel(Level.FINE);
        break;
      case INFO:
        logger.setLevel(Level.INFO);
        break;
      case WARN:
        logger.setLevel(Level.WARNING);
        break;
      case ERROR:
        logger.setLevel(Level.SEVERE);
        break;
      default:
        logger.setLevel(Level.FINEST);
        break;
    }
  }

  @Override
  protected String logp(Object[] logArr, AdfLogLevel adfLogLvl, Level logLvl, String msgFormat,
      Object[] dataArr) {

    // Compose message
    //    String msg = SubstituteString.formatString(msgFormat, dataArr);

    LogRecord logRec = new LogRecord(logLvl, msgFormat);
    logRec.setLoggerName(getName());

    System.out.println("Default Logger");
    logger.log(logRec);

    return msgFormat;
  }

  @Override
  protected String logp(Object[] logArr, Throwable e, AdfLogLevel adfLogLvl, Level logLvl,
      String msgFormat, Object[] dataArr) {

    // Compose message
    //    String msg = SubstituteString.formatString(msgFormat, dataArr);

    LogRecord logRec = new LogRecord(logLvl, msgFormat);
    logRec.setLoggerName(getName());

    logRec.setThrown(e);

    System.out.println("Default Logger");
    logger.log(logRec);

    return msgFormat;
  }
}
