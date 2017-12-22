package ie.gmit.sw.ds.service.facade;

import ie.gmit.sw.ds.service.domain.DictionaryJob;
import ie.gmit.sw.ds.service.domain.WordEntity;
import ie.gmit.sw.ds.service.facade.queues.QueueCommandator;
import ie.gmit.sw.ds.service.facade.queues.QueueType;
import ie.gmit.sw.ds.service.facade.queues.QueuesManager;

public class RMICommandDispatcher {

    private QueuesManager queuesManager = QueuesManager.getInstance();
    private DictionaryJob job;

    public RMICommandDispatcher(WordEntity word) {
        // wrap WordEntity with DictionaryJob
        this.job = new DictionaryJob(word, queuesManager.issueJobId());
    }

    public int execute(QueueType type){

        QueueCommandator commandQueue = queuesManager.getQueue(type);

        commandQueue.addJob(job);

        return job.getJobId();
    }

}
