package ie.gmit.sw.ds.service.facade.queues.result;

import ie.gmit.sw.ds.service.domain.DictionaryJob;
import ie.gmit.sw.ds.service.domain.WordEntity;

import java.util.concurrent.ConcurrentHashMap;

public class ResultsStorage {

    private static ResultsStorage instance;
    private static ConcurrentHashMap<Integer, DictionaryJob> lookupResults;

    private ResultsStorage() {
    }

    public static ResultsStorage getInstance() {
        if(instance == null){
            instance = new ResultsStorage();
            lookupResults = new ConcurrentHashMap<>();
        }
        return instance;
    }

    public void addJobResult(DictionaryJob job){
        lookupResults.put(job.getJobId(), job);
    }

    public WordEntity getJobResult(int jobId){
        DictionaryJob job = lookupResults.get(jobId);
        if(job == null){
            return new WordEntity("", "no job found with this id");
        }
        return job.getWord();
    }

    public int getResultsCount(){
        return lookupResults.size();
    }

}
