package governmentapp.msh;

import hk.hku.cecid.phoenix.message.handler.ApplicationContext;
import hk.hku.cecid.phoenix.message.handler.Request;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.export.msh.ActionNames;
import com.export.msh.MSHUtils;

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
					ActionNames.CREATE_EXPORTER_CERTIFICATE);
            
        	Request mshReq1 = new Request(
        			ac, 
        			null, 
					new ExporterCertificateRequestHandler(),
					MSHUtils.DEFAULT_TRASNSPORT_TYPE);
        	
            mshReq1.setMonitorInterval(1000);
        	System.out.println("ExporterCertificateRequestHandler: registered");

            ac = new ApplicationContext(
            		MSHUtils.DEFAULT_CPA_ID, 
            		MSHUtils.DEFAULT_CONVERSATION_ID, 
            		MSHUtils.DEFAULT_SERVICE, 
					ActionNames.CREATE_SHIPMENT_CERTIFICATE);
            
        	Request mshReq2 = new Request(
        			ac, 
        			null, 
					new ShipmentCertificateRequestHandler(),
					MSHUtils.DEFAULT_TRASNSPORT_TYPE);
        	
            mshReq2.setMonitorInterval(1000);
        	System.out.println("ShipmentCertificateRequestHandler: registered");
        }
        catch (Exception e) {
        	e.printStackTrace();
        }
		
	}
}
