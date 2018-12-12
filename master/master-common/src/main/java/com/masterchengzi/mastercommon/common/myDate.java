package com.masterchengzi.mastercommon.common;

import java.util.Calendar;
import java.util.Date;

public class myDate {

	public static Date getdate(Date date,int index) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, index);
		date = calendar.getTime();
		return date;
	}

}
