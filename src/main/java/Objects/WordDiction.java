package Objects;

import javafx.beans.property.SimpleStringProperty;
import javax.persistence.*;

/**
 * Created by admin on 06.09.17.
 */
@Entity
@Access(value = AccessType.PROPERTY)
public class WordDiction {

    private int id;

    private SimpleStringProperty word = new SimpleStringProperty();
    private SimpleStringProperty determination = new SimpleStringProperty();

    public WordDiction() {
    }

    public WordDiction(String word, String determination) {
        this.word.set(word);
        this.determination.set(determination);
    }

    @Override
    public String toString() {
        return "WordDiction{" +
                "id=" + id +
                ", word=" + word +
                ", determination=" + determination +
                '}';
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word.get();
    }
    public SimpleStringProperty wordProperty() {
        return word;
    }
    public void setWord(String word) {
        this.word.set(word);
    }

    public String getDetermination() {
        return determination.get();
    }
    public SimpleStringProperty determinationProperty() {
        return determination;
    }
    public void setDetermination(String determination) {
        this.determination.set(determination);
    }
}
