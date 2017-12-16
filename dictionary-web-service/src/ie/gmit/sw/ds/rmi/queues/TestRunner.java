package ie.gmit.sw.ds.rmi.queues;

import ie.gmit.sw.ds.rmi.queues.commands.QueueCommandType;
import ie.gmit.sw.ds.rmi.queues.commands.QueueCommandsFactory;

public class TestRunner {
    public static void main(String[] args) {


        // Design I use to implement queues into rmi logic
        // requires command patter. It's is used when the
        // client doesn't have to know what the command do.
        // Encapsulates a request as an object, letting to
        // parametarize clients with different requests or
        // in this case queues, and support undouble operations.

        QueueCommandsFactory commands = QueueCommandsFactory.getInstance();

        QueuesOperator qo = new QueuesOperator();
        qo.execute(commands.createQueueCommand(QueueCommandType.QUEUE_REQUEST_CMD));
        qo.execute(commands.createQueueCommand(QueueCommandType.QUEUE_RESULT_CMD));

    }
}
