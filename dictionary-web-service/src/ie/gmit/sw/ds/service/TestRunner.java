package ie.gmit.sw.ds.service;

import ie.gmit.sw.ds.service.domain.DictionaryJob;
import ie.gmit.sw.ds.service.facade.RMICommandDispatcher;
import ie.gmit.sw.ds.service.facade.commands.RMICommandTypes;
import ie.gmit.sw.ds.service.rmi.RMIThreadPool;

public class TestRunner {

    public static void main(String[] args) {

        String word = "hello";

        RMICommandDispatcher dispatcher = new RMICommandDispatcher();
        DictionaryJob job = new DictionaryJob(word);
        dispatcher.setJob(job);
        dispatcher.execute(RMICommandTypes.QUEUE_REQUEST_CMD);

        job = dispatcher.getJob();

        System.out.println(job.getJobId());


    }
}
