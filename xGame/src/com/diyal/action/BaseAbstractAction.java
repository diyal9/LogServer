package com.diyal.action;

import com.opensymphony.xwork2.ActionSupport;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

public abstract class BaseAbstractAction extends ActionSupport
{
  private static final long serialVersionUID = 972090938389978175L;
  public static final String USER_SESSION_NAME = "userid";

  public HttpServletRequest getRequest()
  {
    return ServletActionContext.getRequest();
  }

  public HttpServletResponse getResponse() {
    return ServletActionContext.getResponse();
  }

  public Object getUser() {
    return getRequest().getSession().getAttribute("userid");
  }
}