package ie.gmit.sw.ds.service.domain;

public class DictionaryJob {

    private int jobId;
    private WordEntity word;

    public DictionaryJob(WordEntity word, int jobId) {
        this.word = word;
        this.jobId = jobId;
    }

    public int getJobId() {
        return jobId;
    }

    public WordEntity getWord() {
        return word;
    }
}
