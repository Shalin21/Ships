package com.ships.Controllers;

import com.ships.Interface.Implementation.CollectionEmployeeList;
import com.ships.Objects.Employee;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Window;
import javafx.util.Callback;
import org.hibernate.ReplicationMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Optional;

/**
 * Created by admin on 13.04.17.
 */
public class AdminWindowController {
    CollectionEmployeeList employeeList = new CollectionEmployeeList();
    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    public Session session = sessionFactory.openSession();
    @FXML
    private TableView<Employee> tableViewAcc;

    @FXML
    private TableColumn<Employee, String> tableColumnCode;

    @FXML
    private TableColumn<Employee, String > tableColumnEmail;

    @FXML
    private TableColumn<Employee, Boolean> tableColumnActive;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnOk;

    public void initialize(){

    }

    public void fillTableView() {

        employeeList.setCollection(FXCollections.observableArrayList(session.createCriteria(Employee.class).list()));
        tableViewAcc.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        tableColumnCode.setCellValueFactory(new PropertyValueFactory<Employee, String>("login"));
        tableColumnEmail.setCellValueFactory(new PropertyValueFactory<Employee, String>("email"));
        tableColumnActive.setCellValueFactory(new PropertyValueFactory<Employee, Boolean>("active"));
        tableColumnActive.setCellFactory(tableColumnActive -> new CheckBoxTableCell());
        tableColumnActive.setEditable(true);
        tableViewAcc.setEditable(true);
        tableViewAcc.setItems(employeeList.getCollection());

    }

    @FXML
    void onBtnAction(ActionEvent event) {

        Object source = event.getSource();
        if(!(source instanceof Button))
        {return;}

        Button clicked = (Button) source;

        Window parent = ((Node)event.getSource()).getScene().getWindow();

        switch (clicked.getId()){

            case "btnOk":{
                if(session.isOpen()!=true){
                    session=sessionFactory.openSession();
                }
                session = sessionFactory.openSession();
                session.beginTransaction();
                employeeList.printCollection();
                for (Employee j:employeeList.getCollection()) {
                    session.saveOrUpdate(j);
                    session.getTransaction().commit();
                }

               session.close();
            break;
            }
            case "btnDelete":{
                if(session.isOpen()!=true) {
                    session = sessionFactory.openSession();
                }
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirm");
                alert.setHeaderText(null);
                alert.setContentText("Do you want to delete selected user?");
                Optional<ButtonType> result = alert.showAndWait();
                if(result.get()==ButtonType.OK) {
                    session.beginTransaction();
                    session.delete((Employee) tableViewAcc.getSelectionModel().getSelectedItem());
                    employeeList.delete((Employee) tableViewAcc.getSelectionModel().getSelectedItem());
                    session.getTransaction().commit();
                }
               session.close();
                break;
            }
        }
    }
}
