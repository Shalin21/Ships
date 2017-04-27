package com.ships.Controllers;

import com.ships.Interface.Implementation.CollectionShipsList;
import com.ships.Objects.Employee;
import com.ships.Objects.Ship;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.Optional;

/**
 * Created by admin on 13.04.17.
 */
public class MainWindowController {
    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    Session session = sessionFactory.openSession();
    CollectionShipsList collectionShipsList = new CollectionShipsList();
    private Stage stage;
    private Stage stage1;
    private Stage stage2;
    private Stage stage3;
    private Parent root;
    private Parent root1;
    private Parent root2;
    private Parent root3;
    private AdminWindowController adminWindowController;
    private ShipsListWindowController shipsListWindowController;
    AddShipWindowController addShipWindowController;
    private FXMLLoader loader = new FXMLLoader();
    private FXMLLoader loader1 = new FXMLLoader();
    private FXMLLoader loader2 = new FXMLLoader();
    private FXMLLoader loader3 = new FXMLLoader();


    private Employee employee = new Employee();

    @FXML
    private Button btnHandySize;

    @FXML
    private Button btnHandyMax;

    @FXML
    private Button btnSeaWayMax;

    @FXML
    private Button btnAfraMax;

    @FXML
    private Button btnSuezMax;

    @FXML
    private Button btnMalaccaMax;

    @FXML
    private Button btnVLCC;

    @FXML
    private Button btnPanaMax;

    @FXML
    private Button btnCapeSize;
    @FXML
    private Button btnAccs;
    @FXML
    private MenuItem menuItemAdd;

    public void setEmployee(Employee employee){this.employee=employee;}
    public Employee getEmployee(){return this.employee;}
    public void setAdmBtn(){btnAccs.setVisible(true);}
    public void initialize(){
        collectionShipsList.setCollection(FXCollections.observableArrayList(session.createCriteria(Ship.class).list()));
        //collectionShipsList.fillTestData();
        btnAccs.setVisible(false);
        try {
            loader.setLocation(getClass().getResource("/Views/adminUsersListWindow.fxml"));
            root = loader.load();
            adminWindowController=loader.getController();

            loader1.setLocation(getClass().getResource("/Views/shipListWindow.fxml"));
            root1 = loader1.load();
            shipsListWindowController=loader1.getController();

            loader2.setLocation(getClass().getResource("/Views/addShipWindow.fxml"));
            root2 = loader2.load();
            addShipWindowController=loader2.getController();

            loader3.setLocation(getClass().getResource("/Views/calculationWindow.fxml"));
            root3 = loader3.load();

        }
        catch (IOException e){
            System.out.println(e.toString());
            System.out.println(e.getMessage());
        }

    }
    @FXML
    void onBtnAction(ActionEvent event) {


        Object source = event.getSource();
        if(!(source instanceof Button))
        {return;}

        Button clicked = (Button) source;

        Window parent = ((Node)event.getSource()).getScene().getWindow();
        if(btnAccs.isVisible()==true){shipsListWindowController.setBtnDeleteEnabled();}
        switch (clicked.getId()){

            case "btnAccs":{
                adminWindowController.fillTableView();
                showAdminDialog();
                break;
            }
            case "btnHandySize":{
            shipsListWindowController.setCollectionShipsList(CollectionFromReq(500.0,60.0,10.0,15000,35000));
            shipsListWindowController.fillTableView();
            shipsListWindowController.setLableText("Handysize");
            ShowShipDialog();
                break;
            }
            case "btnHandyMax":{
                shipsListWindowController.setCollectionShipsList(CollectionFromReq(200.0,60.0,50.0,35000,60000));
                shipsListWindowController.fillTableView();
                shipsListWindowController.setLableText("Handymax");
                ShowShipDialog();
                break;
            }
            case "btnSeaWayMax":{
                shipsListWindowController.setCollectionShipsList(CollectionFromReq(226.0,24.0,7.92,1,500000));
                shipsListWindowController.fillTableView();
                shipsListWindowController.setLableText("Seawaymax");
                ShowShipDialog();
                break;
            }
            case "btnAfraMax":{
                shipsListWindowController.setCollectionShipsList(CollectionFromReq(500.0,100.0,100.0,80000,120000));
                shipsListWindowController.fillTableView();
                shipsListWindowController.setLableText("Aframax");
                ShowShipDialog();
                break;
            }
            case "btnSuezMax":{
                shipsListWindowController.setCollectionShipsList(CollectionFromReq(500.0,46.0, 24.0, 60000,170000));
                shipsListWindowController.fillTableView();
                shipsListWindowController.setLableText("Suezmax");
                ShowShipDialog();
                break;
            }
            case "btnMalaccaMax":{
                shipsListWindowController.setCollectionShipsList(CollectionFromReq(500.0, 100.0, 20.0, 100000, 300000));
                shipsListWindowController.fillTableView();
                shipsListWindowController.setLableText("Malaccamax");
                ShowShipDialog();
                break;
            }
            case "btnVLCC":{
                shipsListWindowController.setCollectionShipsList(CollectionFromReq(470.0, 100.0, 30.0, 160000, 320000));
                shipsListWindowController.fillTableView();
                shipsListWindowController.setLableText("VLCC");
                ShowShipDialog();
                break;
            }
            case "btnPanaMax":{
                shipsListWindowController.setCollectionShipsList(CollectionFromReq(291.1, 32.3, 12.0, 60000, 80000));
                shipsListWindowController.fillTableView();
                shipsListWindowController.setLableText("Panamax");
                ShowShipDialog();
                break;
            }
            case "btnCapeSize":{
                shipsListWindowController.setCollectionShipsList(CollectionFromReq(500.0 , 100.0, 40.0, 150000, 400000));
                shipsListWindowController.fillTableView();
                shipsListWindowController.setLableText("Capesize");
                ShowShipDialog();
                break;
            }
        }
    }


    @FXML
    void onMenuAction(ActionEvent event) {
        Object source = event.getSource();
        if(!(source instanceof MenuItem))
        {return;}
        MenuItem clicked = (MenuItem) source;
        switch (clicked.getId()){
            case "menuItemAdd":{
                ShowAddShipDialog();
                break;
            }
            case "menuItemTest":{
             ShowTestDialog();
                break;
            }
        }

    }
    private void showAdminDialog()
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
    private void ShowShipDialog()
    {
        if(stage1==null)
        {
            stage1=new Stage();
            stage1.setTitle("ShipList");
            stage1.setMinHeight(480);
            stage1.setMinWidth(640);
            stage1.setResizable(false);
            stage1.setScene(new Scene(root1));
            stage1.initModality(Modality.WINDOW_MODAL);
            stage1.initOwner(btnAccs.getScene().getWindow());

        }

        stage1.showAndWait();
    }
    private void ShowAddShipDialog()
    {
        if(stage2==null)
        {
            stage2=new Stage();
            stage2.setTitle("Add ship");
            stage2.setMinHeight(480);
            stage2.setMinWidth(640);
            stage2.setResizable(false);
            stage2.setScene(new Scene(root2));
            stage2.initModality(Modality.WINDOW_MODAL);
            stage2.initOwner(btnAccs.getScene().getWindow());

        }

        stage2.showAndWait();
    }
    private void ShowTestDialog(){
        if(stage3==null)
        {
            stage3=new Stage();
            stage3.setTitle("User list");
            stage3.setMinHeight(480);
            stage3.setMinWidth(640);
            stage3.setResizable(true);
            stage3.setScene(new Scene(root3));
            stage3.initModality(Modality.WINDOW_MODAL);
            stage3.initOwner(btnAccs.getScene().getWindow());

        }
        stage3.showAndWait();
    }
    private ObservableList<Ship> CollectionFromReq(Double length, Double width, Double draft, Integer minDWT, Integer maxDWT){
        ObservableList<Ship> collection = FXCollections.observableArrayList();
        for (Ship s:collectionShipsList.getCollection()) {
            if(s.getLength()<length && s.getWidth()<width && s.getMaxSeaguage()<draft && s.getEqpWeight()>minDWT && s.getEqpWeight()<maxDWT)
            {
                collection.add(s);
            }
        }
        return collection;
    }
}
