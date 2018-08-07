package org.openshift.quickstarts.todolist.service;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class SmtpClient {
	
	public static final String toAddr = getToAddress();
	public static final String smtpUser = getSmtpUser();
	public static final String smtpPassword = getSmtpPassword();
	
	public static void sendMessage(String fromEmail, String fullname, String message) throws EmailException {
		HtmlEmail email = new HtmlEmail();
		email.setAuthentication(smtpUser, smtpPassword);
		email.setHostName("smtp.google.com");
		email.addTo(toAddr);
		email.setFrom(smtpUser);
		email.setSubject("Lemmikloomatuba sõnum");
		email.setHtmlMsg("<html><p>" + fromEmail +"</p>" +
						"<p>" + fullname +"</p>" +
						"<p>" + fromEmail +"</p>" + "</html>");
		email.send();
		
	}
	
	public static String getToAddress() {
		Context initCtx; 
		Context envCtx;
		try {
			initCtx = new InitialContext();
			envCtx = (Context)initCtx.lookup("java:comp/env");
			return (String)envCtx.lookup("toEmail");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String getSmtpUser() {
		Context initCtx; 
		Context envCtx;
		try {
			initCtx = new InitialContext();
			envCtx = (Context)initCtx.lookup("java:comp/env");
			return (String)envCtx.lookup("smtpUser");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String getSmtpPassword() {
		Context initCtx; 
		Context envCtx;
		try {
			initCtx = new InitialContext();
			envCtx = (Context)initCtx.lookup("java:comp/env");
			return (String)envCtx.lookup("smtpPassword");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return null;
	}
}
