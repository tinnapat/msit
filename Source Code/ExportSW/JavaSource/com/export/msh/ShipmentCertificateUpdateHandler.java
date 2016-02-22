package com.export.msh;

import hk.hku.cecid.phoenix.message.handler.MessageListener;
import hk.hku.cecid.phoenix.message.packaging.EbxmlMessage;
import hk.hku.cecid.phoenix.message.packaging.PayloadContainer;

import java.net.URL;
import java.util.Date;

import org.apache.xmlbeans.XmlException;

import th.ac.ku.singlewindow.schema.ShipmentCertificateUpdateMsgDocument;

import com.export.business.SingleWindowService;
import com.export.vo.ShipmentCertificateUpdateMsg;

public class ShipmentCertificateUpdateHandler implements MessageListener {

	public URL getClientUrl() {
		return null;
	}

	public void onMessage(EbxmlMessage message) {
		System.out.println();
		System.out.println("================================");
		System.out.println("ShipmentCertificateUpdateHandler: Message received!!");
		System.out.println("Date: " + new Date());
		System.out.println("Number of payload: " + message.getPayloadCount());
		
		if (message.getPayloadCount() != 1) {
			System.err.println("Invalid payload count!!");
			return;
		}
		
		try {
			// Read ebXML Payload
			PayloadContainer pc = (PayloadContainer) message.getPayloadContainers().next();
			String payload = MSHUtils.getEbXmlPayloadAsString(pc);
			System.out.println("Payload:");
			System.out.println(payload);

			// Populate XMLBean
			ShipmentCertificateUpdateMsgDocument root = ShipmentCertificateUpdateMsgDocument.Factory.parse(payload);
			ShipmentCertificateUpdateMsgDocument.ShipmentCertificateUpdateMsg msg = root.getShipmentCertificateUpdateMsg();
			
			ShipmentCertificateUpdateMsg vo = new ShipmentCertificateUpdateMsg();
			vo.setCertificateRequestId(msg.getCertificateRequestID());
			vo.setCertificateTypeId(msg.getCertificateTypeID());
			vo.setIssueDate(msg.getIssueDate().getTime());
			vo.setExpireDate(msg.getExpireDate().getTime());
			vo.setIssueBy(msg.getIssueBy());
			vo.setStatusCode(msg.getStatusCode());
			vo.setSignature(msg.getSignature());
			
			SingleWindowService service = new SingleWindowService();
			service.updateShipmentCertificate(vo);
		}
		catch (XmlException e) {
			e.printStackTrace();
		}
	}

}
