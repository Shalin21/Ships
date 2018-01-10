package Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

import java.text.DecimalFormat;

/**
 * Created by admin on 14.06.17.
 */
public class RotateShipController {


    @FXML
    private Line lineWater;

    @FXML
    private ImageView shipRect;

    @FXML
    private Label labelDraught;

    @FXML
    private Label labelAngle;

    @FXML
    private Line lineWater1;

    @FXML
    private ImageView shipRect1;

    @FXML
    private Label labelDraught1;

    @FXML
    private Label labelAngle1;

    public void setStartPosition(Double height, Double widht){


        shipRect.setFitHeight(500);
        shipRect.setFitWidth(600);
        shipRect.setLayoutX(320-shipRect.getFitWidth()/2);
        shipRect.setLayoutY(lineWater.getLayoutY()-shipRect.getFitHeight()+0.27*shipRect.getFitHeight());
    }

    public void setDraught(Double draught, Double angle, Double angle2){
        String formattedDouble = new DecimalFormat("#0.0000").format(draught);

        shipRect.setLayoutY(lineWater.getLayoutY()-shipRect.getFitHeight()+0.27*shipRect.getFitHeight()+draught);
        Double sinAngle=0.0;
        sinAngle = angle/(shipRect.getFitWidth()/2);
        formattedDouble = new DecimalFormat("#0.000").format(Math.toDegrees((Math.asin(sinAngle))));
        labelAngle.setText("Angle:"+formattedDouble);
        shipRect.setRotate(-Math.toDegrees(Math.asin(sinAngle)));
        Double startDraught = (shipRect.getFitHeight()+shipRect.getLayoutY())-lineWater.getLayoutY();
        formattedDouble = new DecimalFormat("#0.000").format(draught);
        labelDraught.setText("Draught:"+formattedDouble);


        shipRect1.setLayoutY(lineWater1.getLayoutY()-shipRect1.getFitHeight()+0.27*shipRect1.getFitHeight()+draught);
        Double sinAngle1=0.0;
        sinAngle1 = angle2/(shipRect1.getFitWidth()/2);
        formattedDouble = new DecimalFormat("#0.000").format(Math.toDegrees((Math.asin(sinAngle1))));
        labelAngle1.setText("Angle:"+formattedDouble);
        shipRect1.setRotate(-Math.toDegrees(Math.asin(sinAngle1)));
        Double startDraught1 = (shipRect1.getFitHeight()+shipRect1.getLayoutY())-lineWater1.getLayoutY();
        formattedDouble = new DecimalFormat("#0.000").format(draught);
        labelDraught1.setText("Draught:"+draught.toString());

    }

}
