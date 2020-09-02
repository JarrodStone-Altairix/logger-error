/*
 * Copyright 2012 Altairix Inc.
 */
package com.altairix.logging;

import java.util.logging.Level;

/**
 * Common interface to all ADF Loggers
 */
public abstract class Logger {

  public static final String LOGGING_DISABLED_MESSAGE = "Logging disabled";

  private final String      loggerNm;
  private       AdfLogLevel logLvl;

  /**
   * Override user name for the next log message. {@code null} indicates no override user name
   *
   * @see #pushSession(String, String, String)
   */
  protected String pushUserNm = null;

  /**
   * Override user ID for the next log message. {@code null} indicates no override user ID
   *
   * @see #pushSession(String, String, String)
   */
  protected String pushUserUid = null;

  /**
   * Override session ID for the next log message. {@code null} indicates no override session ID
   *
   * @see #pushSession(String, String, String)
   */
  protected String pushSessionUid = null;

  /**
   * Override task ID for the next log message. {@code null} indicates no override task ID
   *
   * @see #pushTask(String, int, int)
   */
  protected String pushTaskUid = null;

  /**
   * Override task sequence number for the next log message.
   *
   * @see #pushTask(String, int, int)
   */
  protected int pushTaskSeqNo = -1;

  /**
   * Override retry count for the next log message.
   *
   * @see #pushTask(String, int, int)
   */
  protected int pushRetryCnt = -1;

  /**
   * Force log a message at the DEBUG level with associated log Objects
   *
   * @param lobj Objects to be logged with the message
   * @param msg the message to be logged
   * @return the logged message
   */
  public static String doDebug(Lobj lobj, String msg) {
    return LoggerFactory.doLogger.debug(lobj.toArray(), msg, new Object[0]);
  }

  /**
   * Force log a message at the DEBUG level with data substitution values and associated log
   * Objects
   *
   * @param lobj Objects to be logged with the message
   * @param msgFormat the message to be logged
   * @param dataArr array of values to be substituted into the message text using
   * {@link SubstituteString#formatString(String, String, String) SubstituteString.formatString()}
   * @return the logged message
   */
  public static String doDebug(Lobj lobj, String msgFormat, Object... dataArr) {
    return LoggerFactory.doLogger.debug(lobj, msgFormat, dataArr);
  }

  /**
   * Force log a message at the DEBUG level with an associated Exception and log Objects
   *
   * @param lobj Objects to be logged with the message
   * @param e the Exception which generated this log message
   * @param msg the message to be logged
   * @return the logged message
   */
  public static String doDebug(Lobj lobj, Throwable e, String msg) {
    return LoggerFactory.doLogger.debug(lobj, e, msg, new Object[0]);
  }

  /**
   * Force log a message at the DEBUG level with an associated Exception and log Objects
   *
   * @param lobj Objects to be logged with the message
   * @param e the Exception which generated this log message
   * @param msgFormat the message to be logged
   * @param dataArr array of values to be substituted into the message text using
   * {@link SubstituteString#formatString(String, String, String) SubstituteString.formatString()}
   * @return the logged message
   */
  public static String doDebug(Lobj lobj, Throwable e, String msgFormat, Object... dataArr) {
    return LoggerFactory.doLogger.debug(lobj, e, msgFormat, dataArr);
  }

  /**
   * Force log a message at the DEBUG level with associated log Objects
   *
   * @param logArr array of Objects to be logged with the message
   * @param msg the message to be logged
   * @return the logged message
   */
  public static String doDebug(Object[] logArr, String msg) {
    return LoggerFactory.doLogger.debug(logArr, msg, new Object[0]);
  }

  /**
   * Force log a message at the DEBUG level with data substitution values and associated log
   * Objects
   *
   * @param logArr array of Objects to be logged with the message
   * @param msgFormat the message to be logged
   * @param dataArr array of values to be substituted into the message text using
   * {@link SubstituteString#formatString(String, String, String) SubstituteString.formatString()}
   * @return the logged message
   */
  public static String doDebug(Object[] logArr, String msgFormat, Object... dataArr) {
    return LoggerFactory.doLogger.debug(logArr, msgFormat, dataArr);
  }

  /**
   * Force log a message at the DEBUG level with an associated Exception and log Objects
   *
   * @param logArr array of Objects to be logged with the message
   * @param e the Exception which generated this log message
   * @param msg the message to be logged
   * @return the logged message
   */
  public static String doDebug(Object[] logArr, Throwable e, String msg) {
    return LoggerFactory.doLogger.debug(logArr, e, msg, new Object[0]);
  }

  /**
   * Force log a message at the DEBUG level with an associated Exception and log Objects
   *
   * @param logArr array of Objects to be logged with the message
   * @param e the Exception which generated this log message
   * @param msgFormat the message to be logged
   * @param dataArr array of values to be substituted into the message text using
   * {@link SubstituteString#formatString(String, String, String) SubstituteString.formatString()}
   * @return the logged message
   */
  public static String doDebug(Object[] logArr, Throwable e, String msgFormat, Object... dataArr) {
    return LoggerFactory.doLogger.debug(logArr, e, msgFormat, dataArr);
  }

  /**
   * Force log a message at the DEBUG level
   *
   * @param msg the message to be logged
   * @return the logged message
   */
  public static String doDebug(String msg) {
    return LoggerFactory.doLogger.debug(msg, new Object[0]);
  }

  /**
   * Force log a message at the DEBUG level with data substitution values
   *
   * @param msgFormat the message to be logged
   * @param dataArr array of values to be substituted into the message text using
   * {@link SubstituteString#formatString(String, String, String) SubstituteString.formatString()}
   * @return the logged message
   */
  public static String doDebug(String msgFormat, Object... dataArr) {
    return LoggerFactory.doLogger.debug(msgFormat, dataArr);
  }

  /**
   * Force log a message at the DEBUG level with an associated Exception
   *
   * @param e the Exception which generated this log message
   * @param msg the message to be logged
   * @return the logged message
   */
  public static String doDebug(Throwable e, String msg) {
    return LoggerFactory.doLogger.debug(e, msg, new Object[0]);
  }

  /**
   * Force log a message at the DEBUG level with an associated Exception
   *
   * @param e the Exception which generated this log message
   * @param msgFormat the message to be logged
   * @param dataArr array of values to be substituted into the message text using
   * {@link SubstituteString#formatString(String, String, String) SubstituteString.formatString()}
   * @return the logged message
   */
  public static String doDebug(Throwable e, String msgFormat, Object... dataArr) {
    return LoggerFactory.doLogger.debug(e, msgFormat, dataArr);
  }

  /**
   * Force log a message at the INFO level with associated log Objects
   *
   * @param lobj Objects to be logged with the message
   * @param msg the message to be logged
   * @return the logged message
   */
  public static String doInfo(Lobj lobj, String msg) {
    return LoggerFactory.doLogger.info(lobj, msg, new Object[0]);
  }

  /**
   * Force log a message at the INFO level with data substitution values and associated log
   * Objects
   *
   * @param lobj Objects to be logged with the message
   * @param msgFormat the message to be logged
   * @param dataArr array of values to be substituted into the message text using
   * {@link SubstituteString#formatString(String, String, String) SubstituteString.formatString()}
   * @return the logged message
   */
  public static String doInfo(Lobj lobj, String msgFormat, Object... dataArr) {
    return LoggerFactory.doLogger.info(lobj, msgFormat, dataArr);
  }

  /**
   * Force log a message at the INFO level with an associated Exception and log Objects
   *
   * @param lobj Objects to be logged with the message
   * @param e the Exception which generated this log message
   * @param msg the message to be logged
   * @return the logged message
   */
  public static String doInfo(Lobj lobj, Throwable e, String msg) {
    return LoggerFactory.doLogger.info(lobj, e, msg, new Object[0]);
  }

  /**
   * Force log a message at the INFO level with an associated Exception and log Objects
   *
   * @param lobj Objects to be logged with the message
   * @param e the Exception which generated this log message
   * @param msgFormat the message to be logged
   * @param dataArr array of values to be substituted into the message text using
   * {@link SubstituteString#formatString(String, String, String) SubstituteString.formatString()}
   * @return the logged message
   */
  public static String doInfo(Lobj lobj, Throwable e, String msgFormat, Object... dataArr) {
    return LoggerFactory.doLogger.info(lobj, e, msgFormat, dataArr);
  }

  /**
   * Force log a message at the INFO level with associated log Objects
   *
   * @param logArr array of Objects to be logged with the message
   * @param msg the message to be logged
   * @return the logged message
   */
  public static String doInfo(Object[] logArr, String msg) {
    return LoggerFactory.doLogger.info(logArr, msg, new Object[0]);
  }

  /**
   * Force log a message at the INFO level with data substitution values and associated log
   * Objects
   *
   * @param logArr array of Objects to be logged with the message
   * @param msgFormat the message to be logged
   * @param dataArr array of values to be substituted into the message text using
   * {@link SubstituteString#formatString(String, String, String) SubstituteString.formatString()}
   * @return the logged message
   */
  public static String doInfo(Object[] logArr, String msgFormat, Object... dataArr) {
    return LoggerFactory.doLogger.info(logArr, msgFormat, dataArr);
  }

  /**
   * Force log a message at the INFO level with an associated Exception and log Objects
   *
   * @param logArr array of Objects to be logged with the message
   * @param e the Exception which generated this log message
   * @param msg the message to be logged
   * @return the logged message
   */
  public static String doInfo(Object[] logArr, Throwable e, String msg) {
    return LoggerFactory.doLogger.info(logArr, e, msg, new Object[0]);
  }

  /**
   * Force log a message at the INFO level with an associated Exception and log Objects
   *
   * @param logArr array of Objects to be logged with the message
   * @param e the Exception which generated this log message
   * @param msgFormat the message to be logged
   * @param dataArr array of values to be substituted into the message text using
   * {@link SubstituteString#formatString(String, String, String) SubstituteString.formatString()}
   * @return the logged message
   */
  public static String doInfo(Object[] logArr, Throwable e, String msgFormat, Object... dataArr) {
    return LoggerFactory.doLogger.info(logArr, e, msgFormat, dataArr);
  }

  /**
   * Force log a message at the INFO level
   *
   * @param msg the message to be logged
   * @return the logged message
   */
  public static String doInfo(String msg) {
    return LoggerFactory.doLogger.info(msg, new Object[0]);
  }

  /**
   * Force log a message at the INFO level with data substitution values
   *
   * @param msgFormat the message to be logged
   * @param dataArr array of values to be substituted into the message text using
   * {@link SubstituteString#formatString(String, String, String) SubstituteString.formatString()}
   * @return the logged message
   */
  public static String doInfo(String msgFormat, Object... dataArr) {
    return LoggerFactory.doLogger.info(msgFormat, dataArr);
  }

  /**
   * Force log a message at the INFO level with an associated Exception
   *
   * @param e the Exception which generated this log message
   * @param msg the message to be logged
   * @return the logged message
   */
  public static String doInfo(Throwable e, String msg) {
    return LoggerFactory.doLogger.info(e, msg, new Object[0]);
  }

  /**
   * Force log a message at the INFO level with an associated Exception
   *
   * @param e the Exception which generated this log message
   * @param msgFormat the message to be logged
   * @param dataArr array of values to be substituted into the message text using
   * {@link SubstituteString#formatString(String, String, String) SubstituteString.formatString()}
   * @return the logged message
   */
  public static String doInfo(Throwable e, String msgFormat, Object... dataArr) {
    return LoggerFactory.doLogger.info(e, msgFormat, dataArr);
  }

  /**
   * Force log a message at the TRACE level with associated log Objects
   *
   * @param lobj Objects to be logged with the message
   * @param msg the message to be logged
   * @return the logged message
   */
  public static String doTrace(Lobj lobj, String msg) {
    return LoggerFactory.doLogger.trace(lobj, msg, new Object[0]);
  }

  /**
   * Force log a message at the TRACE level with data substitution values and associated log
   * Objects
   *
   * @param lobj Objects to be logged with the message
   * @param msgFormat the message to be logged
   * @param dataArr array of values to be substituted into the message text using
   * {@link SubstituteString#formatString(String, String, String) SubstituteString.formatString()}
   * @return the logged message
   */
  public static String doTrace(Lobj lobj, String msgFormat, Object... dataArr) {
    return LoggerFactory.doLogger.trace(lobj, msgFormat, dataArr);
  }

  /**
   * Force log a message at the TRACE level with an associated Exception and log Objects
   *
   * @param lobj Objects to be logged with the message
   * @param e the Exception which generated this log message
   * @param msg the message to be logged
   * @return the logged message
   */
  public static String doTrace(Lobj lobj, Throwable e, String msg) {
    return LoggerFactory.doLogger.trace(lobj, e, msg, new Object[0]);
  }

  /**
   * Force log a message at the TRACE level with an associated Exception and log Objects
   *
   * @param lobj Objects to be logged with the message
   * @param e the Exception which generated this log message
   * @param msgFormat the message to be logged
   * @param dataArr array of values to be substituted into the message text using
   * {@link SubstituteString#formatString(String, String, String) SubstituteString.formatString()}
   * @return the logged message
   */
  public static String doTrace(Lobj lobj, Throwable e, String msgFormat, Object... dataArr) {
    return LoggerFactory.doLogger.trace(lobj, e, msgFormat, dataArr);
  }

  /**
   * Force log a message at the TRACE level with associated log Objects
   *
   * @param logArr array of Objects to be logged with the message
   * @param msg the message to be logged
   * @return the logged message
   */
  public static String doTrace(Object[] logArr, String msg) {
    return LoggerFactory.doLogger.trace(logArr, msg, new Object[0]);
  }

  /**
   * Force log a message at the TRACE level with data substitution values and associated log
   * Objects
   *
   * @param logArr array of Objects to be logged with the message
   * @param msgFormat the message to be logged
   * @param dataArr array of values to be substituted into the message text using
   * {@link SubstituteString#formatString(String, String, String) SubstituteString.formatString()}
   * @return the logged message
   */
  public static String doTrace(Object[] logArr, String msgFormat, Object... dataArr) {
    return LoggerFactory.doLogger.trace(logArr, msgFormat, dataArr);
  }

  /**
   * Force log a message at the TRACE level with an associated Exception and log Objects
   *
   * @param logArr array of Objects to be logged with the message
   * @param e the Exception which generated this log message
   * @param msg the message to be logged
   * @return the logged message
   */
  public static String doTrace(Object[] logArr, Throwable e, String msg) {
    return LoggerFactory.doLogger.trace(logArr, e, msg, new Object[0]);
  }

  /**
   * Force log a message at the TRACE level with an associated Exception and log Objects
   *
   * @param logArr array of Objects to be logged with the message
   * @param e the Exception which generated this log message
   * @param msgFormat the message to be logged
   * @param dataArr array of values to be substituted into the message text using
   * {@link SubstituteString#formatString(String, String, String) SubstituteString.formatString()}
   * @return the logged message
   */
  public static String doTrace(Object[] logArr, Throwable e, String msgFormat, Object... dataArr) {
    return LoggerFactory.doLogger.trace(logArr, e, msgFormat, dataArr);
  }

  /**
   * Force log a message at the TRACE level
   *
   * @param msg the message to be logged
   * @return the logged message
   */
  public static String doTrace(String msg) {
    return LoggerFactory.doLogger.trace(msg, new Object[0]);
  }

  /**
   * Force log a message at the TRACE level with data substitution values
   *
   * @param msgFormat the message to be logged
   * @param dataArr array of values to be substituted into the message text using
   * {@link SubstituteString#formatString(String, String, String) SubstituteString.formatString()}
   * @return the logged message
   */
  public static String doTrace(String msgFormat, Object... dataArr) {
    return LoggerFactory.doLogger.trace(msgFormat, dataArr);
  }

  /**
   * Force log a message at the TRACE level with an associated Exception
   *
   * @param e the Exception which generated this log message
   * @param msg the message to be logged
   * @return the logged message
   */
  public static String doTrace(Throwable e, String msg) {
    return LoggerFactory.doLogger.trace(e, msg, new Object[0]);
  }

  /**
   * Force log a message at the TRACE level with an associated Exception
   *
   * @param e the Exception which generated this log message
   * @param msgFormat the message to be logged
   * @param dataArr array of values to be substituted into the message text using
   * {@link SubstituteString#formatString(String, String, String) SubstituteString.formatString()}
   * @return the logged message
   */
  public static String doTrace(Throwable e, String msgFormat, Object... dataArr) {
    return LoggerFactory.doLogger.trace(e, msgFormat, dataArr);
  }

  protected Logger(String loggerNm) {
    this.loggerNm = loggerNm;
  }

  /**
   * Log a message at the DEBUG level with associated log Objects
   *
   * @param lobj Objects to be logged with the message
   * @param msg the message to be logged
   * @return the logged message or {@link #LOGGING_DISABLED_MESSAGE} if debug logging
   * is currently disabled
   */
  // -> Required by GWT : GWT will not bind to varargs signature with no args
  public String debug(Lobj lobj, String msg) {
    return debug(lobj, msg, new Object[0]);
  }

  /**
   * Log a message at the DEBUG level with data substitution values and associated log
   * Objects
   *
   * @param lobj Objects to be logged with the message
   * @param msgFormat the message to be logged
   * @param dataArr array of values to be substituted into the message text using
   * {@link SubstituteString#formatString(String, String, String) SubstituteString.formatString()}
   * @return the logged message or {@link #LOGGING_DISABLED_MESSAGE} if debug logging
   * is currently disabled
   */
  public String debug(Lobj lobj, String msgFormat, Object... dataArr) {
    if (isDebugEnabled()) {
      return logp(lobj.toArray(), AdfLogLevel.DEBUG, Level.FINE, msgFormat, dataArr);
    }
    return LOGGING_DISABLED_MESSAGE;
  }

  /**
   * Log a message at the DEBUG level with an associated Exception and log Objects
   *
   * @param lobj Objects to be logged with the message
   * @param e the Exception which generated this log message
   * @param msg the message to be logged
   * @return the logged message or {@link #LOGGING_DISABLED_MESSAGE} if debug logging
   * is currently disabled
   */
  // -> Required by GWT : GWT will not bind to varargs signature with no args
  public String debug(Lobj lobj, Throwable e, String msg) {
    return debug(lobj, e, msg, new Object[0]);
  }

  /**
   * Log a message at the DEBUG level with an associated Exception and log Objects
   *
   * @param lobj Objects to be logged with the message
   * @param e the Exception which generated this log message
   * @param msgFormat the message to be logged
   * @param dataArr array of values to be substituted into the message text using
   * {@link SubstituteString#formatString(String, String, String) SubstituteString.formatString()}
   * @return the logged message or {@link #LOGGING_DISABLED_MESSAGE} if debug logging
   * is currently disabled
   */
  public String debug(Lobj lobj, Throwable e, String msgFormat, Object... dataArr) {
    if (isDebugEnabled()) {
      return logp(lobj.toArray(), e, AdfLogLevel.DEBUG, Level.FINE, msgFormat, dataArr);
    }
    return LOGGING_DISABLED_MESSAGE;
  }

  /**
   * Log a message at the DEBUG level with associated log Objects
   *
   * @param logArr array of Objects to be logged with the message
   * @param msg the message to be logged
   * @return the logged message or {@link #LOGGING_DISABLED_MESSAGE} if debug logging
   * is currently disabled
   */
  // -> Required by GWT : GWT will not bind to varargs signature with no args
  public String debug(Object[] logArr, String msg) {
    return debug(logArr, msg, new Object[0]);
  }

  /**
   * Log a message at the DEBUG level with data substitution values and associated log
   * Objects
   *
   * @param logArr array of Objects to be logged with the message
   * @param msgFormat the message to be logged
   * @param dataArr array of values to be substituted into the message text using
   * {@link SubstituteString#formatString(String, String, String) SubstituteString.formatString()}
   * @return the logged message or {@link #LOGGING_DISABLED_MESSAGE} if debug logging
   * is currently disabled
   */
  public String debug(Object[] logArr, String msgFormat, Object... dataArr) {
    if (isDebugEnabled()) {
      return logp(logArr, AdfLogLevel.DEBUG, Level.FINE, msgFormat, dataArr);
    }
    return LOGGING_DISABLED_MESSAGE;
  }

  /**
   * Log a message at the DEBUG level with an associated Exception and log Objects
   *
   * @param logArr array of Objects to be logged with the message
   * @param e the Exception which generated this log message
   * @param msg the message to be logged
   * @return the logged message or {@link #LOGGING_DISABLED_MESSAGE} if debug logging
   * is currently disabled
   */
  // -> Required by GWT : GWT will not bind to varargs signature with no args
  public String debug(Object[] logArr, Throwable e, String msg) {
    return debug(logArr, e, msg, new Object[0]);
  }

  /**
   * Log a message at the DEBUG level with an associated Exception and log Objects
   *
   * @param logArr array of Objects to be logged with the message
   * @param e the Exception which generated this log message
   * @param msgFormat the message to be logged
   * @param dataArr array of values to be substituted into the message text using
   * {@link SubstituteString#formatString(String, String, String) SubstituteString.formatString()}
   * @return the logged message or {@link #LOGGING_DISABLED_MESSAGE} if debug logging
   * is currently disabled
   */
  public String debug(Object[] logArr, Throwable e, String msgFormat, Object... dataArr) {
    if (isDebugEnabled()) {
      return logp(logArr, e, AdfLogLevel.DEBUG, Level.FINE, msgFormat, dataArr);
    }
    return LOGGING_DISABLED_MESSAGE;
  }

  /**
   * Log a message at the DEBUG level with data substitution values
   *
   * @param msg the message to be logged
   * @return the logged message or {@link #LOGGING_DISABLED_MESSAGE} if debug logging
   * is currently disabled
   */
  // -> Required by GWT : GWT will not bind to varargs signature with no args
  public String debug(String msg) {
    return debug(msg, new Object[0]);
  }

  /**
   * Log a message at the DEBUG level with data substitution values
   *
   * @param msgFormat the message to be logged
   * @param dataArr array of values to be substituted into the message text using
   * {@link SubstituteString#formatString(String, String, String) SubstituteString.formatString()}
   * @return the logged message or {@link #LOGGING_DISABLED_MESSAGE} if debug logging
   * is currently disabled
   */
  public String debug(String msgFormat, Object... dataArr) {
    if (isDebugEnabled()) {
      return logp(AdfLogLevel.DEBUG, Level.FINE, msgFormat, dataArr);
    }
    return LOGGING_DISABLED_MESSAGE;
  }

  /**
   * Log a message at the DEBUG level with an associated Exception
   *
   * @param e the Exception which generated this log message
   * @param msg the message to be logged
   * @return the logged message or {@link #LOGGING_DISABLED_MESSAGE} if debug logging
   * is currently disabled
   */
  // -> Required by GWT : GWT will not bind to varargs signature with no args
  public String debug(Throwable e, String msg) {
    return debug(e, msg, new Object[0]);
  }

  /**
   * Log a message at the DEBUG level with an associated Exception
   *
   * @param e the Exception which generated this log message
   * @param msgFormat the message to be logged
   * @param dataArr array of values to be substituted into the message text using
   * {@link SubstituteString#formatString(String, String, String) SubstituteString.formatString()}
   * @return the logged message or {@link #LOGGING_DISABLED_MESSAGE} if debug logging
   * is currently disabled
   */
  public String debug(Throwable e, String msgFormat, Object... dataArr) {
    if (isDebugEnabled()) {
      return logp(e, AdfLogLevel.DEBUG, Level.FINE, msgFormat, dataArr);
    }
    return LOGGING_DISABLED_MESSAGE;
  }

  /**
   * Log a message at the ERROR level with associated log Objects
   *
   * @param lobj Objects to be logged with the message
   * @param msg the message to be logged
   * @return the logged message or {@link #LOGGING_DISABLED_MESSAGE} if error logging
   * is currently disabled
   */
  // -> Required by GWT : GWT will not bind to varargs signature with no args
  public String error(Lobj lobj, String msg) {
    return error(lobj, msg, new Object[0]);
  }

  /**
   * Log a message at the ERROR level with data substitution values and associated log
   * Objects
   *
   * @param lobj Objects to be logged with the message
   * @param msgFormat the message to be logged
   * @param dataArr array of values to be substituted into the message text using
   * {@link SubstituteString#formatString(String, String, String) SubstituteString.formatString()}
   * @return the logged message or {@link #LOGGING_DISABLED_MESSAGE} if error logging
   * is currently disabled
   */
  public String error(Lobj lobj, String msgFormat, Object... dataArr) {
    if (isErrorEnabled()) {
      return logp(lobj.toArray(), AdfLogLevel.ERROR, Level.SEVERE, msgFormat, dataArr);
    }
    return LOGGING_DISABLED_MESSAGE;
  }

  /**
   * Log a message at the ERROR level with an associated Exception and log Objects
   *
   * @param logArr Objects to be logged with the message
   * @param e the Exception which generated this log message
   * @param msg the message to be logged
   * @return the logged message or {@link #LOGGING_DISABLED_MESSAGE} if error logging
   * is currently disabled
   */
  // -> Required by GWT : GWT will not bind to varargs signature with no args
  public String error(Lobj lobj, Throwable e, String msg) {
    return error(lobj, e, msg, new Object[0]);
  }

  /**
   * Log a message at the ERROR level with an associated Exception and log Objects
   *
   * @param logArr Objects to be logged with the message
   * @param e the Exception which generated this log message
   * @param msgFormat the message to be logged
   * @param dataArr array of values to be substituted into the message text using
   * {@link SubstituteString#formatString(String, String, String) SubstituteString.formatString()}
   * @return the logged message or {@link #LOGGING_DISABLED_MESSAGE} if error logging
   * is currently disabled
   */
  public String error(Lobj lobj, Throwable e, String msgFormat, Object... dataArr) {
    if (isErrorEnabled()) {
      return logp(lobj.toArray(), e, AdfLogLevel.ERROR, Level.SEVERE, msgFormat, dataArr);
    }
    return LOGGING_DISABLED_MESSAGE;
  }

  /**
   * Log a message at the ERROR level with associated log Objects
   *
   * @param logArr array of Objects to be logged with the message
   * @param msg the message to be logged
   * @return the logged message or {@link #LOGGING_DISABLED_MESSAGE} if error logging
   * is currently disabled
   */
  // -> Required by GWT : GWT will not bind to varargs signature with no args
  public String error(Object[] logArr, String msg) {
    return error(logArr, msg, new Object[0]);
  }

  /**
   * Log a message at the ERROR level with data substitution values and associated log
   * Objects
   *
   * @param logArr array of Objects to be logged with the message
   * @param msgFormat the message to be logged
   * @param dataArr array of values to be substituted into the message text using
   * {@link SubstituteString#formatString(String, String, String) SubstituteString.formatString()}
   * @return the logged message or {@link #LOGGING_DISABLED_MESSAGE} if error logging
   * is currently disabled
   */
  public String error(Object[] logArr, String msgFormat, Object... dataArr) {
    if (isErrorEnabled()) {
      return logp(logArr, AdfLogLevel.ERROR, Level.SEVERE, msgFormat, dataArr);
    }
    return LOGGING_DISABLED_MESSAGE;
  }

  /**
   * Log a message at the ERROR level with an associated Exception and log Objects
   *
   * @param logArr array of Objects to be logged with the message
   * @param e the Exception which generated this log message
   * @param msg the message to be logged
   * @return the logged message or {@link #LOGGING_DISABLED_MESSAGE} if error logging
   * is currently disabled
   */
  // -> Required by GWT : GWT will not bind to varargs signature with no args
  public String error(Object[] logArr, Throwable e, String msg) {
    return error(logArr, e, msg, new Object[0]);
  }

  /**
   * Log a message at the ERROR level with an associated Exception and log Objects
   *
   * @param logArr array of Objects to be logged with the message
   * @param e the Exception which generated this log message
   * @param msgFormat the message to be logged
   * @param dataArr array of values to be substituted into the message text using
   * {@link SubstituteString#formatString(String, String, String) SubstituteString.formatString()}
   * @return the logged message or {@link #LOGGING_DISABLED_MESSAGE} if error logging
   * is currently disabled
   */
  public String error(Object[] logArr, Throwable e, String msgFormat, Object... dataArr) {
    if (isErrorEnabled()) {
      return logp(logArr, e, AdfLogLevel.ERROR, Level.SEVERE, msgFormat, dataArr);
    }
    return LOGGING_DISABLED_MESSAGE;
  }

  /**
   * Log a message at the ERROR level
   *
   * @param msg the message to be logged
   * @return the logged message or {@link #LOGGING_DISABLED_MESSAGE} if error logging
   * is currently disabled
   */
  // -> Required by GWT : GWT will not bind to varargs signature with no args
  public String error(String msg) {
    return error(msg, new Object[0]);
  }

  /**
   * Log a message at the ERROR level with data substitution values
   *
   * @param msgFormat the message to be logged
   * @param dataArr array of values to be substituted into the message text using
   * {@link SubstituteString#formatString(String, String, String) SubstituteString.formatString()}
   * @return the logged message or {@link #LOGGING_DISABLED_MESSAGE} if error logging
   * is currently disabled
   */
  public String error(String msgFormat, Object... dataArr) {
    if (isErrorEnabled()) {
      return logp(AdfLogLevel.ERROR, Level.SEVERE, msgFormat, dataArr);
    }
    return LOGGING_DISABLED_MESSAGE;
  }

  /**
   * Log a message at the ERROR level with an associated Exception
   *
   * @param e the Exception which generated this log message
   * @param msg the message to be logged
   * @return the logged message or {@link #LOGGING_DISABLED_MESSAGE} if error logging
   * is currently disabled
   */
  // -> Required by GWT : GWT will not bind to varargs signature with no args
  public String error(Throwable e, String msg) {
    return error(e, msg, new Object[0]);
  }

  /**
   * Log a message at the ERROR level with data substitution values and an associated Exception
   *
   * @param e the Exception which generated this log message
   * @param msgFormat the message to be logged
   * @param dataArr array of values to be substituted into the message text using
   * {@link SubstituteString#formatString(String, String, String) SubstituteString.formatString()}
   * @return the logged message or {@link #LOGGING_DISABLED_MESSAGE} if error logging
   * is currently disabled
   */
  public String error(Throwable e, String msgFormat, Object... dataArr) {
    if (isErrorEnabled()) {
      return logp(e, AdfLogLevel.ERROR, Level.SEVERE, msgFormat, dataArr);
    }
    return LOGGING_DISABLED_MESSAGE;
  }

  /**
   * Returns the current {@link AdfLogLevel} of this logger instance.
   * <p>
   * <b>Note:</b> The logging level at which this logger instance is active may be
   *              inherited from an ancestor. This inherited level may override the
   *              current level of this logger for logging purposes
   */
  public AdfLogLevel getLevel() {
    return logLvl;
  }

  /**
   * Returns the name of this Logger
   */
  public String getName() {
    return loggerNm;
  }

  /**
   * Returns the current Thread's ID
   */
  public abstract long getThreadId();

  /**
   * Log a message at the INFO level with data substitution values and associated log
   * Objects
   *
   * @param lobj Objects to be logged with the message
   * @param msg the message to be logged
   * @return the logged message or {@link #LOGGING_DISABLED_MESSAGE} if info logging
   * is currently disabled
   */
  // -> Required by GWT : GWT will not bind to varargs signature with no args
  public String info(Lobj lobj, String msg) {
    return info(lobj, msg, new Object[0]);
  }

  /**
   * Log a message at the INFO level with data substitution values and associated log
   * Objects
   *
   * @param lobj Objects to be logged with the message
   * @param msgFormat the message to be logged
   * @param dataArr array of values to be substituted into the message text using
   * {@link SubstituteString#formatString(String, String, String) SubstituteString.formatString()}
   * @return the logged message or {@link #LOGGING_DISABLED_MESSAGE} if info logging
   * is currently disabled
   */
  public String info(Lobj lobj, String msgFormat, Object... dataArr) {
    if (isInfoEnabled()) {
      return logp(lobj.toArray(), AdfLogLevel.INFO, Level.INFO, msgFormat, dataArr);
    }
    return LOGGING_DISABLED_MESSAGE;
  }

  /**
   * Log a message at the INFO level with an associated Exception and log Objects
   *
   * @param lobj Objects to be logged with the message
   * @param e the Exception which generated this log message
   * @param msg the message to be logged
   * @return the logged message or {@link #LOGGING_DISABLED_MESSAGE} if info logging
   * is currently disabled
   */
  // -> Required by GWT : GWT will not bind to varargs signature with no args
  public String info(Lobj lobj, Throwable e, String msg) {
    return info(lobj, e, msg, new Object[0]);
  }

  /**
   * Log a message at the INFO level with an associated Exception and log Objects
   *
   * @param lobj Objects to be logged with the message
   * @param e the Exception which generated this log message
   * @param msgFormat the message to be logged
   * @param dataArr array of values to be substituted into the message text using
   * {@link SubstituteString#formatString(String, String, String) SubstituteString.formatString()}
   * @return the logged message or {@link #LOGGING_DISABLED_MESSAGE} if info logging
   * is currently disabled
   */
  public String info(Lobj lobj, Throwable e, String msgFormat, Object... dataArr) {
    if (isInfoEnabled()) {
      return logp(lobj.toArray(), e, AdfLogLevel.INFO, Level.INFO, msgFormat, dataArr);
    }
    return LOGGING_DISABLED_MESSAGE;
  }


  /**
   * Log a message at the INFO level with data substitution values and associated log
   * Objects
   *
   * @param logArr array of Objects to be logged with the message
   * @param msg the message to be logged
   * @return the logged message or {@link #LOGGING_DISABLED_MESSAGE} if info logging
   * is currently disabled
   */
  // -> Required by GWT : GWT will not bind to varargs signature with no args
  public String info(Object[] logArr, String msg) {
    return info(logArr, msg, new Object[0]);
  }

  /**
   * Log a message at the INFO level with data substitution values and associated log
   * Objects
   *
   * @param logArr array of Objects to be logged with the message
   * @param msgFormat the message to be logged
   * @param dataArr array of values to be substituted into the message text using
   * {@link SubstituteString#formatString(String, String, String) SubstituteString.formatString()}
   * @return the logged message or {@link #LOGGING_DISABLED_MESSAGE} if info logging
   * is currently disabled
   */
  public String info(Object[] logArr, String msgFormat, Object... dataArr) {
    if (isInfoEnabled()) {
      return logp(logArr, AdfLogLevel.INFO, Level.INFO, msgFormat, dataArr);
    }
    return LOGGING_DISABLED_MESSAGE;
  }

  /**
   * Log a message at the INFO level with an associated Exception and log Objects
   *
   * @param logArr array of Objects to be logged with the message
   * @param e the Exception which generated this log message
   * @param msg the message to be logged
   * @return the logged message or {@link #LOGGING_DISABLED_MESSAGE} if info logging
   * is currently disabled
   */
  // -> Required by GWT : GWT will not bind to varargs signature with no args
  public String info(Object[] logArr, Throwable e, String msg) {
    return info(logArr, e, msg, new Object[0]);
  }

  /**
   * Log a message at the INFO level with an associated Exception and log Objects
   *
   * @param logArr array of Objects to be logged with the message
   * @param e the Exception which generated this log message
   * @param msgFormat the message to be logged
   * @param dataArr array of values to be substituted into the message text using
   * {@link SubstituteString#formatString(String, String, String) SubstituteString.formatString()}
   * @return the logged message or {@link #LOGGING_DISABLED_MESSAGE} if info logging
   * is currently disabled
   */
  public String info(Object[] logArr, Throwable e, String msgFormat, Object... dataArr) {
    if (isInfoEnabled()) {
      return logp(logArr, e, AdfLogLevel.INFO, Level.INFO, msgFormat, dataArr);
    }
    return LOGGING_DISABLED_MESSAGE;
  }

  /**
   * Log a message at the INFO level
   *
   * @param msg the message to be logged
   * @return the logged message or {@link #LOGGING_DISABLED_MESSAGE} if info logging
   * is currently disabled
   */
  // -> Required by GWT : GWT will not bind to varargs signature with no args
  public String info(String msg) {
    return info(msg, new Object[0]);
  }

  /**
   * Log a message at the INFO level with data substitution values
   *
   * @param msgFormat the message to be logged
   * @param dataArr array of values to be substituted into the message text using
   * {@link SubstituteString#formatString(String, String, String) SubstituteString.formatString()}
   * @return the logged message or {@link #LOGGING_DISABLED_MESSAGE} if info logging
   * is currently disabled
   */
  public String info(String msgFormat, Object... dataArr) {
    if (isInfoEnabled()) {
      return logp(AdfLogLevel.INFO, Level.INFO, msgFormat, dataArr);
    }
    return LOGGING_DISABLED_MESSAGE;
  }

  /**
   * Log a message at the INFO level with an associated Exception
   *
   * @param e the Exception which generated this log message
   * @param msg the message to be logged
   * @return the logged message or {@link #LOGGING_DISABLED_MESSAGE} if info logging
   * is currently disabled
   */
  // -> Required by GWT : GWT will not bind to varargs signature with no args
  public String info(Throwable e, String msg) {
    return info(e, msg, new Object[0]);
  }

  /**
   * Log a message at the INFO level with an associated Exception
   *
   * @param e the Exception which generated this log message
   * @param msgFormat the message to be logged
   * @param dataArr array of values to be substituted into the message text using
   * {@link SubstituteString#formatString(String, String, String) SubstituteString.formatString()}
   * @return the logged message or {@link #LOGGING_DISABLED_MESSAGE} if info logging
   * is currently disabled
   */
  public String info(Throwable e, String msgFormat, Object... dataArr) {
    if (isInfoEnabled()) {
      return logp(e, AdfLogLevel.INFO, Level.INFO, msgFormat, dataArr);
    }
    return LOGGING_DISABLED_MESSAGE;
  }

  /**
   * Returns {@code true} if this logger instance is enabled for the DEBUG.
   */
  public abstract boolean isDebugEnabled();

  /**
   * Returns {@code true} if this logger instance is enabled for the ERROR.
   */
  public abstract boolean isErrorEnabled();

  /**
   * Returns {@code true} if this logger instance is enabled for the INFO.
   */
  public abstract boolean isInfoEnabled();

  /**
   * Returns {@code true} if this logger instance is enabled for the TRACE.
   */
  public abstract boolean isTraceEnabled();

  /**
   * Returns {@code true} if this logger instance is enabled for the WARNING.
   */
  public abstract boolean isWarnEnabled();

  /**
   * Returns a new instance of Logger for the specified class name set to the default
   * Log Level as specified by the Property {@link Adf_Common#PROPERTY_NAME_LOG_LEVEL}
   * FIXME
   */
  public abstract Logger newLogger(String classNm);

  /**
   * Returns a new instance of Logger for the specified class name set to the specified
   * Log Level
   */
  public abstract Logger newLogger(String classNm, AdfLogLevel adfLogLevel);

  /**
   * Push the supplied user name, ID and session Id onto the override stack. These values
   * will be used for the next log message generated by this Logger
   *
   * @param userNm the user name to be used in the next message
   * @param userUid the user ID to be used in the next message
   * @param sessinUid the session ID to be used in the next message
   * @return this Logger
   */
  public Logger pushSession(String userNm, String userUid, String sessionUid) {
    this.pushUserNm     = userNm;
    this.pushUserUid    = userUid;
    this.pushSessionUid = sessionUid;
    return this;
  }

  /**
   * Push the supplied task ID and sequence number onto the override stack. These values
   * will be used for the next log message generated by this Logger
   *
   * @param taskUid the unique task ID to be used in the next message
   * @param taskSeqNo the task sequence number to be used in the next message
   * @param retryCnt the retry count to be used in the next message
   * @return this Logger
   */
  public Logger pushTask(String taskUid, int taskSeqNo, int retryCnt) {
    pushTaskUid   = taskUid;
    pushTaskSeqNo = taskSeqNo;
    pushRetryCnt  = retryCnt;
    return this;
  }

  /**
   * Set the {@link AdfLogLevel} of this logger to the specified level.
   */
  public void setLevel(AdfLogLevel newLvl) {
    logLvl = newLvl;
    setNativeLevel(logLvl);
  }

  /**
   * Log a message at the TRACE level with associated log Objects
   *
   * @param logArr Objects to be logged with the message
   * @param msg the message to be logged
   * @return the logged message or {@link #LOGGING_DISABLED_MESSAGE} if trace logging
   * is currently disabled
   */
  // -> Required by GWT : GWT will not bind to varargs signature with no args
  public String trace(Lobj lobj, String msg) {
    return trace(lobj, msg, new Object[0]);
  }

  /**
   * Log a message at the TRACE level with data substitution values and associated log
   * Objects
   *
   * @param logArr Objects to be logged with the message
   * @param msgFormat the message to be logged
   * @param dataArr array of values to be substituted into the message text using
   * {@link SubstituteString#formatString(String, String, String) SubstituteString.formatString()}
   * @return the logged message or {@link #LOGGING_DISABLED_MESSAGE} if trace logging
   * is currently disabled
   */
  public String trace(Lobj lobj, String msgFormat, Object... dataArr) {
    if (isTraceEnabled()) {
      return logp(lobj.toArray(), AdfLogLevel.TRACE, Level.FINEST, msgFormat, dataArr);
    }
    return LOGGING_DISABLED_MESSAGE;
  }

  /**
   * Log a message at the TRACE level with an associated Exception and log Objects
   *
   * @param logArr Objects to be logged with the message
   * @param e the Exception which generated this log message
   * @param msg the message to be logged
   * @return the logged message or {@link #LOGGING_DISABLED_MESSAGE} if trace logging
   * is currently disabled
   */
  // -> Required by GWT : GWT will not bind to varargs signature with no args
  public String trace(Lobj lobj, Throwable e, String msg) {
    return trace(lobj, e, msg, new Object[0]);
  }

  /**
   * Log a message at the TRACE level with an associated Exception and log Objects
   *
   * @param logArr Objects to be logged with the message
   * @param e the Exception which generated this log message
   * @param msgFormat the message to be logged
   * @param dataArr array of values to be substituted into the message text using
   * {@link SubstituteString#formatString(String, String, String) SubstituteString.formatString()}
   * @return the logged message or {@link #LOGGING_DISABLED_MESSAGE} if trace logging
   * is currently disabled
   */
  public String trace(Lobj lobj, Throwable e, String msgFormat, Object... dataArr) {
    if (isTraceEnabled()) {
      return logp(lobj.toArray(), e, AdfLogLevel.TRACE, Level.FINEST, msgFormat, dataArr);
    }
    return LOGGING_DISABLED_MESSAGE;
  }

  /**
   * Log a message at the TRACE level with associated log Objects
   *
   * @param logArr array of Objects to be logged with the message
   * @param msg the message to be logged
   * @return the logged message or {@link #LOGGING_DISABLED_MESSAGE} if trace logging
   * is currently disabled
   */
  // -> Required by GWT : GWT will not bind to varargs signature with no args
  public String trace(Object[] logArr, String msg) {
    return trace(logArr, msg, new Object[0]);
  }

  /**
   * Log a message at the TRACE level with data substitution values and associated log
   * Objects
   *
   * @param logArr array of Objects to be logged with the message
   * @param msgFormat the message to be logged
   * @param dataArr array of values to be substituted into the message text using
   * {@link SubstituteString#formatString(String, String, String) SubstituteString.formatString()}
   * @return the logged message or {@link #LOGGING_DISABLED_MESSAGE} if trace logging
   * is currently disabled
   */
  public String trace(Object[] logArr, String msgFormat, Object... dataArr) {
    if (isTraceEnabled()) {
      return logp(logArr, AdfLogLevel.TRACE, Level.FINEST, msgFormat, dataArr);
    }
    return LOGGING_DISABLED_MESSAGE;
  }

  /**
   * Log a message at the TRACE level with an associated Exception and log Objects
   *
   * @param logArr array of Objects to be logged with the message
   * @param e the Exception which generated this log message
   * @param msg the message to be logged
   * @return the logged message or {@link #LOGGING_DISABLED_MESSAGE} if trace logging
   * is currently disabled
   */
  // -> Required by GWT : GWT will not bind to varargs signature with no args
  public String trace(Object[] logArr, Throwable e, String msg) {
    return trace(logArr, e, msg, new Object[0]);
  }

  /**
   * Log a message at the TRACE level with an associated Exception and log Objects
   *
   * @param logArr array of Objects to be logged with the message
   * @param e the Exception which generated this log message
   * @param msgFormat the message to be logged
   * @param dataArr array of values to be substituted into the message text using
   * {@link SubstituteString#formatString(String, String, String) SubstituteString.formatString()}
   * @return the logged message or {@link #LOGGING_DISABLED_MESSAGE} if trace logging
   * is currently disabled
   */
  public String trace(Object[] logArr, Throwable e, String msgFormat, Object... dataArr) {
    if (isTraceEnabled()) {
      return logp(logArr, e, AdfLogLevel.TRACE, Level.FINEST, msgFormat, dataArr);
    }
    return LOGGING_DISABLED_MESSAGE;
  }

  /**
   * Log a message at the TRACE level
   *
   * @param msg the message to be logged
   * @return the logged message or {@link #LOGGING_DISABLED_MESSAGE} if trace logging
   * is currently disabled
   */
  // -> Required by GWT : GWT will not bind to varargs signature with no args
  public String trace(String msg) {
    return trace(msg, new Object[0]);
  }

  /**
   * Log a message at the TRACE level with data substitution values
   *
   * @param msgFormat the message to be logged
   * @param dataArr array of values to be substituted into the message text using
   * {@link SubstituteString#formatString(String, String, String) SubstituteString.formatString()}
   * @return the logged message or {@link #LOGGING_DISABLED_MESSAGE} if trace logging
   * is currently disabled
   */
  public String trace(String msgFormat, Object... dataArr) {
    if (isTraceEnabled()) {
      return logp(AdfLogLevel.TRACE, Level.FINEST, msgFormat, dataArr);
    }
    return LOGGING_DISABLED_MESSAGE;
  }

  /**
   * Log a message at the TRACE level with an associated Exception
   *
   * @param e the Exception which generated this log message
   * @param msg the message to be logged
   * @return the logged message or {@link #LOGGING_DISABLED_MESSAGE} if trace logging
   * is currently disabled
   */
  // -> Required by GWT : GWT will not bind to varargs signature with no args
  public String trace(Throwable e, String msg) {
    return trace(e, msg, new Object[0]);
  }

  /**
   * Log a message at the TRACE level with an associated Exception
   *
   * @param e the Exception which generated this log message
   * @param msgFormat the message to be logged
   * @param dataArr array of values to be substituted into the message text using
   * {@link SubstituteString#formatString(String, String, String) SubstituteString.formatString()}
   * @return the logged message or {@link #LOGGING_DISABLED_MESSAGE} if trace logging
   * is currently disabled
   */
  public String trace(Throwable e, String msgFormat, Object... dataArr) {
    if (isTraceEnabled()) {
      return logp(e, AdfLogLevel.TRACE, Level.FINEST, msgFormat, dataArr);
    }
    return LOGGING_DISABLED_MESSAGE;
  }

  /**
   * Log a message at the WARNING level with associated log Objects
   *
   * @param logArr Objects to be logged with the message
   * @param msg the message to be logged
   * @return the logged message or {@link #LOGGING_DISABLED_MESSAGE} if warn logging
   * is currently disabled
   */
  // -> Required by GWT : GWT will not bind to varargs signature with no args
  public String warn(Lobj lobj, String msg) {
    return warn(lobj, msg, new Object[0]);
  }

  /**
   * Log a message at the WARNING level with data substitution values and associated log
   * Objects
   *
   * @param logArr Objects to be logged with the message
   * @param msgFormat the message to be logged
   * @param dataArr array of values to be substituted into the message text using
   * {@link SubstituteString#formatString(String, String, String) SubstituteString.formatString()}
   * @return the logged message or {@link #LOGGING_DISABLED_MESSAGE} if warn logging
   * is currently disabled
   */
  public String warn(Lobj lobj, String msgFormat, Object... dataArr) {
    if (isWarnEnabled()) {
      return logp(lobj.toArray(), AdfLogLevel.WARN, Level.WARNING, msgFormat, dataArr);
    }
    return LOGGING_DISABLED_MESSAGE;
  }

  /**
   * Log a message at the WARNING level with an associated Exception and log Objects
   *
   * @param logArr Objects to be logged with the message
   * @param e the Exception which generated this log message
   * @param msg the message to be logged
   * @return the logged message or {@link #LOGGING_DISABLED_MESSAGE} if warn logging
   * is currently disabled
   */
  // -> Required by GWT : GWT will not bind to varargs signature with no args
  public String warn(Lobj lobj, Throwable e, String msg) {
    return warn(lobj, e, msg, new Object[0]);
  }

  /**
   * Log a message at the WARNING level with an associated Exception and log Objects
   *
   * @param logArr Objects to be logged with the message
   * @param e the Exception which generated this log message
   * @param msgFormat the message to be logged
   * @param dataArr array of values to be substituted into the message text using
   * {@link SubstituteString#formatString(String, String, String) SubstituteString.formatString()}
   * @return the logged message or {@link #LOGGING_DISABLED_MESSAGE} if warn logging
   * is currently disabled
   */
  public String warn(Lobj lobj, Throwable e, String msgFormat, Object... dataArr) {
    if (isWarnEnabled()) {
      return logp(lobj.toArray(), e, AdfLogLevel.WARN, Level.WARNING, msgFormat, dataArr);
    }
    return LOGGING_DISABLED_MESSAGE;
  }

  /**
   * Log a message at the WARNING level with associated log Objects
   *
   * @param logArr array of Objects to be logged with the message
   * @param msg the message to be logged
   * @return the logged message or {@link #LOGGING_DISABLED_MESSAGE} if warn logging
   * is currently disabled
   */
  // -> Required by GWT : GWT will not bind to varargs signature with no args
  public String warn(Object[] logArr, String msg) {
    return warn(logArr, msg, new Object[0]);
  }

  /**
   * Log a message at the WARNING level with data substitution values and associated log
   * Objects
   *
   * @param logArr array of Objects to be logged with the message
   * @param msgFormat the message to be logged
   * @param dataArr array of values to be substituted into the message text using
   * {@link SubstituteString#formatString(String, String, String) SubstituteString.formatString()}
   * @return the logged message or {@link #LOGGING_DISABLED_MESSAGE} if warn logging
   * is currently disabled
   */
  public String warn(Object[] logArr, String msgFormat, Object... dataArr) {
    if (isWarnEnabled()) {
      return logp(logArr, AdfLogLevel.WARN, Level.WARNING, msgFormat, dataArr);
    }
    return LOGGING_DISABLED_MESSAGE;
  }

  /**
   * Log a message at the WARNING level with an associated Exception and log Objects
   *
   * @param logArr array of Objects to be logged with the message
   * @param e the Exception which generated this log message
   * @param msg the message to be logged
   * @return the logged message or {@link #LOGGING_DISABLED_MESSAGE} if warn logging
   * is currently disabled
   */
  // -> Required by GWT : GWT will not bind to varargs signature with no args
  public String warn(Object[] logArr, Throwable e, String msg) {
    return warn(logArr, e, msg, new Object[0]);
  }

  /**
   * Log a message at the WARNING level with an associated Exception and log Objects
   *
   * @param logArr array of Objects to be logged with the message
   * @param e the Exception which generated this log message
   * @param msgFormat the message to be logged
   * @param dataArr array of values to be substituted into the message text using
   * {@link SubstituteString#formatString(String, String, String) SubstituteString.formatString()}
   * @return the logged message or {@link #LOGGING_DISABLED_MESSAGE} if warn logging
   * is currently disabled
   */
  public String warn(Object[] logArr, Throwable e, String msgFormat, Object... dataArr) {
    if (isWarnEnabled()) {
      return logp(logArr, e, AdfLogLevel.WARN, Level.WARNING, msgFormat, dataArr);
    }
    return LOGGING_DISABLED_MESSAGE;
  }

  /**
   * Log a message at the WARNING level
   *
   * @param msg the message to be logged
   * @return the logged message or {@link #LOGGING_DISABLED_MESSAGE} if warn logging
   * is currently disabled
   */
  // -> Required by GWT : GWT will not bind to varargs signature with no args
  public String warn(String msg) {
    return warn(msg, new Object[0]);
  }

  /**
   * Log a message at the WARNING level with data substitution values
   *
   * @param msgFormat the message to be logged
   * @param dataArr array of values to be substituted into the message text using
   * {@link SubstituteString#formatString(String, String, String) SubstituteString.formatString()}
   * @return the logged message or {@link #LOGGING_DISABLED_MESSAGE} if warn logging
   * is currently disabled
   */
  public String warn(String msgFormat, Object... dataArr) {
    if (isWarnEnabled()) {
      return logp(AdfLogLevel.WARN, Level.WARNING, msgFormat, dataArr);
    }
    return LOGGING_DISABLED_MESSAGE;
  }

  /**
   * Log a message at the WARNING level with an associated Exception
   *
   * @param e the Exception which generated this log message
   * @param msg the message to be logged
   * @return the logged message or {@link #LOGGING_DISABLED_MESSAGE} if warn logging
   * is currently disabled
   */
  // -> Required by GWT : GWT will not bind to varargs signature with no args
  public String warn(Throwable e, String msg) {
    return warn(e, msg, new Object[0]);
  }

  /**
   * Log a message at the WARNING level with an associated Exception
   *
   * @param e the Exception which generated this log message
   * @param msgFormat the message to be logged
   * @param dataArr array of values to be substituted into the message text using
   * {@link SubstituteString#formatString(String, String, String) SubstituteString.formatString()}
   * @return the logged message or {@link #LOGGING_DISABLED_MESSAGE} if warn logging
   * is currently disabled
   */
  public String warn(Throwable e, String msgFormat, Object... dataArr) {
    if (isWarnEnabled()) {
      return logp(e, AdfLogLevel.WARN, Level.WARNING, msgFormat, dataArr);
    }
    return LOGGING_DISABLED_MESSAGE;
  }

  /**
   * Log a message with associated log Objects
   *
   * @param logArr array of Objects to be logged with the message
   * @param adfLogLvl the ADF Log Level of the message
   * @param logLvl the JAVA log level of the mesage
   * @param msgFormat the message to be logged
   * @param dataArr array of values to be substituted into the message text using
   * {@link SubstituteString#formatString(String, String, String) SubstituteString.formatString()}
   * @return the logged message
   */
  protected abstract String logp(Object[] logArr, AdfLogLevel adfLogLvl, Level logLvl,
      String msgFormat, Object[] dataArr);

  /**
   * Log a message with an associated Exception and log Objects
   *
   * @param logArr array of Objects to be logged with the message
   * @param e the Exception which generated this log message
   * @param adfLogLvl the ADF Log Level of the message
   * @param logLvl the JAVA log level of the mesage
   * @param msgFormat the message to be logged
   * @param dataArr array of values to be substituted into the message text using
   * {@link SubstituteString#formatString(String, String, String) SubstituteString.formatString()}
   * @return the logged message
   */
  protected abstract String logp(Object[] logArr, Throwable e, AdfLogLevel adfLogLvl, Level logLvl,
      String msgFormat, Object[] dataArr);

  /**
   * Set the native logging level based on the supplied ADF Log Level
   */
  protected abstract void setNativeLevel(AdfLogLevel newLvl);

  private String logp(AdfLogLevel adfLogLvl, Level logLvl,
      String msgFormat, Object[] dataArr) {
    return logp(new Object[] {}, adfLogLvl, logLvl, msgFormat, dataArr);
  }

  private String logp(Throwable e, AdfLogLevel adfLogLvl, Level logLvl,
      String msgFormat, Object[] dataArr) {
    return logp(new Object[] {}, e, adfLogLvl, logLvl, msgFormat, dataArr);
  }
}
