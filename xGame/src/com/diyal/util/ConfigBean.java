package com.diyal.util;
/**
 * @ClassName:     ConfigBean.java
 * @Description:   数据库连接信息解析工具类
 * @author diyalyin
 *         email: diyalyin@lunabox.cn
 *         company:  Lunabox Mobile Technology Co.,Ltd
 * @date 2014-3-23
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class ConfigBean {

	private static String getDBConnFromXML(String refName) {
		String value = "";
		try {
			SAXBuilder builder = new SAXBuilder();
			String sysPath = "config.xml";
			ConfigBean.class.getClassLoader().getResource(sysPath).getPath()
					.toString();
			String realPath = ConfigBean.class.getClassLoader().getResource(
					sysPath).getPath().toString();
//			System.out.println("容器路径:" + realPath);

			// realPath=realPath.substring(1,realPath.length());
			// //默认取到的文件路径前面有/,不需要截去，ubantu下面�?��
			realPath = realPath.replaceAll("%20", " ");
			FileInputStream fin = new FileInputStream(realPath);

			Document readDocument = builder.build(fin);
			Element rootElement = readDocument.getRootElement();
			value = rootElement.getChildText(refName);

//			System.out.println("文件加载成功");
		} catch (Exception e) {
			e.printStackTrace();
			value = "error";
		}
		return value;

	}

	public static void setDBConnFromXML(String driverName, String connStr,
			String user, String pass) {
		try {

			SAXBuilder builder = new SAXBuilder();

			String sysPath = "config.xml";
			String realPath = ConfigBean.class.getClassLoader().getResource(
					sysPath).getPath().toString();
			realPath = realPath.substring(1, realPath.length());
			realPath = realPath.replaceAll("%20", " ");
			// //System.out.println("realPath:"+realPath);
			Document readDocument = builder.build(ConfigBean.class
					.getClassLoader().getResourceAsStream(sysPath));
			Element rootElement = readDocument.getRootElement();
			// System.out.println(rootElement.getChildText("driverName"));
			rootElement.getChild("driverName").setText(driverName);
			rootElement.getChild("connString").setText(connStr);
			rootElement.getChild("userName").setText(user);
			// System.out.println(rootElement.getChildText("userName"));
			rootElement.getChild("passWord").setText(pass);
			// FileOutputStream fout=new FileOutputStream(realPath);
			XMLOutputter outp = new XMLOutputter(Format.getPrettyFormat());
			// outp.output(readDocument,fout);
			try {

				outp.output(readDocument, new FileOutputStream(realPath));
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(realPath);
		} catch (Exception e) {
			// WriteLog.writeErrorInfo("ConfigBean",
			// "getDBConnFromXML","д��ݿ������ļ�����?"+e);
		}
	}

	public static String getDrivername() {
		String a = getDBConnFromXML("driverName");
		return a;
	}

	public static String getConnectURL() {
		return getDBConnFromXML("connString");
	}

	public static String getUserName() {
		String a = getDBConnFromXML("userName");

		return a;
	}

	public static String getPassword() {
		return getDBConnFromXML("passWord");
	}

	public static String getEmailHost() {
		return getDBConnFromXML("emailHost");
	}

	public static String getEmailFromAdd() {
		return getDBConnFromXML("emailFromAdd");
	}

	public static String getEmailUserName() {
		return getDBConnFromXML("emailUserName");
	}

	public static String getEmailPassword() {
		return getDBConnFromXML("emailPassword");
	}

	public static String getEmailSubject() {
		return getDBConnFromXML("emailSubject");
	}

}
