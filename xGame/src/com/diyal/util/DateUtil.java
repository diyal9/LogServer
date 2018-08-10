package com.diyal.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName:     DataUtil.java
 * @Description:   日期工具
 * @author terryZhang
 *         email: 
 *         company:  Lunabox Mobile Technology Co.,Ltd
 * @date 2014�?�?9�?
 */
public class DateUtil {
	
	public static String getDate(String format){
		String temp_str = "";
		Date dt = new Date();
		// �?��的aa表示“上午�?或�?下午�?HH表示24小时�?如果换成hh表示12小时�?
		// SimpleDateFormat("yyyy-MM-dd HH:mm:ss aa");
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		temp_str = sdf.format(dt);
		return temp_str;
	}
	
}
