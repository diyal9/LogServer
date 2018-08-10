package com.diyal.action;

import com.diyal.Bean.ClintLogBean;
import com.diyal.Dao.LogUploadDao;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

public class ViewLogAction extends ActionSupport
{
  public String username;
  public List<ClintLogBean> logList;

  public String execute()
    throws Exception
  {
    this.username = ServletActionContext.getRequest().getSession()
      .getAttribute("userid").toString();

    LogUploadDao dao = new LogUploadDao();
    this.logList = dao.getLogList(this.username);

    return "success";
  }

  public String executeAuto() throws Exception
  {
    this.username = ServletActionContext.getRequest().getSession()
      .getAttribute("userid").toString();

    LogUploadDao dao = new LogUploadDao();
    this.logList = dao.getAutoLogList(this.username);

    return "success";
  }

  public String clearMyLog() throws Exception {
    this.username = ServletActionContext.getRequest().getSession()
      .getAttribute("userid").toString();

    LogUploadDao dao = new LogUploadDao();
    int flg = dao.deleteMyLog(this.username);

    if (flg == 1) {
      return "success";
    }

    return null;
  }

  public String deleteLookUp() throws Exception
  {
    this.username = ServletActionContext.getRequest().getSession()
      .getAttribute("userid").toString();

    LogUploadDao dao = new LogUploadDao();
    int flg = dao.deleteLookUpLog(this.username);

    if (flg == 1) {
      return "success";
    }

    return null;
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