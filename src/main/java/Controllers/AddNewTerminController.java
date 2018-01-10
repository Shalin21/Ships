package Controllers;

import Interface.Implementation.CollectionWordList;
import Objects.WordDiction;
import com.ships.Main;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.hibernate.Session;

/**
 * Created by admin on 07.09.17.
 */
public class AddNewTerminController {
    @FXML
    private TextField inputTermin;

    @FXML
    private TextArea inputTextArea;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnOk;

    private CollectionWordList collectionWordList=new CollectionWordList();
    public void setCollection(CollectionWordList collectionWordList){
        this.collectionWordList=collectionWordList;
    }

    public void initialize(){

        btnOk.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                WordDiction word = new WordDiction(inputTermin.getText(), inputTextArea.getText());
                collectionWordList.add(word);
                Session session = Main.sessionFactory.openSession();
                session.beginTransaction();
                session.save(word);
                session.getTransaction().commit();
                session.close();
                inputTermin.setText("");
                inputTextArea.setText("");
                Node source1 = (Node)event.getSource();
                Stage stage = (Stage)source1.getScene().getWindow();
                stage.hide();
            }
        });

        btnCancel.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                inputTermin.setText("");
                inputTextArea.setText("");
                Node source1 = (Node)event.getSource();
                Stage stage = (Stage)source1.getScene().getWindow();
                stage.hide();
            }
        });

    }



}
