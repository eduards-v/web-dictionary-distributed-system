package ie.gmit.sw.ds.service;


import ie.gmit.sw.ds.service.domain.WordEntity;
import ie.gmit.sw.ds.service.facade.RMICommandDispatcher;
import ie.gmit.sw.ds.service.facade.queues.QueueType;
import ie.gmit.sw.ds.service.facade.queues.result.LookUpResults;

public class TestRunner {

    public static void main(String[] args) {

        String word = "facade";
        int id;
        WordEntity wordEntity = new WordEntity(word);
        RMICommandDispatcher dispatcher;

        for(int i = 0; i < 100; i++){
            dispatcher = new RMICommandDispatcher(wordEntity);
            id = dispatcher.execute(QueueType.LOOK_UP_CMD);
            System.out.println("New Job: " + id);
        }

        LookUpResults results = LookUpResults.getInstance();
        try {
            Thread.sleep(3000);
            System.out.println("Number of results: " + results.getResultsCount());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }
}
