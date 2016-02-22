package com.export.web.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.export.domain.Exporter;

public class WebUtils {
	
	private static Log logger = LogFactory.getLog(WebUtils.class);
	
	public static boolean isUserLoggedIn(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Object exporter = session.getAttribute("exporter");
		if (exporter == null) {
			request.setAttribute("errorMessage", "คุณยังไม่ได้เข้าสู่ระบบ กรณา Login เข้าสู่ระบบก่อนใช้งาน");
			return false;
		}
		return true;
	}
	
	public static String getCurrentExporterId(HttpServletRequest request) {
		Exporter exporter = getCurrentExporter(request);
		if (exporter == null) {
			return null;
		}
		return exporter.getExporterId();
	}
	
	public static Exporter getCurrentExporter(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Exporter exporter = (Exporter) session.getAttribute("exporter");
		
		logger.debug("Retrieved exporter: " + exporter);
		return exporter;
	}

}
