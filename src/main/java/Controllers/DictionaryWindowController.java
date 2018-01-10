package Controllers;

import Interface.Implementation.CollectionWordList;
import Objects.Employee;
import Objects.WordDiction;
import com.ships.Main;
import com.sun.org.apache.xpath.internal.operations.Bool;
import com.sun.prism.paint.Color;
import javafx.application.HostServices;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.hibernate.Session;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * Created by admin on 06.09.17.
 */
public class DictionaryWindowController {

    private Stage stage;
    private Parent root;
    private FXMLLoader loader = new FXMLLoader();
    private AddNewTerminController newTerminController;
    @FXML
    private TableView<WordDiction> tableViewCanals;

    @FXML
    private TableColumn<WordDiction, String > columnCanalName;

    @FXML
    private TableColumn<WordDiction, String > columnCanalLength;
    @FXML
    private Button btnAdd;

    @FXML
    private Button btnDelete;

    @FXML
    private Label labelManual;


    CollectionWordList collectionWordList = new CollectionWordList();



    public void enableBtn(Boolean bool){
        btnDelete.setDisable(bool);
    }

    public void initialize() {
        try {

            loader.setLocation(getClass().getResource("/Views/addNewTerminWindow.fxml"));
            root = loader.load();
            newTerminController = loader.getController();
        } catch (IOException e) {

        }

        labelManual.setOnMouseClicked(event -> {
            String dir = new File(getClass().getProtectionDomain().getCodeSource().getLocation().getPath()).getParent()+"/Manual.pdf";
            File f = new File(dir);
            if(f.exists() && !f.isDirectory()){
                Main.services.showDocument(dir);
            }
            else
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("");
                alert.setContentText("Manual.pdf должен быть в папке с приложением");
                alert.showAndWait();
            }

        });
        labelManual.setOnMouseEntered(event -> {labelManual.setCursor(Cursor.HAND);});


        btnAdd.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                newTerminController.setCollection(collectionWordList);
                showDialog();
            }
        });

        btnDelete.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("");
                alert.setHeaderText("");
                alert.setContentText("Вы действительно хотите удалить выбранный термин?");
                Optional<ButtonType> result = alert.showAndWait();
                WordDiction word  = tableViewCanals.getSelectionModel().getSelectedItem();
                if(result.get() == ButtonType.OK)
                {
                    collectionWordList.delete(word);
                    Session session = Main.sessionFactory.openSession();
                    session.beginTransaction();
                    session.delete(word);
                    session.getTransaction().commit();
                    session.close();
                }
            }
        });
        Session session = Main.sessionFactory.openSession();

        List<WordDiction> list = session.createCriteria(WordDiction.class).list();
        session.close();
        collectionWordList.setCollection(FXCollections.observableArrayList(list));
        // collectionWordList.fillTestData();

        tableViewCanals.setEditable(true);

        columnCanalLength.setCellFactory(param -> {
            TableCell<WordDiction, String> cell = new TableCell<>();
            Text text = new Text();
            text.setStyle("");
            cell.setGraphic(text);
            cell.setPrefHeight(Control.USE_COMPUTED_SIZE);
            //text.wrappingWidthProperty().bind(cell.widthProperty());
            text.textProperty().bind(cell.itemProperty());
            text.wrappingWidthProperty().bind(columnCanalLength.widthProperty());
            return cell;
        });

        columnCanalName.setCellFactory(TextFieldTableCell.<WordDiction>forTableColumn());
        columnCanalLength.setCellFactory(TextFieldTableCell.<WordDiction>forTableColumn());
        columnCanalLength.setCellValueFactory(new PropertyValueFactory<WordDiction, String>("determination"));
        columnCanalName.setCellValueFactory(new PropertyValueFactory<WordDiction, String>("word"));

        tableViewCanals.setItems(collectionWordList.getCollection());

        columnCanalName.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<WordDiction, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<WordDiction, String> event) {
                tableViewCanals.getSelectionModel().getSelectedItem().setWord(event.getNewValue());
                Session session = Main.sessionFactory.openSession();
                session.beginTransaction();
                session.update(tableViewCanals.getSelectionModel().getSelectedItem());
                session.getTransaction().commit();
                session.close();
            }
        });
        columnCanalLength.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<WordDiction, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<WordDiction, String> event) {
                tableViewCanals.getSelectionModel().getSelectedItem().setDetermination(event.getNewValue());
                Session session = Main.sessionFactory.openSession();
                session.beginTransaction();
                session.update(tableViewCanals.getSelectionModel().getSelectedItem());
                session.getTransaction().commit();
                session.close();
            }
        });
    }


    private void showDialog()
    {
        if(stage==null)
        {
            stage=new Stage();
            stage.setTitle("Add");
            stage.setHeight(230);
            stage.setWidth(400);
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(tableViewCanals.getScene().getWindow());

        }
        stage.showAndWait();
    }


}
