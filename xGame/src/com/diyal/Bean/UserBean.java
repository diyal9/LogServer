package com.diyal.Bean;

public class UserBean extends BaseAbstractBean
{
  public String userid;
  public String password;
  public String password2;
  public String username;
  public String mailadress;
  public String realname;
  public String sex;
  public String plyno;

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

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getMailadress() {
    return this.mailadress;
  }

  public void setMailadress(String mailadress) {
    this.mailadress = mailadress;
  }

  public String getRealname() {
    return this.realname;
  }

  public void setRealname(String realname) {
    this.realname = realname;
  }

  public String getSex() {
    return this.sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public String getPlyno() {
    return this.plyno;
  }

  public void setPlyno(String plyno) {
    this.plyno = plyno;
  }

  public String getPassword2() {
    return this.password2;
  }

  public void setPassword2(String password2) {
    this.password2 = password2;
  }
}