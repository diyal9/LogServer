package com.diyal.Dao;

import com.diyal.Bean.UserBean;
import com.diyal.util.DBConn;
import com.opensymphony.xwork2.ActionContext;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class UserDao
{
  private String SQL_LOAD_LOGIN1 = "select * from t_user where t_user_name = ? and t_user_psw = ? ";

  private String SQL_REGISTER = " INSERT INTO t_user(  t_user_name, t_user_psw, t_user_deleteflg, t_user_userrolepriority)  VALUES (?, ?, ?, ?)";

  private String SQL_CHECKUSER = "select count(*) B_PlayerInfo where ply_userid = ? ";

  private String platUserid = null;

  public boolean loginLoad1(String phoneNo, String pwd)
  {
    Connection conn = DBConn.getConn();
    PreparedStatement pstm = null;
    ResultSet rs = null;
    boolean isExist = false;
    try {
      pstm = conn.prepareStatement(this.SQL_LOAD_LOGIN1);
      pstm.setString(1, phoneNo);
      pstm.setString(2, pwd);

      rs = pstm.executeQuery();
      while (rs.next())
        isExist = true;
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return isExist;
  }

  public UserBean selectUser(String phoneNo, String pwd) {
    Connection conn = DBConn.getConn();
    PreparedStatement pstm = null;
    ResultSet rs = null;
    UserBean user = new UserBean();
    try {
      pstm = conn
        .prepareStatement("select ply_fullname  from t_player where PLY_Mobile = ? and PLY_Password = ? ");
      pstm.setString(1, phoneNo);
      pstm.setString(2, pwd);

      rs = pstm.executeQuery();
      while (rs.next()) {
        user.setUserid(phoneNo);
        user.setUsername(rs.getString(1));
      }
    }
    catch (SQLException e) {
      e.printStackTrace();
    }
    return user;
  }

  public UserBean MyBasicInfo() throws SQLException
  {
    Connection conn = DBConn.getConn();
    PreparedStatement pstm = null;
    ResultSet rs = null;

    UserBean user = new UserBean();
    try {
      pstm = conn.prepareStatement("select CUS_Name,CUS_Gender ,CUS_Email  from B_PlayerInfo  WHERE cus_userid = ? ");

      String userid = "";
      if (ActionContext.getContext().getSession().get("userid") != null) {
        userid = ActionContext.getContext().getSession().get("userid")
          .toString();
      }

      pstm.setString(1, userid);

      rs = pstm.executeQuery();

      while (rs.next()) {
        user.setMailadress(rs.getString("CUS_Email"));
        user.setRealname(rs.getString("CUS_Name"));
        user.setSex(rs.getString("CUS_Gender"));
      }
    }
    catch (SQLException e) {
      e.printStackTrace();
    }
    finally {
      if (pstm != null)
      {
        pstm.close();
      }

      if (conn != null)
      {
        conn.close();
      }
    }

    return user;
  }

  public boolean register(UserBean user, String userid, int plyno)
    throws SQLException
  {
    Connection conn = DBConn.getConn();
    PreparedStatement pstmUp = null;
    try
    {
      pstmUp = conn.prepareStatement(this.SQL_REGISTER);
      pstmUp.setInt(1, plyno);
      pstmUp.setString(2, user.getUserid());
      pstmUp.setString(3, user.getPassword());
      pstmUp.setString(4, userid);

      System.out.println("Insert sql：" + pstmUp);

      pstmUp.executeUpdate();
    }
    catch (SQLException e) {
      e.printStackTrace();
      return false;
    } finally {
      if (pstmUp != null) {
        pstmUp.close();
      }

      if (conn != null) {
        conn.close();
      }
    }

    return true;
  }

  public boolean checkUser(String userid) throws SQLException
  {
    Connection conn = DBConn.getConn();
    PreparedStatement pstm = null;
    ResultSet rs = null;

    boolean falg = false;
    try
    {
      pstm = conn.prepareStatement(this.SQL_CHECKUSER);
      pstm.setString(1, userid);

      pstm.executeQuery();

      rs = pstm.executeQuery();

      while (rs.next())
        falg = true;
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    } finally {
      if (pstm != null) {
        pstm.close();
      }

      if (conn != null) {
        conn.close();
      }
    }

    return falg;
  }

  public boolean upBasicInformation(String realname, String sex, String mail)
    throws SQLException
  {
    Connection conn = DBConn.getConn();
    PreparedStatement pstmUp = null;

    String userid = "";

    int nSex = 0;
    try
    {
      pstmUp = conn
        .prepareStatement("UPDATE B_PlayerInfo SET CUS_Name = ?, CUS_Gender = ? , CUS_Email = ? WHERE cus_userid = ? ");

      pstmUp.setString(1, realname);
      if ((sex != null) && (!sex.trim().equals(""))) {
        nSex = Integer.parseInt(sex);
      }
      pstmUp.setInt(2, nSex);
      pstmUp.setString(3, mail);

      if (ActionContext.getContext().getSession().get("userid") != null) {
        userid = ActionContext.getContext().getSession().get("userid")
          .toString();
      }
      pstmUp.setString(4, userid);

      System.out.println("更新sql：" + pstmUp);

      pstmUp.executeUpdate();
    }
    catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
    finally {
      if (pstmUp != null) {
        pstmUp.close();
      }

      if (conn != null) {
        conn.close();
      }

    }

    System.out.println("update succeed");
    return true;
  }

  public String getPlatUserid()
  {
    return this.platUserid;
  }

  public void setPlatUserid(String platUserid) {
    this.platUserid = platUserid;
  }
}