package Interface.Implementation;

import Objects.Canal;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Created by admin on 11.08.17.
 */
public class CollectionCanalList {

    private ObservableList<Canal> canalCollection = FXCollections.observableArrayList();

    public void add(Canal canal){this.canalCollection.add(canal);}
    public void delete(Canal canal){this.canalCollection.remove(canal);}

    public ObservableList<Canal> getCanalCollection(){return this.canalCollection;}

    public void setCanalCollectionData(){

        this.canalCollection.add(new Canal("Беломорско-Балтийский канал", 227.0, 135.0, 14.3, 3.5));
        this.canalCollection.add(new Canal("Канал Рейн-Майн-Дунай", 171.0, 190.0, 11.45, 4.0));
        this.canalCollection.add(new Canal("Суэцкий канал", 193.3, 350.0, 45.0, 24.0));
        this.canalCollection.add(new Canal("Волго-Донской канал", 101.0, 140.0, 16.7, 3.5));
        this.canalCollection.add(new Canal("Кильский канал", 98.0, 310.0, 42.0, 14.0));
        this.canalCollection.add(new Canal("Хьюстонский судоходный канал", 80.0, 400.0, 161.0, 14.0));
        this.canalCollection.add(new Canal("Панамский канал", 77.0, 320.0, 33.53, 25.9));
        this.canalCollection.add(new Canal("Канал Дунай — Чёрное море ", 64.4, 138.0, 16.8, 5.5));
        this.canalCollection.add(new Canal("Манчестерский канал", 58.0, 170.68, 21.94, 8.78));
        this.canalCollection.add(new Canal("Уэллендский канал", 43.4, 225.5, 23.8, 8.2));
        this.canalCollection.add(new Canal("Морской путь Святого Лаврентия", 600.0, 225.5, 23.8, 8.2));

    }

    public void printCollection() {
        for (Canal c:this.canalCollection
             ) {
            System.out.println(c.toString());
        }
    }
}
