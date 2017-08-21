package Objects;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by admin on 11.08.17.
 */
public class Canal {

    private SimpleStringProperty canalName;
    private SimpleDoubleProperty canalLength;
    private SimpleDoubleProperty canalL;
    private SimpleDoubleProperty canalW;
    private SimpleDoubleProperty canalD;
    private SimpleStringProperty canalSize;
    private SimpleStringProperty canalPass;

    @Override
    public String toString() {
        return "Canal{" +
                "canalName=" + canalName +
                ", canalLength=" + canalLength +
                ", canalL=" + canalL +
                ", canalW=" + canalW +
                ", canalD=" + canalD +
                ", canalSize=" + canalSize +
                ", canalPass=" + canalPass +
                '}';
    }

    public Canal(String canalName, Double canalLength, Double canalL, Double canalW, Double canalD) {
        this.canalName.set(canalName);
        this.canalLength.set(canalLength);
        this.canalL.set(canalL);
        this.canalW.set(canalW);
        this.canalD.set(canalD);
        this.canalSize.set(Double.toString(this.getCanalL())+"x"+Double.toString(this.getCanalW())+"x"+Double.toString(this.getCanalD()));
    }

    public void checkShipSize(Double length, Double width, Double depth){

       if(length>=canalL.get() || width>=canalW.get() ||  depth>=canalD.get()){
           if(length>=canalL.get()){canalPass.setValue(canalPass.get()+"Судно не проходит по длинне \n");}
           if(width>=canalW.get()){canalPass.setValue(canalPass.get()+"Судно не проходит по ширине \n");}
           if(depth>=canalD.get()){canalPass.setValue(canalPass.get()+"Судно не проходит по глубине");}
       }
       else
           canalPass.set("Судно проходит");
    }

    public String getCanalName() {
        return canalName.get();
    }

    public SimpleStringProperty canalNameProperty() {
        return canalName;
    }

    public void setCanalName(String canalName) {
        this.canalName.set(canalName);
    }

    public double getCanalLength() {
        return canalLength.get();
    }

    public SimpleDoubleProperty canalLengthProperty() {
        return canalLength;
    }

    public void setCanalLength(double canalLength) {
        this.canalLength.set(canalLength);
    }

    public double getCanalL() {
        return canalL.get();
    }

    public SimpleDoubleProperty canalLProperty() {
        return canalL;
    }

    public void setCanalL(double canalL) {
        this.canalL.set(canalL);
    }

    public double getCanalW() {
        return canalW.get();
    }

    public SimpleDoubleProperty canalWProperty() {
        return canalW;
    }

    public void setCanalW(double canalW) {
        this.canalW.set(canalW);
    }

    public double getCanalD() {
        return canalD.get();
    }

    public SimpleDoubleProperty canalDProperty() {
        return canalD;
    }

    public void setCanalD(double canalD) {
        this.canalD.set(canalD);
    }

    public String getCanalPass() {
        return canalPass.get();
    }

    public SimpleStringProperty canalPassProperty() {
        return canalPass;
    }

    public void setCanalPass(String canalPass) {
        this.canalPass.set(canalPass);
    }
}
