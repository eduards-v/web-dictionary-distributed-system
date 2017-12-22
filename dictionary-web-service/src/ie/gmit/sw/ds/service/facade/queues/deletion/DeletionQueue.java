package ie.gmit.sw.ds.service.facade.queues.deletion;

import ie.gmit.sw.ds.service.domain.DictionaryJob;
import ie.gmit.sw.ds.service.facade.queues.QueueCommandator;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class DeletionQueue implements QueueCommandator{

    private static DeletionQueue instance;
    private BlockingQueue<DictionaryJob> queue = new ArrayBlockingQueue(100);

    private DeletionQueue(){

    }

    public static DeletionQueue getInstance() {
        if(instance == null){
            instance = new DeletionQueue();
            DeletionQueueListener listener = DeletionQueueListener.getInstance();
            listener.setDaemon(true);
            listener.start();
        }
        return instance;
    }

    @Override
    public void addJob(DictionaryJob job) {
        try {
            queue.put(job);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public DictionaryJob retrieveJob() throws InterruptedException {
        return queue.take();
    }
}
