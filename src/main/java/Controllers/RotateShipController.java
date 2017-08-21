package Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

/**
 * Created by admin on 14.06.17.
 */
public class RotateShipController {


    @FXML
    private Line lineWater;

    @FXML
    private Rectangle shipRect;

    @FXML
    private Label labelDraught;

    @FXML
    private Label labelAngle;

    public void setDraught(Double draught, Double angle){
        shipRect.setLayoutY(shipRect.getLayoutY()+draught);
        Double sinAngle=0.0;
        sinAngle = angle/(shipRect.getWidth()/2);
        labelAngle.setText(Double.toString(Math.toDegrees((Math.asin(sinAngle)))));
        shipRect.setRotate(-Math.toDegrees(Math.asin(sinAngle)));
        Double startDraught = (shipRect.getHeight()+shipRect.getLayoutY())-lineWater.getLayoutY();
        labelDraught.setText("Draught:"+Double.toString(startDraught)+" med:"+draught.toString());

    }

}
