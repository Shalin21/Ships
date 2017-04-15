package com.ships.Controllers;

import com.ships.Interface.Implementation.CollectionEmployeeList;
import com.ships.Objects.Employee;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
        employeeList.setCollection(FXCollections.observableArrayList(session.createCriteria(Employee.class).list()));
        tableViewAcc.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        tableColumnCode.setCellValueFactory(new PropertyValueFactory<Employee, String>("login"));
        tableColumnEmail.setCellValueFactory(new PropertyValueFactory<Employee, String>("email"));
       tableColumnActive.setCellValueFactory(new PropertyValueFactory<Employee, Boolean>("active"));
//        tableColumnActive.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Employee,Boolean>,ObservableValue<Boolean>>()
//        {
//            //This callback tell the cell how to bind the data model 'Registered' property to
//            //the cell, itself.
//           // @Override
//            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Employee, Boolean> param)
//            {
//                //param = new SimpleBooleanProperty(param.getValue().getActive());
//                return param.getValue().activeProperty();
//            }
//        });
        //tableColumnActive.setCellFactory(CheckBoxTableCell.forTableColumn(tableColumnActive));
        tableColumnActive.setCellFactory(tableColumnActive -> new CheckBoxTableCell());
        tableColumnActive.setEditable(true);
        tableViewAcc.setEditable(true);
        tableViewAcc.setItems(employeeList.getCollection());

    }
    @FXML
    void onBtnAction(ActionEvent event) {

    }
}
