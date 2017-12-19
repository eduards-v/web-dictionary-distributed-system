package ie.gmit.sw.ds.service.rmi;

import ie.gmit.sw.ds.service.domain.DictionaryJob;
import ie.gmit.sw.ds.service.facade.queues.InQueue;

import javax.annotation.PostConstruct;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RMIThreadPool extends Thread{

    private static RMIThreadPool instance = new RMIThreadPool();

    private ExecutorService executor = Executors.newCachedThreadPool(Executors.defaultThreadFactory());
    private InQueue queue = InQueue.getInstance();

    private RMIThreadPool() {
    }


    public static RMIThreadPool getInstance() {
        return instance;
    }

    public ExecutorService getExecutor() {
        return executor;
    }

    @Override
    public void run() {
        while(!isInterrupted()){
            try{
                DictionaryJob job = queue.getQueue().take();
                System.out.println("Word" + job.getWord() + " Job type: " + job.getJobType());
            }
            catch(InterruptedException e){

            }
        }
    }
}
