package com.export.msh;

import hk.hku.cecid.phoenix.message.handler.Request;
import hk.hku.cecid.phoenix.message.handler.Utility;
import hk.hku.cecid.phoenix.message.packaging.AttachmentDataSource;
import hk.hku.cecid.phoenix.message.packaging.EbxmlMessage;
import hk.hku.cecid.phoenix.message.packaging.MessageHeader;
import hk.hku.cecid.phoenix.message.packaging.PayloadContainer;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;

import javax.activation.DataHandler;

public class MSHUtils {
	
    public static final String DEFAULT_CPA_ID 				= "#DEFAULT_CPA_ID#";
    public static final String DEFAULT_CONVERSATION_ID 		= "#DEFAULT_CONVERSATION_ID#";
    public static final String DEFAULT_SERVICE				= "http://www.ku.ac.th.th/singlewindow/ebxml/service";
    public static final String DEFAULT_TRASNSPORT_TYPE		= "HTTP";
    
    public static String getEbXmlPayloadAsString(PayloadContainer pc) {
		DataHandler dh = pc.getDataHandler();
		System.out.println("Content type: " + dh.getContentType());

        try {
            InputStream is = (InputStream) dh.getInputStream();
            int len = 0;
            byte[] b = null;

            len = is.available();
            int read = 0;
            b = new byte[len];
            while (read < len) {
                is.read(b, read, len-read);
                read += len;
            }
            
            return (new String(b, "UTF-8"));
        }
        catch (IOException e) {
        	e.printStackTrace();
        }
    
        return null;
	}
	
	public static void sentMshMessage(String toMshUrl, String action, String payload) {
		sentMshMessage("fromPartyId", "toPartyId", toMshUrl, action, payload);
	}

	public static void sentMshMessage(String fromPartyId, String toPartyId, String toMshUrl, String action, String payload) {
        try {
        	Request mshReq = new Request(new URL(toMshUrl), null, DEFAULT_TRASNSPORT_TYPE);

            EbxmlMessage message = new EbxmlMessage();

            MessageHeader header = message.addMessageHeader();
            header.addFromPartyId(fromPartyId, "Sample");
            header.addToPartyId(toPartyId, "Sample");
            header.setCpaId(DEFAULT_CPA_ID);
            header.setConversationId(DEFAULT_CONVERSATION_ID);
            header.setService(DEFAULT_SERVICE);
            header.setAction(action);
            header.setTimestamp(Utility.toUTCString(new Date()));

            String messageId = Utility.generateMessageId(new Date(), message);
            header.setMessageId(messageId);

        	AttachmentDataSource attachment = new AttachmentDataSource(payload.getBytes(), "text/xml");
        	DataHandler dh = new DataHandler(attachment);

        	message.addPayloadContainer(dh, "payload", "description");

            message.saveChanges();

    		System.out.println();
    		System.out.println("================================");
            System.out.println("Trying to send...");
    		System.out.println("Date: " + new Date());
    		System.out.println("Action: " + action);
    		System.out.println("To MSH: " + toMshUrl);
            System.out.println(payload);
            
            mshReq.sendReliably(message, false);
        }
        catch (Exception e) {
        	e.printStackTrace();
        }		
	}
	
}
