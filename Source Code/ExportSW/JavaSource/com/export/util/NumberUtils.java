package com.export.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class NumberUtils {
	
	private static Log logger = LogFactory.getLog(NumberUtils.class);
	
	private NumberUtils() { }
	
	public static Double stringToDouble(String s) {
		try {
			Double d = Double.valueOf(s);
			return d;
		}
		catch (Exception e) {
			logger.error("Exception while parsing: " + s, e);
			return new Double(0);
		}
	}

}
