package ie.gmit.sw.ds.service.facade.queues.deletion;

import ie.gmit.sw.ds.service.domain.DictionaryJob;
import ie.gmit.sw.ds.service.facade.queues.QueueCommandator;
import ie.gmit.sw.ds.service.facade.queues.QueueType;
import ie.gmit.sw.ds.service.facade.queues.QueuesManager;

import java.util.concurrent.atomic.AtomicReference;

public class DeletionQueueListener extends Thread {

    private static DeletionQueueListener instance;

    private DeletionQueueListener() {
    }

    public static DeletionQueueListener getInstance() {
        if(instance == null){
            instance = new DeletionQueueListener();
        }
        return instance;
    }

    @Override
    public void run() {
        AtomicReference<QueueCommandator> queue = new AtomicReference<>(
                QueuesManager.getInstance()
                        .getQueue(QueueType.REMOVE_CMD));


        while (!isInterrupted()) {

            try {
                DictionaryJob job = queue.get().retrieveJob();

                //System.out.println("Listener thread got: " + job.getWord());
                new Thread(new DeletionQueueWorker(job)).start();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
