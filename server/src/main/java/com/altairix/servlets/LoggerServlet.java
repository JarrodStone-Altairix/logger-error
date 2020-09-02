package com.altairix.servlets;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class LoggerServlet extends HttpServlet {

  private static final Logger logger = Logger.getLogger(LoggerServlet.class.getName());

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    logger.log(Level.SEVERE, "Message\nWith\nMultiple\nLines");

  }

}