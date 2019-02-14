/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Email;

import DAO.JDBCConnection;
import Random.RandomString;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

public class SendEmail extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        RequestDispatcher dispatcher = null;
        String accountUser =  request.getParameter("accountUser");
        String toEmail = request.getParameter("recoveryEmail");
        boolean kq = JDBCConnection.checkEmailExist(accountUser, toEmail);
        
        session.setAttribute("recoveryEmail", toEmail);
        
        //Tạo chuỗi random gồm 6 ký tự
        RandomString rds = new RandomString();
        String maXacNhan = rds.randomString(6);
        session.setAttribute("maXacNhan", maXacNhan);
        if (kq) {
            try {
                String host = "smtp.gmail.com";
                String user = "nobita961102@gmail.com";
                String pass = "danglovevana9";
                String to = toEmail;
                String from = "nobita961102@gmail.com";
                String subject = "Tiêu đề";
                String messageText = "Mã xác nhận của bạn: " + maXacNhan;
                boolean sessionDebug = false;

                Properties props = System.getProperties();

                props.put("mail.smtp.starttls.enable", "true");
                props.put("mail.smtp.host", host);
                props.put("mail.smtp.port", "587");
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.starttls.required", "true");

                java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
                Session mailSession = Session.getDefaultInstance(props, null);
                mailSession.setDebug(sessionDebug);
                Message msg = new MimeMessage(mailSession);
                msg.setFrom(new InternetAddress(from));
                InternetAddress[] address = {new InternetAddress(to)};
                msg.setRecipients(Message.RecipientType.TO, address);
                msg.setSubject(subject);
                msg.setSentDate(new Date());
                msg.setText(messageText);

                Transport transport = mailSession.getTransport("smtp");
                transport.connect(host, user, pass);
                transport.sendMessage(msg, msg.getAllRecipients());
                transport.close();
                response.sendRedirect("VerificationCode.jsp");
            } catch (MessagingException ex) {
                System.out.println(ex);
            }
        } else {
            request.setAttribute("Notification", "tài khoản hoặc email không đúng");
            dispatcher = request.getRequestDispatcher("FogotPassword.jsp");
            dispatcher.forward(request, response);
            
//            response.sendRedirect("FogotPassword.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
