package com.diyal.service;

import com.diyal.Bean.ClintLogBean;
import com.diyal.Dao.LogUploadDao;
import java.sql.SQLException;
import java.util.Map;

public class ClientResultHandler
{
  public boolean LogHandler(Map map)
    throws SQLException
  {
    ClintLogBean logBean = new ClintLogBean();

    String[] username = (String[])map.get("username");

    String[] oContext = (String[])map.get("info");

    logBean.setContent(oContext[0]);

    logBean.setUsername(username[0]);

    LogUploadDao logDao = new LogUploadDao();
    logDao.insertData(logBean);

    return false;
  }
}