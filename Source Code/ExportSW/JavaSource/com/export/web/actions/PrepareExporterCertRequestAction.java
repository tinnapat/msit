package com.export.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Session;

import com.export.dao.CertificateTypeDAO;
import com.export.dao.hibernate.CertificateTypeDAOHibernate;
import com.export.domain.CertificateType;
import com.export.framework.hibernate.HibernateSession;
import com.export.vo.ExporterCertificateRequestVO;

public class PrepareExporterCertRequestAction extends Action {

	CertificateTypeDAO certTypeDAO = new CertificateTypeDAOHibernate();
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

		Long certTypeId = Long.valueOf(request.getParameter("certTypeId")); 
		
		Session session = HibernateSession.currentSession();
		CertificateType certType = certTypeDAO.getCertificateType(session, certTypeId);
		
		ExporterCertificateRequestVO vo = new ExporterCertificateRequestVO();
		vo.setCertTypeId(String.valueOf(certType.getId()));
		vo.setCertTypeName(certType.getName());
		request.setAttribute("ExporterCertificateRequestVO", vo);
		
		return mapping.findForward("success");
    }
}
