package ie.gmit.sw.ds.service.facade.queues;

import ie.gmit.sw.ds.service.domain.DictionaryJob;
import ie.gmit.sw.ds.service.rmi.RMIThreadPool;

import javax.annotation.PostConstruct;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class InQueue {

    private static InQueue instance;

    private BlockingQueue<DictionaryJob> queue = new ArrayBlockingQueue(100);

    private InQueue() {

    }

    public static InQueue getInstance(){
        if (instance == null){
            instance = new InQueue();
        }
        return instance;
    }

    public void addJob(DictionaryJob job){
        try {
            queue.put(job);
            System.out.println(queue.size());
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public BlockingQueue<DictionaryJob> getQueue() {
        return queue;
    }
}
