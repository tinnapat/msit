package com.export.util;

import java.io.ByteArrayOutputStream;

import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;

public class XmlBeansUtils {
	
	/** Singleton instance of default XmlOptions */
	private static XmlOptions xmlOptions;
	
	/** Private constructor */
	private XmlBeansUtils() { }
	
	/**
	 * Initialize defaut XmlOptions
	 */
	static {
		xmlOptions = new XmlOptions();
		xmlOptions.setSavePrettyPrint();
	}
	
	/**
	 * Get default {@link XmlOptions} to be used in this application.
	 * @return Defaut XmlOptions 
	 */
	public static XmlOptions getDefaultXmlOptions() {
		return xmlOptions;
	}
	
	public static String printXmlObject(XmlObject obj) {
		try {
			ByteArrayOutputStream bo = new ByteArrayOutputStream();
			obj.save(bo, getDefaultXmlOptions());
			return new String(bo.toByteArray());
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
