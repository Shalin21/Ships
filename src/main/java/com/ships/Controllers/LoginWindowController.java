package com.ships.Controllers;

import com.ships.Interface.Implementation.CollectionEmployeeList;
import com.ships.Objects.Employee;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.List;

/**
 * Created by admin on 07.04.17.
 */
public class LoginWindowController {

    private Stage stage;
    private Stage stage1;
    private Stage stage2;
    private Parent root;
    private Parent root1;
    private Parent root2;
    private MainWindowController mainController;
    private EmailSendWindowController emailController;
    private SingUpController singUpController;
    private FXMLLoader loader = new FXMLLoader();
    private FXMLLoader loader1 = new FXMLLoader();
    private FXMLLoader loader2 = new FXMLLoader();
    private Stage mainStage;
    public void setMainStage(Stage mainStage){this.mainStage=mainStage;}
    CollectionEmployeeList employeeList = new CollectionEmployeeList();
    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
   public  Session session = sessionFactory.openSession();

    @FXML
    void linkClickCreate(MouseEvent event) {
        Object source = event.getSource();
        if(!(source instanceof Hyperlink))
        {return;}
        showSignUpDialog();
    }

    @FXML
    private Button btnLogin;

    @FXML
    private TextField txtLogin;
    @FXML
    private Hyperlink linkBtn;
    @FXML
    private PasswordField txtPassword;
    private Employee employee = new Employee("asd","asd","asd",true);
    @FXML
    private Label labelTest;

    public void initialize()
   {
//       System.out.println(employee.toString());
//        session.beginTransaction();
//        employeeList.fillTestData();
//        employeeList.printCollection();
//        for (Employee emp:employeeList.getCollection()
//                ) {
//            session.save(emp);
//        }
//        session.close();
        employeeList.printCollection();
        try {
            loader.setLocation(getClass().getResource("/Views/mainWindow.fxml"));
            root = loader.load();
            mainController = loader.getController();

            loader1.setLocation(getClass().getResource("/Views/emailSendWindow.fxml"));
            root1=loader1.load();
            emailController= loader1.getController();

            loader2.setLocation(getClass().getResource("/Views/createNewAccWindow.fxml"));
            root2=loader2.load();
            singUpController=loader2.getController();
        }
        catch (IOException e){
            System.out.println(e.toString());
            System.out.println(e.getMessage());
        }


    }

    @FXML
    void btnAction(ActionEvent event) {
        Object source = event.getSource();
        if(!(source instanceof Button))
        {return;}

        Button clicked = (Button) source;


        switch (clicked.getId()){

            case "btnLogin": {

                if (status()==true) {
                    try {
                       //mainController.setEmployee(employee);
                        if(employee.getLogin().equals("admin")){mainController.setAdmBtn();}
                        mainStage.hide();
                        showMainDialog();
                        session.close();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                }
            }

        }

    }
    @FXML
    void linkClick(MouseEvent event) {
        showEmailDialog();
    }

    public boolean status(){
        int flag = 3;
        if(!session.getTransaction().isActive()) {
            session.beginTransaction();
        }

        // AppUser user = new AppUser("firstuser");
       // Employee user = new Employee("alex", "shalin");
     //   session.save(user);
        //Employee user1 = new Employee(txtLogin.getText(), txtPassword.getText(), "asd@asd.ru" , false);
        //System.out.println(user1.getLogin()+" "+user1.getPassword());
        //session.getTransaction().commit();
        List<Employee> list = session.createCriteria(Employee.class).list();
        for (Employee j:list) {
            if(j.getLogin().toString().equals(txtLogin.getText()) && j.getPassword().equals(txtPassword.getText()) && j.getActive()==true){
                flag=1;
                employee=j;
                break;
            }
            else if(j.getLogin().toString().equals(txtLogin.getText()) && j.getPassword().equals(txtPassword.getText()) && j.getActive()!=true){
                flag=2;
                break;
            }
            else{
                flag=3;
            }
        }
        if(flag==1){return true;}
        else if(flag==2){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Account not confirmed");
            alert.setHeaderText(null);
            alert.setContentText("Your account is not activated, please contact admin to activate it");
            alert.showAndWait();
            return false;
        }
        else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Wrong login information");
            alert.setHeaderText(null);
            alert.setContentText("Login or password is incorrect, check your login info");
            alert.showAndWait();
            return false;
        }

    }

    private void showMainDialog()
    {
        if(stage==null)
        {
            stage=new Stage();
            stage.setTitle("Test errors");
            stage.setMinHeight(423);
            stage.setMinWidth(337);
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(mainStage);

        }
        stage.showAndWait();
    }
    private void showEmailDialog()
    {
        if(stage1==null)
        {
            //Scene scene;
            stage1=new Stage();
            stage1.setTitle("Add Test");
            stage1.setMinHeight(83);
            stage1.setMinWidth(394);
            stage1.setResizable(false);
            stage1.setScene(new Scene(root1));
            stage1.initModality(Modality.WINDOW_MODAL);
            stage1.initOwner(mainStage);
        }
        stage1.showAndWait();
    }

    private void showSignUpDialog()
    {
        if(stage2==null)
        {
            //Scene scene;
            stage2=new Stage();
            stage2.setTitle("Add Test");
            stage2.setMinHeight(150);
            stage2.setMinWidth(400);
            stage2.setResizable(false);
            stage2.setScene(new Scene(root2));
            stage2.initModality(Modality.WINDOW_MODAL);
            stage2.initOwner(mainStage);
        }
        stage2.showAndWait();
    }

}
