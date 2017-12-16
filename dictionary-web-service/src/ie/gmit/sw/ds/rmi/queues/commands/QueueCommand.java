package ie.gmit.sw.ds.rmi.queues.commands;

// Can be a functional interface because it has only one abstract method
// Java 8+
@FunctionalInterface
public interface QueueCommand {
    void execute();
}
