package ie.gmit.sw.ds.service.facade.queues.result;

import ie.gmit.sw.ds.service.domain.DictionaryJob;
import ie.gmit.sw.ds.service.domain.WordEntity;

import java.util.concurrent.ConcurrentHashMap;

public class LookUpResults {

    private static LookUpResults instance;
    private static ConcurrentHashMap<Integer, DictionaryJob> lookupResults;

    private LookUpResults() {
    }

    public static LookUpResults getInstance() {
        if(instance == null){
            instance = new LookUpResults();
            lookupResults = new ConcurrentHashMap<>();
        }
        return instance;
    }

    public void addJobResult(DictionaryJob job){
        lookupResults.put(job.getJobId(), job);
    }

    public WordEntity getJobResult(String jobId){
        DictionaryJob job = lookupResults.get(jobId);
        return job.getWord();
    }

    public int getResultsCount(){
        return lookupResults.size();
    }
}
