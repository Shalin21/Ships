package Objects;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by admin on 01.06.17.
 */
public class Tank {

    private SimpleStringProperty tankName;
    private SimpleDoubleProperty tankCopacity;

    public Tank(String tankName, Double tankCopacity) {
        this.tankName = new SimpleStringProperty(tankName);
        this.tankCopacity= new SimpleDoubleProperty(tankCopacity);
    }

    public String getTankName() {
        return tankName.get();
    }

    public SimpleStringProperty tankNameProperty() {
        return tankName;
    }

    public void setTankName(String tankName) {
        this.tankName.set(tankName);
    }

    public Double getTankCopacity() {
        return tankCopacity.get();
    }

    public SimpleDoubleProperty tankCopacityProperty() {
        return tankCopacity;
    }

    public void setTankCopacity(Double tankCopacity) {
        this.tankCopacity.set(tankCopacity);
    }
}
