package com.aspire.addstudent.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import java.io.IOException;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=RedirectAddStudentPortlet",
	        "javax.portlet.display-name=RedirectAddStudent Portlet",
	        "javax.portlet.security-role-ref=power-user,user",
	        "mvc.command.name=/AddStudent.jsp"
	    },
	    service = MVCRenderCommand.class
	)
public class RedirectAddStudentPortlet implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		// TODO Auto-generated method stub
		return "/AddStudent.jsp";
	}

	
	
}
