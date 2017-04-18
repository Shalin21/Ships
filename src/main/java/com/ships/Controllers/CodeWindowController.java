package com.ships.Controllers;

import com.ships.Objects.Employee;
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
import org.apache.poi.ss.formula.functions.Code;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;

/**
 * Created by admin on 16.04.17.
 */
public class CodeWindowController {

    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    Session session = sessionFactory.openSession();
    private int code;
    private Employee employee = new Employee();
    @FXML
    private Button btnSend;

    @FXML
    private Button btnCancel;

    @FXML
    private TextField txtCode;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtPassword1;
    public void setEmployee(Employee emp){
        employee=emp;
    }
    public void setCode(int code){this.code=code;}
    private void closeWindow(MouseEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    private void clearFields() {
        txtCode.setText("");
        txtPassword1.setText("");
        txtPassword.setText("");
    }

    @FXML
    void btnSendClick(MouseEvent event) {
        if (Integer.parseInt(txtCode.getText())==code && txtPassword.getText().length() >= 6 && txtPassword.getText().equals(txtPassword1.getText())) {
            session.beginTransaction();
            employee.setPassword(txtPassword.getText());
            session.update(employee);
            session.getTransaction().commit();
            session.close();
            clearFields();
            closeWindow(event);
        } else if(Integer.parseInt(txtCode.getText())!=code){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Wrong code");
            alert.setHeaderText(null);
            alert.setContentText("Make sure that code you entered is same as code in email");
            alert.showAndWait();
        }
        else if(!txtPassword.equals(txtPassword1))
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Wrong password");
            alert.setHeaderText(null);
            alert.setContentText("Make sure that you entered two same passwords");
            alert.showAndWait();
        }

    }

}
