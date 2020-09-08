package com.altairix.servlets;

import java.io.IOException;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.cloud.logging.LoggingHandler;

@SuppressWarnings("serial")
public class LoggerServlet extends HttpServlet {

  private static Logger logger = Logger.getLogger(LoggerServlet.class.getName());

  static {
    logger.addHandler(new LoggingHandler());
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    logger.severe("Message\nWith\nMultiple\nLines");
  }
}