package ie.gmit.sw.ds.rmi.queues.commands;

// Factory for encapsulating creating of a QueueCommand type
public class QueueCommandsFactory {

    private static QueueCommandsFactory instance;

    private QueueCommandsFactory() {
    }

    public static QueueCommandsFactory getInstance() {
        // Lazy instantiation
        if(instance == null){
            instance = new QueueCommandsFactory();
        }

        return instance;
    }

    public QueueCommand createQueueCommand(QueueCommandType type){

        if(type == QueueCommandType.QUEUE_REQUEST_CMD){
            return new QueueRmiRequest();
        } else {
            return new CheckResultsQueue();
        }

    }

}
