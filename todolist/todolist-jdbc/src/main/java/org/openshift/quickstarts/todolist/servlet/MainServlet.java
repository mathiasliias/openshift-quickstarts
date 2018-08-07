package org.openshift.quickstarts.todolist.servlet;

import org.apache.commons.mail.EmailException;
import org.openshift.quickstarts.todolist.service.SmtpClient;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * The MainServlet returns the to-do list html on GET requests and handles the
 * creation of new to-do list entries on POST requests.
 */
public class MainServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        writeHtml(resp.getWriter());
    }

    private void writeHtml(PrintWriter out) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(getServletContext().getResourceAsStream("/WEB-INF/index.html"), "UTF-8"));
        try {
            String line;
            while ((line = reader.readLine()) != null) {
            	out.println(line);
            }
        } finally {
            reader.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String fullname = req.getParameter("fullname");
        String message = req.getParameter("message");

        try {
			SmtpClient.sendMessage(email, fullname, message);
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resp.sendError(400);
		}
        resp.setStatus(200);
        resp.flushBuffer();
    }
}
