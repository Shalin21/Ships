package Interface.Implementation;

import Objects.WordDiction;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Created by admin on 06.09.17.
 */
public class CollectionWordList {

    private ObservableList<WordDiction> dictionary = FXCollections.observableArrayList();


    public void add(WordDiction wordDiction){
        this.dictionary.add(wordDiction);
    }

    public void delete(WordDiction wordDiction){
        this.dictionary.remove(wordDiction);
    }
    public ObservableList<WordDiction> getCollection(){return this.dictionary;}
    public void setCollection(ObservableList<WordDiction> collection){this.dictionary=collection;}
    public void printCollection(){
        for (WordDiction w:dictionary
             ) {
            w.toString();
        }
    }

    public void fillTestData(){
        this.dictionary.add(new WordDiction("B/Landing", "Вес груза по грузовой накладной"));
        this.dictionary.add(new WordDiction("Port(p)", "Левый борт"));
        this.dictionary.add(new WordDiction("Starboard(s)", "Правый борт"));
        this.dictionary.add(new WordDiction("Dist", "Дистанция"));
        this.dictionary.add(new WordDiction("TRIM", "Крен судна. Положительный, когда у судна кормовой крен. Отрицательный, когда у судна носовой крен."));
        this.dictionary.add(new WordDiction("Gross", "Валовый тоннаж"));
    }


}
