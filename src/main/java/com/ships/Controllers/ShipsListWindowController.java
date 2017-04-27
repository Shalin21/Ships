package com.ships.Controllers;
import com.ships.Interface.Implementation.CollectionShipsList;
import com.ships.Objects.Employee;
import com.ships.Objects.Ship;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.util.Optional;

/**
 * Created by admin on 22.04.17.
 */
public class ShipsListWindowController {
    CollectionShipsList collectionShipsList = new CollectionShipsList();
    @FXML
    private Label labelType;
    public void setLableText(String text){labelType.setText(text);}
    @FXML
    private TableView<Ship> tableView;

    @FXML
    private TableColumn<Ship, String> tableColumnName;

    @FXML
    private TableColumn<Ship, String> tableColumnType;

    @FXML
    private TableColumn<Ship, Integer> tableColumnYear;

    @FXML
    private TableColumn<Ship, Double> tableColumnLength;

    @FXML
    private TableColumn<Ship, Double> tableColumnWidth;

    @FXML
    private TableColumn<Ship, Integer> tableColumnEquip;

    @FXML
    private TableColumn<Ship, Double> tableColumnDraft;

    @FXML
    private TableColumn<Ship, Integer> tableColumnCarry;

    @FXML
    private TableColumn<Ship, String> tableColumnFlag;

    @FXML
    private Button btnOK;

    @FXML
    private Button btnDelete;
    public void setBtnDeleteEnabled(){btnDelete.setVisible(true);}

    public void initialize(){
        btnDelete.setVisible(false);
        tableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        tableColumnName.setCellValueFactory(new PropertyValueFactory<Ship, String>("Name"));
        tableColumnType.setCellValueFactory(new PropertyValueFactory<Ship, String>("Type"));
        tableColumnYear.setCellValueFactory(new PropertyValueFactory<Ship, Integer>("Year"));
        tableColumnLength.setCellValueFactory(new PropertyValueFactory<Ship, Double>("Length"));
        tableColumnWidth.setCellValueFactory(new PropertyValueFactory<Ship, Double>("Width"));
        tableColumnEquip.setCellValueFactory(new PropertyValueFactory<Ship, Integer>("EqpWeight"));
        tableColumnDraft.setCellValueFactory(new PropertyValueFactory<Ship, Double>("MaxSeaguage"));
        tableColumnCarry.setCellValueFactory(new PropertyValueFactory<Ship, Integer>("MaxCarrying"));
        tableColumnFlag.setCellValueFactory(new PropertyValueFactory<Ship, String>("Flag"));

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
                Node source1 = (Node)event.getSource();
                Stage stage = (Stage)source1.getScene().getWindow();
                stage.hide();
                break;
            }
            case "btnDelete":{
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirm");
                alert.setHeaderText(null);
                alert.setContentText("Do you want to delete selected ship?");
                Optional<ButtonType> result = alert.showAndWait();
                if(result.get()==ButtonType.OK) {
                   // session.beginTransaction();
                   // session.delete((Ship)tableView.getSelectionModel().getSelectedItem());
                    collectionShipsList.delete((Ship)tableView.getSelectionModel().getSelectedItem());
                   // session.getTransaction().commit();
                }
                //session.close();
                break;
            }
        }
    }

    @FXML
    void tableViewClick(MouseEvent event) {

    }
    public void fillTableView(){
        tableView.setItems(collectionShipsList.getCollection());
    }
    public void setCollectionShipsList(ObservableList<Ship> list){collectionShipsList.setCollection(list);}
}
