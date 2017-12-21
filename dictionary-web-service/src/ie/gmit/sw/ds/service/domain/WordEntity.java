package ie.gmit.sw.ds.service.domain;

import java.io.Serializable;

public class WordEntity implements Serializable{

    private static final long serialVersionUID = 7777;
    private String word;
    private String description;

    public WordEntity() {
    }

    public WordEntity(String word) {
        this.word = word;
    }

    public WordEntity(String word, String description) {
        this.word = word;
        this.description = description;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "WordEntity{" +
                "word='" + word + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
