package ie.gmit.sw.ds.service.facade.queues.lookup;

import ie.gmit.sw.ds.service.domain.DictionaryJob;
import ie.gmit.sw.ds.service.facade.queues.CommandQueue;
import ie.gmit.sw.ds.service.facade.queues.QueueType;
import ie.gmit.sw.ds.service.facade.queues.QueuesManager;

import java.util.concurrent.atomic.AtomicReference;

public class LookUpQueueListener extends Thread{

    private static LookUpQueueListener instance;

    private LookUpQueueListener() {

    }

    public static LookUpQueueListener getInstance() {
        if(instance == null) instance = new LookUpQueueListener();
        return instance;
    }

    @Override
    public void run() {
        // set this thread to daemon, perfect for monitoring object states
        // will be terminated once there is no non-deamon threads running in JVM

        AtomicReference<CommandQueue> queue = new AtomicReference<>(
                                              QueuesManager.getInstance()
                                              .getQueue(QueueType.LOOK_UP_CMD));

        while(!isInterrupted()){

            try {
                DictionaryJob job = queue.get().retrieveJob();

                //System.out.println("Listener thread got: " + job.getWord());
                new Thread(new LookUpQueueWorker(job)).start();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
