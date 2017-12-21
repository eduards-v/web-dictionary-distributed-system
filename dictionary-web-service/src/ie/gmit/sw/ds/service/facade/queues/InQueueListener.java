package ie.gmit.sw.ds.service.facade.queues;

import ie.gmit.sw.ds.service.domain.DictionaryJob;

public class InQueueListener extends Thread{

    private static InQueueListener instance = new InQueueListener();

    private InQueue queue = InQueue.getInstance();

    private InQueueListener() {
    }


    public static InQueueListener getInstance() {
        if(instance == null) new InQueueListener();
        return instance;
    }


    @Override
    public void run() {
        while(!isInterrupted()){
            try{
                DictionaryJob job = queue.getQueue().take();

                new Thread(new InQueueJobWorker(job)).start();
                System.out.println("Word" + job.getWord() + " Job type: " + job.getJobType());
            }
            catch(InterruptedException e){

            }
        }
    }
}
