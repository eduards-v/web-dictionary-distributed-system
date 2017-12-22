package ie.gmit.sw.ds.service.facade.queues.result;

import ie.gmit.sw.ds.service.domain.WordEntity;

@FunctionalInterface
public interface RMIResultsRetriever {

    WordEntity retrieve(int jobId) throws InterruptedException;
}
