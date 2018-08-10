package com.diyal.action;

import com.diyal.service.NetServices;
import com.opensymphony.xwork2.ActionSupport;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

public class ProtocolAction extends ActionSupport
  implements ServletRequestAware, ServletResponseAware
{
  private HttpServletRequest request;
  private HttpServletResponse response;

  public String execute()
    throws Exception
  {
    try
    {
      this.response.setContentType("text/html;charset=utf-8");
      this.response.setCharacterEncoding("UTF-8");
    }
    catch (Exception e) {
      e.printStackTrace();
    }

    return "ok";
  }

  public void LogUpload()
    throws IOException, SQLException
  {
    NetServices netServices = new NetServices();
    String result = netServices.LogHandler(this.request);

    HttpServletResponse response = ServletActionContext.getResponse();

    response.setContentType("text/html;charset=utf-8");
    PrintWriter out = response.getWriter();
    out.println(result);
    System.out.println("协议：" + result);
    out.flush();
    out.close();
  }

  public void setServletResponse(HttpServletResponse response) {
    this.response = response;
  }

  public void setServletRequest(HttpServletRequest request) {
    this.request = request;
    try {
      request.setCharacterEncoding("UTF-8");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
  }
}