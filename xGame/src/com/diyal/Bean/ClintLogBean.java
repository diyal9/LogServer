package com.diyal.Bean;

public class ClintLogBean
{
  private int userid;
  private String username;
  private int logLevel;
  private String content;
  private String time;
  private int deleteflg;

  public int getUserid()
  {
    return this.userid;
  }
  public void setUserid(int userid) {
    this.userid = userid;
  }
  public String getUsername() {
    return this.username;
  }
  public void setUsername(String username) {
    this.username = username;
  }
  public int getLogLevel() {
    return this.logLevel;
  }
  public void setLogLevel(int logLevel) {
    this.logLevel = logLevel;
  }
  public String getContent() {
    return this.content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public String getTime() {
    return this.time;
  }
  public void setTime(String time) {
    this.time = time;
  }
  public int getDeleteflg() {
    return this.deleteflg;
  }
  public void setDeleteflg(int deleteflg) {
    this.deleteflg = deleteflg;
  }
}