package ie.gmit.sw.ds.service.facade.queues;

import ie.gmit.sw.ds.service.domain.DictionaryJob;
import ie.gmit.sw.ds.service.facade.commands.RMICommandTypes;

import java.util.concurrent.*;

public class InQueueWorkersPool {

    private ExecutorService executor = Executors.newCachedThreadPool(Executors.defaultThreadFactory());

    // Handle on OutQueue


    public void dispatchJob(DictionaryJob job){

        Callable<DictionaryJob> task = () -> {
            try {
                TimeUnit.SECONDS.sleep(1);

                // dispatch job to RMI server here
                switch(job.getJobType()){

                    case QUEUE_REQUEST_CMD:
                        break;
                }

                return job;
            }
            catch (InterruptedException e) {
                throw new IllegalStateException("task interrupted", e);
            }
        };

        dispatch(task);
    }

    private void dispatch(Callable task){
        Future<DictionaryJob> result = executor.submit(task);

        try {
            DictionaryJob job = result.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
