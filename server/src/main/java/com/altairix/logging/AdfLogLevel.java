package com.altairix.logging;

public enum AdfLogLevel {

  ALL     ("*", "All"),
  PROBLEM ("-", "*PROBLEM"),
  TRACE   ("T", "Trace"),
  DEBUG   ("D", "Debug"),
  INFO    ("I", "Info"),
  WARN    ("W", "Warning"),
  ERROR   ("E", "Error"),
  NULL    ("@"  ,"Null");

  private String value, desc;

  AdfLogLevel(String value, String desc) {
    this.value = value;
    this.desc = desc;
  }

  public String getDesc() { return desc; }
  public String getString() { return value; }

  //  @Override
  //  public boolean isInstanceOf(Object testObj) {
  //    return testObj instanceof AdfLogLevel;
  //  }
  //
  //  @Override
  //  public boolean isSelectionValue(AdfLogLevel tstEnum) { return tstEnum == ALL || tstEnum == PROBLEM; }
  //
  //  @Override
  //  public AdfLogLevel toEnum(String enumString) {
  //
  //    if (enumString != null) {
  //      for (AdfLogLevel enumVal: AdfLogLevel.values()) {
  //        if (enumVal.value.equals(enumString)) { return enumVal; }
  //      }
  //    }
  //
  //    logger.error("Invalid value({}) for AdfLogLevel.toEnum()", enumString);
  //
  //    return null;
}
