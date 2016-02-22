package com.export.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtils {
	
	public static final String DEFAULT_DATE_FORMAT		= "yyyy-MM-dd";
	
	public static DateFormat DEFAULT_DATE_FORMATTER = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
	
	public static Date stringToDate(String s) {
		try {
			return DEFAULT_DATE_FORMATTER.parse(s);
		}
		catch (ParseException e) {
			return null;
		}
	}
	
	public static String dateToString(Date d) {
		if (d == null) {
			return null;
		}
		
		return DEFAULT_DATE_FORMATTER.format(d);
	}
	
	public static String dateToStringThai(Date d) {
		if (d == null) {
			return "-";
		}
		
		DateFormat format = new SimpleDateFormat("d MMMM yyyy", new Locale("th", "TH"));
		return format.format(d);
	}

}
