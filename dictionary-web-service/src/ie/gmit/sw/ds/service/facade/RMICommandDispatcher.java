package ie.gmit.sw.ds.service.facade;

import ie.gmit.sw.ds.service.domain.DictionaryJob;
import ie.gmit.sw.ds.service.domain.WordEntity;
import ie.gmit.sw.ds.service.facade.queues.CommandQueue;
import ie.gmit.sw.ds.service.facade.queues.QueueType;
import ie.gmit.sw.ds.service.facade.queues.QueuesManager;

public class RMICommandDispatcher {

    private QueuesManager queuesManager = QueuesManager.getInstance();
    private DictionaryJob job;

    public RMICommandDispatcher(WordEntity word) {
        // wrap WordEntity with DictionaryJob

    }

    public String execute(QueueType type){

        CommandQueue commandQueue = queuesManager.getQueue(type);

        commandQueue.addJob(job);

        return job.getJobId();
    }

}
