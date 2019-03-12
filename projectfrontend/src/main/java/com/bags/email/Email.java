/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bags.email;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

/**
 *
 * @author Admin
 */
public class Email {

    private String FROM, TO, PASSWORD;
    private Session SESSION;

    public Email(final String FROM, final String PASSWORD) {

        this.FROM = "generatorstory@gmail.com";
        this.PASSWORD = "storygenauto";

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");

        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "587");

        SESSION = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                        return new javax.mail.PasswordAuthentication(FROM, PASSWORD);//change accordingly
                    }
                });
    }

    public boolean sendSimpleMail(String FROM, String TO, String SUBJECT, String MESSAGE) {
        // send simple mail
        try {
            MimeMessage message = configureMail(FROM, TO, SUBJECT, MESSAGE);
            //send message 
            Transport.send(message);
            return true;
        } catch (MessagingException e) {System.err.println(e);
            return false;
        }
    }

    private MimeMessage configureMail(String FROM1, String TO1, String SUBJECT, String MESSAGE) throws MessagingException {
        MimeMessage message = new MimeMessage(SESSION);
        message.setFrom(new InternetAddress(FROM1)); //change accordingly
        //change accordingly
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(TO1.trim()));
        message.setSubject(SUBJECT);
        message.setText(MESSAGE);
        message.setSentDate(new Date());
        return message;
    }

    public boolean sendAttachedMail(String FROM, String TO, String SUBJECT, String MESSAGE, HttpServletRequest request) {
        try {
//            List<File> uploadedFiles = saveUploadedFiles(request);
            MimeMessage message = configureMail(FROM, TO, SUBJECT, MESSAGE);
/*
            // creates message part
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(MESSAGE, "text/html");

            // creates multi-part
            Multipart multipart = new MimeMultipart();

            // adds attachments
            if (uploadedFiles != null && uploadedFiles.size() > 0) {
                for (File aFile : uploadedFiles) {
                    DataSource source = new FileDataSource(aFile);
                    messageBodyPart.setDataHandler(new DataHandler(source));
                    messageBodyPart.setFileName(aFile.getName());
                    multipart.addBodyPart(messageBodyPart);
                }
            }
            // sets the multi-part as e-mail's content
            message.setContent(multipart);*/

            // sends the e-mail
            Transport.send(message);
//            deleteUploadFiles(uploadedFiles);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    /**
     * Saves uploaded files into a List
     */
    private List<File> saveUploadedFiles(HttpServletRequest request)
            throws IllegalStateException, IOException, ServletException {
        List<File> listFiles = new ArrayList<File>();
        byte[] buffer = new byte[4096];
        int bytesRead = -1;
        Collection<Part> multiparts = request.getParts();
        if (multiparts.size() > 0) {
            for (Part part : request.getParts()) {
                // creates a file to be saved
                String fileName = extractFileName(part);
                if (fileName == null || fileName.equals("")) {
                    // not attachment part, continue
                    continue;
                }

                File saveFile = new File(fileName);
                System.out.println("saveFile: " + saveFile.getAbsolutePath());
                FileOutputStream outputStream = new FileOutputStream(saveFile);

                // saves uploaded file
                InputStream inputStream = part.getInputStream();
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                outputStream.close();
                inputStream.close();

                listFiles.add(saveFile);
            }
        }
        return listFiles;
    }

    /**
     * Retrieves file name of a upload part from its HTTP header
     */
    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return null;
    }

    /**
     * Deletes all uploaded files, should be called after the e-mail was sent.
     */
    private void deleteUploadFiles(List<File> listFiles) {
        if (listFiles != null && listFiles.size() > 0) {
            for (File aFile : listFiles) {
                aFile.delete();
            }
        }
    }

}
