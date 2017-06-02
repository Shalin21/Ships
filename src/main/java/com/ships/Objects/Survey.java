package com.ships.Objects;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by admin on 02.06.17.
 */
public class Survey {

    private SimpleStringProperty Sounding;
    private SimpleDoubleProperty Volume;
    private SimpleDoubleProperty Density;
    private  SimpleDoubleProperty Tonnes;

    public Survey(String sounding, Double volume, Double density) {
       this.Sounding = new SimpleStringProperty(sounding);
       this.Volume = new SimpleDoubleProperty(volume);
       this.Density = new SimpleDoubleProperty(density);
       this.Tonnes = new SimpleDoubleProperty(volume*density);
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

    public double getVolume() {
        return Volume.get();
    }

    public SimpleDoubleProperty volumeProperty() {
        return Volume;
    }

    public void setVolume(double volume) {
        this.Volume.set(volume);
    }

    public double getDensity() {
        return Density.get();
    }

    public SimpleDoubleProperty densityProperty() {
        return Density;
    }

    public void setDensity(double density) {
        this.Density.set(density);
    }

    public double getTonnes() {
        return Tonnes.get();
    }

    public SimpleDoubleProperty tonnesProperty() {
        return Tonnes;
    }

    public void setTonnes(double tonnes) {
        this.Tonnes = new SimpleDoubleProperty(tonnes);
    }
}
