package ie.gmit.sw.ds.service.facade.queues;

import ie.gmit.sw.ds.service.facade.queues.creation.CreationQueue;
import ie.gmit.sw.ds.service.facade.queues.deletion.DeletionQueue;
import ie.gmit.sw.ds.service.facade.queues.lookup.LookUpQueue;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;


// Queue Manager issue an appropriate queue for requested command
// Used by RMICommandDispatcher
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

            queues.put(QueueType.LOOK_UP_CMD, LookUpQueue.getInstance());
            queues.put(QueueType.ADD_CMD, CreationQueue.getInstance());
            queues.put(QueueType.REMOVE_CMD, DeletionQueue.getInstance());

        }
        return instance;
    }

    // Method to return appropriate queue based on type enum
    public QueueCommandator getQueue(QueueType type){
        return queues.get(type);
    }

    // issue a job id. Note that jobId is atomic, i.e., all threads aware of new value
    public int issueJobId() {
        jobId.getAndIncrement();
        return jobId.get();
    }
}
