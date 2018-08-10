package com.diyal.Dao;

import com.diyal.Bean.ClintLogBean;
import com.diyal.util.DBConn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LogUploadDao
{
  public int insertData(ClintLogBean clintBean)
    throws SQLException
  {
    Connection conn = DBConn.getConn();
    PreparedStatement pstm = null;
    ResultSet rs = null;
    try
    {
      String insertSQL = "INSERT INTO t_clintlog ( t_usename, t_loglevel,t_json,t_time,t_deleteflg ) values(?,?,?,now(), 0) ";

      pstm = conn.prepareStatement(insertSQL);

      pstm.setString(1, clintBean.getUsername());
      pstm.setInt(2, clintBean.getLogLevel());
      pstm.setString(3, clintBean.getContent());
      pstm.executeUpdate();
    }
    catch (SQLException e) {
      e.printStackTrace();
    }
    finally {
      if (pstm != null) {
        pstm.close();
      }
      if (conn != null) {
        conn.close();
      }
      if (rs != null) {
        DBConn.close(rs);
      }
    }
    return 1;
  }

  public List<ClintLogBean> getAutoLogList(String userid) throws SQLException {
    Connection conn = DBConn.getConn();
    PreparedStatement pstm = null;
    ResultSet rs = null;

    List logBeanList = new ArrayList();
    try
    {
      pstm = conn
        .prepareStatement(" SELECT * from t_clintlog where t_usename = ? and t_deleteflg = 0 order by t_time desc limit 5");

      pstm.setString(1, userid);

      rs = pstm.executeQuery();

      while (rs.next())
      {
        ClintLogBean logbean = new ClintLogBean();
        logbean.setUsername(rs.getString("t_usename"));
        String content = rs.getString("t_json");
        content = content.replaceAll("\\n", "<br>");
        logbean.setContent(content);
        logbean.setTime(rs.getString("t_time"));
        logBeanList.add(logbean);
      }
    }
    catch (SQLException e) {
      e.printStackTrace();
    }
    finally {
      if (pstm != null) {
        pstm.close();
      }
      if (conn != null) {
        conn.close();
      }
      if (rs != null) {
        DBConn.close(rs);
      }
    }
    return logBeanList;
  }

  public List<ClintLogBean> getLogList(String userid) throws SQLException
  {
    Connection conn = DBConn.getConn();
    PreparedStatement pstm = null;
    ResultSet rs = null;

    List logBeanList = new ArrayList();
    try
    {
      pstm = conn
        .prepareStatement(" SELECT * from t_clintlog where t_usename = ? order by t_deleteflg, t_time desc");

      pstm.setString(1, userid);

      rs = pstm.executeQuery();

      while (rs.next())
      {
        ClintLogBean logbean = new ClintLogBean();
        logbean.setUsername(rs.getString("t_usename"));
        String content = rs.getString("t_json");
        content = content.replaceAll("\\n", "<br>");
        logbean.setContent(content);
        logbean.setTime(rs.getString("t_time"));
        logbean.setDeleteflg(rs.getInt("t_deleteflg"));
        logBeanList.add(logbean);
      }
    }
    catch (SQLException e) {
      e.printStackTrace();
    }
    finally {
      if (pstm != null) {
        pstm.close();
      }
      if (conn != null) {
        conn.close();
      }
      if (rs != null) {
        DBConn.close(rs);
      }
    }
    return logBeanList;
  }

  public int deleteMyLog(String userid)
    throws SQLException
  {
    Connection conn = DBConn.getConn();
    PreparedStatement pstm = null;
    ResultSet rs = null;
    try
    {
      String insertSQL = " UPDATE t_clintlog SET t_deleteflg = 1, updatetime = now() WHERE t_usename = ? ";

      pstm = conn.prepareStatement(insertSQL);

      pstm.setString(1, userid);

      pstm.executeUpdate();
    }
    catch (SQLException e) {
      e.printStackTrace();
    }
    finally {
      if (pstm != null) {
        pstm.close();
      }
      if (conn != null) {
        conn.close();
      }
      if (rs != null) {
        DBConn.close(rs);
      }
    }
    return 1;
  }

  public int deleteLookUpLog(String userid) throws SQLException
  {
    Connection conn = DBConn.getConn();
    PreparedStatement pstm = null;
    ResultSet rs = null;
    try
    {
      String sqlStr = " DELETE FROM t_clintlog WHERE t_usename = ? and t_deleteflg = 1 ";

      pstm = conn.prepareStatement(sqlStr);

      pstm.setString(1, userid);

      pstm.executeUpdate();
    }
    catch (SQLException e) {
      e.printStackTrace();
    }
    finally {
      if (pstm != null) {
        pstm.close();
      }
      if (conn != null) {
        conn.close();
      }
      if (rs != null) {
        DBConn.close(rs);
      }
    }
    return 1;
  }

  public static void main(String[] args)
  {
  }
}