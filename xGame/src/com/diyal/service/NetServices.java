package com.diyal.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

public class NetServices
{
  private String resultStr;
  private HttpServletRequest request;
  private Map map;

  public String LogHandler(HttpServletRequest request)
    throws SQLException, IOException
  {
    this.request = request;
    this.map = request.getParameterMap();

    ClientResultHandler clintResult = new ClientResultHandler();
    clintResult.LogHandler(this.map);

    this.resultStr = "log had upload success";

    return this.resultStr;
  }
}