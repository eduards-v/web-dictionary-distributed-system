package ie.gmit.sw.ds.rmi.queues;

import ie.gmit.sw.ds.rmi.queues.commands.QueueCommand;

public class QueuesOperator {

    // QueuesOperator doesn't need to know about
    // details of the command. Factory method
    // can be used to encapsulate creation of commands
    // for operator.

    public void execute(QueueCommand command){
        command.execute();
    }
}
