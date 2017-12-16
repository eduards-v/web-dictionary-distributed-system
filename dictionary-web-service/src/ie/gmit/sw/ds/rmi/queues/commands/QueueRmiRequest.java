package ie.gmit.sw.ds.rmi.queues.commands;

import ie.gmit.sw.ds.rmi.queues.QueuesContainer;

public class QueueRmiRequest implements QueueCommand{


    // get an instance of QueuesContainer to execute
    // method that place request into rmi queue
    private QueuesContainer container;

    @Override
    public void execute() {

        System.out.println("##### Executing QueueRmiRequest execute() method #####");
        // Place request into the queue.
        // Class needs to be aggregated with
        // query, i.e., word string from user
    }
}
