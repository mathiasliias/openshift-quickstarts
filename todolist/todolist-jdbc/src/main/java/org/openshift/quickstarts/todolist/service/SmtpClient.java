package org.openshift.quickstarts.todolist.service;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class SmtpClient {
	
	public static final String toAddr = System.getenv("toEmail");
	public static final String smtpUser = System.getenv("smtpUser");
	public static final String smtpPassword = System.getenv("smtpPassword");
	
	public static void sendMessage(String fromEmail, String fullname, String message) throws EmailException {
		HtmlEmail email = new HtmlEmail();
		email.setCharset("UTF-8");
		email.setAuthentication(smtpUser, smtpPassword);
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setSSLOnConnect(true);
		email.addTo(toAddr);
		email.setFrom(smtpUser);
		email.setSubject("Lemmikloomatuba: " + fullname);
		email.setHtmlMsg("<html><p>" + fromEmail +"</p>" +
						"<p>" + fullname +"</p>" +
						"<p>" + message +"</p>" + "</html>");
		email.send();
	}
}
