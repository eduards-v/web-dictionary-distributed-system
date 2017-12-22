package ie.gmit.sw.ds.service.facade.queues.lookup;

import ie.gmit.sw.ds.service.domain.DictionaryJob;
import ie.gmit.sw.ds.service.facade.queues.result.ResultsStorage;
import ie.gmit.sw.ds.service.rmi.DictionaryService;
import ie.gmit.sw.ds.service.rmi.RemoteWordEntity;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

public class LookUpQueueWorker implements Runnable {

    private DictionaryJob job;
    private DictionaryService rmiDictionary;


    public LookUpQueueWorker(DictionaryJob job) {
        this.job = job;
        try {
            this.rmiDictionary = (DictionaryService)Naming.lookup("rmi://127.0.0.1:1099/dictionaryService");
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        //System.out.println(Thread.currentThread().getName());
        AtomicReference<ResultsStorage> resultsMap = new AtomicReference<>(ResultsStorage.getInstance());

        try {
            RemoteWordEntity rwe = rmiDictionary.lookup(job.getWord().getWord());
            job.getWord().setDescription(rwe.getDescription());
            Thread.sleep(1000);
            resultsMap.get().addJobResult(job);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Make an RMI call, get result and place it into
        // results concurrent hashmap.


    }
}
