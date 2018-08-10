package com.diyal.interceptors;

import com.diyal.action.LoginAction;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import java.io.PrintStream;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

public class NoLoginInterceptor extends AbstractInterceptor
{
  public static ActionContext ctx;
  private static final String NO_LOGIN = "noLogin";
  public static Map sessionMap = null;

  public String intercept(ActionInvocation invocation) throws Exception
  {
    ctx = invocation.getInvocationContext();
    sessionMap = invocation.getInvocationContext().getSession();

    Object action = invocation.getAction();

    if ((action instanceof LoginAction)) {
      System.out.println("exit check login,because this is loginAction");
      invocation.invoke();
      return null;
    }
    Object user = ServletActionContext.getRequest().getSession()
      .getAttribute("userid");
    if (user == null) {
      System.out.println("session失效");
      return "noLogin";
    }
    return invocation.invoke();
  }
}