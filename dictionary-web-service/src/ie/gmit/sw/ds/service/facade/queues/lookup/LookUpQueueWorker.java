package ie.gmit.sw.ds.service.facade.queues.lookup;

import ie.gmit.sw.ds.service.domain.DictionaryJob;

public class LookUpQueueWorker implements Runnable {

    private DictionaryJob job;

    public LookUpQueueWorker(DictionaryJob job) {
        this.job = job;
    }

    @Override
    public void run() {
        System.out.println(job.getWord());
        System.out.println(Thread.currentThread().getName());

        // Make an RMI call, get result and place it into
        // results concurrent hashmap.
    }
}
