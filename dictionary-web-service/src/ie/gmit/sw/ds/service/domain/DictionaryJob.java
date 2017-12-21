package ie.gmit.sw.ds.service.domain;

import java.util.UUID;

public class DictionaryJob {

    private String jobId;
    private WordEntity word;

    public DictionaryJob(WordEntity word) {
        this.word = word;
        this.jobId = UUID.randomUUID().toString();
    }

    public String getJobId() {
        return jobId;
    }

    public String getWord(){
        return word.getWord();
    }

    public String getDescription(){
        return word.getDescription();
    }

}
