package com.ships.Controllers;

import com.ships.Interface.Implementation.CollectionEmployeeList;
import com.ships.Objects.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by admin on 13.04.17.
 */
public class EmailSendWindowController {
    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    public Session session = sessionFactory.openSession();
    CollectionEmployeeList employeeList = new CollectionEmployeeList();
    @FXML
    private Button btnSendMail;

    @FXML
    private TextField txtEmail;

    @FXML
    private ProgressIndicator pgsInicator;

    public void initialize(){
       employeeList.setCollection(FXCollections.observableArrayList(session.createCriteria(Employee.class).list()));
       //employeeList.printCollection();
    }

    @FXML
    void onBtnClick(MouseEvent event) {
        boolean flag=false;
        if(txtEmail.getText().length()>0) {
            for (Employee e : employeeList.getCollection()) {
                if (e.getEmail().equals(txtEmail.getText())){
                    flag=true;
                    break;
                   // sendEmailCode();
                }

            }
            if(flag==true){
                sendEmailCode();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Email was found");
                alert.setHeaderText(null);
                alert.setContentText("Code was send to your email. If you cant find it please check spam box");
                alert.showAndWait();
            }
            else
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Email not found");
                alert.setHeaderText(null);
                alert.setContentText("Email was not found");
                alert.showAndWait();
            }
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Email field is empty");
            alert.setHeaderText(null);
            alert.setContentText("Please write down email, so we can send you letter with code");
            alert.showAndWait();
        }
    }

    public void sendEmailCode() {
        final String username = "dinnhall123@gmail.com";
        final String password = "asddsa123";
        int randomPIN = (int)(Math.random()*9000)+1000;
        String code = String.valueOf(randomPIN);
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
                    InternetAddress.parse(txtEmail.getText()));
            message.setSubject("Code to reset password");
            message.setText("Dear "+txtEmail.getText()+","
                    + "\n\n Here is code:"+code);

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
