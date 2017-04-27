package com.ships.Controllers;
import com.ships.Interface.Implementation.CollectionShipsList;
import com.ships.Objects.Ship;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Optional;

/**
 * Created by admin on 22.04.17.
 */
public class AddShipWindowController {
    CollectionShipsList collectionShipsList = new CollectionShipsList();

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnSave;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtType;

    @FXML
    private TextField txtYear;

    @FXML
    private TextField txtFlag;

    @FXML
    private TextField txtLength;

    @FXML
    private TextField txtWidth;

    @FXML
    private TextField txtDwt;

    @FXML
    private TextField txtCarry;

    @FXML
    private TextField txtDraft;

    @FXML
    private Button btnAdd;

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

    public void initialize(){
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
        tableView.setItems(collectionShipsList.getCollection());
    }

    @FXML
    void onBtnAction(ActionEvent event) {

        Object source = event.getSource();
        if(!(source instanceof Button))
        {return;}

        Button clicked = (Button) source;

        Window parent = ((Node)event.getSource()).getScene().getWindow();

        switch (clicked.getId()){

            case "btnSave":{
                if(collectionShipsList.getCollection().size()>=1) {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Confirm");
                    alert.setHeaderText(null);
                    alert.setContentText("Do you want to save listed ships?");
                    Optional<ButtonType> result = alert.showAndWait();
                    if(result.get()==ButtonType.OK) {
                        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
                        Session session = sessionFactory.openSession();
                         session.beginTransaction();
                        for (Ship s:collectionShipsList.getCollection()) {
                            session.save(s);
                        }
                        session.getTransaction().commit();
                        session.close();
                        clearAll();
                        Node source1 = (Node)event.getSource();
                        Stage stage = (Stage)source1.getScene().getWindow();
                        stage.hide();
                    }

                }

                break;
            }
            case "btnCancel":{
                clearAll();
                Node source1 = (Node)event.getSource();
                Stage stage = (Stage)source1.getScene().getWindow();
                stage.hide();
                break;
            }
            case "btnAdd":{
                if(inputCheck()==true){
                    boolean flag=false;
                    Ship ship = new Ship();
                    ship.setName(txtName.getText());
                    ship.setType(txtType.getText());
                    ship.setYear(Integer.parseInt(txtYear.getText()));
                    ship.setFlag(txtFlag.getText());
                    ship.setLength(Double.parseDouble(txtLength.getText()));
                    ship.setWidth(Double.parseDouble(txtWidth.getText()));
                    ship.setEqpWeight(Integer.parseInt(txtDwt.getText()));
                    ship.setMaxCarrying(Integer.parseInt(txtCarry.getText()));
                    ship.setMaxSeaguage(Double.parseDouble(txtDraft.getText()));
                    for (Ship s:collectionShipsList.getCollection()) {
                        if(s.getName().equals(ship.getName()))
                        {
                            flag=true;
                            break;
                        }
                    }
                    if(flag==false) {
                        collectionShipsList.add(ship);
                    }
                    else
                    {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Wrong input");
                        alert.setHeaderText("");
                        alert.setContentText("Судно уже в списке");
                        alert.showAndWait();
                    }
                }
                break;
            }
        }
    }
    private void clearAll(){
        txtCarry.setText("");
        txtDwt.setText("");
        txtDraft.setText("");
        txtType.setText("");
        txtWidth.setText("");
        txtFlag.setText("");
        txtLength.setText("");
        txtName.setText("");
        txtYear.setText("");
        collectionShipsList= new CollectionShipsList();
        tableView.setItems(collectionShipsList.getCollection());

    }
    private boolean inputCheck(){

        if(Integer.parseInt(txtYear.getText())<1950 || Integer.parseInt(txtYear.getText())>2050 || txtYear.getText().length()<=0)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Wrong input");
            alert.setHeaderText("");
            alert.setContentText("Год не может быть меньше 1950 и больше 2050");
            alert.showAndWait();
            return false;
        }
       else if(Double.parseDouble(txtLength.getText())<=0 || Double.parseDouble(txtLength.getText())>1000.0 || txtLength.getText().length()<=0)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Wrong input");
            alert.setHeaderText("");
            alert.setContentText("Длинна не может быть отрицательной и не может привышать 1 000");
            alert.showAndWait();
            return false;
        }
      else  if(Double.parseDouble(txtWidth.getText())<=0 || Double.parseDouble(txtWidth.getText())>300.0 || txtWidth.getText().length()<=0)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Wrong input");
            alert.setHeaderText("");
            alert.setContentText("Ширина не может быть отрицательной и не может привышать 300");
            alert.showAndWait();
            return false;
        }
       else if(Integer.parseInt(txtDwt.getText())<=0 || Integer.parseInt(txtDwt.getText())>1000000 || txtDwt.getText().length()<=0)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Wrong input");
            alert.setHeaderText("");
            alert.setContentText("Дедвейт не может быть отрицательной и не может привышать 1 000 000");
            alert.showAndWait();
            return false;
        }
      else  if(Integer.parseInt(txtCarry.getText())<=0 || Integer.parseInt(txtCarry.getText())>1000000  || txtCarry.getText().length()<=0)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Wrong input");
            alert.setHeaderText("");
            alert.setContentText("Грузоподьемность не может быть отрицательной и не может привышать 1 000 000" + '\''+"а так же превышать дедвейт либо быть равной ему");
            alert.showAndWait();
            return false;
        }
        else if(Double.parseDouble(txtDraft.getText())<=0 || Double.parseDouble(txtDraft.getText())>100.0 || txtDraft.getText().length()<=0)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Wrong input");
            alert.setHeaderText("");
            alert.setContentText("Осадка не может быть отрицательной и не может привышать 100");
            alert.showAndWait();
            return false;
        }
        else if(txtName.getText().length()<=0)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Wrong input");
            alert.setHeaderText("");
            alert.setContentText("Введи имя судна");
            alert.showAndWait();
            return false;
        }
        else if(txtFlag.getText().length()<=0)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Wrong input");
            alert.setHeaderText("");
            alert.setContentText("Введите флаг судна");
            alert.showAndWait();
          return false;
        }
        else if(txtType.getText().length()<=0)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Wrong input");
            alert.setHeaderText("");
            alert.setContentText("Введите тип судна");
            alert.showAndWait();
            return false;
        }
            return true;

    }
    @FXML
    void tableViewClick(MouseEvent event) {

    }
}
