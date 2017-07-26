package com.tj.jst.base.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class UtilDate {

	/**
	 * 获取五年以后的时间
	 * @return
	 */
	public static java.sql.Date getStringChangeDate() {
		Calendar curr = Calendar.getInstance();
		curr.set(Calendar.YEAR,curr.get(Calendar.YEAR)+5);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    String fDate = simpleDateFormat.format(curr.getTime());
        Date date = null;
        java.sql.Date sqldate = null;
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = (Date) format.parse(fDate);
            sqldate=new java.sql.Date(date.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return sqldate;
    }
}
