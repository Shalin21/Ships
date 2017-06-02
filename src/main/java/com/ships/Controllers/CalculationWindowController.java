package com.ships.Controllers;
import com.ships.Objects.Ship;
//import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import com.ships.Objects.Sounding;
import com.ships.Objects.Survey;
import com.ships.Objects.Tank;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;
import javafx.util.converter.DoubleStringConverter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 25.04.17.
 */
public class CalculationWindowController {
    private Ship ship;
    private final ObservableList<Tank> data =
            FXCollections.observableArrayList(
                    new Tank("Tank 1", 0.0),
                    new Tank("Tank 2", 0.0));
    private final ObservableList<Tank> data1 =
            FXCollections.observableArrayList(
                    new Tank("Tank 1", 0.0),
                    new Tank("Tank 2", 0.0));

    private final ObservableList<Survey> dataInitSurv =
            FXCollections.observableArrayList(
                    new Survey("1", 1.0, 2.0),
                    new Survey("2", 0.0, 0.0));
    private final ObservableList<Survey> dataInitSurv1 =
            FXCollections.observableArrayList(
                    new Survey("1", 1.0, 2.0),
                    new Survey("2", 0.0, 0.0));
    private final ObservableList<Survey> dataFinSurv =
            FXCollections.observableArrayList(
                    new Survey("1", 1.0, 2.0),
                    new Survey("2", 0.0, 0.0));
    private final ObservableList<Survey> dataFinSurv1 =
            FXCollections.observableArrayList(
                    new Survey("1", 1.0, 2.0),
                    new Survey("2", 0.0, 0.0));

    private final ObservableList<Sounding> sounding =
            FXCollections.observableArrayList(
                    new Sounding("1", 0.0)
            );
    private final ObservableList<Sounding> sounding1 =
            FXCollections.observableArrayList(
                    new Sounding("1", 0.0)
            );
    private final ObservableList<Sounding> oil =
            FXCollections.observableArrayList(
                    new Sounding("Heavy", 0.0),
                    new Sounding("Diesel", 0.0),
                    new Sounding("Lub Oil", 0.0),
                    new Sounding("Slops", 0.0),
                    new Sounding("Fecal", 0.0)
            );
    private final ObservableList<Sounding> oil1 =
            FXCollections.observableArrayList(
                    new Sounding("Heavy", 0.0),
                    new Sounding("Diesel", 0.0),
                    new Sounding("Lub Oil", 0.0),
                    new Sounding("Slops", 0.0),
                    new Sounding("Fecal", 0.0)
            );
   @FXML
   private  Label labelOilinitTotal;
   @FXML
   private  Label labelOilFinTotal;
    @FXML
    private TableView<Tank> tableTanks;

    @FXML
    private TableColumn<Tank, String> tanksColumnTank;

    @FXML
    private TableColumn<Tank, Double> tanksColumnCopacity;
    @FXML
    private TableView<Survey> tableInitSurvey;

    @FXML
    private TableColumn<Survey, String> intSurvColumnSound;

    @FXML
    private TableColumn<Survey, Double> intSurvColumnVolume;

    @FXML
    private TableColumn<Survey, Double> intSurvColumnDensity;

    @FXML
    private TableColumn<Survey, Double> intSurvColumnTonnes;
    @FXML
    private TableView<Survey> tableFinSurvey;

    @FXML
    private TableColumn<Survey, String> finSurveyColumnSound;

    @FXML
    private TableColumn<Survey, Double> finSurveyColumnVolume;

    @FXML
    private TableColumn<Survey, Double> finSurveyColumnDensity;

    @FXML
    private TableColumn<Survey, Double> finSurveyColumnTonnes;
    @FXML
    private TableView<Tank> tableFWTanks;

    @FXML
    private TableColumn<Tank, String> FWTankColumnTank;

    @FXML
    private TableColumn<Tank, Double> FWTankColumnCopacity;
    @FXML
    private TableView<Sounding> tableFWInitSurvey;

    @FXML
    private TableColumn<Sounding, String > FWInitColumnSound;

    @FXML
    private TableColumn<Sounding, Double> FWInitColumnTonnes;

    @FXML
    private TableView<Sounding> tableFWFinSurvey;

    @FXML
    private TableColumn<Sounding, String> FWFinColumnSound;

    @FXML
    private TableColumn<Sounding, Double> FWFinColumnTonnes;
    @FXML
    private TableView<Sounding> OilTableInit;

    @FXML
    private TableColumn<Sounding, String > OilinitColumnName;

    @FXML
    private TableColumn<Sounding, Double> OilinitColumnTonnes;

    @FXML
    private TableView<Sounding> OilTableFin;

    @FXML
    private TableColumn<Sounding, String> OilFinColumnName;

    @FXML
    private TableColumn<Sounding, Double> OilFinColumnTonnes;
    @FXML
    private TabPane tabPane;

    @FXML
    private Tab tabImage;

    @FXML
    private ListView<String> listView;

    @FXML
    private Button btnLoadImage;

    @FXML
    private Button btnFullView;

    @FXML
    private Button btnResetView;

    @FXML
    private AnchorPane paneImageView;

    @FXML
    private ImageView imageView;
    @FXML
    private Label txtShipName;

    @FXML
    private Label txtShipType;

    @FXML
    private Label txtShipYear;

    @FXML
    private Label txtShipFlag;

    @FXML
    private Label txtShipLength;

    @FXML
    private Label txtShipWidth;

    @FXML
    private Label txtShipSeaguage;

    @FXML
    private Label txtShipEqp;

    @FXML
    private Label txtShipCarry;

    @FXML
    private Label txtShipDisplace;
    @FXML
    private TextField inputFileName;

    @FXML
    private TextField inputPortOfReg;

    @FXML
    private TextField inputOwner;

    @FXML
    private TextField inputCapt;

    @FXML
    private TextField inputBerth;

    @FXML
    private TextField inputCargo;

    @FXML
    private TextField inputCargoOfficer;

    @FXML
    private TextField inputArrived;

    @FXML
    private TextField inputCommenced;

    @FXML
    private TextField inputCompleted;

    @FXML
    private TextField inputGross;

    @FXML
    private TextField inputNett;

    @FXML
    private TextField inputLBP;

    @FXML
    private TextField inputDockDensity;
    @FXML
    private TextField inputDockDensity1;
    @FXML
    private TextField inputLastPort;

    @FXML
    private TextField inputNextPort;

    @FXML
    private TextField inputSurveyor;

    @FXML
    private TextField inputLanding;

    @FXML
    private TextField inputPort;

    @FXML
    private TextField inputFordP;

    @FXML
    private TextField inputFordS;

    @FXML
    private TextField inputMidP;

    @FXML
    private TextField inputMidS;

    @FXML
    private TextField inputAftP;

    @FXML
    private TextField inputAftS;

    @FXML
    private TextField inputDistFp;

    @FXML
    private TextField inputDistMid;

    @FXML
    private TextField inputDistAp;
    @FXML
    private TextField inputDistFp1;

    @FXML
    private TextField inputDistMid1;

    @FXML
    private TextField inputDistAp1;

    @FXML
    private TextField inputScaleDensity;

    @FXML
    private DatePicker datePick;

    @FXML
    private  Label labelPort;

    @FXML
    private Label labelPort1;
    @FXML
    private Label labelVessel;
    @FXML
    private Label labelVessel1;
    @FXML
    private Label labelLightShip1;
    @FXML
    private Label labelDate;
    @FXML
    private Label labelDate1;
    @FXML
    private  Label labelBL;
    @FXML
    private Label labelFromAP;

    @FXML
    private Label labelFromMP;

    @FXML
    private Label labelFromFP;

    @FXML
    private Label labelFromAP1;

    @FXML
    private Label labelFromMP1;

    @FXML
    private Label labelFromFP1;
    @FXML
    private Label labelDockDensAriv;
    @FXML
    private Label labelDockDensDep;
    @FXML
    private TextField inputFordP1;

    @FXML
    private TextField inputFordS1;

    @FXML
    private TextField inputMidP1;

    @FXML
    private TextField inputMidS1;

    @FXML
    private TextField inputAftP1;

    @FXML
    private TextField inputAftS1;

    @FXML
    private TextField inputDepLCF;

    @FXML
    private TextField inputArrivLCF;

    @FXML
    private TextField DraughtDepBelow;

    @FXML
    private TextField DisplaceDepBelow;

    @FXML
    private TextField TPCDepBelow;

    @FXML
    private TextField LCFDepBelow;

    @FXML
    private TextField MCTDepBelow;

    @FXML
    private TextField MCT2DepBelow;

    @FXML
    private TextField DraughtDepAbove;

    @FXML
    private TextField DisplaceDepAbove;

    @FXML
    private TextField TPCDepAbove;

    @FXML
    private TextField LCFDepAbove;

    @FXML
    private TextField MCTDepAbove;

    @FXML
    private TextField MCT2DepAbove;
    @FXML
    private TextField inputScaleDensity1;





    @FXML
    private Label labelSurvPortAft;

    @FXML
    private Label labelSurvPortMid;

    @FXML
    private Label labelSurvPortFord;

    @FXML
    private Label labelSurvBoardAft;

    @FXML
    private Label labelSurvBoardMid;



    @FXML
    private Label labelSurvBoardFord;

    @FXML
    private Label labelSurvPortAft1;

    @FXML
    private Label labelSurvPortMid1;

    @FXML
    private Label labelSurvPortFord1;

    @FXML
    private Label labelSurvBoardAft1;

    @FXML
    private Label labelSurvBoardMid1;

    @FXML
    private Label labelSurvBoardFord1;
    @FXML
    private Label labelMeanAft1;

    @FXML
    private Label labelMeanMid1;

    @FXML
    private Label labelMeanFord1;
    @FXML
    private Label labelMeanAft;

    @FXML
    private Label labelMeanMid;

    @FXML
    private Label labelMeanFord;
    @FXML
    private Label labelScaleDens;
    @FXML
    private Label labelScaleDens1;
    @FXML
    private Label labelSurveyer;
    @FXML
    private Label labelLBP;
    @FXML
    private  Label labelTanksTotal;
    @FXML
    private Label labelInitSurveyTotalTon;
    @FXML
    private Label labelInitSurveyTotalVol;
    @FXML
    private Label labelFinSurveyTotalTon;
    @FXML
    private Label labelFinSurveyTotalVol;
    @FXML
    private Label labelFreshWTankCop;
    @FXML
    private  Label labelFreshWInitTotal;
    @FXML
    private  Label labelFreshWFinTotal;

    private String IMAGE_URL= "https://img2.goodfon.ru/original/4288x2848/3/16/chas-pik-dzheki-chan-kris-taker-rush-hour.jpg";
    private DirectoryChooser directoryChooser = new DirectoryChooser();
    File dir;

    public void initialize(){


        initTables();

        //tableTanks.getItems().add(new Tank("asd", 20.0));
        DirectoryChooser directoryChooser = new DirectoryChooser();
        Image image = new Image("file:/Users/admin/Pictures/cityscape-skyscrapers-7436.jpg");
        double width = image.getWidth();
        double height = image.getHeight();
        imageView.setImage(image);

        imageView.fitHeightProperty().bind(paneImageView.heightProperty());
        imageView.fitWidthProperty().bind(paneImageView.widthProperty());
        imageView.setPreserveRatio(false);
        reset(imageView, width / 2, height / 2);

        ObjectProperty<Point2D> mouseDown = new SimpleObjectProperty<>();

        imageView.setOnMousePressed(e -> {

            Point2D mousePress = imageViewToImage(imageView, new Point2D(e.getX(), e.getY()));
            mouseDown.set(mousePress);
        });
       btnResetView.setOnAction(event -> reset(imageView, width / 2, height / 2));
       btnFullView.setOnAction(event -> reset(imageView, width, height));
        imageView.setOnMouseDragged(e -> {
            Point2D dragPoint = imageViewToImage(imageView, new Point2D(e.getX(), e.getY()));
            shift(imageView, dragPoint.subtract(mouseDown.get()));
            mouseDown.set(imageViewToImage(imageView, new Point2D(e.getX(), e.getY())));
        });

        imageView.setOnScroll(e -> {
            double delta = e.getDeltaY();
            Rectangle2D viewport = imageView.getViewport();

            double scale = clamp(Math.pow(1.01, delta),

                    // don't scale so we're zoomed in to fewer than MIN_PIXELS in any direction:
                    Math.min(10 / viewport.getWidth(), 10 / viewport.getHeight()),

                    // don't scale so that we're bigger than image dimensions:
                    Math.max(width / viewport.getWidth(), height / viewport.getHeight())

            );

            Point2D mouse = imageViewToImage(imageView, new Point2D(e.getX(), e.getY()));

            double newWidth = viewport.getWidth() * scale;
            double newHeight = viewport.getHeight() * scale;

            // To keep the visual point under the mouse from moving, we need
            // (x - newViewportMinX) / (x - currentViewportMinX) = scale
            // where x is the mouse X coordinate in the image

            // solving this for newViewportMinX gives

            // newViewportMinX = x - (x - currentViewportMinX) * scale

            // we then clamp this value so the image never scrolls out
            // of the imageview:

            double newMinX = clamp(mouse.getX() - (mouse.getX() - viewport.getMinX()) * scale,
                    0, width - newWidth);
            double newMinY = clamp(mouse.getY() - (mouse.getY() - viewport.getMinY()) * scale,
                    0, height - newHeight);

            imageView.setViewport(new Rectangle2D(newMinX, newMinY, newWidth, newHeight));
        });

        imageView.setOnMouseClicked(e -> {
            if (e.getClickCount() == 2) {
                reset(imageView, width, height);
            }
        });

        //IMAGE VIEW CLICK EVENT
        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                File temp;
               // System.out.println(dir+"/"+listView.getSelectionModel().getSelectedItem());
                    //temp = new File(listView.getSelectionModel().getSelectedItem());
                Image image1 = new Image("file:"+dir+"/"+listView.getSelectionModel().getSelectedItem());
                    imageView.setImage(image1);

            }
        });

        //listView.getItems().add(IMAGE_URL);
        //listView.getItems().add("https://img1.goodfon.ru/original/3840x2160/4/be/cvetok-liliya-lepestki-fon.jpg");
       // btnCalc.setOnAction(event -> calculate());
    }

    public void initTables() {
        //TABLE TANKS
        tableTanks.setEditable(true);
        tanksColumnTank.setCellValueFactory(new PropertyValueFactory<Tank, String>("tankName"));
        tanksColumnCopacity.setCellValueFactory(new PropertyValueFactory<Tank, Double>("tankCopacity"));
        tanksColumnTank.setCellFactory(TextFieldTableCell.<Tank>forTableColumn());
        tanksColumnCopacity.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        tanksColumnCopacity.setEditable(true);
        tanksColumnTank.setEditable(true);
        tableTanks.setItems(data);
        tanksColumnCopacity.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Tank, Double>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Tank, Double> event) {
                if(tableTanks.getSelectionModel().getFocusedIndex()==tableTanks.getItems().size()-1)
                {
                    data.add(new Tank("Tank "+(tableTanks.getItems().size()+1), 0.0));
                }
                tableTanks.getSelectionModel().getSelectedItem().setTankCopacity(event.getNewValue());
                Double sum=0.0;
                for (Tank t:tableTanks.getItems()) {
                    sum=sum+t.getTankCopacity();
                    labelTanksTotal.setText(Double.toString(sum));
                }
            }
        });
        tanksColumnTank.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Tank, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Tank, String> event) {
                if(tableTanks.getSelectionModel().getFocusedIndex()==tableTanks.getItems().size()-1)
                {
                    data.add(new Tank("Tank "+(tableTanks.getItems().size()+1), 0.0));
                }
                tableTanks.getSelectionModel().getSelectedItem().setTankName(event.getNewValue());
            }
        });

        //TABLE ININT SURVEY
        tableInitSurvey.setEditable(true);

        intSurvColumnSound.setCellValueFactory(new PropertyValueFactory<Survey, String>("Sounding"));
        intSurvColumnDensity.setCellValueFactory(new PropertyValueFactory<Survey, Double>("Density"));
        intSurvColumnTonnes.setCellValueFactory(new PropertyValueFactory<Survey, Double>("Tonnes"));
        intSurvColumnVolume.setCellValueFactory(new PropertyValueFactory<Survey, Double>("Volume"));
        intSurvColumnSound.setCellFactory(TextFieldTableCell.<Survey>forTableColumn());
       // intSurvColumnTonnes.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        intSurvColumnVolume.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        intSurvColumnDensity.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));

        intSurvColumnVolume.setEditable(true);
        intSurvColumnTonnes.setEditable(true);
        intSurvColumnDensity.setEditable(true);
        intSurvColumnSound.setEditable(true);

        tableInitSurvey.setItems(dataInitSurv);


        intSurvColumnDensity.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Survey, Double>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Survey, Double> event) {
                if(tableInitSurvey.getSelectionModel().getFocusedIndex()==tableInitSurvey.getItems().size()-1)
                {
                    dataInitSurv.add(new Survey(""+(tableInitSurvey.getItems().size()+1), 0.0, 0.0));
                }
                tableInitSurvey.getSelectionModel().getSelectedItem().setTonnes(event.getNewValue()*tableInitSurvey.getSelectionModel().getSelectedItem().getVolume());
                tableInitSurvey.getSelectionModel().getSelectedItem().setDensity(event.getNewValue());
                dataInitSurv1.setAll(dataInitSurv);
                dataInitSurv.removeAll();
                dataInitSurv.setAll(dataInitSurv1);
                Double sum=0.0;
                for (Survey t:tableInitSurvey.getItems()) {
                    sum=sum+t.getTonnes();
                    labelInitSurveyTotalTon.setText(Double.toString(sum));
                }
            }
        });
        intSurvColumnVolume.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Survey, Double>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Survey, Double> event) {
                if(tableInitSurvey.getSelectionModel().getFocusedIndex()==tableInitSurvey.getItems().size()-1)
                {
                    dataInitSurv.add(new Survey(""+(tableInitSurvey.getItems().size()+1), 0.0, 0.0));
                }
                tableInitSurvey.getSelectionModel().getSelectedItem().setTonnes(event.getNewValue()*tableInitSurvey.getSelectionModel().getSelectedItem().getDensity());
                tableInitSurvey.getSelectionModel().getSelectedItem().setVolume(event.getNewValue());
                dataInitSurv1.setAll(dataInitSurv);
                dataInitSurv.removeAll();
                dataInitSurv.setAll(dataInitSurv1);
                Double sum=0.0;
                Double sum1=0.0;
                for (Survey t:tableInitSurvey.getItems()) {
                    sum = sum + t.getTonnes();
                    sum1= sum1 + t.getVolume();
                    labelInitSurveyTotalTon.setText(Double.toString(sum));
                    labelInitSurveyTotalVol.setText(Double.toString(sum1));
                }
            }
        });

        intSurvColumnSound.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Survey, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Survey, String> event) {
                if(tableInitSurvey.getSelectionModel().getFocusedIndex()==tableInitSurvey.getItems().size()-1)
                {
                    dataInitSurv.add(new Survey(""+(tableInitSurvey.getItems().size()+1), 0.0, 0.0));
                }
                tableInitSurvey.getSelectionModel().getSelectedItem().setSounding(event.getNewValue());

            }
        });

        //TABLE FIN SURVEY
        tableFinSurvey.setEditable(true);

        finSurveyColumnSound.setCellValueFactory(new PropertyValueFactory<Survey, String>("Sounding"));
        finSurveyColumnDensity.setCellValueFactory(new PropertyValueFactory<Survey, Double>("Density"));
        finSurveyColumnTonnes.setCellValueFactory(new PropertyValueFactory<Survey, Double>("Tonnes"));
        finSurveyColumnVolume.setCellValueFactory(new PropertyValueFactory<Survey, Double>("Volume"));
        finSurveyColumnSound.setCellFactory(TextFieldTableCell.<Survey>forTableColumn());
        // intSurvColumnTonnes.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        finSurveyColumnVolume.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        finSurveyColumnDensity.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));

        finSurveyColumnVolume.setEditable(true);
        finSurveyColumnTonnes.setEditable(true);
        finSurveyColumnDensity.setEditable(true);
        finSurveyColumnSound.setEditable(true);

        tableFinSurvey.setItems(dataFinSurv);


        finSurveyColumnDensity.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Survey, Double>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Survey, Double> event) {
                if(tableFinSurvey.getSelectionModel().getFocusedIndex()==tableFinSurvey.getItems().size()-1)
                {
                    dataInitSurv.add(new Survey(""+(tableFinSurvey.getItems().size()+1), 0.0, 0.0));
                }
                tableFinSurvey.getSelectionModel().getSelectedItem().setTonnes(event.getNewValue()*tableFinSurvey.getSelectionModel().getSelectedItem().getVolume());
                tableFinSurvey.getSelectionModel().getSelectedItem().setDensity(event.getNewValue());
                dataFinSurv1.setAll(dataFinSurv);
                dataFinSurv.removeAll();
                dataFinSurv.setAll(dataFinSurv1);
                Double sum=0.0;
                for (Survey t:tableFinSurvey.getItems()) {
                    sum=sum+t.getTonnes();
                    labelFinSurveyTotalTon.setText(Double.toString(sum));
                }
            }
        });

       finSurveyColumnVolume.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Survey, Double>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Survey, Double> event) {
                if(tableFinSurvey.getSelectionModel().getFocusedIndex()==tableFinSurvey.getItems().size()-1)
                {
                    dataFinSurv.add(new Survey(""+(tableFinSurvey.getItems().size()+1), 0.0, 0.0));
                }
                tableFinSurvey.getSelectionModel().getSelectedItem().setTonnes(event.getNewValue()*tableFinSurvey.getSelectionModel().getSelectedItem().getDensity());
                tableFinSurvey.getSelectionModel().getSelectedItem().setVolume(event.getNewValue());
                dataFinSurv1.setAll(dataFinSurv);
                dataFinSurv.removeAll();
                dataFinSurv.setAll(dataFinSurv1);
                Double sum=0.0;
                Double sum1=0.0;
                for (Survey t:tableFinSurvey.getItems()) {
                    sum = sum + t.getTonnes();
                    sum1= sum1 + t.getVolume();
                    labelFinSurveyTotalTon.setText(Double.toString(sum));
                    labelFinSurveyTotalVol.setText(Double.toString(sum1));
                }
            }
        });

        finSurveyColumnSound.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Survey, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Survey, String> event) {
                if(tableFinSurvey.getSelectionModel().getFocusedIndex()==tableFinSurvey.getItems().size()-1)
                {
                    dataInitSurv.add(new Survey(""+(tableFinSurvey.getItems().size()+1), 0.0, 0.0));
                }
                tableFinSurvey.getSelectionModel().getSelectedItem().setSounding(event.getNewValue());

            }
        });
        //TABLE

        tableFWTanks.setEditable(true);
        FWTankColumnTank.setCellValueFactory(new PropertyValueFactory<Tank, String>("tankName"));
        FWTankColumnCopacity.setCellValueFactory(new PropertyValueFactory<Tank, Double>("tankCopacity"));
        FWTankColumnTank.setCellFactory(TextFieldTableCell.<Tank>forTableColumn());
        FWTankColumnCopacity.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        FWTankColumnCopacity.setEditable(true);
        FWTankColumnTank.setEditable(true);
        tableFWTanks.setItems(data1);
        FWTankColumnCopacity.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Tank, Double>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Tank, Double> event) {
                if(tableFWTanks.getSelectionModel().getFocusedIndex()==tableFWTanks.getItems().size()-1)
                {
                    data1.add(new Tank("Tank "+(tableFWTanks.getItems().size()+1), 0.0));
                }
                tableFWTanks.getSelectionModel().getSelectedItem().setTankCopacity(event.getNewValue());
                Double sum=0.0;
                for (Tank t:tableFWTanks.getItems()) {
                    sum=sum+t.getTankCopacity();
                    labelFreshWTankCop.setText(Double.toString(sum));
                }
            }
        });
        FWTankColumnTank.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Tank, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Tank, String> event) {
                if(tableFWTanks.getSelectionModel().getFocusedIndex()==tableFWTanks.getItems().size()-1)
                {
                    data1.add(new Tank("Tank "+(tableFWTanks.getItems().size()+1), 0.0));
                }
                tableFWTanks.getSelectionModel().getSelectedItem().setTankName(event.getNewValue());
            }
        });


        //TABLE FW INIT SURVEY
        tableFWInitSurvey.setEditable(true);
        FWInitColumnSound.setCellValueFactory(new PropertyValueFactory<Sounding, String>("Sounding"));
        FWInitColumnTonnes.setCellValueFactory(new PropertyValueFactory<Sounding, Double>("Tonnes"));
        FWInitColumnSound.setCellFactory(TextFieldTableCell.<Sounding>forTableColumn());
        FWInitColumnTonnes.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        FWInitColumnTonnes.setEditable(true);
        FWInitColumnSound.setEditable(true);
        tableFWInitSurvey.setItems(sounding);
        FWInitColumnTonnes.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Sounding, Double>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Sounding, Double> event) {
                if(tableFWInitSurvey.getSelectionModel().getFocusedIndex()==tableFWInitSurvey.getItems().size()-1)
                {
                    sounding.add(new Sounding(""+(tableFWInitSurvey.getItems().size()+1), 0.0));
                }
                tableFWInitSurvey.getSelectionModel().getSelectedItem().setTonnes(event.getNewValue());
                Double sum=0.0;
                for (Sounding t:tableFWInitSurvey.getItems()) {
                    sum=sum+t.getTonnes();
                    labelFreshWInitTotal.setText(Double.toString(sum));
                }
            }
        });
        FWInitColumnSound.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Sounding, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Sounding, String> event) {
                if(tableFWInitSurvey.getSelectionModel().getFocusedIndex()==tableFWInitSurvey.getItems().size()-1)
                {
                    sounding.add(new Sounding(""+(tableFWInitSurvey.getItems().size()+1), 0.0));
                }
                tableFWInitSurvey.getSelectionModel().getSelectedItem().setSounding(event.getNewValue());
            }
        });
        //TABLE FW INIT SURVEY
        tableFWFinSurvey.setEditable(true);
        FWFinColumnSound.setCellValueFactory(new PropertyValueFactory<Sounding, String>("Sounding"));
        FWFinColumnTonnes.setCellValueFactory(new PropertyValueFactory<Sounding, Double>("Tonnes"));
        FWFinColumnSound.setCellFactory(TextFieldTableCell.<Sounding>forTableColumn());
        FWFinColumnTonnes.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        FWFinColumnTonnes.setEditable(true);
        FWFinColumnSound.setEditable(true);
        tableFWFinSurvey.setItems(sounding1);
        FWFinColumnTonnes.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Sounding, Double>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Sounding, Double> event) {
                if(tableFWFinSurvey.getSelectionModel().getFocusedIndex()==tableFWFinSurvey.getItems().size()-1)
                {
                    sounding1.add(new Sounding(""+(tableFWFinSurvey.getItems().size()+1), 0.0));
                }
                tableFWFinSurvey.getSelectionModel().getSelectedItem().setTonnes(event.getNewValue());
                Double sum=0.0;
                for (Sounding t:tableFWFinSurvey.getItems()) {
                    sum=sum+t.getTonnes();
                    labelFreshWFinTotal.setText(Double.toString(sum));
                }
            }
        });
        FWFinColumnSound.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Sounding, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Sounding, String> event) {
                if(tableFWFinSurvey.getSelectionModel().getFocusedIndex()==tableFWFinSurvey.getItems().size()-1)
                {
                    sounding1.add(new Sounding(""+(tableFWFinSurvey.getItems().size()+1), 0.0));
                }
                tableFWFinSurvey.getSelectionModel().getSelectedItem().setSounding(event.getNewValue());
            }
        });


        //TABLE OILS
        OilTableInit.setEditable(true);
        OilinitColumnName.setCellValueFactory(new PropertyValueFactory<Sounding, String>("Sounding"));
        OilinitColumnTonnes.setCellValueFactory(new PropertyValueFactory<Sounding, Double>("Tonnes"));
        OilinitColumnName.setCellFactory(TextFieldTableCell.<Sounding>forTableColumn());
        OilinitColumnTonnes.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        OilinitColumnTonnes.setEditable(true);
        OilinitColumnName.setEditable(true);
        OilTableInit.setItems(oil);
        OilinitColumnTonnes.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Sounding, Double>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Sounding, Double> event) {

                OilTableInit.getSelectionModel().getSelectedItem().setTonnes(event.getNewValue());
                Double sum=0.0;
                for (Sounding t:OilTableInit.getItems()) {
                    sum=sum+t.getTonnes();
                    labelOilinitTotal.setText(Double.toString(sum));
                }
            }
        });
        OilinitColumnName.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Sounding, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Sounding, String> event) {

                OilTableInit.getSelectionModel().getSelectedItem().setSounding(event.getNewValue());
            }
        });

        OilTableFin.setEditable(true);
        OilFinColumnName.setCellValueFactory(new PropertyValueFactory<Sounding, String>("Sounding"));
        OilFinColumnTonnes.setCellValueFactory(new PropertyValueFactory<Sounding, Double>("Tonnes"));
        OilFinColumnName.setCellFactory(TextFieldTableCell.<Sounding>forTableColumn());
        OilFinColumnTonnes.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        OilFinColumnTonnes.setEditable(true);
        OilFinColumnName.setEditable(true);
        OilTableFin.setItems(oil1);
        OilFinColumnTonnes.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Sounding, Double>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Sounding, Double> event) {

                OilTableFin.getSelectionModel().getSelectedItem().setTonnes(event.getNewValue());
                Double sum=0.0;
                for (Sounding t:OilTableFin.getItems()) {
                    sum=sum+t.getTonnes();
                    labelOilFinTotal.setText(Double.toString(sum));
                }
            }
        });
        OilFinColumnName.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Sounding, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Sounding, String> event) {

                OilTableFin.getSelectionModel().getSelectedItem().setSounding(event.getNewValue());
            }
        });
    }

    // reset to the top left:
    private void reset(ImageView imageView, double width, double height) {
       // directoryChooser.showDialog(btnResetView.getScene().getWindow());
        imageView.setViewport(new Rectangle2D(0, 0, width, height));
    }

    // shift the viewport of the imageView by the specified delta, clamping so
    // the viewport does not move off the actual image:
    private void shift(ImageView imageView, Point2D delta) {
        Rectangle2D viewport = imageView.getViewport();

        double width = imageView.getImage().getWidth() ;
        double height = imageView.getImage().getHeight() ;

        double maxX = width - viewport.getWidth();
        double maxY = height - viewport.getHeight();

        double minX = clamp(viewport.getMinX() - delta.getX(), 0, maxX);
        double minY = clamp(viewport.getMinY() - delta.getY(), 0, maxY);

        imageView.setViewport(new Rectangle2D(minX, minY, viewport.getWidth(), viewport.getHeight()));
    }

    private double clamp(double value, double min, double max) {

        if (value < min)
            return min;
        if (value > max)
            return max;
        return value;
    }

    // convert mouse coordinates in the imageView to coordinates in the actual image:
    private Point2D imageViewToImage(ImageView imageView, Point2D imageViewCoordinates) {
        double xProportion = imageViewCoordinates.getX() / imageView.getBoundsInLocal().getWidth();
        double yProportion = imageViewCoordinates.getY() / imageView.getBoundsInLocal().getHeight();

        Rectangle2D viewport = imageView.getViewport();
        return new Point2D(
                viewport.getMinX() + xProportion * viewport.getWidth(),
                viewport.getMinY() + yProportion * viewport.getHeight());
    }
    // array of supported extensions (use a List if you prefer)
    static final String[] EXTENSIONS = new String[]{
            "gif", "png", "bmp", "jpg" // and other formats you need
    };
    static final FilenameFilter IMAGE_FILTER = new FilenameFilter() {

        @Override
        public boolean accept(final File dir, final String name) {
            for (final String ext : EXTENSIONS) {
                if (name.endsWith("." + ext)) {
                    return (true);
                }
            }
            return (false);
        }
    };
    private void fillImages(File dir){

        if (dir.isDirectory() && dir!=null) { // make sure it's a directory
            for (final File f : dir.listFiles(IMAGE_FILTER)) {
                BufferedImage img = null;

                try {
                    img = ImageIO.read(f);
                    listView.getItems().add(f.getName());
//                    // you probably want something more involved here
//                    // to display in your UI
//                    System.out.println("image: " + f.getName());
//                    System.out.println(" width : " + img.getWidth());
//                    System.out.println(" height: " + img.getHeight());
//                    System.out.println(" size  : " + f.length());
                } catch (final IOException e) {
                    // handle errors here
                }
            }
        }
    }
    @FXML
    void btnLoadClicked(MouseEvent event) {
        dir = directoryChooser.showDialog(((Node)event.getTarget()).getScene().getWindow());
        fillImages(dir);
    }

    public void setShip(Ship ship){this.ship=ship;
    txtShipCarry.setText(Integer.toString(this.ship.getMaxCarrying()) + " t");
    txtShipDisplace.setText(Integer.toString(this.ship.getMaxCarrying()+this.ship.getEqpWeight()) + " t");
    txtShipEqp.setText(Integer.toString(this.ship.getEqpWeight())+ " t");
    txtShipFlag.setText(this.ship.getFlag());
    txtShipName.setText(this.ship.getName());
    txtShipLength.setText(Double.toString(this.ship.getLength())+" m");
    txtShipWidth.setText(Double.toString(this.ship.getWidth())+" m");
    txtShipType.setText(this.ship.getType());
    txtShipYear.setText(Integer.toString(this.ship.getYear()));
    txtShipSeaguage.setText(Double.toString(this.ship.getMaxSeaguage())+ " m");

    //----------------------SURVEY--------------------------------------------
        labelVessel.setText(this.ship.getName());
        labelVessel1.setText(this.ship.getName());
        labelLightShip1.setText(Integer.toString(this.ship.getEqpWeight()) + " t");

        inputArrivLCF.setTooltip(new Tooltip("Insert A if Distance is from Aft Perp"));
        inputDepLCF.setTooltip(new Tooltip("Insert A if Distance is from Aft Perp"));
    //------------------------------------------------------------------------
        inputLBP.textProperty().addListener((observable, oldValue, newValue) -> {
            String formattedDouble = new DecimalFormat("#0.00").format(Double.parseDouble(newValue));
            labelLBP.setText(formattedDouble);
        });
        inputSurveyor.textProperty().addListener((observable, oldValue, newValue) -> {
            labelSurveyer.setText(newValue);
            Double sum=0.0;

            for (Tank t:tableTanks.getItems()) {
                sum=sum+t.getTankCopacity();
                labelTanksTotal.setText(Double.toString(sum));
            }
        });
        inputScaleDensity.textProperty().addListener((observable, oldValue, newValue) -> {
            String formattedDouble = new DecimalFormat("#0.0000").format(Double.parseDouble(newValue));
            labelScaleDens.setText(formattedDouble);
        });
        inputScaleDensity1.textProperty().addListener((observable, oldValue, newValue) -> {
            String formattedDouble = new DecimalFormat("#0.0000").format(Double.parseDouble(newValue));
            labelScaleDens1.setText(formattedDouble);
        });
        inputFordP.textProperty().addListener((observable, oldValue, newValue) -> {
            String formattedDouble = new DecimalFormat("#0.0000").format(Double.parseDouble(newValue));
            labelSurvPortFord.setText(formattedDouble);
        });
        inputMidP.textProperty().addListener((observable, oldValue, newValue) -> {
            String formattedDouble = new DecimalFormat("#0.0000").format(Double.parseDouble(newValue));
            labelSurvPortMid.setText(formattedDouble);
        });
        inputAftP.textProperty().addListener((observable, oldValue, newValue) -> {
            String formattedDouble = new DecimalFormat("#0.0000").format(Double.parseDouble(newValue));
            labelSurvPortAft.setText(formattedDouble);
        });
        inputFordP1.textProperty().addListener((observable, oldValue, newValue) -> {
            String formattedDouble = new DecimalFormat("#0.0000").format(Double.parseDouble(newValue));
            labelSurvPortFord1.setText(formattedDouble);
        });
        inputMidP1.textProperty().addListener((observable, oldValue, newValue) -> {
            String formattedDouble = new DecimalFormat("#0.0000").format(Double.parseDouble(newValue));
            labelSurvPortMid1.setText(formattedDouble);
        });
        inputAftP1.textProperty().addListener((observable, oldValue, newValue) -> {
            String formattedDouble = new DecimalFormat("#0.0000").format(Double.parseDouble(newValue));
            labelSurvPortAft1.setText(formattedDouble);
        });
        inputFordS.textProperty().addListener((observable, oldValue, newValue) -> {
            String formattedDouble = new DecimalFormat("#0.0000").format(Double.parseDouble(newValue));
            labelSurvBoardFord.setText(formattedDouble);
        });
        inputMidS.textProperty().addListener((observable, oldValue, newValue) -> {
            String formattedDouble = new DecimalFormat("#0.0000").format(Double.parseDouble(newValue));
            labelSurvBoardMid.setText(formattedDouble);
        });
        inputAftS.textProperty().addListener((observable, oldValue, newValue) -> {
            String formattedDouble = new DecimalFormat("#0.0000").format(Double.parseDouble(newValue));
            labelSurvBoardAft.setText(formattedDouble);
        });
        inputFordS1.textProperty().addListener((observable, oldValue, newValue) -> {
            String formattedDouble = new DecimalFormat("#0.0000").format(Double.parseDouble(newValue));
            labelSurvBoardFord1.setText(formattedDouble);
        });
        inputMidS1.textProperty().addListener((observable, oldValue, newValue) -> {
            String formattedDouble = new DecimalFormat("#0.0000").format(Double.parseDouble(newValue));
            labelSurvBoardMid1.setText(formattedDouble);
        });
        inputAftS1.textProperty().addListener((observable, oldValue, newValue) -> {
            String formattedDouble = new DecimalFormat("#0.0000").format(Double.parseDouble(newValue));
            labelSurvBoardAft1.setText(formattedDouble);
            draughtMean();
        });


        inputDockDensity.textProperty().addListener((observable, oldValue, newValue) -> {
            String formattedDouble = new DecimalFormat("#0.000").format(Double.parseDouble(newValue));
            labelDockDensAriv.setText(formattedDouble);
        });
        inputDockDensity1.textProperty().addListener((observable, oldValue, newValue) -> {
            String formattedDouble = new DecimalFormat("#0.000").format(Double.parseDouble(newValue));
            labelDockDensDep.setText(formattedDouble);
        });
        inputDistAp.textProperty().addListener((observable, oldValue, newValue) -> {
            String formattedDouble = new DecimalFormat("#0.000").format(Double.parseDouble(newValue));
            labelFromAP.setText(formattedDouble);
        });
        inputDistFp.textProperty().addListener((observable, oldValue, newValue) -> {
            String formattedDouble = new DecimalFormat("#0.000").format(Double.parseDouble(newValue));
            labelFromFP.setText(formattedDouble);
        });
        inputDistMid.textProperty().addListener((observable, oldValue, newValue) -> {
            String formattedDouble = new DecimalFormat("#0.000").format(Double.parseDouble(newValue));
            labelFromMP.setText(formattedDouble);
        });
        inputDistAp1.textProperty().addListener((observable, oldValue, newValue) -> {
            String formattedDouble = new DecimalFormat("#0.000").format(Double.parseDouble(newValue));
            labelFromAP1.setText(formattedDouble);
        });
        inputDistFp1.textProperty().addListener((observable, oldValue, newValue) -> {
            String formattedDouble = new DecimalFormat("#0.000").format(Double.parseDouble(newValue));
            labelFromFP1.setText(formattedDouble);
        });
        inputDistMid1.textProperty().addListener((observable, oldValue, newValue) -> {
            String formattedDouble = new DecimalFormat("#0.000").format(Double.parseDouble(newValue));
            labelFromMP1.setText(formattedDouble);
        });
        inputLanding.textProperty().addListener((observable, oldValue, newValue) -> {
            labelBL.setText(newValue);
        });
        datePick.valueProperty().addListener((observable, oldValue, newValue) -> {
            labelDate.setText(newValue.toString());
            labelDate1.setText(newValue.toString());
            draughtCor();
        });
    inputPort.textProperty().addListener((observable, oldValue, newValue) -> {
        labelPort.setText(newValue);
        labelPort1.setText(newValue);

    });



    }
    private void draughtMean(){

        String formattedDouble = new DecimalFormat("#0.0000").format(((Double.parseDouble(labelSurvBoardAft.getText().replace(',','.'))+Double.parseDouble(labelSurvPortAft.getText().replace(',','.')))/2));
        labelMeanAft.setText(formattedDouble);
        formattedDouble = new DecimalFormat("#0.0000").format(((Double.parseDouble(labelSurvBoardFord.getText().replace(',','.'))+Double.parseDouble(labelSurvPortFord.getText().replace(',','.')))/2));
        labelMeanFord.setText(formattedDouble);
        formattedDouble = new DecimalFormat("#0.0000").format(((Double.parseDouble(labelSurvBoardMid.getText().replace(',','.'))+Double.parseDouble(labelSurvPortMid.getText().replace(',','.')))/2));
        labelMeanMid.setText(formattedDouble);
        formattedDouble = new DecimalFormat("#0.0000").format(((Double.parseDouble(labelSurvBoardAft1.getText().replace(',','.'))+Double.parseDouble(labelSurvPortAft1.getText().replace(',','.')))/2));
        labelMeanAft1.setText(formattedDouble);
        formattedDouble = new DecimalFormat("#0.0000").format(((Double.parseDouble(labelSurvBoardFord1.getText().replace(',','.'))+Double.parseDouble(labelSurvPortFord1.getText().replace(',','.')))/2));
        labelMeanFord1.setText(formattedDouble);
        formattedDouble = new DecimalFormat("#0.0000").format(((Double.parseDouble(labelSurvBoardMid1.getText().replace(',','.'))+Double.parseDouble(labelSurvPortMid1.getText().replace(',','.')))/2));
        labelMeanMid1.setText(formattedDouble);
    }
    @FXML
    private Label labelCorrAft;
    @FXML
    private Label labelCorrAft1;
    @FXML
    private Label labelCorrFord;
    @FXML
    private Label labelCorrFord1;
    @FXML
    private Label labelCorrMid;
    @FXML
    private Label labelCorrMid1;
    private void draughtCor(){
        String formattedDouble;
        Double cornToPerp = new Double(0);
        //ARRIVE
        Double mean = Double.parseDouble(labelMeanAft.getText().replace(',','.'))-Double.parseDouble(labelMeanFord.getText().replace(',','.'));
        cornToPerp=(Double.parseDouble(labelFromAP.getText().replace(',','.'))*mean)/(Double.parseDouble(labelLBP.getText().replace(',','.'))-Double.parseDouble(labelFromAP.getText().replace(',','.'))+Double.parseDouble(labelFromFP.getText().replace(',','.')));
        formattedDouble = new DecimalFormat("#0.000").format(cornToPerp);
        labelCorrAft.setText(cornToPerp.toString());
        cornToPerp=(Double.parseDouble(labelFromMP.getText().replace(',','.'))*mean)/(Double.parseDouble(labelLBP.getText().replace(',','.'))-Double.parseDouble(labelFromAP.getText().replace(',','.'))+Double.parseDouble(labelFromFP.getText().replace(',','.')));
        formattedDouble = new DecimalFormat("#0.000").format(cornToPerp);
        labelCorrMid.setText(cornToPerp.toString());
        cornToPerp=(Double.parseDouble(labelFromFP.getText().replace(',','.'))*mean)/(Double.parseDouble(labelLBP.getText().replace(',','.'))-Double.parseDouble(labelFromAP.getText().replace(',','.'))+Double.parseDouble(labelFromFP.getText().replace(',','.')));
        formattedDouble = new DecimalFormat("#0.000").format(cornToPerp);
        labelCorrFord.setText(cornToPerp.toString());
        //DEPART
        mean=Double.parseDouble(labelMeanAft1.getText().replace(',','.'))-Double.parseDouble(labelMeanFord1.getText().replace(',','.'));
        cornToPerp=(Double.parseDouble(labelFromAP1.getText().replace(',','.'))*mean)/(Double.parseDouble(labelLBP.getText().replace(',','.'))-Double.parseDouble(labelFromAP1.getText().replace(',','.'))+Double.parseDouble(labelFromFP1.getText().replace(',','.')));
        formattedDouble = new DecimalFormat("#0.000").format(cornToPerp);
        labelCorrAft1.setText(cornToPerp.toString());
        cornToPerp=(Double.parseDouble(labelFromMP1.getText().replace(',','.'))*mean)/(Double.parseDouble(labelLBP.getText().replace(',','.'))-Double.parseDouble(labelFromAP1.getText().replace(',','.'))+Double.parseDouble(labelFromFP1.getText().replace(',','.')));
        formattedDouble = new DecimalFormat("#0.000").format(cornToPerp);
        labelCorrMid1.setText(cornToPerp.toString());
        cornToPerp=(Double.parseDouble(labelFromFP1.getText().replace(',','.'))*mean)/(Double.parseDouble(labelLBP.getText().replace(',','.'))-Double.parseDouble(labelFromAP1.getText().replace(',','.'))+Double.parseDouble(labelFromFP1.getText().replace(',','.')));
        formattedDouble = new DecimalFormat("#0.000").format(cornToPerp);
        labelCorrFord1.setText(cornToPerp.toString());
        calcDraught();

    }
    @FXML
    private Label labelDraughtAft;
    @FXML
    private Label labelDraughtAft1;
    @FXML
    private Label labelDraughtMid;
    @FXML
    private Label labelDraughtMid1;
    @FXML
    private Label labelDraughtFord;
    @FXML
    private Label labelDraughtFord1;
    @FXML
    private Label labelthreefourAr;
    @FXML
    private Label labelthreefourDe;
    @FXML
    private TextField inputCaorrMM;
    @FXML
    private TextField DraughtArrivBelow;

    @FXML
    private TextField DisplaceArrivBelow;

    @FXML
    private TextField TPCArrivBelow;



    @FXML
    private TextField MCTArrivBelow;

    @FXML
    private TextField MCT2ArrivBelow;

    @FXML
    private TextField DraughtArrivAbove;

    @FXML
    private TextField DisplaceArrivAbove;

    @FXML
    private TextField TPCArrivAbove;



    @FXML
    private TextField MCTArrivAbove;

    @FXML
    private TextField MCT2ArrivAbove;

    @FXML
    private Label labelTPC;
    @FXML
    private Label labelTPC1;

    @FXML
    private TextField LCFArrivAbove;
    @FXML
    private TextField LCFArrivBelow;
    @FXML
    private Label labelLcf;
    @FXML
    private Label labelLcf1;
    @FXML
    private Label labelMctMinus;
    @FXML
    private Label labelMctPlus;
    @FXML
    private Label labelMctMinus1;
    @FXML
    private Label labelMctPlus1;
    @FXML
    private Label labelTrim;
    @FXML
    private Label labelTrim1;
    @FXML
    private Label labelDisp;
    @FXML
    private Label labelDisp1;
    @FXML
    private Label labelTrimCorA;
    @FXML
    private Label labelTrimCorB;
    @FXML
    private Label labelTrimCorA1;
    @FXML
    private Label labelTrimCorB1;
    @FXML
    private Label labelCorDisp;
    @FXML
    private Label labelCorDisp1;
    @FXML
    private  Label labelDispDens;

    @FXML
    private  Label labelDispDens1;


    private void calcDraught(){
        String formattedDouble = new DecimalFormat("#0.0000").format((Double.parseDouble(labelMeanAft.getText().replace(',','.'))+Double.parseDouble(labelCorrAft.getText().replace(',','.'))));
        labelDraughtAft.setText(formattedDouble);
        formattedDouble = new DecimalFormat("#0.0000").format((Double.parseDouble(labelMeanMid.getText().replace(',','.'))+Double.parseDouble(labelCorrMid.getText().replace(',','.'))));
        labelDraughtMid.setText(formattedDouble);
        formattedDouble = new DecimalFormat("#0.0000").format((Double.parseDouble(labelMeanFord.getText().replace(',','.'))+Double.parseDouble(labelCorrFord.getText().replace(',','.'))));
        labelDraughtFord.setText(formattedDouble);

        formattedDouble = new DecimalFormat("#0.0000").format((Double.parseDouble(labelMeanAft1.getText().replace(',','.'))+Double.parseDouble(labelCorrAft1.getText().replace(',','.'))));
        labelDraughtAft1.setText(formattedDouble);
        formattedDouble = new DecimalFormat("#0.0000").format((Double.parseDouble(labelMeanMid1.getText().replace(',','.'))+Double.parseDouble(labelCorrMid1.getText().replace(',','.'))));
        labelDraughtMid1.setText(formattedDouble);
        formattedDouble = new DecimalFormat("#0.0000").format((Double.parseDouble(labelMeanFord1.getText().replace(',','.'))+Double.parseDouble(labelCorrFord1.getText().replace(',','.'))));
        labelDraughtFord1.setText(formattedDouble);

        Double threeFourMeanAr = new Double(0);
        Double threeFourMeanDep = new Double(0);

        threeFourMeanAr = ((Double.parseDouble(labelDraughtMid.getText().replace(',','.'))*6.0)+Double.parseDouble(labelDraughtAft.getText().replace(',','.'))+Double.parseDouble(labelDraughtFord.getText().replace(',','.')))/8.0;
        threeFourMeanDep = ((Double.parseDouble(labelDraughtMid1.getText().replace(',','.'))*6.0)+Double.parseDouble(labelDraughtAft1.getText().replace(',','.'))+Double.parseDouble(labelDraughtFord1.getText().replace(',','.')))/8.0;
        formattedDouble = new DecimalFormat("#0.0000").format(threeFourMeanAr);
        labelthreefourAr.setText(formattedDouble);
        formattedDouble = new DecimalFormat("#0.0000").format(threeFourMeanDep);
        labelthreefourDe.setText(formattedDouble);

        Double main34MeanAr=0.0;
        Double main34MeanDe=0.0;
        main34MeanAr=threeFourMeanAr-(Double.parseDouble(inputCaorrMM.getText())/1000.0);
        main34MeanDe=threeFourMeanDep-(Double.parseDouble(inputCaorrMM.getText())/1000.0);
        //System.out.println("Main34 AR: "+main34MeanAr.toString());
        //System.out.println("Main34 DE:" + main34MeanDe.toString());

        Double TPCAr=0.0;
        Double TPCDe=0.0;
        Double dTPCArriveBelow=Double.parseDouble(TPCArrivBelow.getText().replace(',','.'));
        //System.out.println(dTPCArriveBelow.toString());
        Double dTPCArriveAbove=Double.parseDouble(TPCArrivAbove.getText().replace(',','.'));
        //System.out.println(dTPCArriveAbove);
        Double dDraughtAbove=Double.parseDouble(DraughtArrivAbove.getText().replace(',','.'));
        //System.out.println(dDraughtAbove);
        Double dDraughtBelow=Double.parseDouble(DraughtArrivBelow.getText().replace(',','.'));
        //System.out.println(dDraughtBelow);
        TPCAr=(dTPCArriveAbove-dTPCArriveBelow)/(dDraughtAbove-dDraughtBelow)*(main34MeanAr-dDraughtBelow)/dTPCArriveBelow + dTPCArriveBelow;
        //System.out.println(TPCAr.toString());
        labelTPC.setText(TPCAr.toString());

        Double dTPCDepBelow=Double.parseDouble(TPCDepBelow.getText().replace(',','.'));
        Double dTPCDepAbove=Double.parseDouble(TPCDepAbove.getText().replace(',','.'));
        Double dDraughtDepAbove=Double.parseDouble(DraughtDepAbove.getText().replace(',','.'));
        Double dDraughtDepBelow=Double.parseDouble(DraughtDepBelow.getText().replace(',','.'));
        TPCDe=(dTPCDepAbove-dTPCDepBelow)/(dDraughtDepAbove-dDraughtBelow)*(main34MeanDe-dDraughtDepBelow)/dTPCDepBelow + dTPCDepBelow;
        labelTPC1.setText(TPCDe.toString());

        Double LFC=0.0;
        Double LFC1=0.0;
        Double LCFArBelow=Double.parseDouble(LCFArrivBelow.getText());
        Double LCFArAbove=Double.parseDouble(LCFArrivAbove.getText());
        Double LCFDBelow=Double.parseDouble(LCFDepBelow.getText());
        Double LCFDAbove=Double.parseDouble(LCFDepAbove.getText());

        Double LBP = Double.parseDouble(inputLBP.getText().replace(',','.'));
        System.out.println(inputArrivLCF.getText());
        System.out.println(inputDepLCF.getText());
        System.out.println(LBP.toString());
        if(inputArrivLCF.getText().toUpperCase().toCharArray()[0]=='A')
        {
            System.out.println("TRUE");
            LFC=(LBP/2.0)-((LCFArAbove-LCFArBelow)/(dDraughtAbove-dDraughtBelow)*(main34MeanAr-dDraughtBelow)+LCFArBelow);
        }
        else
        {
            LFC=((LCFArAbove-LCFArBelow)/(dDraughtAbove-dDraughtBelow)*(main34MeanAr-dDraughtBelow)+LCFArBelow);
        }

        if(inputDepLCF.getText().toUpperCase().toCharArray()[0]=='A')
        {
            System.out.println("TRUE");
            LFC1=(LBP/2.0)-((LCFDAbove-LCFDBelow)/(dDraughtDepAbove-dDraughtDepBelow)*(main34MeanDe-dDraughtDepBelow)+LCFDBelow);
        }
        else
        {
            LFC1=((LCFDAbove-LCFDBelow)/(dDraughtDepAbove-dDraughtDepBelow)*(main34MeanDe-dDraughtDepBelow)+LCFDBelow);
        }
        labelLcf.setText(LFC.toString());
        labelLcf1.setText(LFC1.toString());


        //MCT
        Double MCTPlusAr=0.0;
        Double MCTMinusAr=0.0;
        Double MCTPlusDe=0.0;
        Double MCTMinusDe=0.0;
        Double MctPlusBelow=Double.parseDouble(MCTArrivBelow.getText().replace(',','.'));
        Double MctPlusAbove=Double.parseDouble(MCTArrivAbove.getText().replace(',','.'));
        Double MctMinusBelow=Double.parseDouble(MCT2ArrivBelow.getText().replace(',','.'));
        Double MctMinusAbove=Double.parseDouble(MCT2ArrivAbove.getText().replace(',','.'));

        Double MctPlusBelow1=Double.parseDouble(MCTDepBelow.getText().replace(',','.'));
        Double MctPlusAbove1=Double.parseDouble(MCTDepAbove.getText().replace(',','.'));
        Double MctMinusBelow1=Double.parseDouble(MCT2DepBelow.getText().replace(',','.'));
        Double MctMinusAbove1=Double.parseDouble(MCT2DepAbove.getText().replace(',','.'));
        MCTPlusAr=(MctPlusAbove-MctPlusBelow)/(dDraughtAbove-dDraughtBelow)*(main34MeanAr-dDraughtBelow)+MctPlusBelow;
        MCTMinusAr=(MctMinusAbove-MctMinusBelow)/(dDraughtAbove-dDraughtBelow)*(main34MeanAr-dDraughtBelow)+MctMinusBelow;

        MCTPlusDe=(MctPlusAbove1-MctPlusBelow1)/(dDraughtDepAbove-dDraughtDepBelow)*(main34MeanDe-dDraughtDepBelow)+MctPlusBelow1;
        MCTMinusDe=(MctMinusAbove1-MctMinusBelow1)/(dDraughtDepAbove-dDraughtDepBelow)*(main34MeanDe-dDraughtDepBelow)+MctMinusBelow1;

        labelMctPlus.setText(MCTPlusAr.toString());
        labelMctMinus.setText(MCTMinusAr.toString());
        labelMctPlus1.setText(MCTPlusDe.toString());
        labelMctMinus1.setText(MCTMinusDe.toString());

        labelTrim.setText(Double.toString(Double.parseDouble(labelDraughtAft.getText().replace(',','.'))-Double.parseDouble(labelDraughtFord.getText().replace(',','.'))));
        labelTrim1.setText(Double.toString(Double.parseDouble(labelDraughtAft1.getText().replace(',','.'))-Double.parseDouble(labelDraughtFord1.getText().replace(',','.'))));


        //Disp @ 3/4mean

        Double DispAr=0.0;
        Double DispDe=0.0;
        Double dispBelow=Double.parseDouble(DisplaceArrivBelow.getText());
        Double dispAbove=Double.parseDouble(DisplaceArrivAbove.getText());
        Double dispBelow1=Double.parseDouble(DisplaceDepBelow.getText());
        Double dispAbove1=Double.parseDouble(DisplaceDepAbove.getText());

        DispAr=(dispAbove-dispBelow)/(dDraughtAbove-dDraughtBelow)*(main34MeanAr-dDraughtBelow)+dispBelow;
        DispDe=(dispAbove1-dispBelow1)/(dDraughtDepAbove-dDraughtDepBelow)*(main34MeanDe-dDraughtDepBelow)+dispBelow1;

        labelDisp.setText(DispAr.toString());
        labelDisp1.setText(DispDe.toString());


        //Trim Correction
        Double trimCorrA=0.0;
        Double trimCorrB=0.0;
        Double trimCorrA1=0.0;
        Double trimCorrB1=0.0;


        trimCorrA=(TPCAr*LFC*Double.parseDouble(labelTrim.getText().replace(',','.'))*100)/LBP;
        trimCorrB=((MCTPlusAr-MCTMinusAr)*50*Double.parseDouble(labelTrim.getText().replace(',','.'))*Double.parseDouble(labelTrim.getText().replace(',','.')))/LBP;

        trimCorrA1=(TPCDe*LFC1*Double.parseDouble(labelTrim1.getText().replace(',','.'))*100)/LBP;
        trimCorrB1=((MCTPlusDe-MCTMinusDe)*50*Double.parseDouble(labelTrim1.getText().replace(',','.'))*Double.parseDouble(labelTrim1.getText().replace(',','.')))/LBP;

        labelTrimCorA.setText(trimCorrA.toString());
        labelTrimCorB.setText(trimCorrB.toString());
        labelTrimCorA1.setText(trimCorrA1.toString());
        labelTrimCorB1.setText(trimCorrB1.toString());


        Double corDisp=DispAr+trimCorrA+trimCorrB;
        Double corDisp1=DispDe+trimCorrA1+trimCorrB1;

        labelCorDisp.setText(corDisp.toString());
        labelCorDisp1.setText(corDisp1.toString());


        Double dispDens=corDisp/Double.parseDouble(labelScaleDens.getText().replace(',','.'))*Double.parseDouble(labelDockDensAriv.getText().replace(',','.'));
        Double dispDens1=corDisp1/Double.parseDouble(labelScaleDens1.getText().replace(',','.'))*Double.parseDouble(labelDockDensDep.getText().replace(',','.'));

        labelDispDens.setText(dispDens.toString());
        labelDispDens1.setText(dispDens1.toString());



    }

    private void hydroStatic(){
    Double TCPArrive = new Double(0);
    Double TCPDepart = new Double(0);


    }

    private void calculate(){
//        Double DraftNose ;
//        Double DraftMid;
//        Double DraftBack;
//        Double DraftMedNose = null;
//        Double DraftMedMid = null;
//        Double DraftMedBack = null;
//        Double DraftMed;
//        if(txtDraftLF.getText().length()>0 && txtDraftRF.getText().length()>0)
//        {
//            DraftNose= (Double.parseDouble(txtDraftLF.getText())+Double.parseDouble(txtDraftRF.getText()))/2;
//            DraftMedNose=DraftNose+((ship.getWidth()+DraftNose)/2)*Math.tan(Math.toRadians(Integer.parseInt(txtAngle.getText())));
//            String formattedDouble = new DecimalFormat("#0.00000").format(DraftMedNose);
//           //labelDraftLeft.setText("Draft Nose:"+formattedDouble);
//        }
//        if(txtDraftLM.getText().length()>0 && txtDraftRM.getText().length()>0)
//        {
//            DraftMid= (Double.parseDouble(txtDraftLM.getText())+Double.parseDouble(txtDraftRM.getText()))/2;
//            DraftMedMid=DraftMid+((ship.getWidth()+DraftMid)/2)*Math.tan(Integer.parseInt(txtAngle.getText()));
//
//        }
//        if(txtDraftLB.getText().length()>0 && txtDraftRB.getText().length()>0)
//        {
//            DraftBack= (Double.parseDouble(txtDraftLB.getText())+Double.parseDouble(txtDraftRB.getText()))/2;
//            DraftMedBack=DraftBack+((ship.getWidth()+DraftBack)/2)*Math.tan(Integer.parseInt(txtAngle.getText()));
//        }
//        DraftMed=(DraftMedNose+DraftMedMid+DraftMedBack)/3;
//        String formattedDouble = new DecimalFormat("#0.00000").format(DraftMedNose);
//        labelDraftLeft.setText("Medium draft:"+formattedDouble);

    }
}
