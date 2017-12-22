package ie.gmit.sw.ds.service.facade.queues;

import ie.gmit.sw.ds.service.facade.queues.lookup.LookUpQueueCommand;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;


public class QueuesManager {

    private static QueuesManager instance;
    private static Map<QueueType , QueueCommandator> queues = new HashMap<>();

    // new Java 8 features from concurrent package to add thread safety with
    // thread sharing primitives and objects
    private final AtomicInteger jobId = new AtomicInteger(0);

    private QueuesManager() {

    }

    public static QueuesManager getInstance() {
        if(instance == null){
            instance = new QueuesManager();

            queues.put(QueueType.LOOK_UP_CMD, LookUpQueueCommand.getInstance());

        }
        return instance;
    }

    public QueueCommandator getQueue(QueueType type){
        return queues.get(type);
    }

    public int issueJobId() {
        jobId.getAndIncrement();
        return jobId.get();
    }
}
