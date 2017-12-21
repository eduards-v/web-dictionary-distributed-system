package ie.gmit.sw.ds.service.facade.queues;

import ie.gmit.sw.ds.service.facade.queues.lookup.LookUpQueue;

import java.util.HashMap;
import java.util.Map;


public class QueuesManager {

    private static QueuesManager instance;
    private static Map<QueueType , CommandQueue> queues = new HashMap<>();
    private volatile int jobId = 0;

    private QueuesManager() {

    }

    public static QueuesManager getInstance() {
        if(instance == null){
            instance = new QueuesManager();

            queues.put(QueueType.LOOK_UP_CMD, LookUpQueue.getInstance());

        }
        return instance;
    }

    public CommandQueue getQueue(QueueType type){
        return queues.get(type);
    }

    public int issueJobId() {
        jobId++;
        return jobId;
    }
}
