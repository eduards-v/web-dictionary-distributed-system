package ie.gmit.sw.ds.service.facade.queues.creation;

import ie.gmit.sw.ds.service.domain.DictionaryJob;
import ie.gmit.sw.ds.service.facade.queues.QueueCommandator;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class CreationQueue implements QueueCommandator {

    private static CreationQueue instance;
    private BlockingQueue<DictionaryJob> queue = new ArrayBlockingQueue(100);

    private CreationQueue() {
    }

    public static CreationQueue getInstance() {
        if(instance == null) instance = new CreationQueue();
        return instance;
    }

    @Override
    public void addJob(DictionaryJob job) {
        try {
            queue.put(job);
            System.out.println("Creation Queue Size: " + queue.size());
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public DictionaryJob retrieveJob() throws InterruptedException {
        // Takes an element from top of the queue, removes it, waits if element is
        // is not available.
        return queue.take();
    }
}
