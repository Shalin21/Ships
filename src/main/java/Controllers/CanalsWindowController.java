package Controllers;

import Interface.Implementation.CollectionCanalList;
import Objects.Canal;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Created by admin on 11.08.17.
 */
public class CanalsWindowController {
    @FXML
    private TableView<Canal> tableViewCanals;

    @FXML
    private TableColumn<Canal, String> columnCanalName;

    @FXML
    private TableColumn<Canal, Double> columnCanalLength;

    @FXML
    private TableColumn<Canal, String> columnCanalSize;

    @FXML
    private TableColumn<Canal, String> columnCanalPass;
    private CollectionCanalList collectionCanalList = new CollectionCanalList();
    public void setData(){
        //Canal canal = new Canal("Морской путь Святого Лаврентия", 600.0, 225.5, 23.8, 8.2);
        //System.out.println(canal.toString());
        collectionCanalList.setCanalCollectionData();
        //collectionCanalList.printCollection();
        tableViewCanals.setItems(collectionCanalList.getCanalCollection());
    }
    public void initialize(){
        tableViewCanals.setEditable(false);
        columnCanalName.setCellValueFactory(new PropertyValueFactory<Canal, String>("canalName"));
        columnCanalLength.setCellValueFactory(new PropertyValueFactory<Canal, Double>("canalLength"));
        columnCanalSize.setCellValueFactory(new PropertyValueFactory<Canal, String>("canalSize"));
        columnCanalPass.setCellValueFactory(new PropertyValueFactory<Canal, String>("canalPass"));


    }

}
