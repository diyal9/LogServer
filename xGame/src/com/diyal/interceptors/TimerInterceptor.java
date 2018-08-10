package com.diyal.interceptors;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import java.io.PrintStream;

public class TimerInterceptor extends AbstractInterceptor
{
  public String intercept(ActionInvocation invocation)
    throws Exception
  {
    long start = System.currentTimeMillis();
    String result = invocation.invoke();
    long end = System.currentTimeMillis();
    System.out.println("执行被拦截方法的时间为=" + (end - start) + "毫秒");
    return result;
  }
}