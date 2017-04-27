package com.ships.Controllers;

import com.ships.Interface.Implementation.CollectionEmployeeList;
import com.ships.Objects.Employee;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;

/**
 * Created by admin on 15.04.17.
 */
public class SingUpController {

    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    Session session = sessionFactory.openSession();
    @FXML
    private Button btnSend;

    @FXML
    private Button btnCancel;

    @FXML
    private TextField txtLogin;

    @FXML
    private TextField txtEmail;

    @FXML
    private PasswordField txtPassword;

    @FXML
    void btnCanselClick(MouseEvent event) {
        closeWindow(event);
    }

    private void closeWindow(MouseEvent event) {
        Node source = (Node)event.getSource();
        Stage stage = (Stage)source.getScene().getWindow();
        stage.close();
    }
    private void clearFields(){
        txtLogin.setText("");
        txtEmail.setText("");
        txtPassword.setText("");
    }
    @FXML
    void btnSendClick(MouseEvent event) {
        if(session.isOpen()!=true){
            session=sessionFactory.openSession();
        }
        boolean flag=false;
       CollectionEmployeeList employeeList = new CollectionEmployeeList();
       employeeList.setCollection(FXCollections.observableArrayList(session.createCriteria(Employee.class).list()));
        if(txtLogin.getText().length()>0 && txtPassword.getText().length()>=6 && txtEmail.getText().length()>5) {
            for (Employee lemployee:employeeList.getCollection()) {
                if(lemployee.getLogin().equals(txtLogin.getText()) || lemployee.getEmail().equals(txtEmail.getText())){
                    flag=true;
                    break;
                }
                else
                {flag=false;}
            }
            if(flag==false) {
                session.beginTransaction();
                Employee emp = new Employee(txtLogin.getText(), txtPassword.getText(), txtEmail.getText(), false);
                session.save(emp);
                session.getTransaction().commit();
                session.close();
                clearFields();
                closeWindow(event);
            }
            else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Wrong input info");
                alert.setHeaderText(null);
                alert.setContentText("Login or email already in use");
                alert.showAndWait();
            }
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Wrong input info");
            alert.setHeaderText(null);
            alert.setContentText("Make sure that you password length is 6 or more symbols" + '\'' + "and email is correct");
            alert.showAndWait();
        }

    }


}
