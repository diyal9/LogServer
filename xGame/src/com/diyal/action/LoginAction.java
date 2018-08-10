package com.diyal.action;

import com.diyal.Dao.UserDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;

public class LoginAction extends ActionSupport
{
  public String platId;
  public String password;
  public String message;
  public String userid;
  public String loginsession;
  private UserDao uDao = null;
  private static final String PLATFORM = "platform";
  private static final String PLATFORMREG = "platformReg";

  public boolean validateLogin()
  {
    if ((this.userid == null) || ("".equals(this.userid.trim()))) {
      addFieldError("", "用户账号不能为空");
      return false;
    }

    if ((this.password == null) || ("".equals(this.password.trim()))) {
      addFieldError("", "请输入密码");
      return false;
    }

    return true;
  }

  public String execute()
    throws Exception
  {
    boolean usercodeExist = false;

    this.uDao = new UserDao();

    if (!validateLogin()) {
      return "input";
    }

    usercodeExist = comPtfCheck();
    if (usercodeExist) {
      this.message = (this.userid + "登录成功！");

      ActionContext.getContext().getSession().put("userid", this.userid);
      ActionContext.getContext().getSession().put("userbean", this.userid);
    } else {
      addFieldError("", "登录失败，用户名或密码不正确");
      return "input";
    }
    return "success";
  }

  public String gohome() throws Exception
  {
    return "success";
  }

  public String gotoLuna()
  {
    return "success";
  }

  public String gotoReg()
  {
    return "success";
  }

  private boolean comPtfCheck()
  {
    if (!this.uDao.loginLoad1(this.userid, this.password)) {
      return false;
    }

    return true;
  }

  public String getUserid()
  {
    return this.userid;
  }

  public void setUserid(String userid) {
    this.userid = userid;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getMessage() {
    return this.message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getLoginsession() {
    return this.loginsession;
  }

  public void setLoginsession(String loginsession) {
    this.loginsession = loginsession;
  }

  public String getPlatId() {
    return this.platId;
  }

  public void setPlatId(String platId) {
    this.platId = platId;
  }
}