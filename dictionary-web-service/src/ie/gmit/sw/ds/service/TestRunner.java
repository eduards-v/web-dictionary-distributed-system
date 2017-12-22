package ie.gmit.sw.ds.service;


import ie.gmit.sw.ds.service.domain.WordEntity;
import ie.gmit.sw.ds.service.facade.RMICommandDispatcher;
import ie.gmit.sw.ds.service.facade.queues.QueueType;
import ie.gmit.sw.ds.service.facade.queues.result.ResultsStorage;

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

        ResultsStorage results = ResultsStorage.getInstance();
        try {
            Thread.sleep(1500);
            System.out.println("Number of results: " + results.getResultsCount());
            System.out.println(results.getJobResult(30));
            System.out.println(results.getJobResult(20));

        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }
}
