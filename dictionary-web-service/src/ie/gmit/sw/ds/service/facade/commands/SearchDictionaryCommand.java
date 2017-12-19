package ie.gmit.sw.ds.service.facade.commands;

import ie.gmit.sw.ds.service.domain.DictionaryJob;
import ie.gmit.sw.ds.service.facade.DictionaryCommand;
import ie.gmit.sw.ds.service.facade.queues.InQueue;

public class SearchDictionaryCommand implements DictionaryCommand {

    private InQueue queue = InQueue.getInstance();

    // put command into the queue
    @Override
    public DictionaryJob execute(DictionaryJob job) {
        queue.addJob(job);
        return job;
    }
}
