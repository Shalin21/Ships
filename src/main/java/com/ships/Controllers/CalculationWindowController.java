package com.ships.Controllers;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

/**
 * Created by admin on 25.04.17.
 */
public class CalculationWindowController {

    @FXML
    private TabPane tabPane;

    @FXML
    private Tab tabMain;

    @FXML
    private Tab tabImage;

    @FXML
    private ListView<String> listView;

    @FXML
    private Button btnFullView;

    @FXML
    private Button btnResetView;
    @FXML
    private Button btnLoadImage;
    @FXML
    private AnchorPane paneImageView;

    @FXML
    private ImageView imageView;
    private String IMAGE_URL= "https://img2.goodfon.ru/original/4288x2848/3/16/chas-pik-dzheki-chan-kris-taker-rush-hour.jpg";
    private DirectoryChooser directoryChooser = new DirectoryChooser();
    File dir;
    public void initialize(){
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
}
