package ie.gmit.sw.ds.service.domain;

import ie.gmit.sw.ds.service.facade.commands.RMICommandTypes;
import ie.gmit.sw.ds.service.rmi.WordEntity;

import java.util.UUID;

public class DictionaryJob {

    private String jobId;
    private WordEntity word;
    private RMICommandTypes jobType;

    public DictionaryJob(String word) {
        this.word = new WordEntity();
        this.word.setWord(word);
        this.jobId = UUID.randomUUID().toString();
    }

    public DictionaryJob(String word, String description) {
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

    public RMICommandTypes getJobType() {
        return jobType;
    }

    public void setJobType(RMICommandTypes jobType) {
        this.jobType = jobType;
    }

}
