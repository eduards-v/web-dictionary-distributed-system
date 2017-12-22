package ie.gmit.sw.ds.service.facade.queues.modification;

import ie.gmit.sw.ds.service.domain.DictionaryJob;
import ie.gmit.sw.ds.service.facade.queues.QueueCommandator;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ModificationQueue implements QueueCommandator {

    private static ModificationQueue instance;
    private BlockingQueue<DictionaryJob> queue = new ArrayBlockingQueue(100);

    private ModificationQueue(){

    }

    public static ModificationQueue getInstance() {
        if(instance == null){
            instance = new ModificationQueue();
            ModificationQueueListener listener = ModificationQueueListener.getInstance();
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
