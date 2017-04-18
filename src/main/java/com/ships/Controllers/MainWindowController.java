package com.ships.Controllers;

import com.ships.Objects.Employee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by admin on 13.04.17.
 */
public class MainWindowController {
    private Stage stage;
    private Parent root;
    private AdminWindowController adminWindowController;
    private FXMLLoader loader = new FXMLLoader();


    private Employee employee = new Employee();
    public void setEmployee(Employee employee){this.employee=employee;}
    public Employee getEmployee(){return this.employee;}
    public void setAdmBtn(){btnAccs.setVisible(true);}
    public void initialize(){

        btnAccs.setVisible(false);
        try {
            loader.setLocation(getClass().getResource("/Views/adminUsersListWindow.fxml"));
            root = loader.load();
            adminWindowController=loader.getController();
        }
        catch (IOException e){
            System.out.println(e.toString());
            System.out.println(e.getMessage());
        }

    }
    @FXML
    private Button btnAccs;

    @FXML
    void onBtnAction(ActionEvent event) {
        adminWindowController.fillTableView();
        showMainDialog();

    }
    private void showMainDialog()
    {
        if(stage==null)
        {
            stage=new Stage();
            stage.setTitle("User list");
            stage.setMinHeight(423);
            stage.setMinWidth(337);
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(btnAccs.getScene().getWindow());

        }
        stage.showAndWait();
    }
}
