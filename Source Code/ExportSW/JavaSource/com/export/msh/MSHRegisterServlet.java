package com.export.msh;

import hk.hku.cecid.phoenix.message.handler.ApplicationContext;
import hk.hku.cecid.phoenix.message.handler.Request;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * Startup servlet to register MSH hanlders with MSH at server startup. 
 * @author Tinnapat C.
 */
public class MSHRegisterServlet extends HttpServlet {

	public void init() throws ServletException {
		System.out.println("**********************************");
		System.out.println("* MSHRegisterServet loaded.");
		System.out.println("**********************************");
		
        ApplicationContext ac = null;
        try {
            ac = new ApplicationContext(
            		MSHUtils.DEFAULT_CPA_ID, 
            		MSHUtils.DEFAULT_CONVERSATION_ID, 
            		MSHUtils.DEFAULT_SERVICE, 
					ActionNames.UPDATE_EXPORTER_CERTIFICATE);
            
        	Request mshReq1 = new Request(
        			ac, 
        			null, 
					new ExporterCertificateUpdateHandler(),
					MSHUtils.DEFAULT_TRASNSPORT_TYPE);
        	
            mshReq1.setMonitorInterval(1000);
        	System.out.println("ExporterCertificateUpdateHandler: registered");

            ac = new ApplicationContext(
            		MSHUtils.DEFAULT_CPA_ID, 
            		MSHUtils.DEFAULT_CONVERSATION_ID, 
            		MSHUtils.DEFAULT_SERVICE, 
					ActionNames.UPDATE_SHIPMENT_CERTIFICATE);
            
        	Request mshReq2 = new Request(
        			ac, 
        			null, 
					new ShipmentCertificateUpdateHandler(),
					MSHUtils.DEFAULT_TRASNSPORT_TYPE);
        	
            mshReq2.setMonitorInterval(1000);
        	System.out.println("ShipmentCertificateUpdateHandler: registered");
        }
        catch (Exception e) {
        	e.printStackTrace();
        }
		
	}
}
