package ie.gmit.sw.ds.service.facade.queues.creation;

import ie.gmit.sw.ds.service.domain.DictionaryJob;
import ie.gmit.sw.ds.service.facade.queues.QueueCommandator;
import ie.gmit.sw.ds.service.facade.queues.QueueType;
import ie.gmit.sw.ds.service.facade.queues.QueuesManager;

import java.util.concurrent.atomic.AtomicReference;

public class CreationQueueListener extends Thread {
    private static CreationQueueListener instance;

    private CreationQueueListener(){

    }

    public static CreationQueueListener getInstance() {
        if(instance == null) instance = new CreationQueueListener();
        return instance;
    }

    @Override
    public void run() {

        // Get an instance of the queue using QueuesManager.
        // AtomicReference provides a wrapper for an instance
        // to make sure thread knows about the change in state of it.
        AtomicReference<QueueCommandator> queue = new AtomicReference<>(
                                            QueuesManager.getInstance()
                                            .getQueue(QueueType.LOOK_UP_CMD));


        while(!isInterrupted()){

            try {
                DictionaryJob job = queue.get().retrieveJob();

                //System.out.println("Listener thread got: " + job.getWord());
                new Thread(new CreationQueueWorker(job)).start();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
