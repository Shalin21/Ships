package com.ships.Objects;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import javax.persistence.*;

/**
 * Created by admin on 21.04.17.
 */
@Entity
@Access(value = AccessType.PROPERTY)
public class Ship {
    private int ShipId;
    private SimpleStringProperty Name = new SimpleStringProperty();
    private SimpleStringProperty Type = new SimpleStringProperty();
    private SimpleIntegerProperty Year = new SimpleIntegerProperty();
    private SimpleDoubleProperty Length = new SimpleDoubleProperty();
    private SimpleDoubleProperty Width = new SimpleDoubleProperty();
    private SimpleIntegerProperty EqpWeight = new SimpleIntegerProperty();
    private SimpleDoubleProperty MaxSeaguage = new SimpleDoubleProperty();
    private SimpleIntegerProperty MaxCarrying = new SimpleIntegerProperty();
    private SimpleStringProperty Flag = new SimpleStringProperty();

    public Ship(){}
    public Ship(String name, String type, Integer year, Double length, Double width, Integer eqpWeight, Double maxSeaguage, Integer maxCarrying, String flag) {
        this.Name.set(name);
        this.Type.set(type);
        this.Year.set(year);
        this.Length.set(length);
        this.Width.set(width);
        this.EqpWeight.set(eqpWeight);
        this.MaxSeaguage.set(maxSeaguage);
        this.MaxCarrying.set(maxCarrying);
        this.Flag.set(flag);

    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getShipId() {
        return ShipId;
    }
    public void setShipId(int shipId) {
        ShipId = shipId;
    }


    public String getName() {
        return Name.get();
    }
    public SimpleStringProperty nameProperty() {
        return Name;
    }
    public void setName(String name) {
        this.Name.set(name);
    }


    public String getType() {
        return Type.get();
    }
    public SimpleStringProperty typeProperty() {
        return Type;
    }
    public void setType(String type) {
        this.Type.set(type);
    }


    public int getYear() {
        return Year.get();
    }
    public SimpleIntegerProperty yearProperty() {
        return Year;
    }
    public void setYear(int year) {
        this.Year.set(year);
    }


    public Double getLength() {
        return Length.get();
    }
    public SimpleDoubleProperty lengthProperty() {
        return Length;
    }
    public void setLength(Double length) {
        this.Length.set(length);
    }


    public Double getWidth() {
        return Width.get();
    }
    public SimpleDoubleProperty widthProperty() {
        return Width;
    }
    public void setWidth(Double width) {
        this.Width.set(width);
    }


    public int getEqpWeight() {
        return EqpWeight.get();
    }
    public SimpleIntegerProperty eqpWeightProperty() {
        return EqpWeight;
    }
    public void setEqpWeight(int eqpWeight) {
        this.EqpWeight.set(eqpWeight);
    }


    public Double getMaxSeaguage() {
        return MaxSeaguage.get();
    }
    public SimpleDoubleProperty maxSeaguageProperty() {
        return MaxSeaguage;
    }
    public void setMaxSeaguage(Double maxSeaguage) {
        this.MaxSeaguage.set(maxSeaguage);
    }


    public int getMaxCarrying() {
        return MaxCarrying.get();
    }
    public SimpleIntegerProperty maxCarryingProperty() {
        return MaxCarrying;
    }
    public void setMaxCarrying(int maxCarrying) {
        this.MaxCarrying.set(maxCarrying);
    }


    public String getFlag() {
        return Flag.get();
    }
    public SimpleStringProperty flagProperty() {
        return Flag;
    }
    public void setFlag(String flag) {
        this.Flag.set(flag);
    }

    @Override
    public String toString() {
        return "Ship{" +
                "ShipId=" + ShipId +
                ", Name=" + Name +
                ", Type=" + Type +
                ", Year=" + Year +
                ", Length=" + Length +
                ", Width=" + Width +
                ", EqpWeight=" + EqpWeight +
                ", MaxSeaguage=" + MaxSeaguage +
                ", MaxCarrying=" + MaxCarrying +
                ", Flag=" + Flag +
                '}';
    }
}
