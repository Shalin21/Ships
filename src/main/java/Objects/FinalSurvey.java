package Objects;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.Date;

/**
 * Created by admin on 07.06.17.
 */
public class FinalSurvey {

    private String shipName = new String();
    private String portOfReg = new String();
    private String flag = new String();
    private  String owner = new String();
    private  String captain = new String();
    private  String cargoOff = new String ();
    private  String berth = new String ();
    private  String cargo = new String ();
    private  String arrived = new String ();
    private  String lastPort = new String();
    private  String nextPort = new String();
    private  String commenced = new String ();
    private  String DSWeight = new String ();
    private  String Build = new String ();
    private  String NRT = new String ();
    private  String GRT = new String ();
    private  String loa = new String ();
    private  String lbp = new String ();
    private  String breadth = new String ();
    private  String depth = new String ();
    private  String summerDisp = new String ();
    private  String summerDead = new String ();
    private  String lightShip = new String ();
    private  String completed = new String ();
    private  String dSurvey = new String ();
    private LocalDate date;


    public FinalSurvey(String shipName, String portOfReg, String flag, String owner, String captain, String cargoOff, String berth,  String cargo, String arrived, String lastPort, String nextPort, String commenced, String DSWeight, String build, String NRT, String GRT, String loa, String lbp, String breadth, String depth, String summerDisp, String summerDead, String lightShip, String completed, String dSurvey) {

        this.shipName = shipName;
        this.portOfReg = portOfReg;
        this.flag = flag;
        this.owner = owner;
        this.captain = captain;
        this.cargoOff = cargoOff;
        this.berth = berth;
        this.cargo = cargo;
        this.arrived = arrived;
        this.lastPort = lastPort;
        this.nextPort = nextPort;
        this.commenced = commenced;
        this.DSWeight = DSWeight;
        this.Build = build;
        this.NRT = NRT;
        this.GRT = GRT;
        this.loa = loa;
        this.lbp = lbp;
        this.breadth = breadth;
        this.depth = depth;
        this.summerDisp = summerDisp;
        this.summerDead = summerDead;
        this.lightShip = lightShip;
        this.completed = completed;
        this.dSurvey = dSurvey;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public FinalSurvey() {
        this.shipName = new String();
        this.portOfReg = new String();
        this.flag = new String();
        this.owner = new String();
        this.captain = new String();
        this.cargoOff = new String();
        this.berth = new String();
        this.cargo = new String();
        this.arrived = new String();
        this.lastPort = new String();
        this.nextPort = new String();
        this.commenced = new String();
        this.DSWeight = new String();
        this.Build = new String();
        this.NRT = new String();
        this.GRT = new String();
        this.loa = new String();
        this.lbp = new String();
        this.breadth = new String();
        this.depth = new String();
        this.summerDisp = new String();
        this.summerDead = new String();
        this.lightShip = new String();
        this.completed = new String();
        this.dSurvey = new String();


    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getPortOfReg() {
        return portOfReg;
    }

    public void setPortOfReg(String portOfReg) {
        this.portOfReg = portOfReg;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getCaptain() {
        return captain;
    }

    public void setCaptain(String captain) {
        this.captain = captain;
    }

    public String getCargoOff() {
        return cargoOff;
    }

    public void setCargoOff(String cargoOff) {
        this.cargoOff = cargoOff;
    }

    public String getBerth() {
        return berth;
    }

    public void setBerth(String berth) {
        this.berth = berth;
    }


    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getArrived() {
        return arrived;
    }

    public void setArrived(String arrived) {
        this.arrived = arrived;
    }

    public String getLastPort() {
        return lastPort;
    }

    public void setLastPort(String lastPort) {
        this.lastPort = lastPort;
    }

    public String getNextPort() {
        return nextPort;
    }

    public void setNextPort(String nextPort) {
        this.nextPort = nextPort;
    }

    public String getCommenced() {
        return commenced;
    }

    public void setCommenced(String commenced) {
        this.commenced = commenced;
    }

    public String getDSWeight() {
        return DSWeight;
    }

    public void setDSWeight(String DSWeight) {
        this.DSWeight = DSWeight;
    }

    public String getBuild() {
        return Build;
    }

    public void setBuild(String build) {
        Build = build;
    }

    public String getNRT() {
        return NRT;
    }

    public void setNRT(String NRT) {
        this.NRT = NRT;
    }

    public String getGRT() {
        return GRT;
    }

    public void setGRT(String GRT) {
        this.GRT = GRT;
    }

    public String getLoa() {
        return loa;
    }

    public void setLoa(String loa) {
        this.loa = loa;
    }

    public String getLbp() {
        return lbp;
    }

    public void setLbp(String lbp) {
        this.lbp = lbp;
    }

    public String getBreadth() {
        return breadth;
    }

    public void setBreadth(String breadth) {
        this.breadth = breadth;
    }

    public String getDepth() {
        return depth;
    }

    public void setDepth(String depth) {
        this.depth = depth;
    }

    public String getSummerDisp() {
        return summerDisp;
    }

    public void setSummerDisp(String summerDisp) {
        this.summerDisp = summerDisp;
    }

    public String getSummerDead() {
        return summerDead;
    }

    public void setSummerDead(String summerDead) {
        this.summerDead = summerDead;
    }

    public String getLightShip() {
        return lightShip;
    }

    public void setLightShip(String lightShip) {
        this.lightShip = lightShip;
    }

    public String getCompleted() {
        return completed;
    }

    public void setCompleted(String completed) {
        this.completed = completed;
    }

    public String getdSurvey() {
        return dSurvey;
    }

    public void setdSurvey(String dSurvey) {
        this.dSurvey = dSurvey;
    }

    @Override
    public String toString() {
        return "FinalSurvey{" +
                "shipName='" + shipName + '\'' +
                ", portOfReg='" + portOfReg + '\'' +
                ", flag='" + flag + '\'' +
                ", owner='" + owner + '\'' +
                ", captain='" + captain + '\'' +
                ", cargoOff='" + cargoOff + '\'' +
                ", berth='" + berth + '\'' +
                ", cargo='" + cargo + '\'' +
                ", arrived='" + arrived + '\'' +
                ", lastPort='" + lastPort + '\'' +
                ", nextPort='" + nextPort + '\'' +
                ", commenced='" + commenced + '\'' +
                ", DSWeight='" + DSWeight + '\'' +
                ", Build='" + Build + '\'' +
                ", NRT='" + NRT + '\'' +
                ", GRT='" + GRT + '\'' +
                ", loa='" + loa + '\'' +
                ", lbp='" + lbp + '\'' +
                ", breadth='" + breadth + '\'' +
                ", depth='" + depth + '\'' +
                ", summerDisp='" + summerDisp + '\'' +
                ", summerDead='" + summerDead + '\'' +
                ", lightShip='" + lightShip + '\'' +
                ", completed='" + completed + '\'' +
                ", dSurvey='" + dSurvey + '\'' +
                '}';
    }
}
