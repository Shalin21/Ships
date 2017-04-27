package com.ships.Interface.Implementation;

import com.ships.Interface.ShipsList;
import com.ships.Objects.Ship;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Created by admin on 21.04.17.
 */
public class CollectionShipsList implements ShipsList {

    private ObservableList<Ship> shipCollection = FXCollections.observableArrayList();

    @Override
    public void add(Ship ship) {
    this.shipCollection.add(ship);
    }

    @Override
    public void update(Ship ship) {

    }

    @Override
    public void delete(Ship ship) {
    this.shipCollection.remove(ship);
    }

    public ObservableList<Ship> getCollection(){return this.shipCollection;}
    public void setCollection(ObservableList<Ship> collection){this.shipCollection=collection;}

    public void printCollection(){
        for (Ship s:shipCollection
             ) {
            s.toString();
        }
    }

    public void fillTestData(){
        this.shipCollection.add(new Ship("Seabreeze", "General Cargo", 1996, 145.0, 24.0, 18468, 4.7, 11478, "Belize" ));
        this.shipCollection.add(new Ship("Riroil 4", "Tanker", 2002, 129.3, 16.5, 6620, 4.5, 4606, "Malta" ));
        this.shipCollection.add(new Ship("Sider Moon", "Cargo", 2015, 157.23, 27.0, 26355, 7.5, 15861, "Malta" ));
        this.shipCollection.add(new Ship("Tatry", "Bulk Cargo", 2013, 229.0, 32.0, 82138, 12.4, 43025, "Liberia" ));
        this.shipCollection.add(new Ship("Maran Gas", "LNG Tanker", 2005, 285.4, 43.44, 84659, 10.5, 97496, "Greece" ));
        this.shipCollection.add(new Ship("YM World", "Container Ship", 2015, 368.0, 51.0, 137825, 14.3, 146700, "Hong Kong" ));
        this.shipCollection.add(new Ship("Cosco Shiping", "Container Ship", 2016, 300.0, 48.25, 117366, 12.1, 93702, "Marshal" ));
        this.shipCollection.add(new Ship("Hurvest Time", "Bulk Cargo", 2015, 237.0, 32.0, 95000, 7.9, 51000, "Marshal" ));
        this.shipCollection.add(new Ship("Libra trader", "Tanker", 2010, 333.0, 60.0, 310339, 19.2, 160141, "Marshal" ));
        this.shipCollection.add(new Ship("Spruce 2", "Oil Tanker", 2008, 228.6, 32.7, 73747, 8.2, 42010, "Liberia" ));
        this.shipCollection.add(new Ship("Cosco Roterdam", "Cargo", 2002, 280.0, 39.8, 69224, 13.1, 65531, "UK" ));
        this.shipCollection.add(new Ship("Front Scilla", "Tanker", 2000, 330.0, 60.04, 302561, 11.0, 159756, "Marshal" ));
        this.shipCollection.add(new Ship("Libra Voyager", "Tanker", 2014, 333.0, 60.0, 319431, 21.2, 164411, "Bagamas" ));
        this.shipCollection.add(new Ship("Island Splendor", "Tanker", 2011, 330.0, 60.4, 296919, 19.7, 156651, "Hong Kong" ));
        this.shipCollection.add(new Ship("Turkon Egypt", "Container Ship", 2007, 221.8, 32.0, 38617, 10.5, 32968, "Turkey" ));
        this.shipCollection.add(new Ship("OOCL Istanbul", "Container Ship", 2008, 260.0, 32.0, 50550, 10.9, 40030, "Malta" ));
        this.shipCollection.add(new Ship("Wadi Sudr", "Bulc Carrier", 1994, 225.0, 32.24, 64214, 6.3, 37550, "Egypt" ));
        this.shipCollection.add(new Ship("Un Karadeniz", "Ro-Ro Cargo", 2008, 193.3, 26.0, 9481, 6.3, 29004, "Turkey" ));
        this.shipCollection.add(new Ship("Cardiff", "Container Ship", 2014, 270.9, 42.8, 80551, 12.3, 69809, "Liberia" ));
        this.shipCollection.add(new Ship("Gabdulla Tukay", "Oil Tanker", 2015, 139.9, 16.93, 7056, 4.5, 5254, "Russia" ));
        this.shipCollection.add(new Ship("Decent", "General Cargo", 1977, 114.0, 13.23, 3493, 3.8, 2457, "Togo" ));
        this.shipCollection.add(new Ship("SuperFast 1", "Ro-Ro Cargo", 2008, 198.99, 26.0, 8500, 5.6, 25757, "Greece" ));
        this.shipCollection.add(new Ship("Liberty", "Vehicles Carrier", 2006, 199.99, 32.29, 19628, 10.4, 61321, "USA" ));
        this.shipCollection.add(new Ship("MSC Floriana", "Container Ship", 1986, 187.26, 28.4, 31205, 6.7, 21648, "Panama" ));
        this.shipCollection.add(new Ship("Asiatic moon", "Container Ship", 2006, 148.53, 22.0, 12545, 6.1, 9978, "Singapore" ));
        this.shipCollection.add(new Ship("Estestar", "General Cargo", 2005, 132.6, 18.6, 10887, 4.3, 6945, "Panama" ));
        this.shipCollection.add(new Ship("Katherine", "Container Ship", 2013, 270.0, 42.0, 80295, 12.9, 71021, "Marshal" ));
        this.shipCollection.add(new Ship("Boyaca", "Cargo", 2014, 332.0, 60.04, 320840, 12.1, 167572, "Singapore" ));
        this.shipCollection.add(new Ship("Kokkari", "Oil Tanker", 2008, 330.0, 60.0, 297538, 13.5, 156902, "Bagamas" ));
        this.shipCollection.add(new Ship("Maersk Tukang", "Container Ship", 2008, 322.0, 43.3, 113478, 13.5, 94193, "Singapore" ));

    }
}
