package ie.gmit.sw.ds.service.facade.queues;

import ie.gmit.sw.ds.service.domain.DictionaryJob;

public interface CommandQueue {

    void addJob(DictionaryJob job);

    DictionaryJob retrieveJob() throws InterruptedException;

}