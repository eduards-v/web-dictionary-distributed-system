package ie.gmit.sw.ds.service.facade.queues.result;

import ie.gmit.sw.ds.service.domain.WordEntity;

public class ConcreteResultsRetriever implements RMIResultsRetriever{

    private final ResultsStorage storage = ResultsStorage.getInstance();

    @Override
    public WordEntity retrieve(int jobId) throws InterruptedException {
        return storage.getJobResult(jobId);
    }
}
