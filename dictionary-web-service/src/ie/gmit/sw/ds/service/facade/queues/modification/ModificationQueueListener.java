package ie.gmit.sw.ds.service.facade.queues.modification;

import ie.gmit.sw.ds.service.domain.DictionaryJob;
import ie.gmit.sw.ds.service.facade.queues.QueueCommandator;
import ie.gmit.sw.ds.service.facade.queues.QueueType;
import ie.gmit.sw.ds.service.facade.queues.QueuesManager;

import java.util.concurrent.atomic.AtomicReference;

public class ModificationQueueListener extends Thread {

    private static ModificationQueueListener instance;

    private ModificationQueueListener() {
    }

    public static ModificationQueueListener getInstance() {
        if(instance == null){
            instance = new ModificationQueueListener();
        }
        return instance;
    }

    @Override
    public void run() {
        AtomicReference<QueueCommandator> queue = new AtomicReference<>(
                QueuesManager.getInstance()
                        .getQueue(QueueType.MODIFY_CMD));

        while(!isInterrupted()){

            try {
                DictionaryJob job = queue.get().retrieveJob();

                //System.out.println("Listener thread got: " + job.getWord());
                new Thread(new ModificationQueueWorker(job)).start();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
