package ie.gmit.sw.ds.service.facade.queues.lookup;

import ie.gmit.sw.ds.service.domain.DictionaryJob;
import ie.gmit.sw.ds.service.facade.queues.QueueCommandator;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class LookUpQueueCommand implements QueueCommandator {

    private static LookUpQueueCommand instance;
    private BlockingQueue<DictionaryJob> queue = new ArrayBlockingQueue(100);


    private LookUpQueueCommand() {
    }

    public static LookUpQueueCommand getInstance() {
        if(instance == null){
            instance = new LookUpQueueCommand();
            // start listener once queue is created
            LookUpQueueListener listener = LookUpQueueListener.getInstance();
            listener.setDaemon(true);
            listener.start();
        }
        return instance;
    }

    @Override
    public void addJob(DictionaryJob job) {
        try {
            queue.put(job);
            System.out.println("LookUp Queue Size: " + queue.size());
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public DictionaryJob retrieveJob() throws InterruptedException{
        return queue.take();
    }


}
