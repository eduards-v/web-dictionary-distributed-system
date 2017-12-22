package ie.gmit.sw.ds.service.facade.queues;

import ie.gmit.sw.ds.service.domain.DictionaryJob;

public interface QueueCommandator {

    void addJob(DictionaryJob job);

    DictionaryJob retrieveJob() throws InterruptedException;

}