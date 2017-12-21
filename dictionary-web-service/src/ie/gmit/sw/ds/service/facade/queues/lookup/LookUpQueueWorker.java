package ie.gmit.sw.ds.service.facade.queues.lookup;

import ie.gmit.sw.ds.service.domain.DictionaryJob;
import ie.gmit.sw.ds.service.facade.queues.result.LookUpResults;

import java.util.concurrent.atomic.AtomicReference;

public class LookUpQueueWorker implements Runnable {

    private DictionaryJob job;

    public LookUpQueueWorker(DictionaryJob job) {
        this.job = job;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());

        // Make an RMI call, get result and place it into
        // results concurrent hashmap.

        AtomicReference<LookUpResults> resultsMap = new AtomicReference<>(LookUpResults.getInstance());

        resultsMap.get().addJobResult(job);
    }
}
