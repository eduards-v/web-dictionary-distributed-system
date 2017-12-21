package ie.gmit.sw.ds.service;

import ie.gmit.sw.ds.service.domain.DictionaryJob;
import ie.gmit.sw.ds.service.facade.RMICommandDispatcher;
import ie.gmit.sw.ds.service.facade.commands.RMICommandTypes;
import ie.gmit.sw.ds.service.facade.queues.InQueueListener;

public class TestRunner {

    public static void main(String[] args) {

        String word = "hello";

        // Start InQueue listener
        InQueueListener inQueueListener = InQueueListener.getInstance();
        inQueueListener.setPriority(Thread.MAX_PRIORITY);
        System.out.println("Is Queue Listener Daemon: " + inQueueListener.isDaemon());
        inQueueListener.start();

        RMICommandDispatcher dispatcher = new RMICommandDispatcher();
        DictionaryJob job = new DictionaryJob(word);
        dispatcher.setJob(job);
        dispatcher.execute(RMICommandTypes.QUEUE_REQUEST_CMD);

        DictionaryJob job2 = new DictionaryJob("hello there");
        dispatcher.setJob(job2);
        dispatcher.execute(RMICommandTypes.QUEUE_REQUEST_CMD);

        // job = dispatcher.getJob();

        // System.out.println(job.getJobId());


    }
}
