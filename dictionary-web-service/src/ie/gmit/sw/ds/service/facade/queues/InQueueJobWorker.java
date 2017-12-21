package ie.gmit.sw.ds.service.facade.queues;

import ie.gmit.sw.ds.service.domain.DictionaryJob;

public class InQueueJobWorker implements Runnable {

    private DictionaryJob job;

    public InQueueJobWorker(DictionaryJob job) {
        this.job = job;
    }

    @Override
    public void run() {
        System.out.println(job.getWord() + " | " + job.getJobType());
        System.out.println(Thread.currentThread().getName());

        // Make an RMI call, get result and place it into
        // results concurrent hashmap.
    }
}
