package org.opendls.publicclient.servlet;


import java.util.Date;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MoreInfoServlet extends HttpServlet
{
    /** Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {

        // Check it is a valid record
        String id = request.getParameter("id");



    }

    /** Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {

        String id = request.getParameter("id");
        String fromEmail = request.getParameter("fromEmail");
        String fromName = request.getParameter("fromName");
        String comments = request.getParameter("comments");

        // TODO: Get RecLibInfo
        //try {
            // Do something
            // check the record exists
            // get librarian parameters
            //throw new ItemNotFoundException;
        //}
        //catch (ItemNotFoundException e) {
        //    System.out.print("Record not found");
        //}

        String toEmail = "system@opendls.org";

        // Send the Email
        try {
            boolean debug = false;

            // Set the host SMTP address
            Properties props = new Properties();
            props.put("mail.smtp.host", "localhost");

            // Get the default Session
            Session session = Session.getDefaultInstance(props, null);
            session.setDebug(debug);

            // Instantiate a new message
            Message msg = new MimeMessage(session);


            // Set message attributes
            msg.setFrom(new InternetAddress(fromEmail));
            InternetAddress[] address = {new InternetAddress(toEmail)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject("OpenDLS: Resource Info Request: #getRecLibInfo.source");
            msg.setSentDate(new Date());

            // Set the message content
            String content =
                "This message is delivered automatically by OpenDLS mail:" +
                    "----------------------------------------------------    " +
                    "" +
                    "To: #getRecLibInfo.contactName#" +
                    "(contact for #getRecLibInfo.libraryName#)" +
                    "" +
                    "A user of the Digital Library System is requesting more information on a resource present in the Digital Library System." +
                    "" +
                    "USER INFORMATION" +
                    "" +
                    "=================================================/dls" +
                    "" +
                    "From: <cfif len(attributes.fromName)>#attributes.fromName#<cfelse>An unnamed user</cfif>" +
                    "Email: " + fromName +
                    "" +
                    "RESOURCE INFORMATION" +
                    "=================================================/dls" +
                    "Data Id: #getRecLibInfo.data_Id#" +
                    "Title: #getRecLibInfo.title#" +
                    "Source: #getRecLibInfo.source#" +
                    "Library: #getRecLibInfo.libraryName#" +
                    "" +
                    "To view this resource now:" +
                    "Go to http://opendls.org/#getRecLibInfo.data_Id#";

            String asciiLogo = "" +
                    "\n----------------------------------------------------   " +
                    "\nOPEN DIGITAL LIBRARY SYSTEM\n";

            // TODO: If there are comments
            String commentText = "" +
                    "USER COMMENTS" +
                    "================================================/dls" +
                    "<comments>";

            //content.append(commentText);
            //content.append(asciiLogo);

            msg.setText(content);

            // Send the message
            Transport.send(msg);

        }
        catch (MessagingException mex) {
            // Prints all nested (chained) exceptions as well
            mex.printStackTrace();
        }

    }

}
