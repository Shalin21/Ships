package FunctionClasses;

import javafx.scene.control.Alert;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.util.Properties;

/**
 * Created by admin on 09.06.17.
 */
public class SendEmailClass {


    public void sendEmailCode(File file, String adress) {
        final String username = "dinnhall123@gmail.com";
        final String password = "asddsa123";
        //randomPIN = (int) (Math.random() * 9000) + 1000;
        //String code = String.valueOf(randomPIN);
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        javax.mail.Session session1 = javax.mail.Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session1);
            message.setFrom(new InternetAddress("dinnhall123@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(adress));
            message.setSubject("Code to reset password");

            BodyPart messageBodyPart = new MimeBodyPart();

            // Now set the actual message
            messageBodyPart.setText("This is message body");
            Multipart multipart = new MimeMultipart();

            // Set text message part
            multipart.addBodyPart(messageBodyPart);

            // Part two is attachment
            messageBodyPart = new MimeBodyPart();
            String filename = file.getAbsolutePath();
            //String filename = "/Users/admin/Downloads/test.pdf";
            DataSource source = new FileDataSource(filename);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(filename);
            //messageBodyPart.setText("Hello");
            multipart.addBodyPart(messageBodyPart);

            // Send the complete message parts
            message.setContent(multipart);
            Transport.send(message);
            // System.out.println("Done");

        } catch (MessagingException e1) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText(e1.getMessage());

            alert.showAndWait();
            throw new RuntimeException(e1);
        }
    }

}
