package com.diyal.action;

import com.diyal.Bean.ClintLogBean;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;

public class LogHandleTeamAction extends ActionSupport
{
  public String username;
  public List<ClintLogBean> logList;

  public String execute()
    throws Exception
  {
    return "success";
  }

  public String getUserid()
  {
    return this.username;
  }

  public void setUserid(String userid) {
    this.username = userid;
  }

  public List<ClintLogBean> getLogList() {
    return this.logList;
  }

  public void setLogList(List<ClintLogBean> logList) {
    this.logList = logList;
  }
}