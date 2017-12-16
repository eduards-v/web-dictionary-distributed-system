package ie.gmit.sw.ds.rmi.queues.commands;

import ie.gmit.sw.ds.rmi.queues.QueuesContainer;

public class CheckResultsQueue implements QueueCommand {


    private QueuesContainer container;


    @Override
    public void execute() {

        // call a container method to check for results in result queue


        System.out.println("##### Executing CheckResultsQueue execute() method #####");
    }
}
