package com.export.msh;

import hk.hku.cecid.phoenix.message.handler.MessageListener;
import hk.hku.cecid.phoenix.message.packaging.EbxmlMessage;
import hk.hku.cecid.phoenix.message.packaging.PayloadContainer;

import java.net.URL;
import java.util.Date;

import org.apache.xmlbeans.XmlException;

import th.ac.ku.singlewindow.schema.ExporterCertificateUpdateMsgDocument;

import com.export.business.SingleWindowService;
import com.export.vo.ExporterCertificateUpdateMsg;

public class ExporterCertificateUpdateHandler implements MessageListener {
	
	public ExporterCertificateUpdateHandler() {
		System.out.println("ExporterCertificateUpdateHandler: created");;
	}
	
	public URL getClientUrl() {
		return null;
	}

	public void onMessage(EbxmlMessage message) {
		System.out.println();
		System.out.println("================================");
		System.out.println("ExporterCertificateUpdateHandler: Message received!!");
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
			ExporterCertificateUpdateMsgDocument root = ExporterCertificateUpdateMsgDocument.Factory.parse(payload);
			ExporterCertificateUpdateMsgDocument.ExporterCertificateUpdateMsg msg = root.getExporterCertificateUpdateMsg();
			
			ExporterCertificateUpdateMsg vo = new ExporterCertificateUpdateMsg();
			vo.setExporterId(msg.getExporterId());
			vo.setCertificateTypeCode(msg.getCertificateTypeCode());
			vo.setIssueDate(msg.getIssueDate().getTime());
			vo.setExpireDate(msg.getExpireDate().getTime());
			vo.setIssueBy(msg.getIssueBy());
			vo.setStatusCode(msg.getStatusCode());
			vo.setSignature(msg.getSignature());
			
			SingleWindowService service = new SingleWindowService();
			service.updateExporterCertificate(vo);
		}
		catch (XmlException e) {
			e.printStackTrace();
		}
	}

}
