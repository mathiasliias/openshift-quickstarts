package org.openshift.quickstarts.todolist.service;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class SmtpClient {
	
	public static final String toAddr = System.getenv("toEmail");
	public static final String smtpUser = System.getenv("smtpPassword");
	public static final String smtpPassword = System.getenv("smtpPassword");
	
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
}
