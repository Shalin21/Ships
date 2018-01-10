package Objects;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by admin on 02.06.17.
 */
public class Sounding {
    private SimpleStringProperty Sounding = new SimpleStringProperty();
    private SimpleDoubleProperty Tonnes = new SimpleDoubleProperty();

    public Sounding(String sounding, Double tonnes) {
        this.Sounding =new SimpleStringProperty(sounding);
        this.Tonnes = new SimpleDoubleProperty(tonnes);
    }

    public Sounding() {
    }

    public String getSounding() {
        return Sounding.get();
    }

    public SimpleStringProperty soundingProperty() {
        return Sounding;
    }

    public void setSounding(String sounding) {
        this.Sounding.set(sounding);
    }

    public double getTonnes() {
        return Tonnes.get();
    }

    public SimpleDoubleProperty tonnesProperty() {
        return Tonnes;
    }

    public void setTonnes(double tonnes) {
        this.Tonnes.set(tonnes);
    }
}
